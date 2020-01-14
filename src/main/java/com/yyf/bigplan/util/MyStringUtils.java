package com.yyf.bigplan.util;

/**
 * @author 杨宇飞 2019-12-16 9:37 上午
 * @version 1.0
 * @apiNote <p>字符串处理工具拓展</p>
 */
public class MyStringUtils {

    /**
     * 去除首尾指定字符
     *
     * @param str     字符串
     * @param element 指定字符
     */
    public static String trimFirstAndLastChar(String str, String element) {
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do {
            int beginIndex = str.indexOf(element) == 0 ? 1 : 0;
            int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
            str = str.substring(beginIndex, endIndex);
            beginIndexFlag = (str.indexOf(element) == 0);
            endIndexFlag = (str.lastIndexOf(element) + 1 == str.length());
        } while (beginIndexFlag || endIndexFlag);
        return str;
    }

}
