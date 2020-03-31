package com.mzdxztm.ztm.library.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.mzdxztm.ztm.library.R;
import com.mzdxztm.ztm.library.data.resource.Res;

/**
 * 录制小视频的按钮
 */
public class RecordVideoView extends View {

    private int size;

    @DimenRes
    private int strokeWidth;
    @ColorRes
    private int strokeColor;

    private long maxMilli;//能录制的最长时间

    private long startTime;//录制的开始时间

    private long currentTime;//正在按下的时间

    private Paint paint;

    private OnClickListener onClickListener;

    private boolean isPress;

    private static Handler handler;

    private Callback callback;


    public RecordVideoView(Context context) {
        this(context, null);
    }

    public RecordVideoView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecordVideoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
//        strokeWidth = size / 6;
        strokeColor = R.color.red;
        maxMilli = 15000;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);//描边
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (isPress) {
                    currentTime = System.currentTimeMillis();
                    if (currentTime - startTime >= maxMilli) {
                        isPress = false;
                    }
                    float progress = 100f / maxMilli * (currentTime - startTime);
                    if (callback != null) callback.onProgress((int) progress);
                    invalidate();
                }
            }
        };
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(100);
                    handler.sendEmptyMessage(0);
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        size = Math.min(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        int sizeSpec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.AT_MOST);
        strokeWidth = size / 10;
        super.onMeasure(sizeSpec, sizeSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //框住它的矩形
        RectF rectF = new RectF(strokeWidth / 2, strokeWidth / 2, size - strokeWidth / 2, size - strokeWidth / 2);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(Res.color(strokeColor));
        canvas.drawArc(rectF, -90, getProgress(), false, paint);
    }

    private float getProgress() {
        float progress = 360f / maxMilli * (currentTime - startTime);
        return progress;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startTime = System.currentTimeMillis();
                isPress = true;
                if (callback != null) callback.onStart();
                return true;
            case MotionEvent.ACTION_UP:
                isPress = false;
                if (currentTime - startTime <= 90) {
                    if (onClickListener != null) {
                        onClickListener.onClick(this);
                    }
                }
                startTime = 0;
                currentTime = 0;
                invalidate();
                if (callback != null) callback.onEnd();
                return true;

        }

        return false;
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        this.onClickListener = l;
    }


    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public void setMaxMilli(long maxMilli) {
        this.maxMilli = maxMilli;
    }


    public void addCallback(Callback callback) {
        this.callback = callback;
    }


    public interface Callback {

        void onStart();

        void onProgress(int progress);

        void onEnd();

    }

}
