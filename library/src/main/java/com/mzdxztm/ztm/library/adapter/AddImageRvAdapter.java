package com.mzdxztm.ztm.library.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mzdxztm.ztm.library.recyclerview.adapter.AddItemRvAdapter;

import java.util.List;

public class AddImageRvAdapter extends AddItemRvAdapter<String> {


    public AddImageRvAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    protected RecyclerView.ViewHolder[] initViewHolders() {
        return new RecyclerView.ViewHolder[0];
    }

    @Override
    protected void itemViewholder(RecyclerView.ViewHolder viewHolder, int position) {

    }

    @Override
    protected void addViewholder(RecyclerView.ViewHolder viewHolder, int position) {

    }

    @Override
    public void itemClick(View v, int position) {

    }

    @Override
    public void addClick(View v, int position) {

    }
}
