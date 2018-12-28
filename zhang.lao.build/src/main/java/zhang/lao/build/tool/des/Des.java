package zhang.lao.build.tool.des;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class Des
{
    private static byte[] ivkey = { 5, 3, 1, 3, 3, 1, 9, 1 };
    public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
    public static final  String passKey ="DDKKJJJDDERRD98798DFFFDSSDSDFMJJDSFFKJHGHHSS99999DSF";
    /**
     * DES算法，加密
     *
     * @param data 待加密字符串
     * @param key  加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     */
    public static String encode(String key,String data) throws Exception
    {
        return encode(key, data.getBytes());
    }
    /**
     * DES算法，加密
     *
     * @param data 待加密字符串
     * @param key  加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     */
    public static String encode(String key,byte[] data) throws Exception
    {
        try
        {
            DESKeySpec dks = new DESKeySpec(key.getBytes());

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            //key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(ivkey);
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey,paramSpec);

            byte[] bytes = cipher.doFinal(data);
            return Base64.encode(bytes);
        } catch (Exception e)
        {
            throw new Exception(e);
        }
    }
    /**
     * DES算法，解密
     *
     * @param data 待解密字符串
     * @param key  解密私钥，长度不能够小于8位
     * @return 解密后的字节数组
     * @throws Exception 异常
     */
    public static byte[] decode(String key,byte[] data) throws Exception
    {
        try
        {
            SecureRandom sr = new SecureRandom();
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            //key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(ivkey);
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey,paramSpec);
            return cipher.doFinal(data);
        } catch (Exception e)
        {
//         e.printStackTrace();
            throw new Exception(e);
        }
    }

    /**
     * 获取编码后的值
     * @param key
     * @param data
     * @return
     * @throws Exception
     * @throws Exception
     */
    public static String decodeValue(String key,String data) throws Exception
    {
        byte[] datas;
        String value = null;

        datas = decode(key, Base64.decode(data));

        value = new String(datas);
        if (value.equals("")){
            throw new Exception();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(encode("aaaaaaaaas","12fdgsdgdsfgsdfgfdsgfdsgfdsgdsfgdsfgfds3456"));
    }
}