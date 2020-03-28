package com.mzdxztm.ztm.library.other.refreshlayout.impl;

import android.annotation.SuppressLint;
import android.view.View;

import com.mzdxztm.ztm.library.other.refreshlayout.api.RefreshHeader;
import com.mzdxztm.ztm.library.other.refreshlayout.internal.InternalAbstract;


/**
 * 刷新头部包装
 * Created by scwang on 2017/5/26.
 */
@SuppressLint("ViewConstructor")
public class RefreshHeaderWrapper extends InternalAbstract implements RefreshHeader/*, InvocationHandler*/ {

    public RefreshHeaderWrapper(View wrapper) {
        super(wrapper);
    }

}
