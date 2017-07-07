package com.zwl9517.zutilslibrary.version;

import android.os.Build;

/**
 * <pre>
 *      author : zouweilin
 *      e-mail : zwl9517@hotmail.com
 *      time   : 2017/07/06
 *      version:
 *      desc   : check android system version
 * </pre>
 */
public class CheckVersion {

    /**
     * Jelly_Bean
     *
     * @return {@code true} version >= 16, Android API 4.1
     */
    public static boolean chargeVersionHigherJelly_Bean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    /**
     * KITKAT
     *
     * @return {@code true} version >= 19, Android API 4.4
     */
    public static boolean chargeVersionHigherKITKAT() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    /**
     * LOLLIPOP
     *
     * @return {@code true} version >= 21, Android API 5.0
     */
    public static boolean checkVersionIsHigherLOLLIPOP() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * LOLLIPOP_MR1
     *
     * @return {@code true} version >= 22, Android API 5.1
     */
    public static boolean checkVersionIsHigherLOLLIPOP_MR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1;
    }

    /**
     * M
     *
     * @return {@code true} version >= 23, Android API 6.0
     */
    public static boolean checkVersionIsHigherM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /**
     * N
     *
     * @return {@code true} version >= 24, Android API 7.0
     */
    public static boolean checkVrsionIsHigherN() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
    }
}
