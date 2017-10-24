package zhang.lao.build.tool;/**
 * Created by zhangqin on 2017/10/24.
 */

import zhang.lao.build.tool.MD5;

/**
 * @author
 * @create 2017-10-24 10:09
 **/
public class UserPassqwordEncrypt {

    public static String makePassword(String pass){
        return MD5.MD5Encode(MD5.MD5Encode(pass));
    }

    public static String encryptLoginPassword(String pass){
        return MD5.MD5Encode(pass);
    }
}
