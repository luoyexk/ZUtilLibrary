package com.zwl9517.zutilslibrary.file;

import java.io.IOException;
import java.io.Reader;

/**
 * <pre>
 *      author : zouweilin
 *      e-mail : zwl9517@hotmail.com
 *      time   : 2017/07/07
 *      version:
 *      desc   :
 * </pre>
 */
public class IOUtil {

    public static String read(Reader isr) throws IOException {
        return readToBuilder(isr).toString();
    }

    public static StringBuilder readToBuilder(Reader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        char[] chars = new char[1024];
        int len = -1;
        while ((len = reader.read(chars)) != -1) {
            builder.append(chars, 0, len);
        }
        return builder;
    }
}
