package com.mzdxztm.ztm.library.popwindow;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mzdxztm.ztm.library.R;
import com.mzdxztm.ztm.library.adapter.ImageSelectRvAdapter;
import com.mzdxztm.ztm.library.adapter.SelectRvAdapter;
import com.mzdxztm.ztm.library.data.resource.Res;
import com.ruffian.library.RTextView;

public class ImageSelectPopwindow extends FullScreenPopWindow implements SelectRvAdapter.onSelectChangeListener {

    private ViewHolder holder;
    private ImageSelectRvAdapter imageSelectRvAdapter;

    public ImageSelectPopwindow(AppCompatActivity activity) {
        super(activity);
        setAnimationStyle(R.style.right_pop_anim);
        initView();
        initData();
    }

    private void initView() {
        View contentView = Res.layout(R.layout.pop_image_select);
        holder = new ViewHolder(contentView);
        holder.rtvBack.setOnClickListener(this);
        holder.tvIndicator.setOnClickListener(this);
        setContentView(contentView);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.rtv_back) {
            dismiss();
        } else if (id == R.id.tv_indicator) {
            dismiss();
//            if (selectCallback.onSelect(v,));
        }
    }

    private void initData() {
        GridLayoutManager layoutManager = new GridLayoutManager(activity, 3);
        imageSelectRvAdapter = new ImageSelectRvAdapter(activity);
        imageSelectRvAdapter.setSelectChangeListener(this);
        holder.rvImgList.setLayoutManager(layoutManager);
        holder.rvImgList.setAdapter(imageSelectRvAdapter);
        setMaxSelectCount(1);
    }

    public void setMaxSelectCount(int maxSelectCount) {
        imageSelectRvAdapter.setMaxSelectCount(maxSelectCount);
        chageSelect();
    }

    public void setBack(Activity activity) {
        if (imageSelectRvAdapter.getImgCheckPop().isShowing()) {
            imageSelectRvAdapter.getImgCheckPop().dismiss();
        } else if (this.isShowing()) {
            this.dismiss();
        } else {
            activity.finish();
        }
    }

    public ImageSelectRvAdapter getImageSelectRvAdapter() {
        return imageSelectRvAdapter;
    }

    private SelectCallback selectCallback;//选择图片后的回调

    public void setSelectCallback(SelectCallback selectCallback) {
        this.selectCallback = selectCallback;
    }

    @Override
    public void onSelectChange(boolean select, int position) {
        chageSelect();
    }

    private void chageSelect() {
        int maxSelectCount = imageSelectRvAdapter.getMaxSelectCount();
        int size = imageSelectRvAdapter.getSelects().size();
        holder.tvIndicator.setText("(" + size + "/" + maxSelectCount + ")");
    }

    public interface SelectCallback {
        void onSelect(View v, int postion);
    }

    private static class ViewHolder {
        public View rootView;
        public RTextView rtvBack;
        public TextView tvIndicator;
        public RecyclerView rvImgList;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.rtvBack = (RTextView) rootView.findViewById(R.id.rtv_back);
            this.tvIndicator = (TextView) rootView.findViewById(R.id.tv_indicator);
            this.rvImgList = (RecyclerView) rootView.findViewById(R.id.rv_imgList);
        }

    }

}
