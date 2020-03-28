package com.mzdxztm.ztm.library.popwindow;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;


public class BasePopWindow extends PopupWindow implements View.OnClickListener {

    protected AppCompatActivity activity;


    public BasePopWindow(AppCompatActivity activity) {
        super(activity);
        init(activity);
        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new BitmapDrawable());
    }

    private void init(AppCompatActivity activity) {
        this.activity = activity;
    }

    public BasePopWindow setSimpleBg(int colorRes, int cornerRadiusRes) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(activity.getResources().getColor(colorRes));
        drawable.setCornerRadius(activity.getResources().getDimension(cornerRadiusRes));
        setBackgroundDrawable(drawable);
        return this;
    }

    public BasePopWindow setSize(int widthRes, int heightRes) {
        int width = (int) activity.getResources().getDimension(widthRes);
        int height = (int) activity.getResources().getDimension(heightRes);
        setWidth(width);
        setHeight(height);
        return this;
    }

    public void show(int gravity) {
        showAtLocation(activity.getWindow().getDecorView(), gravity, 0, 0);
    }

    public void show(int gravity, int x, int y) {
        showAtLocation(activity.getWindow().getDecorView(), gravity, x, y);
    }

    @Override
    public void onClick(View v) {

    }


}
