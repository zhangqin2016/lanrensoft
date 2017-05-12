package zhang.lao.build.tool;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * <p>
 * Title:AES128 算法
 * </p>
 * <p>
 * Description:AES128 算法，加密模式为ECB，填充模式为 pkcs7（实际就是pkcs5）
 * </p>
 * <p>
 * 2013 All Rights Reserved. 版权所有
 * </p>
 * 
 * @author LDL
 * @version 1.0
 * @Date 2014-6-19
 */
public class ToolSecurityDES {

	private final static String DES = "DES";
	private final static String key = "lxEBeYi4rWB32Itf9qKw8A==@";

	/**
	 * 加密
	 * 
	 * @param src
	 *            数据源
	 * @param key
	 *            密钥，长度必须是8的倍数
	 * @return 返回加密后的数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] src, byte[] key)
			throws RuntimeException {
		// DES算法要求有一个可信任的随机数源
		try {
			SecureRandom sr = new SecureRandom();
			// 从原始密匙数据创建DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(key);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			// 一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance(DES);
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 解密
	 * 
	 * @param src
	 *            数据源
	 * @param key
	 *            密钥，长度必须是8的倍数
	 * @return 返回解密后的原始数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src, byte[] key)
			throws RuntimeException {
		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();
			// 从原始密匙数据创建一个DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(key);
			// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
			// 一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			// Cipher对象实际完成解密操作
			Cipher cipher = Cipher.getInstance(DES);
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
			// 现在，获取数据并解密
			// 正式执行解密操作
			return cipher.doFinal(src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 数据解密
	 * 
	 * @param data
	 * @param key
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public final static String decrypt(String data){
		String codeString = "";
		try {
			codeString = new String(decrypt(hex2byte(data.getBytes()), key.getBytes()));
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codeString;
	}

	/**
	 * 数据加密
	 * 
	 * @param data
	 * @param key
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public final static String encrypt(String data) {
		if (data != null)
			try {
				return byte2hex(encrypt(data.getBytes(), key.getBytes()));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		return null;
	}

	/**
	 * 二行制转字符串
	 * 
	 * @param b
	 * @return
	 */
	private static String byte2hex(byte[] b) {
		StringBuilder hs = new StringBuilder();
		String stmp;
		for (int n = 0; b != null && n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1)
				hs.append('0');
			hs.append(stmp);
		}
		return hs.toString().toUpperCase();
	}

	private static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException();
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}

	public static void main(String[] args) {
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES"); // 获取密匙生成器
			kg.init(256); // 初始化
			// DES算法必须是56位
			// DESede算法可以是112位或168位
			// AES算法可以是128、192、256位
			SecretKey key = kg.generateKey(); // 生成密匙，可用多种方法来保存密匙
			System.out.println(new String(key.getEncoded()));
			System.out.println(encrypt("bnghty56?"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
