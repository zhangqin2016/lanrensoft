package zhang.lao.tool;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
* @ClassName: FileMd5Tool 
* @Description:文件MD5获取
* @author zhangqin
* @date 2016年4月5日 下午6:43:42 
*
 */
public class FileMd5Tool {

	/**
	 * 获取文件MD5
	 * @param file
	 * @return
	 */
	public static String getMd5(File file){
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));
			IOUtils.closeQuietly(fis);
			return md5;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null; 
		} catch (IOException e) {
			e.printStackTrace();
			return null; 
		}
		
	}
	
	/**
	 * 获取文件MD5
	 * @return
	 */
	public static String getMd5(String url){
	
		InputStream fis;
		try {
	        // 构造URL  
	        URL ur = new URL(url);  
	        // 打开连接  
	        URLConnection con = ur.openConnection();  
	        //设置请求超时为5s  
	        con.setConnectTimeout(5*1000);  
	        // 输入流  
	        fis = con.getInputStream();  
			String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));
			IOUtils.closeQuietly(fis);
			return md5;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null; 
		} catch (IOException e) {
			e.printStackTrace();
			return null; 
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(getMd5(new File("D:/workspace/sunarvr2.0/sunarvr.console/src/main/webapp/file/model/luomo_man_yf_01.assetbundle")));
		System.out.println(getMd5(new File("D:/workspace/sunarvr2.0/sunarvr.console/src/main/webapp/file/model/luomo_man.assetbundle")));
	}
}
