package com.mzdxztm.ztm.library.net;

import java.util.Map;

public class NetParam {
    /**
     * 必加参数，如userToken
     *
     * @param params
     */
    public static void addHeader(Map<String, Object> params) {
        //params.put("user_token",userToken);
        //.....TODO
    }

    /**
     * 增加app签名参数
     *
     * @param params
     */
    public static void addSignParam(Map<String, Object> params) {
        //通过params和sign_key计算得到sign_value
        params.put(NetConstent.param_sign_key, signParam(params));
    }

    /**
     * 给网络请求参数签名
     *
     * @param params
     * @return 返回网络参数签名字符串
     */
    private static String signParam(Map<String, Object> params) {
        //todo
        return "";
    }


}
