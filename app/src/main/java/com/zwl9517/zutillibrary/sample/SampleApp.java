package com.zwl9517.zutillibrary.sample;

import android.app.Application;

import com.zwl9517.zutilslibrary.Kit;

/**
 * <pre>
 *      author : zouweilin
 *      e-mail : zwl9517@hotmail.com
 *      time   : 2017/07/06
 *      version:
 *      desc   :
 * </pre>
 */
public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Kit.init(this);
    }
}
