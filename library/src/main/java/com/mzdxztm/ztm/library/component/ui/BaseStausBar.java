package com.mzdxztm.ztm.library.component.ui;

import android.app.Activity;
import android.view.View;
import android.view.Window;

import com.mzdxztm.ztm.library.component.ui.IStatusBar;

public class BaseStausBar implements IStatusBar {

    private Window window;

    private View decorView;

    //todo

    public BaseStausBar(Activity activity) {
        window = activity.getWindow();
        decorView = window.getDecorView();

      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT); //导航栏颜色也可以正常设置 //
                window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }*/
    }

    @Override
    public void showStatusBar() {

    }

    @Override
    public void hideStatusBar() {

    }

    @Override
    public void setBackgroundColor(int colorRes) {

    }

    @Override
    public void setTextColor(int colorRes) {

    }

    @Override
    public int getStatusBarHeight() {
        return 0;
    }


}
