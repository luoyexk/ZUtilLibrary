package com.zwl9517.zutilslibrary.file;

import java.io.File;

/**
 * <pre>
 *      author : zouweilin
 *      e-mail : zwl9517@hotmail.com
 *      time   : 2017/07/07
 *      version:
 *      desc   :
 * </pre>
 */
public class FileUtil {

    /**
     * 递归删除文件夹里的文件
     * @param folder
     */
    public static void deleteAllFilesInFolder(File folder) {
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()){
                deleteAllFilesInFolder(file);
            }
        }
        folder.delete();
    }
}
