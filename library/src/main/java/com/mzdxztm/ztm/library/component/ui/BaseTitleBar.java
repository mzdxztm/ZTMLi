package com.mzdxztm.ztm.library.component.ui;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mzdxztm.ztm.library.component.ui.ITitleBar;

public abstract class BaseTitleBar implements ITitleBar {

    private Activity activity;

    private View titleBarLayout;

    private View backView;

    private View titleView;

    private View rightView;


    private View.OnClickListener onClickListene = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == backView) {
                backListener(v);
            } else if (v == rightView) {
                rightListener(v);
            }
        }
    };

    public BaseTitleBar(Activity activity, int width, int height) {
        this.activity = activity;
        //init view
        titleBarLayout = getTitleBarView();
        setSize(width, height);
        backView = getBackView();
        titleView = getTitleView();
        rightView = getRightView();
        //init listener
        backView.setOnClickListener(onClickListene);
        rightView.setOnClickListener(onClickListene);
        //
    }

    public void setSize(int width, int height) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        titleBarLayout.setLayoutParams(layoutParams);
    }

    protected void backListener(View v) {
        activity.finish();
    }

    protected abstract void rightListener(View v);

    @Override
    public void showActionBar(AppCompatActivity activity) {
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public void hintActionBar(AppCompatActivity activity) {
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
    }

    @Override
    public void showTitleBar() {
        titleBarLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hintTitleBar() {
        titleBarLayout.setVisibility(View.GONE);
    }

    @Override
    public void setTitleText(String title) {
        if (titleView instanceof TextView) {
            TextView tv = (TextView) titleView;
            tv.setText(title);
        }
    }

}
