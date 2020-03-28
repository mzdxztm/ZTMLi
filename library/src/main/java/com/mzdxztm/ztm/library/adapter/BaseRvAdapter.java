package com.mzdxztm.ztm.library.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mzdxztm.ztm.library.devices.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRvAdapter<T> extends RecyclerView.Adapter {

    protected List<T> list;

    protected static final int itemId = -100;

    protected AppCompatActivity activity;

    protected int screenWidth;

    protected int screenHeight;

    protected int statueHeight;//状态栏高度

    public BaseRvAdapter(AppCompatActivity activity) {
        this(activity, new ArrayList<T>());
    }

    public BaseRvAdapter(AppCompatActivity activity, List<T> list) {
        this.activity = activity;
        this.list = list;
        if (list == null) list = new ArrayList<>();
        screenHeight = ScreenUtils.getScreenHeight(activity);
        screenWidth = ScreenUtils.getScreenWidth(activity);
        statueHeight = ScreenUtils.getStatusHeight(activity);
    }

    @Override
    public int getItemCount() {
        if (list != null) return list.size();
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return getViewHolder(activity, i);
    }

    protected abstract RecyclerView.ViewHolder getViewHolder(Context context, int itemType);

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        viewHolder.itemView.setId(itemId);
        bindData(viewHolder, i);
    }

    public abstract void bindData(RecyclerView.ViewHolder viewHolder, final int position);

    public T getItem(int position) {
        return list.get(position);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void scollTo(LinearLayoutManager layoutManager, int position) {
        layoutManager.scrollToPositionWithOffset(position, 0);
        layoutManager.setStackFromEnd(true);
    }

    public void showToast(String content) {
        Toast.makeText(activity, content, Toast.LENGTH_LONG).show();
    }

    public void showSnakBar(String content, int showTime) {
        Snackbar.make(activity.getWindow().getDecorView(), content, showTime).show();
    }

    protected void setAdapterViewClickListener(View view, final int position, final OnAdapterViewClickListener onAdapterViewClickListener) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAdapterViewClickListener.onClick(v, position);
            }
        });
    }

    public interface OnAdapterViewClickListener {
        void onClick(View v, int position);
    }

}
