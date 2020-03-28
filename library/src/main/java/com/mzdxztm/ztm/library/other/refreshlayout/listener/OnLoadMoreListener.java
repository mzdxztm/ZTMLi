package com.mzdxztm.ztm.library.other.refreshlayout.listener;

import android.support.annotation.NonNull;

import com.mzdxztm.ztm.library.other.refreshlayout.api.RefreshLayout;


/**
 * 加载更多监听器
 * Created by scwang on 2017/5/26.
 */
public interface OnLoadMoreListener {
    void onLoadMore(@NonNull RefreshLayout refreshLayout);
}
