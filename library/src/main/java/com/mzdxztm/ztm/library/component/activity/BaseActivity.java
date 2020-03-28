package com.mzdxztm.ztm.library.component.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mzdxztm.ztm.library.R;
import com.mzdxztm.ztm.library.data.resource.Src;

import java.io.Serializable;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected LinearLayout rootView;
    protected ViewGroup titleBarView;
    protected ViewGroup contentView;
    protected BaseActivity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setStatusBar(this);
        setContentView(R.layout.activity_base);
        activity = this;
        initBaseView();
        initView();
        initData();
    }

    private void initBaseView() {
        //root
        rootView = (LinearLayout) findViewById(R.id.layout);
        //init title bar
        titleBarView = (ViewGroup) getTitleBarView(getTitleBarLayoutId());
        int titleHeight = (int) Src.dimens(R.dimen.title_bar_height);
        LinearLayout.LayoutParams titleLParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, titleHeight);
        titleBarView.setLayoutParams(titleLParam);
        //init content
        contentView = (ViewGroup) getContentView(getContentLayoutId());
        LinearLayout.LayoutParams contentLParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        contentView.setLayoutParams(contentLParam);
        //add to rootview
        rootView.addView(titleBarView);
        rootView.addView(contentView);
    }

    private View getContentView(int layoutId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View contentView = inflater.inflate(layoutId, null);
        return contentView;
    }

    private View getTitleBarView(int layoutId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View titleBarView = inflater.inflate(layoutId, null);
        return titleBarView;
    }

    protected abstract int getTitleBarLayoutId();

    protected abstract int getContentLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected void setOnClick(View view) {
        view.setOnClickListener(this);
    }

    protected void setStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT); //导航栏颜色也可以正常设置 //
                window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }

    protected int getIntentValue(String key, int defValue) {
        Intent intent = getIntent();
        if (intent == null) return defValue;
        return intent.getIntExtra(key, defValue);
    }

    protected float getIntentValue(String key, float defValue) {
        Intent intent = getIntent();
        if (intent == null) return defValue;
        return intent.getFloatExtra(key, defValue);
    }

    protected String getIntentValue(String key, String defValue) {
        Intent intent = getIntent();
        if (intent == null) return defValue;
        String stringExtra = intent.getStringExtra(key);
        if (TextUtils.isEmpty(stringExtra)) return defValue;
        return stringExtra;
    }

    protected Serializable getIntentValue(String key) {
        Intent intent = getIntent();
        if (intent == null) return null;
        Serializable serializableExtra = intent.getSerializableExtra(key);
        if (serializableExtra == null) return null;
        return serializableExtra;
    }

    protected boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    protected boolean isEmpty(EditText editText) {
        Editable text = editText.getText();
        return TextUtils.isEmpty(text);
    }

    protected void toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    protected void showTitleBarView() {
        titleBarView.setVisibility(View.VISIBLE);
    }

    protected void hideTitleBarView() {
        titleBarView.setVisibility(View.GONE);
    }

    protected void showContentView() {
        contentView.setVisibility(View.VISIBLE);
    }

    protected void hideContentView() {
        contentView.setVisibility(View.GONE);
    }

    protected void showFaildPage() {
    }

    protected void hideFaildPage() {
    }

    protected void showLoading() {
    }

    protected void hideLoading() {
    }

    @Override
    public void onClick(View v) {

    }


}
