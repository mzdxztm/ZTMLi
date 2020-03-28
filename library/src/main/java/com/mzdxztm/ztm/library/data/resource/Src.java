package com.mzdxztm.ztm.library.data.resource;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class Src {

    private static Context context;

    public static final void init(@NotNull Context context) {
        Src.context = context;
    }

    public static String string(@StringRes int res) {
        return context.getString(res);
    }

    public static int color(@ColorInt int res) {
        return context.getResources().getColor(res);
    }

    public static Drawable drawable(@DrawableRes int res) {
        return context.getResources().getDrawable(res);
    }

    public static float dimens(@DimenRes int res) {
        return context.getResources().getDimension(res);
    }

    public static File asset(@NotNull String path) {
        File file = null;
        try {
            AssetManager assets = context.getResources().getAssets();
            String[] list = assets.list("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static View layout(@LayoutRes int res) {
        return layout(res, null);
    }

    public static View layout(@LayoutRes int res, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(res, parent);
    }


}
