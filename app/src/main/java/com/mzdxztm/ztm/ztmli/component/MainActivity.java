package com.mzdxztm.ztm.ztmli.component;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mzdxztm.ztm.ztmli.R;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* CommTextView commTv = findViewById(R.id.commTv);
        commTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());
                startActivity(new Intent(MainActivity.this, AlipayActivity.class));
            }
        });*/

    }

    public void v7View(View view) {
        startActivity(new Intent(this, V7ViewTestActivity.class));
    }

    public void dialog(View view) {
        startActivity(new Intent(this, DialogTestActivity.class));
    }

    public void popwindow(View view) {
        startActivity(new Intent(this, PopWindowTestActivity.class));
    }

    public void adapter(View view) {
        startActivity(new Intent(this, AdapterTestActivity.class));
    }

    public void coll(View view) {
        startActivity(new Intent(MainActivity.this, AlipayActivity.class));
    }

    public void open(View view) {
//        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        startActivity(intent);
    }

    private int clicTimes = 0;

    public void dir(View view) {
        Button btnDir = (Button) findViewById(R.id.btn_dir);
        TextView tvDirShow = (TextView) findViewById(R.id.tv_dirShow);
        switch (clicTimes++) {
            case 0:
                btnDir.setText("显示根目录下所有文件");
                setDirShow(tvDirShow, new File("/"));
                break;
            case 1:
                btnDir.setText("显示根系统下所有文件");
                File file = Environment.getRootDirectory();//File file=new File("/system");
                setDirShow(tvDirShow, file);
                break;
            case 2:
                btnDir.setText("显示sdcard目录下所有文件");
                setDirShow(tvDirShow, Environment.getExternalStorageDirectory());//File file=new File("/sdcard");
                break;
            default:
                clicTimes = 0;
                break;

        }
    }


    private void setDirShow(TextView tvDirShow, File file) {
        File[] fileList = file.listFiles();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < fileList.length; i++) {
            sb.append(fileList[i].getAbsolutePath() + "\n");
        }
        tvDirShow.setText(sb);
    }

    @Override
    public void onClick(View v) {

    }
}
