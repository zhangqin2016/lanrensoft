package com.lz.auto.utils;

/**
 * <p>
 * title:
 * </p>
 * <p>
 * description:自动生成常量类
 * </p>
 *
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @version 1.0
 * @create zhangqin
 * @update
 * @date 2016年3月9日
 */
public class BuildNameTool {
    public static String getName(String tableName) {
        String s[] = tableName.split("_");
        StringBuffer buffer = new StringBuffer();
        for (String string : s) {
            buffer.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
        }
        return buffer.toString();
    }

    public static String getCaseName(String tableName) {
        String firesStr = getName(tableName).substring(0, 1).toLowerCase();
        return firesStr + getName(tableName).substring(1);
    }

}
