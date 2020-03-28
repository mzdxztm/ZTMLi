package com.mzdxztm.ztm.ztmli.component;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mzdxztm.ztm.library.popwindow.ImageSelectPopwindow;
import com.mzdxztm.ztm.ztmli.R;
import com.mzdxztm.ztm.ztmli.pop.RightPop;

public class DialogTestActivity extends AppCompatActivity {

    private RightPop rightPop;
    private ImageSelectPopwindow imgSelectPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dialog_test);
        rightPop = new RightPop(this);
        imgSelectPop = new ImageSelectPopwindow(this);
        imgSelectPop.setMaxSelectCount(6);
    }

    public void rightPop(View view) {
        rightPop.show();
    }

    @Override
    public void finish() {
        imgSelectPop.setBack(this);
    }

    public void imgSelectPop(View view) {
        imgSelectPop.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        imgSelectPop.getImageSelectRvAdapter().getLocalImages();
    }
}
