package com.mzdxztm.ztm.library.popwindow;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mzdxztm.ztm.library.R;
import com.mzdxztm.ztm.library.adapter.ImageCheckRvAdapter;
import com.mzdxztm.ztm.library.data.resource.Res;
import com.ruffian.library.RTextView;

import java.io.File;

public class ImageCheckPopwindow extends FullScreenPopWindow implements ImageCheckRvAdapter.PagerChangeListener {

    private ImageCheckRvAdapter imgAdapter;
    private ViewHolder holder;

    public ImageCheckPopwindow(AppCompatActivity activity) {
        super(activity);
        initView(activity);
    }

    private void initView(AppCompatActivity activity) {
        View view = Res.layout(R.layout.pop_image_check);
        holder = new ViewHolder(view);
        holder.rtvBack.setOnClickListener(this);
        //adapter
        imgAdapter = new ImageCheckRvAdapter(activity, holder.recyclerView);
        imgAdapter.setPagerChangeListener(this);
        //
        setContentView(view);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.rtv_back) {
            dismiss();
        }
    }

    public void show(int position) {
        imgAdapter.scollTo((LinearLayoutManager) holder.recyclerView.getLayoutManager(), position);
        changeUi(position);
        super.show();
    }

    public ImageCheckRvAdapter getImgAdapter() {
        return imgAdapter;
    }

    @Override
    public void onPagerChange(int postion) {
        changeUi(postion);
    }

    private void changeUi(int postion) {
        int size = imgAdapter.getList().size();
        holder.tvIndicator.setText(postion + 1 + "/" + size);
        holder.tvTitle.setText(new File(imgAdapter.getItem(postion)).getName());
    }

    private static class ViewHolder {
        public View rootView;
        public RecyclerView recyclerView;
        public TextView tvTitle;
        public RTextView rtvBack;
        public TextView tvIndicator;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
            this.tvTitle = (TextView) rootView.findViewById(R.id.tv_title);
            this.rtvBack = (RTextView) rootView.findViewById(R.id.rtv_back);
            this.tvIndicator = (TextView) rootView.findViewById(R.id.tv_indicator);
        }

    }
}
