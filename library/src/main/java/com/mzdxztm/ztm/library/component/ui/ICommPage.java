package com.mzdxztm.ztm.library.component.ui;

public interface ICommPage {

    void showLoadingPage();

    void showFialdPage();

    void showContentPage();

    void showEmptyPage();

    ICommPage setLoadingPageView(int res);

    ICommPage setFialdPageView(int res);

    ICommPage setContentPageView(int res);

    ICommPage setEmptuPageView(int res);
}
