package com.mzdxztm.ztm.library.image;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片显示（包括本地和网络和资源）
 */
public class ImgDisplay {

    public static void init(Context context) {
        GlideBuilder glideBuilder = new GlideBuilder();
        glideBuilder.setMemoryCache(new LruResourceCache(10 * 1024 * 1024));
        Glide.init(context, glideBuilder);
    }

    public static void display(String url, ImageView iv) {
        Glide.with(iv.getContext()).load(url).into(iv);
    }

    public static void display(int res, ImageView iv) {
        Glide.with(iv.getContext()).load(res).into(iv);
    }

    public static void displayCircle(String url, ImageView iv) {
        Glide.with(iv.getContext()).load(url).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv);
    }

    public static void displayCircle(int res, ImageView iv) {
        Glide.with(iv.getContext()).load(res).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv);
    }

}
