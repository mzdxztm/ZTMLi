package com.mzdxztm.ztm.library.net;

import io.reactivex.functions.Consumer;

/**
 * 需要统一处理的结果
 */
public class NetResultHandler {

    /**
     * 请求出现错误的处理
     *
     * @return
     */
    public static Consumer<Throwable> errorHandler() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
                // TODO: 2020/3/19  
//                LogUtils.e(throwable);
            }
        };
    }

    /**
     * 其他返回结果处理
     *
     * @param code
     * @param message
     */
    public static void dealResult(int code, String message) {
        // TODO: 2020/3/19
    }


}