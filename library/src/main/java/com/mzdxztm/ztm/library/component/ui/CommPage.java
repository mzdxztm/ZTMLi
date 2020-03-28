package com.mzdxztm.ztm.library.component.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mzdxztm.ztm.library.component.ui.ICommPage;

public class CommPage implements ICommPage {

    private ViewGroup layout;

    private View loadingPageView;
    private View fialdPageView;
    private View contentPageView;
    private View emptuPageView;

    public CommPage(ViewGroup layout) {
        this.layout = layout;
    }

    @Override
    public void showLoadingPage() {
        if (loadingPageView == null) {
            return;
        } else {
            layout.removeAllViews();
            layout.addView(loadingPageView);
        }
    }

    @Override
    public void showFialdPage() {
        if (fialdPageView == null) {
            return;
        } else {
            layout.removeAllViews();
            layout.addView(fialdPageView);
        }
    }

    @Override
    public void showContentPage() {
        layout.removeAllViews();
        layout.addView(fialdPageView);
    }

    @Override
    public void showEmptyPage() {
        if (emptuPageView == null) {
            return;
        } else {
            layout.removeAllViews();
            layout.addView(emptuPageView);
        }
    }

    @Override
    public ICommPage setLoadingPageView(int res) {
        this.loadingPageView = LayoutInflater.from(layout.getContext()).inflate(res, null);
        return this;
    }

    @Override
    public ICommPage setFialdPageView(int res) {
        this.fialdPageView = LayoutInflater.from(layout.getContext()).inflate(res, null);
        ;
        return this;
    }

    @Override
    public ICommPage setContentPageView(int res) {
        this.contentPageView = LayoutInflater.from(layout.getContext()).inflate(res, null);
        return this;
    }

    @Override
    public ICommPage setEmptuPageView(int res) {
        this.emptuPageView = LayoutInflater.from(layout.getContext()).inflate(res, null);
        return this;
    }

    public View getLoadingPageView() {
        return loadingPageView;
    }

    public View getFialdPageView() {
        return fialdPageView;
    }

    public View getContentPageView() {
        return contentPageView;
    }

    public View getEmptuPageView() {
        return emptuPageView;
    }


}
