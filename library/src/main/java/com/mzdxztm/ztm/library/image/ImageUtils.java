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
 * 图片工具类
 *
 */
public class ImageUtils {

    public static void initGlide(Context context) {
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

    public static void getLocatImages(final Context context, final GetLocalImagesCallback callback) {
        new AsyncTask<String, Integer, List<String>>() {
            @Override
            protected List<String> doInBackground(String... strings) {
                List<String> imgPathList = new ArrayList<>();
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Cursor cursor = contentResolver.query(uri, null, null, null, null);
                while (cursor.moveToNext()) {
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    imgPathList.add(path);
                }
                cursor.close();
                return imgPathList;
            }

            @Override
            protected void onPostExecute(List<String> imgPathList) {
                callback.callback(imgPathList);
            }
        }.execute();
    }


    public interface GetLocalImagesCallback {
        void callback(List<String> imageList);
    }


}
