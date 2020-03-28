package com.mzdxztm.ztm.library.drawable;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class ThreeStateDrawable extends StateListDrawable {


    private Context context;

    private GradientDrawable normalDrawable = new GradientDrawable();
    private GradientDrawable secondStateDrawable = new GradientDrawable();
    private GradientDrawable thirdStateDrawable = new GradientDrawable();

    /**
     * secondState和thirdState为除了nomal状态之外的状态，值为android.R.attr.state_xxx,例如android.R.attr.state_pressed
     * @param context
     * @param secondState
     * @param hirdState
     */
    public ThreeStateDrawable(Context context, int secondState, int hirdState) {
        super();
        this.context = context;
        addState(new int[]{secondState}, secondStateDrawable);
        addState(new int[]{hirdState}, thirdStateDrawable);
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
    public ThreeStateDrawable setCorner(int leftTopRes, int rightTopRes, int leftBottomRes, int rightBottomRes) {
        float leftTop = context.getResources().getDimension(leftTopRes);
        float rightTop = context.getResources().getDimension(rightTopRes);
        float leftBottom = context.getResources().getDimension(leftBottomRes);
        float rightBottom = context.getResources().getDimension(rightBottomRes);
        float[] corner = {leftTop, leftTop, rightTop, rightTop, leftBottom, leftBottom, rightBottom, rightBottom};
        normalDrawable.setCornerRadii(corner);
        secondStateDrawable.setCornerRadii(corner);
        thirdStateDrawable.setCornerRadii(corner);
        return this;
    }

    /**
     * 设置圆角，四个圆角的半径相同，每个角的x、y半径也相同
     *
     * @param radiusRes
     * @return
     */
    public ThreeStateDrawable setCorner(int radiusRes) {
        float radius = context.getResources().getDimension(radiusRes);
        normalDrawable.setCornerRadius(radius);
        secondStateDrawable.setCornerRadius(radius);
        thirdStateDrawable.setCornerRadius(radius);
        return this;
    }


    public ThreeStateDrawable setBgColor(int normalColorRes, int secondStateColorRes, int thirdStateColorRes) {
        normalDrawable.setColor(context.getResources().getColor(normalColorRes));
        secondStateDrawable.setColor(context.getResources().getColor(secondStateColorRes));
        thirdStateDrawable.setColor(context.getResources().getColor(thirdStateColorRes));
        return this;
    }


    /**
     * 三种状态下的背景的边线宽度和颜色
     *
     * @param widthRes
     * @param colorRes
     * @return
     */
    public ThreeStateDrawable setStroke(int widthRes, int colorRes) {
        int width = (int) context.getResources().getDimension(widthRes);
        int color = context.getResources().getColor(colorRes);
        normalDrawable.setStroke(width, color);
        secondStateDrawable.setStroke(width, color);
        thirdStateDrawable.setStroke(width, color);
        return this;
    }


    /**
     *
     * @param normalWidthRes
     * @param secondWidthRes
     * @param thirdWidthRes
     * @param normalColorRes
     * @param secondColorRes
     * @param thirdColorRes
     * @return
     */
    public ThreeStateDrawable setStroke(int normalWidthRes, int secondWidthRes, int thirdWidthRes, int normalColorRes, int secondColorRes, int thirdColorRes) {
        int normalWidth = (int) context.getResources().getDimension(normalWidthRes);
        int secondStateWidth = (int) context.getResources().getDimension(secondWidthRes);
        int thirdStateWidth = (int) context.getResources().getDimension(thirdWidthRes);
        int normalColor = context.getResources().getColor(normalColorRes);
        int secondStateColor = context.getResources().getColor(secondColorRes);
        int thirdtateColor = context.getResources().getColor(thirdColorRes);
        normalDrawable.setStroke(normalWidth, normalColor);
        secondStateDrawable.setStroke(secondStateWidth, secondStateColor);
        secondStateDrawable.setStroke(thirdStateWidth, thirdtateColor);
        return this;
    }


}
