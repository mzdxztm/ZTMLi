package com.mzdxztm.ztm.library.recyclerview.other;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AddItemList {

    private List list;

    private RecyclerView.Adapter adapter;

    public AddItemList(@NotNull RecyclerView.Adapter adapter, @NotNull List list) {
        this.adapter = adapter;
        this.list = list;
    }

    /**
     * 点击最后一个item是增加item的功能
     *
     * @param v
     * @param position
     * @param listener
     */
    public void addClickListener(View v, int position, OnItemListener listener) {
        if (position != list.size() - 1) {
            if (listener != null) listener.itemClick(v, position);
        } else {
            if (listener != null) listener.addClick(v, position);
        }
    }

    public void deleteItem(int position) {
        list.remove(position);
        adapter.notifyDataSetChanged();
    }

    public void deleteAll() {
        list.clear();
        adapter.notifyDataSetChanged();
    }

    public void addItems(List<String> items) {
        if (this.list == null) this.list = new ArrayList<>();
        this.list.addAll(items);
        adapter.notifyDataSetChanged();
    }

    public interface OnItemListener {

        void itemClick(View v, int position);

        void addClick(View v, int position);
    }

}
