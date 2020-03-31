package com.mzdxztm.ztm.library.net;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;
import okhttp3.Request;
import io.reactivex.functions.Consumer;

/**
 *
 */
public class NetRequest {

    private final NetInit netInit;

    public NetRequest() {
        super();
        netInit = NetInit.newInstance();
        netInit.defaultInit();
    }

    public static Request getOkRequest(Map<String, Object> params, String url) {
        return getOkRequest(params, url, false, false);
    }

    public static Request getOkRequest(Map<String, Object> params, String url, boolean addHeader, boolean signParam) {
        if (addHeader == true) NetParam.addHeader(params);
        if (signParam == true) NetParam.addSignParam(params);
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            builder.add(entry.getKey(), entry.getValue().toString());
        }
        return new Request.Builder()
                .url(getFinalUrl(url))
                .put(builder.build())
                .build();
    }

    public static <T> void request(Observable<T> observable, final Consumer<T> consumer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(NetResultHandler.errorHandler())
                .subscribe(consumer, NetResultHandler.errorHandler());
    }

    /**
     * 有时候并不需要baseUrl，所以看传过来的url是非http开头的后缀，
     * 还是http开头的完整地址，得出最后的正确地址
     *
     * @param url
     * @return
     */
    private static String getFinalUrl(String url) {
        if (url == null) return url;
        if (url.startsWith("http")) return url;
        else return NetConstant.base_url;
    }


}
