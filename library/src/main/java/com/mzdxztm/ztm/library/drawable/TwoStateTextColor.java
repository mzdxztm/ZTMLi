package com.mzdxztm.ztm.library.drawable;

import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;

import com.mzdxztm.ztm.library.R;

public class TwoStateTextColor {

    private ColorStateList colorStateList;

    private int secondState;

    public TwoStateTextColor(int secondState) {
        super();
        this.secondState = secondState;
        setTextColor(R.color.gray, R.color.gray);
    }

    /**
     * @param normalColor
     * @param secondColor
     */
    public TwoStateTextColor setTextColor(@ColorInt int normalColor,@ColorInt int secondColor) {
        int[][] states = new int[2][];
        states[0] = new int[]{secondState};
        states[1] = new int[]{};
        int[] colors = new int[]{secondColor, normalColor};
        colorStateList = new ColorStateList(states, colors);
        return this;
    }

    public ColorStateList getColorStateList() {
        return colorStateList;
    }

}
