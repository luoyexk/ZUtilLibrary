package com.zwl9517.zutilslibrary;

import android.app.Application;
import android.content.Context;

import com.zwl9517.zutilslibrary.log.crash.CrashHandler;

/**
 * <pre>
 *      author : zouweilin
 *      e-mail : zwl9517@hotmail.com
 *      time   : 2017/07/06
 *      version: 1.0
 *      desc   : initialize model, should initialize it in {@link Application#onCreate()}
 *      func   :   1、权限申请
 *                 2、奔溃日志保存
 *                 3、
 * </pre>
 */
public class Kit {

    private static Context mContext;

    public static void init(Context context) {
        Kit.mContext = context;

        CrashHandler.init(context);// init crashLog helper
    }

    public static Context getContext() {
        return mContext;
    }

    public static void onDestroy() {
        CrashHandler.init(mContext).destroy();
        mContext = null;
    }

}
