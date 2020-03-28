package com.mzdxztm.ztm.ztmli.component;

import android.app.Application;

import com.mzdxztm.ztm.library.common.InitUtils;

public class MyApplication extends Application {

    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        init();
    }

    private void init() {
        InitUtils.init(this);
    }


}
