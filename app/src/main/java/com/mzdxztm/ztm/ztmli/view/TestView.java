package com.mzdxztm.ztm.ztmli.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mzdxztm.ztm.library.data.resource.Res;
import com.mzdxztm.ztm.library.devices.ScreenUtils;
import com.mzdxztm.ztm.ztmli.R;

public class TestView extends View {


    private Paint paint;

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setColor(Res.color(R.color.red));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(ScreenUtils.dp2px(context, 10));
        paint.setStrokeWidth(20);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        canvas.drawCircle( getWidth() / 2,  getHeight() / 2, getHeight() / 2, paint);
    }
}
