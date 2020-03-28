package com.mzdxztm.ztm.library.recyclerview.other;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

/**
 * RecyclerView.Adapter是选择列表时使用
 */
public class SelectList {

    private boolean[] selects;
    private int maxSelectCount = 1;
    private Context context;
    private onSelectListener selectListener;
    private RecyclerView.Adapter adapter;

    public SelectList(@NotNull Context context, @NotNull RecyclerView.Adapter adapter) {
        this.context = context;
        this.adapter = adapter;
        selects = new boolean[adapter.getItemCount()];
    }

    public void select(int position) {
        if (selects[position] == true) {
            selects[position] = false;
            if (selectListener != null)
                selectListener.onSelectChange(false, position);
        } else {
            if (getSelectCount() < maxSelectCount) {
                selects[position] = true;
                if (selectListener != null)
                    selectListener.onSelectChange(true, position);
            } else {
//                Toast.makeText(context, "已经选择到最多了", Toast.LENGTH_SHORT).show();
            }
        }
        adapter.notifyItemChanged(position);
    }

    public int getSelectCount() {
        int count = 0;
        for (int i = 0; i < selects.length; i++) {
            if (selects[i] == true) count++;
        }
        return count;
    }

    public int getMaxSelectCount() {
        return maxSelectCount;
    }

    public void setMaxSelectCount(int maxSelectCount) {
        this.maxSelectCount = maxSelectCount;
    }

    public void setSelectListener(onSelectListener selectListener) {
        this.selectListener = selectListener;
    }

    public interface onSelectListener {
        void onSelectChange(boolean select, int position);
    }

}
