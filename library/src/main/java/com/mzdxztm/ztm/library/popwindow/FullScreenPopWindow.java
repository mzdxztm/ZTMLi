package com.mzdxztm.ztm.library.popwindow;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.mzdxztm.ztm.library.devices.ScreenUtils;

public class FullScreenPopWindow extends BasePopWindow {

    public FullScreenPopWindow(AppCompatActivity activity) {
        super(activity);
//        setClippingEnabled(false);//sdk > 21 解决 标题栏没有办法遮罩的问题。好像不起作用
        setBackgroundDrawable(new ColorDrawable(Color.WHITE));//设置背景色，默认是透明的
        setWidth(ScreenUtils.getScreenWidth(activity));
        setHeight(ScreenUtils.getScreenHeight(activity) - ScreenUtils.getStatusHeight(activity));
    }

    public void show() {
        super.show(Gravity.RIGHT | Gravity.BOTTOM);
    }

}
