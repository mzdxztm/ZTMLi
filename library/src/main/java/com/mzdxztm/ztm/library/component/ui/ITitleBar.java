package com.mzdxztm.ztm.library.component.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

public interface ITitleBar {

    void showActionBar(AppCompatActivity activity);

    void hintActionBar(AppCompatActivity activity);

    View getTitleBarView();

    View getBackView();

    View getTitleView();

    View getRightView();

    void showTitleBar();

    void hintTitleBar();

    void setTitleText(String title);

}
