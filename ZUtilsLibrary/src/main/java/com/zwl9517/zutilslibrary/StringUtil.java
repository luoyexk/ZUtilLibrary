package com.zwl9517.zutilslibrary;

/**
 * <pre>
 *      author : zouweilin
 *      e-mail : zwl9517@hotmail.com
 *      time   : 2017/07/07
 *      version:
 *      desc   :
 * </pre>
 */
public class StringUtil {

    /**
     * 获取一个字符串中指定子字符串的数量
     *
     * @param content 一段字符串
     * @param t 该字符串中相同的子字符串
     * @return 相同数量
     */
    public static int containsCount(String content, String t) {
        return content.contains(t) ? containsCount(content.substring(content.indexOf(t) + t.length()), t) + 1 : 0;
    }
}
