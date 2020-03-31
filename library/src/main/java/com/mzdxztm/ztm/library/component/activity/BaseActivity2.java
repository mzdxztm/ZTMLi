package com.mzdxztm.ztm.library.component.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mzdxztm.ztm.library.R;
import com.mzdxztm.ztm.library.component.ui.BaseStausBar;
import com.mzdxztm.ztm.library.component.ui.IStatusBar;
import com.mzdxztm.ztm.library.component.ui.ITitleBar;
import com.mzdxztm.ztm.library.data.resource.Res;

public abstract class BaseActivity2 extends AppCompatActivity implements View.OnClickListener {

    protected LinearLayout rootView;
    protected ViewGroup contentView;

    protected BaseActivity2 activity;

    protected IStatusBar statusBar;
    protected ITitleBar titleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        //
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //
        statusBar = new BaseStausBar(this);
        statusBar.hideStatusBar();
        //init title bar
        titleBar = initTitleBar();
        titleBar.hintActionBar(this);
        //
        setContentView(R.layout.activity_base);
        //
        initBaseView();
        initView();
        initData();
    }

    private void initBaseView() {
        //root
        rootView = (LinearLayout) findViewById(R.id.layout);
        //init content
        initContentView();
        //add to rootview
        rootView.addView(titleBar.getTitleBarView());
        rootView.addView(contentView);
    }

    private void initContentView() {
        contentView = (ViewGroup) Res.layout(getContentLayoutId());
        LinearLayout.LayoutParams contentLParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        contentView.setLayoutParams(contentLParam);
    }

    protected abstract ITitleBar initTitleBar();

    protected abstract int getContentLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected void setOnClick(View view) {
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }


}
