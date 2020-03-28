package com.mzdxztm.ztm.library.other.refreshlayout.api;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * 默认Footer创建器
 * Created by scwang on 2018/1/26.
 */
public interface DefaultRefreshFooterCreator {
    @NonNull
    RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout);
}
