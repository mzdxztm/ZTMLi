package com.mzdxztm.ztm.library.net;

/**
 * 请求结果实体基类
 * 说明：
 * 1、可能存在其他参数，可根据情况随时更改
 * 2、result字段可能为空，这跟后台有关，所以有必要的时候还是要判空
 *
 * @param <T>
 */
public class BaseRespons<T> {

    private static int SUCCESS_CODE = 200;//成功的code
    private int code;                   //响应码
    private String message;             //提示信息
    private T results;                  //返回的具体数据

    public boolean isSuccess() {
        return getCode() == SUCCESS_CODE;
    }

    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static void setSuccessCode(int successCode) {
        SUCCESS_CODE = successCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "BaseReponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", results=" + results +
                '}';
    }

}
