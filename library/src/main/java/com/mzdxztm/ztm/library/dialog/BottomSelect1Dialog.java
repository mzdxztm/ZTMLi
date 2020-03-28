package com.mzdxztm.ztm.library.dialog;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.view.WheelView;
import com.mzdxztm.ztm.library.R;
import com.mzdxztm.ztm.library.data.resource.Src;

import java.util.List;

public class BottomSelect1Dialog extends BaseDialog {

    private List<String> list;
    private ViewHolder holder;
    private boolean isSelect;
    private int currentSelectIndex;

    public BottomSelect1Dialog(@NonNull Activity activity, List<String> list) {
        super(activity, R.style.dialog_style);
        this.list = list;
        currentSelectIndex = -1;
        initView(activity);
        initData();
    }

    private void initView(@NonNull Context context) {
        setGravity(Gravity.BOTTOM);
        setWindowAnimations(R.style.bottom_dialog_anim);
        contentView = Src.layout(R.layout.dialog_bottom_wheel_select);
        holder = new ViewHolder(contentView);
        holder.tvCancle.setOnClickListener(this);
        holder.tvConfirm.setOnClickListener(this);
        setContentView(holder.rootView);
        setDialogWidth(screenWidth);
    }

    private void initData() {
        holder.wheelView.setAdapter(new WheelAdapter() {
            @Override
            public int getItemsCount() {
                return list.size();
            }

            @Override
            public Object getItem(int index) {
                return list.get(index);
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }
        });
    }

    public String getCurrentItem() {
        return list.get(holder.wheelView.getCurrentItem());
    }

    public int getCurrentSelectIndex() {
        return currentSelectIndex;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_cancle) {
            dismiss();
        } else if (id == R.id.tv_confirm) {
            if (selectCallback != null)
                selectCallback.selectResult(holder.wheelView.getCurrentItem());
            isSelect = true;
            currentSelectIndex = holder.wheelView.getCurrentItem();
            dismiss();
        }
    }

    public boolean isSelect() {
        return isSelect;
    }

    private SelectCallback selectCallback;

    public void addSelectCallback(SelectCallback selectCallback) {
        this.selectCallback = selectCallback;
    }

    public interface SelectCallback {
        void selectResult(int position);
    }

    private static class ViewHolder {
        public View rootView;
        public TextView tvCancle;
        public TextView tvConfirm;
        public WheelView wheelView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tvCancle = (TextView) rootView.findViewById(R.id.tv_cancle);
            this.tvConfirm = (TextView) rootView.findViewById(R.id.tv_confirm);
            this.wheelView = (WheelView) rootView.findViewById(R.id.wheelView);
        }

    }

}
