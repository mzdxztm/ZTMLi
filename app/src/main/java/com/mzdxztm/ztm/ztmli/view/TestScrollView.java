package com.mzdxztm.ztm.ztmli.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class TestScrollView extends ViewGroup {



    public TestScrollView(Context context) {
        super(context);
    }

    public TestScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


   /* public void fling(int velocityY) {
        if (this.getChildCount() > 0) {
            this.startNestedScroll(2, 1);
            this.mScroller.fling(this.getScrollX(), this.getScrollY(), 0, velocityY, 0, 0, -2147483648, 2147483647, 0, 0);
            this.mLastScrollerY = this.getScrollY();
            ViewCompat.postInvalidateOnAnimation(this);
        }

    }

    private void flingWithNestedDispatch(int velocityY) {
        int scrollY = this.getScrollY();
        boolean canFling = (scrollY > 0 || velocityY > 0) && (scrollY < this.getScrollRange() || velocityY < 0);
        if (!this.dispatchNestedPreFling(0.0F, (float)velocityY)) {
            this.dispatchNestedFling(0.0F, (float)velocityY, canFling);
            this.fling(velocityY);
        }

    }
    */
}
