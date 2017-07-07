package com.zwl9517.zutillibrary.sample.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.zwl9517.zutillibrary.sample.R;
import com.zwl9517.zutilslibrary.permission.MPermission;
import com.zwl9517.zutilslibrary.permission.annotation.OnMPermissionDenied;
import com.zwl9517.zutilslibrary.permission.annotation.OnMPermissionGranted;
import com.zwl9517.zutilslibrary.permission.annotation.OnMPermissionNeverAskAgain;
import com.zwl9517.zutilslibrary.version.CheckVersion;

import java.util.List;

/**
 * <pre>
 *      author : zouweilin
 *      e-mail : zwl9517@hotmail.com
 *      time   : 2017/07/06
 *      version:
 *      desc   :
 * </pre>
 */
public class TakePhotoActivity extends AppCompatActivity implements View.OnClickListener {

    public static void start(Context context) {
        context.startActivity(new Intent(context, TakePhotoActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takc_photo);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MPermission.onRequestPermissionsResult(this, 100, permissions, grantResults);                  // 调用此方法在标注为OnMPermissionGranted、OnMPermissionDenied的方法中获取结果
    }

    @OnMPermissionGranted(100)
    public void allPermissionGranted() {
        Log.e("tag", "【TakePhotoActivity】类的方法：【allPermissionGranted】: " + "用户授权");
    }

    @OnMPermissionDenied(100)
    public void permissionDeny() {
        Log.e("tag", "【TakePhotoActivity】类的方法：【permissionDeny】: " + "用户拒绝");
    }

    @OnMPermissionNeverAskAgain(100)
    public void permissionNeverAsk() {
        Log.e("tag", "【TakePhotoActivity】类的方法：【permissionNeverAsk】: " + "用户点击了不再显示");
    }

    private void openCamera() {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    private String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    /**
     * 基本权限管理
     */
    private void requestBasicPermission() {
        MPermission.with(TakePhotoActivity.this)
                .addRequestCode(100)
                .permissions(
                        Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
                )
                .request();
    }

    @Override
    public void onClick(View v) {
        if (CheckVersion.checkVersionIsHigherM()) {
            List<String> deniedPermissions = MPermission.getDeniedPermissions(this, permissions);
            if (deniedPermissions != null && deniedPermissions.size() != 0) {
                requestBasicPermission();
            } else {
                openCamera();
            }
        } else {
            openCamera();
        }
    }
}
