package com.mzdxztm.ztm.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.mzdxztm.ztm.library.R;
import com.mzdxztm.ztm.library.drawable.TwoStateDrawable;
import com.mzdxztm.ztm.library.drawable.TwoStateTextColor;


public class CommTextView extends android.support.v7.widget.AppCompatTextView {

    //<editor-fold desc="背景和颜色变量">
    private TwoStateTextColor stateTextColor;
    private TwoStateDrawable stateBackground;
    //</editor-fold>

    //<editor-fold desc="构造方法">
//    public CommTextView(Context context) {
//        this(context, null);
//    }
//
//    public CommTextView(Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs, 0);
//    }

    public CommTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setClickable(true);
        initAttrs(context.obtainStyledAttributes(attrs, R.styleable.CommTextView));
        initState();
    }
    //</editor-fold>

    //<editor-fold desc="初始化数据">
    private void initAttrs(TypedArray typedArray) {
        int state = android.R.attr.state_pressed;
        int stateIndex = typedArray.getInt(R.styleable.CommTextView_state, 1);
        if (stateIndex == 1) state = android.R.attr.state_pressed;
        if (stateIndex == 2) state = android.R.attr.state_selected;
        stateBackground = new TwoStateDrawable(getContext(), state);
        stateTextColor = new TwoStateTextColor(state);
        //getBackground and  setBackground
        int normalBgColor = typedArray.getColor(R.styleable.CommTextView_normal_bg_color, getResources().getColor(R.color.transparency));
        int secondBgColor = typedArray.getColor(R.styleable.CommTextView_second_bg_color, getResources().getColor(R.color.transparency));
        stateBackground.setBgColorRgb(normalBgColor, secondBgColor);
        //getStroke and setStrokeRes
        int strokeColor = typedArray.getColor(R.styleable.CommTextView_stroke_color, getResources().getColor(R.color.transparency));
        int strokeWidth = (int) typedArray.getDimension(R.styleable.CommTextView_stroke_width, getResources().getDimension(R.dimen.dimen0));
        stateBackground.setStroke(strokeWidth, strokeColor);
        //getTextColor and setTextColor
        int normalTxtColor = typedArray.getColor(R.styleable.CommTextView_normal_txt_color, getResources().getColor(R.color.gray));
        int secondTxtColor = typedArray.getColor(R.styleable.CommTextView_second_txt_color, getResources().getColor(R.color.gray));
        stateTextColor.setTextColor(normalTxtColor, secondTxtColor);
        //getRadius and setRadius
        float radius = typedArray.getDimension(R.styleable.CommTextView_radius, 0);
        if (radius == 0) {
            float ltRadius = typedArray.getDimension(R.styleable.CommTextView_lt_radius, 0);
            float rtRadius = typedArray.getDimension(R.styleable.CommTextView_rt_radius, 0);
            float rbRadius = typedArray.getDimension(R.styleable.CommTextView_rb_radius, 0);
            float lbRadius = typedArray.getDimension(R.styleable.CommTextView_lb_radius, 0);
            stateBackground.setCorner(ltRadius, rtRadius, rbRadius, lbRadius);
        } else {
            stateBackground.setCorner(radius);
        }
        typedArray.recycle();
    }

    private void initState() {

        setBackground(stateBackground);
        setTextColor(stateTextColor.getColorStateList());

    }
    //</editor-fold>

}
