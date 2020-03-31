package com.mzdxztm.ztm.library.common;

import android.app.Application;

import com.mzdxztm.ztm.library.data.resource.Res;
import com.mzdxztm.ztm.library.image.ImageUtils;
import com.mzdxztm.ztm.library.image.ImgDisplay;

public class InitUtils {

    public static Application app = null;

    public static void init(Application application) {
        InitUtils.app = application;
        ImageUtils.initGlide(application);
        ImgDisplay.init(application);
    }

}
