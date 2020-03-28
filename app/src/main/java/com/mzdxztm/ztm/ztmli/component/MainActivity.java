package com.mzdxztm.ztm.ztmli.component;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mzdxztm.ztm.library.drawable.TwoStateDrawable;
import com.mzdxztm.ztm.library.drawable.TwoStateTextColor;
import com.mzdxztm.ztm.library.view.CommTextView;
import com.mzdxztm.ztm.ztmli.R;

public class MainActivity extends AppCompatActivity {

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
}
