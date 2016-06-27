package zhang.lao.tool;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomTool {
	/**
	 * 123456789
	 */
	public static int TYPEl1=-1;
	
	/**
	 * 0123456789
	 */
	public static int TYPE0=0;
	/**
	 * abcdefghijklmnopqrstuvwxyz
	 */
	public static int TYPE1=1;
	/**
	 * ABCDEFGHIJKLMNOPQRSTUVWXYZ
	 */
	public static int TYPE2=2;
	/**
	 * 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
	 */
	public static int TYPE3=3;
	/**
	 * abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789
	 */
	public static int TYPE4=4;
	/**
	 * 0123456789abcdefghijklmnopqrstuvwxyz
	 */
	public static int TYPE11=11;
	/**
	 * uuid
	 */
	public static int TYPE5=5;
	public static String getCode(int passLength, int type)  
    {  
        StringBuffer buffer = null;  
        StringBuffer sb = new StringBuffer();  
        Random r = new Random();  
        r.setSeed(new Date().getTime());  
        switch (type)  
        {  
        case -1:  
            buffer = new StringBuffer("123456789");  
            break;
        case 0:  
            buffer = new StringBuffer("0123456789");  
            break;  
        case 1:  
            buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyz");  
            break;  
        case 11:  
            buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyz");  
            break; 
        case 2:  
            buffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");  
            break;  
        case 3:  
            buffer = new StringBuffer(  
                    "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");  
            break;  
        case 4:  
            buffer = new StringBuffer(  
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");  
            sb.append(buffer.charAt(r.nextInt(buffer.length() - 10)));  
            passLength -= 1;  
            break;  
        case 5:  
            String s = UUID.randomUUID().toString();  
            sb.append(s.substring(0, 8) + s.substring(9, 13)  
                    + s.substring(14, 18) + s.substring(19, 23)  
                    + s.substring(24));  
        }  
        if (type != 5)  
        {  
            int range = buffer.length();  
            for (int i = 0; i < passLength; ++i)  
            {  
                sb.append(buffer.charAt(r.nextInt(range)));  
            }  
        }  
        return sb.toString();  
    }  
	public static void main(String[] args) {
		System.out.println(RandomTool.getCode(6, -1));
	}
}
