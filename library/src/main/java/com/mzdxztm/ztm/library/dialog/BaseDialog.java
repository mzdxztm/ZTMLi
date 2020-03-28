package com.mzdxztm.ztm.library.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mzdxztm.ztm.library.devices.ScreenUtils;

public class BaseDialog extends Dialog implements View.OnClickListener {

    protected Activity activity;

    protected View contentView;

    protected int screenWidth;

    protected int screenHeight;


    public BaseDialog(Activity activity, int themeResId) {
        super(activity, themeResId);
        initProperty(activity);
    }

    public BaseDialog setGravity(int gravity) {
        getWindow().setGravity(gravity);
        return this;
    }

    public BaseDialog setWindowAnimations(int resId) {
        getWindow().setWindowAnimations(resId);
        return this;
    }

    private void initProperty(Activity activity) {
        screenHeight = ScreenUtils.getScreenHeight(activity);
        screenWidth = ScreenUtils.getScreenWidth(activity);
    }

    @Override
    public void setContentView(View contentView) {
        super.setContentView(contentView);
        this.contentView = contentView;
    }

    /*
     * 设置dialog的宽,在setContentView之后使用
     * */
    public void setDialogWidth(int width) {
        ViewGroup.LayoutParams contentLayoutParams = contentView.getLayoutParams();
        contentLayoutParams.width = width;
        contentView.setLayoutParams(contentLayoutParams);
    }

    /*
     * 设置dialog的高，在setContentView之后使用
     * */
    public void setDialogHeight(int height) {
        ViewGroup.LayoutParams contentLayoutParams = contentView.getLayoutParams();
        contentLayoutParams.height = height;
        contentView.setLayoutParams(contentLayoutParams);
    }

    /*
     * 设置dialog的宽高，在setContentView之后使用
     * */
    public void setDialogSize(int width, int height) {
        ViewGroup.LayoutParams contentLayoutParams = contentView.getLayoutParams();
        contentLayoutParams.width = width;
        contentLayoutParams.height = height;
        contentView.setLayoutParams(contentLayoutParams);
    }

    @Override
    public void onClick(View v) {

    }

}
