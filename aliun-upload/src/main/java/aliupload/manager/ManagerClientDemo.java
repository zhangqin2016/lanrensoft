package aliupload.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.media.*;
import com.alibaba.media.client.impl.DefaultMediaClient;
import com.alibaba.media.common.PagedList;
import com.alibaba.media.manage.ManageClient;

/**
 * @author hyzhou.zhy 2015.03.05
 *         这个Demo展示了 ManagerClient 的接口使用方法
 *         Media SDK 为这个接口提供了一个默认实现 DefaultManagerClient
 */
public class ManagerClientDemo {

    private static final MediaConfiguration configuration = new MediaConfiguration();
    private static final ManageClient client;

    static {
        /**
         * 初始化 MediaConfiguration
         * 配置图片服务的AK:           AccessKey、AccessKeySecret
         * 配置图片服务的namespace:    可选, 不提供将会使用默认服务. 如果你有多个服务, 最好显式指定.
         */ t:
        configuration.setAk("23497027");
        configuration.setSk("a528f6b2ccacd90bf356b53d164eac34");
        configuration.setNamespace("qinningtest2");

        /**
         * 初始化 MediaClient
         */
        client = new DefaultMediaClient(configuration);
    }

    public static void main(String[] args) {
        /**
         * 判断文件是否存在
         */
        Result<Boolean> fileExistsResult = client.existsFile("/tmp", "image.jpg");
        if (fileExistsResult.isSuccess()) { // 文件是否存在
            //do something
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
}
