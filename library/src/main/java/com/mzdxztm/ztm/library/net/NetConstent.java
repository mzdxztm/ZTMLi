package com.mzdxztm.ztm.library.net;

public interface NetConstent {

    String param_sign_key = "app_secret";//todo
    String param_sign_secret = "123456";//todo

    String base_url = "";//todo

    String cache_path = "//";//网络缓存路径 todo
    int cache_size = 1024 * 1024 * 100;//网络缓存大小

    int timeout = 20;//请求超时

    int net_type_wifi = 1;
    int net_type_gprs = 2;
    int net_type_4g = 3;
    int net_type_3g = 4;
    int net_type_2g = 5;

}
