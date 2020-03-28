package com.mzdxztm.ztm.library.adapter;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <T>
 */
@Deprecated
public abstract class SelectRvAdapter<T> extends BaseRvAdapter<T> {

    protected boolean[] selects;

    protected int maxSelectCount = 1;

    public SelectRvAdapter(AppCompatActivity activity) {
        super(activity);
        selects = new boolean[getItemCount()];
    }

    @Override
    public void setList(List<T> list) {
        super.setList(list);
        selects = new boolean[getItemCount()];
    }

    protected void changeSelect(int position) {
        if (selects[position] == true) {
            selects[position] = false;
            if (selectChangeListener != null)
                selectChangeListener.onSelectChange(false, position);
        } else {
            if (getSelectCount() < maxSelectCount) {
                selects[position] = true;
                if (selectChangeListener != null)
                    selectChangeListener.onSelectChange(true, position);
            } else {
                showToast("已经选择到最多了");
            }
        }
        notifyItemChanged(position);
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

    public List<T> getSelects() {
        List<T> selectedList = new ArrayList<>();
        for (int i = 0; i < selects.length; i++) {
            if (selects[i] == true) {
                selectedList.add(list.get(i));
            }
        }
        return selectedList;
    }

    private onSelectChangeListener selectChangeListener;

    public void setSelectChangeListener(onSelectChangeListener selectChangeListener) {
        this.selectChangeListener = selectChangeListener;
    }

    public interface onSelectChangeListener {
        void onSelectChange(boolean select, int position);
    }
}
