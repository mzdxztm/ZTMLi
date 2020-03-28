package com.mzdxztm.ztm.library.hardware.madia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.provider.MediaStore;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.mzdxztm.ztm.library.devices.ScreenUtils;
import com.mzdxztm.ztm.library.hardware.use.Takephone;

import java.io.IOException;

public class MyCamera1 {

    private Activity activity;

    private Camera camera;

    private SurfaceView surfaceView;//展示拍照预览
    private View takeButton;//拍照按钮
    private View recodButton;//录视频按钮
    private TextView timerShow;//录视频计时器

    private MyCamera1(Activity activity, SurfaceView surfaceView) {
        this.activity = activity;
        this.surfaceView = surfaceView;
    }

    public static MyCamera1 getInstance(Activity activity, SurfaceView surfaceView) {
        return new MyCamera1(activity, surfaceView);
    }

    private void defaultConfig(View takeButton, View recodButton) {

        //<editor-fold desc="Camera初始化">
        camera = Camera.open();
        try {
            camera.setPreviewDisplay(getHold());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //</editor-fold>

        //<editor-fold desc="camera参数设置">
        Camera.Parameters parameters = camera.getParameters();
        /**
         * 调用setFocusMode方法可以设置聚焦模式，聚焦模式有很多：
         *
         * FOCUS_MODE_AUTO、FOCUS_MODE_INFINITY、FOCUS_MODE_MACRO、FOCUS_MODE_FIXED、FOCUS_MODE_EDOF、
         * FOCUS_MODE_CONTINUOUS_VIDEO、FOCUS_MODE_CONTINUOUS_PICTURE.
         *
         * 这些模式用到的有两种模式，分别是：FOCUS_MODE_CONTINUOUS_PICTURE和FOCUS_MODE_CONTINUOUS_VIDEO。
         * 这两个参数最大的作用是可以不断的触发聚焦，并且可以接收到监听的回调。
         */
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        parameters.setPreviewSize(ScreenUtils.getScreenWidth(activity), ScreenUtils.getScreenHeight(activity));//相当于设置预览分辨率
        parameters.setPictureSize(ScreenUtils.getScreenWidth(activity), ScreenUtils.getScreenHeight(activity));//相当于设置保存图片的分辨率
        parameters.setRotation(90);   //设置预览角度
        parameters.setPictureFormat(ImageFormat.JPEG);//图片格式

        camera.setParameters(parameters);
        //</editor-fold>
    }


    private void initDefualtView() {

    }


    private SurfaceHolder getHold() {
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
        return holder;
    }
}
