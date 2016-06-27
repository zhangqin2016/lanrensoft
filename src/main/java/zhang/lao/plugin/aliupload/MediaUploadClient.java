package zhang.lao.plugin.aliupload;

import com.alibaba.fastjson.JSON;
import com.alibaba.media.MediaConfiguration;
import com.alibaba.media.Result;
import com.alibaba.media.upload.*;
import com.alibaba.media.upload.impl.DefaultUploadClient;
import com.alibaba.media.upload.impl.DefaultUploadTokenClient;
import zhang.lao.tool.FileTool;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hyzhou.zhy 2015.03.05
 *         这个Demo展示了 UploadClient 的接口使用方法
 *         Media SDK 为这个接口提供了一个默认实现 DefaultUploadClient
 *         <p/>
 *         这个Demo展示了 UploadTokenClient 的接口使用方法
 *         Media SDK 为这个接口提供了一个默认实现 DefaultUploadTokenClient
 */
public class MediaUploadClient {
	/**
	 * 图片文件阿里存储地址
	 */
	public final static String IMG_URL ="http://arvrdata.image.alimmdn.com/";
	public final static String IMG_URL_DIR ="http://arvrdata.image.alimmdn.com/img/";
	
//	public final static String OSS_HOST = HTTP + "yio2o.image.alimmdn.com" + URL_SPLITTER;
	/**
	 * 非图片文件阿里存储地址
	 */
	public final static String FILE_URL ="http://arvrdata.file.alimmdn.com/";
	
	public final static String IMG_DIR="/yilove/img";
	
	public final static String ILE_DIR="/yilove/file";
	
    private static final Integer PART_SIZE = 100 * 1024;

    private static final UploadClient client;
    private static String bucketName = "";
   	private static final String ACCESS_ID = "";
   	private static final String ACCESS_KEY = "";
    private static String TOKEN;
    
    static {
        /**
         * 初始化 MediaConfiguration
         * 配置图片服务的AK:           AccessKey、AccessKeySecret
         * 配置图片服务的namespace:
         */
        MediaConfiguration configuration = new MediaConfiguration();
        configuration.setAk(ACCESS_ID);
        configuration.setSk(ACCESS_KEY);
        configuration.setNamespace(bucketName);
        UploadTokenClient tokenClient = new DefaultUploadTokenClient(configuration);

        /**
         * 为用户指定上传策略
         * 下面的上传策略指定了:
         *      用户上传文件允许覆盖
         *      该用户凭证的失效时间为当前时间之后的一个小时, 在之后的一个小时之内Token都可以作为用户的上传凭证
         *      失效时间设置为-1时表示永不失效
         */
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(-1);//失效时间设置为-1时表示永不失效

        /**
         * 请求Token服务,为该用户申请该上传策略对应的Token
         */
        TOKEN = tokenClient.getUploadToken(uploadPolicy);

        /**
         * 初始化 UploadClient
         */
        client = new DefaultUploadClient();
    }

    /**
     * 用户直接上传多媒体文件
     * @param file 文件
     */
    public static  UploadResponse  uploadImg( File file,String fileName) {
    	UploadRequest uploadRequest = new UploadRequest(TOKEN);
        uploadRequest.setFile(file);// 文件
        uploadRequest.setDir(IMG_DIR);// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
        	return result.getData();
        }else{
        	return null;
        }
    }
    
    /**
     * 用户直接上传多媒体文件
     * @param file 文件
     */
    public static UploadResponse uploadFile( File file,String fileName) {
    	UploadRequest uploadRequest = new UploadRequest(TOKEN);
        uploadRequest.setFile(file);// 文件
        uploadRequest.setDir(IMG_DIR);// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
        	return result.getData();
        }else{
        	return null;
        }
    }
    /**
     * 用户直接上传多媒体文件
     * @param file 文件
     */
    public static UploadResponse upload(String dir, File file,String fileName) {
        UploadRequest uploadRequest = new UploadRequest(TOKEN);
        uploadRequest.setFile(file);// 文件
        uploadRequest.setDir("/yilove/"+FileTool.getExtention(fileName).replace(".", "")+"/"+dir);// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
        	return result.getData();
        }else{
        	return null;
        }
    }
    /**
     * 用户直接上传多媒体文件
     * @param file 文件
     */
    public static UploadResponse upload(String dir, File file,String fileName,int errorNumber) {
        UploadRequest uploadRequest = new UploadRequest(TOKEN);
        uploadRequest.setFile(file);// 文件
        uploadRequest.setDir("/yilove/"+ FileTool.getExtention(fileName).replace(".", "")+"/"+dir);// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
        	return result.getData();
        }else{
        	if(errorNumber==10){
        		return null;
        	}
        	errorNumber++;
        	upload(dir, file, fileName, errorNumber);
        	return null;
        }
    }
    
    /**
     * 用户直接上传多媒体文件
     * @throws java.io.IOException
     */
    public static UploadResponse blockUpload(String dir, File bigFile,String fileName) throws IOException {
    	int partCount = (int) ((bigFile.length() - 1) / PART_SIZE + 1);
    	if (partCount <= 1) {
    	    throw new IllegalArgumentException("at least two pieces of block." + PART_SIZE);
    	}
    	// 3.1 初始化分片上传
    	InputStream in = new FileInputStream(bigFile);
    	List<MultipartCompleteRequest.PartInfo> parts = new ArrayList<MultipartCompleteRequest.PartInfo>();
    	MultipartInitRequest initRequest = new MultipartInitRequest(TOKEN);
    	initRequest.setDir(dir);
    	initRequest.setName(fileName);
    	initRequest.setContentSize(PART_SIZE);
    	initRequest.setContent(in);
    	Result<MultipartInitResponse> multipartInitResult = client.multipartInit(initRequest);
    	in.close();
    	 
    	if (!multipartInitResult.isSuccess()) {
    	    // 初始化分片上传失败,直接退出
    	    return null;
    	}
    	 
    	parts.add(new MultipartCompleteRequest.PartInfo(multipartInitResult.getData().getPartNumber(), multipartInitResult.getData().geteTag()));
    	 
    	// 3.2 分片上传剩余分片
    	for (int i = 1; i < partCount; i++) {
    	    long start = PART_SIZE * i;
    	    long curPartSize = PART_SIZE < bigFile.length() - start ? PART_SIZE : bigFile.length() - start;
    	    in = new FileInputStream(bigFile);
    	    in.skip(start);
    	    MultipartUploadRequest uploadRequest = new MultipartUploadRequest(TOKEN);
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
    	        // 某个分片上传失败
    	        return null;
    	    }
    	 
    	    parts.add(new MultipartCompleteRequest.PartInfo(uploadResult.getData().getPartNumber(), uploadResult.getData().geteTag()));
    	}
    	 
    	// 3.3 分支一：完成分片上传
    	MultipartCompleteRequest completeRequest = new MultipartCompleteRequest(TOKEN);
    	completeRequest.setDir(multipartInitResult.getData().getDir());
    	completeRequest.setName(multipartInitResult.getData().getName());
    	completeRequest.setId(multipartInitResult.getData().getId());
    	completeRequest.setUploadId(multipartInitResult.getData().getUploadId());
    	completeRequest.setParts(parts);
    	Result<MultipartCompleteResponse> completeResult = client.multipartComplete(completeRequest);
    	if (!completeResult.isSuccess()) {
    	    // 完成分片接口调用失败,打印错误信息
    	    System.out.println(JSON.toJSONString(completeResult));
    	    return null;
    	}else{
    		return completeResult.getData();
    	}
    	 
/*    	 
    	// 3.3 分支二：取消分片上传
    	MultipartCancelRequest cancelResult = new MultipartCancelRequest(TOKEN);
    	cancelResult.setDir(multipartInitResult.getData().getDir());
    	cancelResult.setName(multipartInitResult.getData().getName());
    	cancelResult.setId(multipartInitResult.getData().getId());
    	cancelResult.setUploadId(multipartInitResult.getData().getUploadId());
    	client.multipartCancel(cancelResult);*/
    }
    /**
     * 实例二
     * 分片上传完整流程用于大文件上传
     * 注: 单片最小不能小于100KB,最后一片无大小限制s
     */
    public static void blockUpload(String dir, File contentFile) throws IOException {
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
        MultipartInitRequest initRequest = new MultipartInitRequest(TOKEN);
        initRequest.setDir(dir);
        initRequest.setName(contentFile.getName());
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
            MultipartUploadRequest uploadRequest = new MultipartUploadRequest(TOKEN);
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
        MultipartCompleteRequest completeRequest = new MultipartCompleteRequest(TOKEN);
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
     * 用户直接上传多媒体文件
     */
    public static UploadResponse uploadImg(InputStream inputStream,String fileName,Long inputLength)  throws FileNotFoundException {
        UploadRequest uploadRequest = new UploadRequest(TOKEN);
        uploadRequest.setInputStream(inputStream, inputLength);// 文件
        uploadRequest.setDir(IMG_DIR);// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
        	return result.getData();
        }else{
        	return null;
        }
    }

    public static UploadResponse upload(InputStream inputStream,String fileName,Long inputLength)  throws FileNotFoundException {
        UploadRequest uploadRequest = new UploadRequest(TOKEN);
        uploadRequest.setInputStream(inputStream, inputLength);// 文件
        uploadRequest.setDir(ILE_DIR);// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
            return result.getData();
        }else{
            return null;
        }
    }

    public static UploadResponse upload(String dir,InputStream inputStream,String fileName,Long inputLength)  throws FileNotFoundException {
        UploadRequest uploadRequest = new UploadRequest(TOKEN);
        uploadRequest.setInputStream(inputStream, inputLength);// 文件
        uploadRequest.setDir(ILE_DIR+dir);// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
        	return result.getData();
        }else{
        	return null;
        }
    }
    /**
     * 实例三
     * 用户分片上传, 并在中途取消上传
     */
    public static void blockUploadCancel() throws IOException {
        File contentFile = getFile("image/image.bmp");
        int partCount = (int) ((contentFile.length() - 1) / PART_SIZE + 1);
        if (partCount <= 1) {
            throw new IllegalArgumentException("at least two pieces of block. when using block upload." + PART_SIZE);
        }

        /**
         * 初始化分片上传
         */
        InputStream input = new FileInputStream(contentFile);
        MultipartInitRequest initRequest = new MultipartInitRequest(TOKEN);
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
        MultipartCancelRequest cancelRequest = new MultipartCancelRequest(TOKEN);
        cancelRequest.setDir(multipartInitResult.getData().getDir());
        cancelRequest.setName(multipartInitResult.getData().getName());
        cancelRequest.setId(multipartInitResult.getData().getId());
        cancelRequest.setUploadId(multipartInitResult.getData().getUploadId());
        client.multipartCancel(cancelRequest);
        System.out.println();
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 取出resource目录下的多媒体资源文件
     * 你也可以改写这个方法, 直接取出本地文件.
     *
     * @param path 相对目录
     */
    private static File getFile(String path) {
        URL url = MediaUploadClient.class.getClassLoader().getResource(path);
        assert url != null; //断言: 文件必须存在. 否则找不到上传文件, 程序会直接退出.
        return new File(url.getFile());
    }
    
    public static void main(String[] args) {
    	
     	UploadRequest uploadRequest = new UploadRequest(TOKEN);
        uploadRequest.setFile(new File("D:/crossdomain.xml"));// 文件
        uploadRequest.setDir("/");// 云存储路径
        uploadRequest.setName("crossdomain.xml");// 文件名
        client.upload(uploadRequest);
	}
}
