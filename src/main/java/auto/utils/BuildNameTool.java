package auto.utils;

/**
 * <p>
 * title:
 * </p>
 * <p>
 * description:自动生成常量类
 * </p>
 * 
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月9日
 */
public class BuildNameTool {
	public static String getModelName(String tableName){
		String s[]=tableName.split("_");
		StringBuffer buffer=new StringBuffer();
		for (String string : s) {
			buffer.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
		}
		return buffer.toString();
	}
	public static String getControllerName(String tableName){
		String s[]=tableName.split("_");
		StringBuffer buffer=new StringBuffer();
		for (String string : s) {
			buffer.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
		}
		return buffer.append("Controller").toString();
	}
	public static String getServiceName(String tableName){
		String s[]=tableName.split("_");
		StringBuffer buffer=new StringBuffer();
		for (String string : s) {
			buffer.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
		}
		return buffer.append("Service").toString();
	}
	public static String getServiceImpName(String tableName){
		String s[]=tableName.split("_");
		StringBuffer buffer=new StringBuffer();
		for (String string : s) {
			buffer.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
		}
		return buffer.append("ServiceImp").toString();
	}
	public static String getDaoName(String tableName){
		String s[]=tableName.split("_");
		StringBuffer buffer=new StringBuffer();
		for (String string : s) {
			buffer.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
		}
		return buffer.append("Dao").toString();
	}
	public static String getDaoImpName(String tableName){
		String s[]=tableName.split("_");
		StringBuffer buffer=new StringBuffer();
		for (String string : s) {
			buffer.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
		}
		return buffer.append("DaoImp").toString();
	}
	
	public static final String baseUrl="${ctxPath}/console/database";
	public static final String basePackage="zhang.lao";
}
