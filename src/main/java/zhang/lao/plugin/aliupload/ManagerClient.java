package zhang.lao.plugin.aliupload;

import com.alibaba.fastjson.JSON;
import com.alibaba.media.MediaConfiguration;
import com.alibaba.media.MediaDir;
import com.alibaba.media.MediaFile;
import com.alibaba.media.Result;
import com.alibaba.media.client.MediaClient;
import com.alibaba.media.client.impl.DefaultMediaClient;
import com.alibaba.media.common.PagedList;

/**
 * @author hyzhou.zhy 2015.03.05
 *         这个Demo展示了 ManagerClient 的接口使用方法
 *         Media SDK 为这个接口提供了一个默认实现 DefaultManagerClient
 */
public class ManagerClient {

    private static final MediaConfiguration configuration = new MediaConfiguration();
    private static final MediaClient client;
    private static String bucketName = "artist";
   	private static final String ACCESS_ID = "23243855";
   	private static final String ACCESS_KEY = "16ca28185a4987b73244c936f064ed84";
    static {
        /**
         * 初始化 MediaConfiguration
         * 配置图片服务的AK:           AccessKey、AccessKeySecret
         * 配置图片服务的namespace:    可选, 不提供将会使用默认服务. 如果你有多个服务, 最好显式指定.
         */
        configuration.setAk(ACCESS_ID);
        configuration.setSk(ACCESS_KEY);
        configuration.setNamespace(bucketName);
    	  client = new DefaultMediaClient(configuration);

    }
    
    public static  PagedList<MediaFile> getListFile(String dir,int start,int end){
    	Result<PagedList<MediaFile>> listFilesResult = client.listFiles(dir, start, end);
    	 if (listFilesResult.isSuccess()) {
    		 return listFilesResult.getData();
    	 }else{
    		 return null;
    	 }
    }

    public static  PagedList<MediaDir>  getListDir(String s,int start,int end){
    	  Result<PagedList<MediaDir>> mediaDirsResult = client.listDirs("/", 1, 10);
          if (mediaDirsResult.isSuccess()) { // 遍历获取到的目录
             return mediaDirsResult.getData();
          } else { // 调用出错
        	  return null;
          }
    }
    public static void main(String[] args) {
     /*   *//**
         * 判断文件是否存在
         *//*
        Result<Boolean> fileExistsResult = client.existsFile("/tmp", "image.jpg");
        if (fileExistsResult.isSuccess()) { // 文件是否存在
            //do something
            System.out.println(fileExistsResult.getData());
        } else {
            System.out.println(fileExistsResult.toString());
        }

        *//**
         * 获得文件元信息
         * 当文件不存在时,会返回404-资源不存在
         *//*
        Result<MediaFile> mediaFileResult = client.getFile("/tmp", "image.jpg");
        if (mediaFileResult.isSuccess()) {
            System.out.println(JSON.toJSONString(mediaFileResult.getData()));
        } else {
            System.out.println(mediaFileResult);
        }

        *//**
         * 分页获取指定目录下的图片元信息
         *//*
        Result<PagedList<MediaFile>> listFilesResult = client.listFiles("/tmp", 1, 10);
        if (listFilesResult.isSuccess()) { // 遍历获取到的文件
            for (MediaFile file : listFilesResult.getData()) {
                System.out.println(JSON.toJSONString(file));
            }
        } else { // 调用出错
            System.out.println(listFilesResult.toString());
        }

        *//**
         * 删除图片文件
         * 当图片不存在时, 会返回404-资源不存在
         *//*
        Result<Void> deleteResult = client.deleteFile("/tmp", "image.jpg");
        if (deleteResult.isSuccess()) { //删除成功
            System.out.println("Delete File Success");
        } else {
            System.out.println(deleteResult.toString());
        }


        *//**
         * 创建目录
         * 当目录已经存在时,错误码为"NameDuplicated"
         *//*
        Result<Void> createDirResult = client.createDir("/tmp/dir");
        if (createDirResult.isSuccess()) { // 创建成功
            System.out.println("Create Dir Success");
        } else {
            System.out.println(createDirResult.toString());
        }

        *//**
         * 判断目录是否存在
         *//*
        Result<Boolean> dirExistsResult = client.existsDir("/tmp/dir");
        if (dirExistsResult.isSuccess()) { // 目录是否存在
            System.out.println(dirExistsResult.getData());
        } else { // 调用出错
            System.out.println(dirExistsResult.toString());
        }*/

        /**
         * 分页获取指定文件夹下的目录
         */
 /*       Result<PagedList<MediaDir>> mediaDirsResult = client.listDirs("/", 1, 10);
        if (mediaDirsResult.isSuccess()) { // 遍历获取到的目录
            for (MediaDir dir : mediaDirsResult.getData()) {
                System.out.println(JSON.toJSONString(dir));
            }
        } else { // 调用出错
            System.out.println(mediaDirsResult.toString());
        }*/
        PagedList<MediaDir> mediaDirsResult = getListDir("/", 0,11);
            for (MediaDir dir :mediaDirsResult) {
                System.out.println(JSON.toJSONString(dir));
            }
            PagedList<MediaFile> listFilesResult =getListFile("/artist", 1, 10);
                for (MediaFile file :listFilesResult) {
                    System.out.println(JSON.toJSONString(file));
                }

    }
}
