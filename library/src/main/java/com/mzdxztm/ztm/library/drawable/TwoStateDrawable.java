package com.mzdxztm.ztm.library.drawable;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;

public class TwoStateDrawable extends StateListDrawable {


    private Context context;

    private GradientDrawable normalDrawable = new GradientDrawable();
    private GradientDrawable secondStateDrawable = new GradientDrawable();

    /**
     * secondState为除了nomal状态之外的第二状态，值为android.R.attr.state_xxx,例如android.R.attr.state_pressed
     *
     * @param context
     * @param secondState
     */
    public TwoStateDrawable(Context context,@AttrRes int secondState) {
        super();
        this.context = context;
        addState(new int[]{secondState}, secondStateDrawable);
        addState(new int[]{}, normalDrawable);
    }


    /**
     * 设置圆角，每个角的x、y半径也相同
     *
     * @param leftTopRes
     * @param rightTopRes
     * @param leftBottomRes
     * @param rightBottomRes
     * @return
     */
    public TwoStateDrawable setCorner(@DimenRes int leftTopRes,
                                      @DimenRes int rightTopRes,
                                      @DimenRes int rightBottomRes,
                                      @DimenRes int leftBottomRes) {
        float leftTop = context.getResources().getDimension(leftTopRes);
        float rightTop = context.getResources().getDimension(rightTopRes);
        float rightBottom = context.getResources().getDimension(rightBottomRes);
        float leftBottom = context.getResources().getDimension(leftBottomRes);
        setCorner(leftTop, rightTop, rightBottom, leftBottom);
        return this;
    }

    public TwoStateDrawable setCorner(@Dimension float leftTop,
                                      @Dimension float rightTop,
                                      @Dimension float rightBottom,
                                      @Dimension float leftBottom) {
        float[] corner = {leftTop, leftTop, rightTop, rightTop, rightBottom, rightBottom, leftBottom, leftBottom};
        normalDrawable.setCornerRadii(corner);
        secondStateDrawable.setCornerRadii(corner);
        return this;
    }

    /**
     * 设置圆角，四个圆角的半径相同，每个角的x、y半径也相同
     *
     * @param radiusRes
     * @return
     */
    public TwoStateDrawable setCorner(@DimenRes int radiusRes) {
        float radius = context.getResources().getDimension(radiusRes);
        setCorner(radius);
        return this;
    }

    public TwoStateDrawable setCorner(@Dimension float radius) {
        normalDrawable.setCornerRadius(radius);
        secondStateDrawable.setCornerRadius(radius);
        return this;
    }


    /**
     * @param normalColorRes
     * @param secondStateColorRes
     * @return
     */
    public TwoStateDrawable setBgColorRes(@ColorRes int normalColorRes,
                                          @ColorRes int secondStateColorRes) {
        int normalColor = context.getResources().getColor(normalColorRes);
        int secondColor = context.getResources().getColor(secondStateColorRes);
        setBgColorRgb(normalColor, secondColor);
        return this;
    }

    public TwoStateDrawable setBgColorRgb(@ColorInt int normalStateColor, @ColorInt int secondStateColor) {
        normalDrawable.setColor(normalStateColor);
        secondStateDrawable.setColor(secondStateColor);
        return this;
    }


    /**
     * 两种状态下的背景的边线宽度和颜色
     *
     * @param widthRes
     * @param colorRes
     * @return
     */
    public TwoStateDrawable setStrokeRes(@DimenRes int widthRes, @ColorRes int colorRes) {
        int width = (int) context.getResources().getDimension(widthRes);
        int color = context.getResources().getColor(colorRes);
        setStroke(width, color);
        return this;
    }

    public TwoStateDrawable setStroke(@Dimension int width, @ColorInt int color) {
        normalDrawable.setStroke(width, color);
        secondStateDrawable.setStroke(width, color);
        return this;
    }


}
