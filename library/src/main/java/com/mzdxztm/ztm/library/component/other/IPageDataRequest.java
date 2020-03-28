package com.mzdxztm.ztm.library.component.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页加载的列表数据
 *
 * 1、特殊请求参数和页码的记录
 * 2、刷新列表和加载更多数据变化的不同
 * @param <T>
 */
public abstract class IPageDataRequest<T> {

    public static final String PAGE_KEY = "currentPage";

    private Map<String, Object> param = new HashMap<>();

    private List<T> data = new ArrayList<>();

    private int currentPage = 1;

    public void addParam(String key, Object value) {
        param.put(key, value);
    }

    public void removeParam(String key) {
        param.remove(key);
    }

  /*  public void requestNext() {
        currentPage++;

    }

    public void request() {
        currentPage = 1;
    }*/


}
