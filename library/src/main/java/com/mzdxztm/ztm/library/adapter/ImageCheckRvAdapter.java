package com.mzdxztm.ztm.library.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.view.ViewGroup;

import com.mzdxztm.ztm.library.image.ImageUtils;
import com.mzdxztm.ztm.library.view.photoView.PhotoView;


public class ImageCheckRvAdapter extends BaseRvAdapter<String> {

    private RecyclerView recyclerView;

    public ImageCheckRvAdapter(AppCompatActivity activity, RecyclerView recyclerView) {
        super(activity);
        this.recyclerView = recyclerView;
        initRecyclerView(activity, recyclerView);
    }

    private void initRecyclerView(AppCompatActivity activity, RecyclerView recyclerView) {
        //layoutManager
        final LinearLayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        //snapHelper
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            private int lastPostion;

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
               /* if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                }*/
                int position = layoutManager.findFirstVisibleItemPosition();
                if (position != lastPostion) {
                    if (pagerChangeListener != null)
                        pagerChangeListener.onPagerChange(position);
                    lastPostion = position;
                }
            }
        });
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(Context context, int itemType) {
        PhotoView photoView = new PhotoView(context);
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(width, height);
        photoView.setLayoutParams(params);
        photoView.enable();
        return new ImageCheckViewHolder(photoView);
    }

    @Override
    public void bindData(RecyclerView.ViewHolder viewHolder, int position) {
        ImageUtils.display(list.get(position), (PhotoView) viewHolder.itemView);
    }

    private PagerChangeListener pagerChangeListener;

    public void setPagerChangeListener(PagerChangeListener pagerChangeListener) {
        this.pagerChangeListener = pagerChangeListener;
    }

    public interface PagerChangeListener {
        void onPagerChange(int postion);
    }

    private class ImageCheckViewHolder extends RecyclerView.ViewHolder {
        public ImageCheckViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
