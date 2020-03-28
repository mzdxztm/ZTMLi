package com.mzdxztm.ztm.ztmli.pop;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mzdxztm.ztm.library.data.resource.Src;
import com.mzdxztm.ztm.library.popwindow.FullScreenPopWindow;
import com.mzdxztm.ztm.ztmli.R;

public class RightPop extends FullScreenPopWindow {
    public RightPop(final AppCompatActivity activity) {
        super(activity);
        View view = Src.layout(R.layout.pop_right_test);
        view.findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        setAnimationStyle(R.style.right_pop_anim);
        setContentView(view);
    }

}
