package test;

import android.os.Environment;

import com.zwl9517.zutilslibrary.Kit;
import com.zwl9517.zutilslibrary.constant.ConstantAppInfo;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 *      author : zouweilin
 *      e-mail : zwl9517@hotmail.com
 *      time   : 2017/07/07
 *      version:
 *      desc   :
 * </pre>
 */
public class TestModel {

    /**
     * 删除测试
     * @throws IOException
     */
    public static void createFileTest() throws IOException {
        String s = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator
                + Kit.getContext().getPackageName() + File.separator
                + ConstantAppInfo.CRASH_LOG_FILE_NAME;
        File file = new File(s);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file1 = new File(file, "123");
        if (!file1.exists()) {
            file1.mkdirs();
        }
        for (int i = 0; i < 10; i++) {
            File file2 = new File(file1, i + ".txt");
            file2.createNewFile();
        }
    }
}
