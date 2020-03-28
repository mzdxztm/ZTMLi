package com.mzdxztm.ztm.library.net;

/**
 * 这个接口木有实现任何功能，只是单纯的文档说明
 */
public interface Doc {

    /**
     * 网络请求的封装目标
     * 目标：
     *  1、OkHttpClient（日志拦截器、头拦截器、网络缓存）与Retrofit（gson转换器、rxjava、okhttp，baseUrl）基本配置
     *  2、简化observable，统一处理错误的请求结果，编写BaseRespons处理返回结果，顺便配置OkHttpClient的Request对象
     *  observable.subscribeOn(Schedulers.io())
     *  .observeOn(AndroidSchedulers.mainThread())
     *  .doOnError(NetResultHandler.errorHandler())
     *  .subscribe(consumer, NetResultHandler.errorHandler());
     *  <p>
     *  public static Consumer<Throwable> errorHandler() {
     *  return new Consumer<Throwable>() {
     *
     *  @Override public void accept(Throwable throwable) throws Exception {
     *  throwable.printStackTrace();
     *  LogUtils.e(throwable);
     *  }
     *  };
     *  }
     *  3、统一处理请求必加参数和参数签名
     *  4、处理后台访问和下载的数据（app下载更新等）
     *  5、处理小请求（收藏、点赞、喜欢）
     *  6、处理需要保存到db的数据（浏览记录、城市地区数据（持续更新）、搜索条件常用数据（持续更新）等）
     *  7、处理每个请求都可能附加的请求（app检查更新，用户是否处于登陆状态等）
     *  8、必要时，检查线程管理
     */

    /**
     * 需要项目开发时才能完善的功能（一般都加了todo）
     * 1、增加必须参数和签名参数
     * 2.base_url,签名参数所使用secret，网络缓存路径
     * 3、网络参数签名功能
     * 4、BaseResons
     * 5、返回结果的统一处理
     */

}
