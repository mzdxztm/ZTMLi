package com.mzdxztm.ztm.library.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mzdxztm.ztm.library.R;
import com.mzdxztm.ztm.library.data.resource.Src;
import com.mzdxztm.ztm.library.hardware.use.Takephone;
import com.mzdxztm.ztm.library.popwindow.ImageCheckPopwindow;
import com.mzdxztm.ztm.library.image.ImageUtils;

import java.util.List;

public class ImageSelectRvAdapter extends SelectRvAdapter<String> implements BaseRvAdapter.OnAdapterViewClickListener {

    private boolean showCamera;//是否显示相机
    private int cameraIcon;
    private ImageCheckPopwindow imgCheckPop;

    public ImageSelectRvAdapter(AppCompatActivity activity) {
        super(activity);
        showCamera = true;
        cameraIcon = R.drawable.ic_camera;
        imgCheckPop = new ImageCheckPopwindow(activity);
        getLocalImages();
    }

    @Override
    public int getItemCount() {
        if (showCamera == true) return list.size() + 1;
        else return list.size();
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(Context context, int itemType) {
        return new ImageViewHolder(Src.layout(R.layout.recy_image_select));
    }

    @Override
    public void bindData(RecyclerView.ViewHolder viewHolder, int position) {
        ImageViewHolder ivViewHolder = (ImageViewHolder) viewHolder;
        setAdapterViewClickListener(ivViewHolder.ivImg, position, this);
        setAdapterViewClickListener(ivViewHolder.ivSelect, position, this);
        //
        if (showCamera && position == 0) {
            ivViewHolder.ivSelect.setVisibility(View.GONE);
            ImageUtils.display(cameraIcon, ivViewHolder.ivImg);
        } else {
            ivViewHolder.ivSelect.setVisibility(View.VISIBLE);
            String imgUrl = showCamera ? list.get(position - 1) : list.get(position);
            ImageUtils.display(imgUrl, ivViewHolder.ivImg);
            //
            if (selects[position] == true)
                ivViewHolder.ivSelect.setImageResource(R.drawable.img_select);
            else ivViewHolder.ivSelect.setImageResource(R.drawable.img_unselect);
        }
    }

    public ImageSelectRvAdapter setShowCamera(boolean showCamera) {
        this.showCamera = showCamera;
        return this;
    }

    public ImageSelectRvAdapter setCameraIcon(int cameraIcon) {
        this.cameraIcon = cameraIcon;
        return this;
    }

    public ImageCheckPopwindow getImgCheckPop() {
        return imgCheckPop;
    }

    /*
     *获取本地所有图片
     * */
    public void getLocalImages() {
        ImageUtils.getLocatImages(activity, new ImageUtils.GetLocalImagesCallback() {
            @Override
            public void callback(List<String> imageList) {
                setList(imageList);
                notifyDataSetChanged();

                imgCheckPop.getImgAdapter().setList(list);
                imgCheckPop.getImgAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v, int position) {
        int id = v.getId();
        if (id == R.id.iv_img) {
            if (showCamera && position == 0)
                Takephone.openSysCamera(activity.getApplicationContext());
            else {
                if (showCamera) imgCheckPop.show(position - 1);
                else imgCheckPop.show(position);
            }
        } else if (id == R.id.iv_select) {
            changeSelect(position);
        }
    }

    private class ImageViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivImg;
        public ImageView ivSelect;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivImg = (ImageView) itemView.findViewById(R.id.iv_img);
            this.ivSelect = (ImageView) itemView.findViewById(R.id.iv_select);
        }
    }

}
