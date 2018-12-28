package zhang.lao.build.tool;

import java.util.Random;

public class TokenTool {
	/**
	 * 生成token
	 * @param appid
	 * @return
	 */
	public static String getToken(String appid){
		String tokenId = String.valueOf(new Random().nextLong());
		return ToolSecurityDES.encrypt(tokenId.replace("-", "")+":"+appid);
	}
	
	/**
	 * 更具key生成秘钥
	 * @param key
	 * @return
	 */
	public static String getKey(String key){
		return ToolSecurityDES.encrypt(key).toLowerCase();
	}
	
	/**
	 * 根据token获取appid
	 * @param token
	 * @return
	 */
	public static String getAppid(String token){
		return ToolSecurityDES.decrypt(token).split(":")[1];
	}
	
}
