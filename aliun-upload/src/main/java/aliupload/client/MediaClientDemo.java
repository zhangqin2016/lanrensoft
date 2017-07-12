package aliupload.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.media.*;
import com.alibaba.media.client.MediaClient;
import com.alibaba.media.client.impl.DefaultMediaClient;
import com.alibaba.media.common.PagedList;
import com.alibaba.media.upload.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hyzhou.zhy 2015.03.05
 *         <p/>
 *         这个Demo展示了 MediaClient 的接口使用方法
 *         Media SDK 为这个接口提供了一个默认实现 DefaultMediaClient
 *         <p/>
 *         MediaClient
 *         接口继承了ManageClient(文件管理), UploadClient(文件上传)
 *         并提供了一个额外的方法, 用于图片的上传:
 *         Result<MediaFile> upload(String dir, String name, File file);
 */
public class MediaClientDemo {

    private static final Integer PART_SIZE = 100 * 1024;

    private static final MediaClient client;

    static {
        /**
         * 初始化 MediaConfiguration
         * 配置图片服务的AK、SK
         * 配置图片服务的Namespace
         */
        MediaConfiguration configuration = new MediaConfiguration();
        configuration.setAk("23****41");
        configuration.setSk("ef9ea***********************af72");
        configuration.setNamespace("qinningtest2");

        /**
         * 初始化 MediaClient
         * 覆盖默认的getDefaultUploadPolicy方法
         *
         * 默认情况下得到的上传策略是不允许上传文件直接覆盖已存在的文件的.
         * 在这里我们希望能够允许覆盖上传
         * 那么就可以通过匿名类的方式, 改写默认的getDefaultUploadPolicy方法
         */
        client = new DefaultMediaClient(configuration) {
            @Override
            protected UploadPolicy getDefaultUploadPolicy() {
                UploadPolicy uploadPolicy = super.getDefaultUploadPolicy();
                uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
                return uploadPolicy;
            }
        };
    }

    /**
     * 实例执行入口
     * 实例一 直接上传多媒体文件, 比较简单
     * 实例二 直接上传多媒体文件
     * 实例三 用户分片上传完整流程
     * 实例四 用户分片上传, 并在中途取消上传
     * 实例五 一些管理接口的调用
     */
    public static void main(String[] args) throws IOException {
        uploadSimple();
        upload();
        blockUpload();
        blockUploadCancel();
        manager();
    }

    /**
     * 实例一
     * 直接上传多媒体文件,简单接口
     */
    public static void uploadSimple() {
        File file = getFile("image/image.jpg");
        /**
         * 开发者上传接口示例
         * MediaFile upload(String dir, String name, File file) throws MediaException;
         */
        Result<MediaFile> result = client.upload("图片目录", "文件", file);
        if (result.isSuccess()) {
            // 调用接口成功,打印出上传接口的返回信息
            System.out.println(JSON.toJSONString(result.getData()));
        } else {
            // 调用接口失败,输出错误信息便于排查问题
            System.out.println(JSON.toJSONString(result));
        }

    }

    /**
     * 实例二
     * 直接上传多媒体文件,扩展接口——支持自定义上传策略
     */
    public static void upload() {
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);

        UploadRequest uploadRequest = new UploadRequest(uploadPolicy);
        uploadRequest.setFile(getFile("image/image.jpg"));
        uploadRequest.setDir("dir");
        uploadRequest.setName("upload");
        Result<UploadResponse> result = client.upload(uploadRequest);

        if (result.isSuccess()) {
            // 调用接口成功,打印出上传接口的返回信息
            System.out.println(JSON.toJSONString(result.getData()));
        } else {
            // 调用接口失败,输出错误信息便于排查问题
            System.out.println(JSON.toJSONString(result));
        }
    }

    /**
     * 实例三
     * 分片上传完整流程,用于大文件上传
     * 注: 单片最小不能小于100KB,最后一片无大小限制
     */
    public static void blockUpload() throws IOException {
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);

        File contentFile = getFile("image/image.jpg");
        int partCount = (int) ((contentFile.length() - 1) / PART_SIZE + 1);
        if (partCount <= 1) {
            throw new IllegalArgumentException("at least two pieces of block. when using block upload." + PART_SIZE);
        }

        /**
         * 初始化分片上传
         * parts 用于记录每一个分片上传之后得到的ETag, 在最后完成分片上传时提供
         */
        InputStream in = new FileInputStream(contentFile);
        List<MultipartCompleteRequest.PartInfo> parts = new ArrayList<MultipartCompleteRequest.PartInfo>();
        MultipartInitRequest initRequest = new MultipartInitRequest(uploadPolicy);
        initRequest.setDir("dir");
        initRequest.setName("block");
        initRequest.setContentSize(PART_SIZE);
        initRequest.setContent(in);
        Result<MultipartInitResponse> multipartInitResult = client.multipartInit(initRequest);
        in.close();

        if (!multipartInitResult.isSuccess()) {
            // 初始化分片上传失败,直接退出
            System.out.println("MultipartInit failed. ErrorMsg: " + multipartInitResult.toString());
            return;
        } else {
            // 初始化成功,可以把ETag打印出来,ETag即各个片的MD5值
            System.out.println(multipartInitResult.getData().geteTag());
        }

        parts.add(new MultipartCompleteRequest.PartInfo(multipartInitResult.getData().getPartNumber(), multipartInitResult.getData().geteTag()));

        /**
         * 分片上传剩余分片
         */
        for (int i = 1; i < partCount; i++) {
            long start = PART_SIZE * i;
            long curPartSize = PART_SIZE < contentFile.length() - start ? PART_SIZE : contentFile.length() - start;

            in = new FileInputStream(contentFile);
            in.skip(start);
            MultipartUploadRequest uploadRequest = new MultipartUploadRequest(uploadPolicy);
            uploadRequest.setDir(multipartInitResult.getData().getDir());
            uploadRequest.setName(multipartInitResult.getData().getName());
            uploadRequest.setContentSize(curPartSize);
            uploadRequest.setId(multipartInitResult.getData().getId());
            uploadRequest.setUploadId(multipartInitResult.getData().getUploadId());
            uploadRequest.setPartNumber(i + 1);
            uploadRequest.setContent(in);
            Result<MultipartUploadResponse> uploadResult = client.multipartUpload(uploadRequest);
            in.close();

            if (!uploadResult.isSuccess()) {
                // 某个分片上传失败,打印错误信息;注: 这里为了演示方便没有重试,开发者可以根据自己情况决定是否重试
                System.out.println("MultipartUpload failed. ErrorMsg: " + uploadResult.toString());
                return;
            }

            parts.add(new MultipartCompleteRequest.PartInfo(uploadResult.getData().getPartNumber(), uploadResult.getData().geteTag()));
        }

        /**
         * 完成分片上传
         */
        MultipartCompleteRequest completeRequest = new MultipartCompleteRequest(uploadPolicy);
        completeRequest.setDir(multipartInitResult.getData().getDir());
        completeRequest.setName(multipartInitResult.getData().getName());
        completeRequest.setId(multipartInitResult.getData().getId());
        completeRequest.setUploadId(multipartInitResult.getData().getUploadId());
        completeRequest.setParts(parts);
        Result<MultipartCompleteResponse> completeResult = client.multipartComplete(completeRequest);
        if (!completeResult.isSuccess()) {
            // 完成分片接口调用失败,打印错误信息
            System.out.println(JSON.toJSONString(completeResult));
        } else {
            System.out.println(JSON.toJSONString("Multipart Upload Success.UploadId: " + multipartInitResult.getData().getUploadId()));
        }

    }

    /**
     * 实例四
     * 分片上传, 并在中途取消上传,服务端会清理已上传的块
     */
    public static void blockUploadCancel() throws IOException {
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);

        File file = getFile("image/image.jpg");
        int partCount = (int) ((file.length() - 1) / PART_SIZE + 1);
        if (partCount <= 1) {
            throw new IllegalArgumentException("at least two pieces of block. when using block upload." + PART_SIZE);
        }

        /**
         * 初始化分片上传
         */
        InputStream input = new FileInputStream(file);
        MultipartInitRequest initRequest = new MultipartInitRequest(uploadPolicy);
        initRequest.setDir("dir");
        initRequest.setName("block");
        initRequest.setContentSize(PART_SIZE);
        initRequest.setContent(input);
        Result<MultipartInitResponse> multipartInitResult = client.multipartInit(initRequest);
        input.close();
        if (!multipartInitResult.isSuccess()) {
            // 初始化分片上传失败,直接退出
            System.out.println("MultipartInit failed. ErrorMsg: " + multipartInitResult.toString());
            return;
        } else {
            // 初始化成功,可以把ETag打印出来,ETag即各个片的MD5值
            System.out.println(multipartInitResult.getData().geteTag());
        }

        /**
         * 取消分片上传
         */
        MultipartCancelRequest cancelResult = new MultipartCancelRequest(uploadPolicy);
        cancelResult.setDir(multipartInitResult.getData().getDir());
        cancelResult.setName(multipartInitResult.getData().getName());
        cancelResult.setId(multipartInitResult.getData().getId());
        cancelResult.setUploadId(multipartInitResult.getData().getUploadId());
        client.multipartCancel(cancelResult);
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 实例五
     * 一些管理接口的调用
     */
    public static void manager() {

        /**
         * 判断文件是否存在
         */
        Result<Boolean> fileExistsResult = client.existsFile("/tmp", "image.jpg");
        if (fileExistsResult.isSuccess()) { // 文件是否存在
            System.out.println(fileExistsResult.getData());
        } else {
            System.out.println(fileExistsResult.toString());
        }

        /**
         * 获得文件元信息
         * 当文件不存在时,会返回404-资源不存在
         */
        Result<MediaFile> mediaFileResult = client.getFile("/tmp", "image.jpg");
        if (mediaFileResult.isSuccess()) {
            System.out.println(JSON.toJSONString(mediaFileResult.getData()));
        } else {
            System.out.println(mediaFileResult);
        }

        /**
         * 分页获取指定目录下的图片元信息
         */
        Result<PagedList<MediaFile>> listFilesResult = client.listFiles("/tmp", 1, 10);
        if (listFilesResult.isSuccess()) { // 遍历获取到的文件
            for (MediaFile file : listFilesResult.getData()) {
                System.out.println(JSON.toJSONString(file));
            }
        } else { // 调用出错
            System.out.println(listFilesResult.toString());
        }

        /**
         * 删除图片文件
         * 当图片不存在时, 会返回404-资源不存在
         */
        Result<Void> deleteResult = client.deleteFile("/tmp", "image.jpg");
        if (deleteResult.isSuccess()) { //删除成功
            System.out.println("Delete File Success");
        } else {
            System.out.println(deleteResult.toString());
        }


        /**
         * 创建目录
         * 当目录已经存在时,错误码为"NameDuplicated"
         */
        Result<Void> createDirResult = client.createDir("/tmp/dir");
        if (createDirResult.isSuccess()) { // 创建成功
            System.out.println("Create Dir Success");
        } else {
            System.out.println(createDirResult.toString());
        }

        /**
         * 判断目录是否存在
         */
        Result<Boolean> dirExistsResult = client.existsDir("/tmp/dir");
        if (dirExistsResult.isSuccess()) { // 目录是否存在
            System.out.println(dirExistsResult.getData());
        } else { // 调用出错
            System.out.println(dirExistsResult.toString());
        }

        /**
         * 分页获取指定文件夹下的目录
         */
        Result<PagedList<MediaDir>> mediaDirsResult = client.listDirs("/tmp", 1, 10);
        if (mediaDirsResult.isSuccess()) { // 遍历获取到的目录
            for (MediaDir dir : mediaDirsResult.getData()) {
                System.out.println(JSON.toJSONString(dir));
            }
        } else { // 调用出错
            System.out.println(mediaDirsResult.toString());
        }
    }

    /**
     * 取出resource目录下的多媒体资源文件
     * 你也可以改写这个方法, 直接取出本地文件.
     *
     * @param path 相对目录
     */
    private static File getFile(String path) {
        URL url = MediaClientDemo.class.getClassLoader().getResource(path);
        assert url != null; //断言: 文件必须存在. 否则找不到上传文件, 程序会直接退出.
        return new File(url.getFile());
    }
}
