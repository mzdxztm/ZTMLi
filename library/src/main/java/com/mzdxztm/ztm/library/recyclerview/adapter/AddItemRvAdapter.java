package com.mzdxztm.ztm.library.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mzdxztm.ztm.library.recyclerview.other.AddItemList;

import java.util.List;

//@Deprecated
public abstract class AddItemRvAdapter<T> extends RecyclerView.Adapter implements AddItemList.OnItemListener {

    protected static final int LAYOUT_TYPE1 = 233;//item 布局
    protected static final int LAYOUT_TYPE2 = 234;//add按钮布局
    private Context context;
    private List<T> list;
    private AddItemList addItemList;//列表增加删除操作类
    private AddItemRvAdapter<T> adapter;//

    public AddItemRvAdapter(Context context, List<T> list) {
        super();
        this.context = context;
        this.list = list;
        adapter = this;
        init();
    }

    private void init() {
        addItemList = new AddItemList(adapter, list);
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        if (itemType == LAYOUT_TYPE1) {
            return initViewHolders()[0];
        } else if (itemType == LAYOUT_TYPE2) {
            return initViewHolders()[1];
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        addItemList.addClickListener(viewHolder.itemView, position, this);
        if (getItemViewType(position) == LAYOUT_TYPE1) {
            itemViewholder(viewHolder, position);
        } else if (getItemViewType(position) == LAYOUT_TYPE2) {
            addViewholder(viewHolder, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == list.size()) return LAYOUT_TYPE1;
        else return LAYOUT_TYPE2;
    }

    /**
     * 第一个ViewHolder是item。第二个ViewHolder是add按钮
     *
     * @return
     */
    protected abstract RecyclerView.ViewHolder[] initViewHolders();

    /**
     * item布局数据班定
     *
     * @param viewHolder
     * @param position
     */
    protected abstract void itemViewholder(RecyclerView.ViewHolder viewHolder, int position);

    /**
     * add按钮布局数据班定
     *
     * @param viewHolder
     * @param position
     */
    protected abstract void addViewholder(RecyclerView.ViewHolder viewHolder, int position);

}
