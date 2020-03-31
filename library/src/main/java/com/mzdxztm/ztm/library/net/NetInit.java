package com.mzdxztm.ztm.library.net;

import com.mzdxztm.ztm.library.common.FileUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * *
 * *
 */
public class NetInit {

    private static NetInit netInit = null;

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    private NetInit() {
    }

    public static NetInit newInstance() {
        if (netInit == null) {
            synchronized (NetInit.class) {
                if (netInit == null) {
                    netInit = new NetInit();
                }
            }
        }

        return netInit;
    }

    public NetInit defaultInit() {
        File cacheFile = FileUtils.createFile(NetConstant.cache_path, false);
        //初始化Okhttp,绑定拦截器事件
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(NetConstant.timeout, TimeUnit.SECONDS)                   //设置请求超时时间
                .readTimeout(NetConstant.timeout, TimeUnit.SECONDS)                      //设置读取数据超时时间
                .writeTimeout(NetConstant.timeout, TimeUnit.SECONDS)                     //设置写入数据超时时间
                .addInterceptor(NetInterceptor.getLogInterceptor())              //绑定日志拦截器
                .addNetworkInterceptor(NetInterceptor.getHeaderInterceptor())       //绑定header拦截器
                .cache(new Cache(cacheFile, NetConstant.cache_size))                       //设置网络缓存
                .build();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//设置gson转换器,将返回的json数据转为实体
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //设置CallAdapter
//                .baseUrl(baseUrl) //设置客户端okhttp相关参数
                .client(okHttpClient)
                .build();
        return this;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }



}
