package com.mzdxztm.ztm.library.component.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    protected View contentView;

    protected AppCompatActivity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup c, @Nullable Bundle b) {
        contentView = inflater.inflate(getLayout(), c, false);
        activity = (AppCompatActivity) getActivity();
        initView();
        initData();
        return contentView;
    }

    protected abstract int getLayout();

    protected abstract void initView();

    @Override
    public abstract void onClick(View view);

    protected abstract void initData();

    protected void toast(String content) {
        Toast.makeText(activity, content, Toast.LENGTH_LONG).show();
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

    protected void hideLoading() {}


}
