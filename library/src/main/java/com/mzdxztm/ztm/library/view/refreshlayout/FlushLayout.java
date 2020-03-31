package com.mzdxztm.ztm.library.view.refreshlayout;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class FlushLayout extends RelativeLayout {

    public FlushLayout(Context context) {
        this(context, null);
    }

    public FlushLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlushLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        MeasureSpec.AT_MOST
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
