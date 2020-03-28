package com.mzdxztm.ztm.library.component.ui;

import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

public class BaseHintUI implements IHIntUI {

    private Context context;

    private Toast hintToast;

    private Snackbar hintSnackBar;

    private Dialog loadingDialog;

    public BaseHintUI(Context context) {
        this.context = context;
        initDefaultUI();
    }

    public  void initDefaultUI(){}{
        //todo
    }

    public Context getContext() {
        return context;
    }

    public BaseHintUI setHintToast(Toast hintToast) {
        this.hintToast = hintToast;
        return this;
    }

    public BaseHintUI setHintSnackBar(Snackbar hintSnackBar) {
        this.hintSnackBar = hintSnackBar;
        return this;
    }

    public BaseHintUI setLoadingDialog(Dialog loadingDialog) {
        this.loadingDialog = loadingDialog;
        return this;
    }

    public Toast getHintToast() {
        return hintToast;
    }

    public Snackbar getHintSnackBar() {
        return hintSnackBar;
    }

    public Dialog getLoadingDialog() {
        return loadingDialog;
    }

    @Override
    public void showLoading() {
        loadingDialog.show();
    }
    @Override
    public void dismissLoading() {
        loadingDialog.dismiss();
    }
    @Override
    public void showToast(String content) {
        hintToast.show();
    }
    @Override
    public void showSnackbar(String content) {
        hintSnackBar.show();
    }

}
