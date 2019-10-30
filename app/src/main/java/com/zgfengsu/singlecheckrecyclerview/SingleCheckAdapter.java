package com.zgfengsu.singlecheckrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SingleCheckAdapter extends RecyclerView.Adapter<SingleCheckAdapter.SingleCheckVH> {

    private List<SingleCheckBean> mData;
    private Context context;
    private int currentIndex = -1;


    public void setData(List<SingleCheckBean> mData) {
        this.mData = mData;
    }


    public void addData(List<SingleCheckBean> data) {
        if (mData != null && mData.size() > 0) {
            mData.addAll(data);
            notifyDataSetChanged();
        } else {
            mData = data;
            notifyDataSetChanged();
        }
    }

    public SingleCheckAdapter(Context context) {
        this.context = context;
    }

    public List<SingleCheckBean> getData() {
        return mData;
    }


    @NonNull
    @Override
    public SingleCheckVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SingleCheckVH(LayoutInflater.from(context).inflate(R.layout.item_single_check, parent, false));
    }

    @Override
    public void onBindViewHolder(SingleCheckVH holder, int position, List<Object> payloads) {
        if (payloads.size() > 0) {
            Log.e("TAG", payloads.get(0) + "   " + System.currentTimeMillis());
            if ("selected".equals(payloads.get(0))) {
                if (currentIndex == position) {
                    holder.imageView.setImageResource(R.drawable.checkbox_unselected_h);
                    currentIndex = -1;
                    mData.get(position).setCheck(false);
                } else {
                    holder.imageView.setImageResource(R.drawable.checkbox_selected_circle_h);
                    currentIndex = position;
                    mData.get(position).setCheck(true);
                }
            } else if ("unSelected".equals(payloads.get(0))) {
                holder.imageView.setImageResource(R.drawable.checkbox_unselected_h);
                mData.get(position).setCheck(false);
            }
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull SingleCheckVH holder, final int position) {
        SingleCheckBean bean = mData.get(position);
        holder.textView.setText(bean.getMsg());
        if (bean.isCheck()) {
            holder.imageView.setBackgroundResource(R.drawable.checkbox_selected_circle_h);
        } else {
            holder.imageView.setBackgroundResource(R.drawable.checkbox_unselected_h);
        }
        holder.itemParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex != -1 && currentIndex != position) {
                    notifyItemChanged(currentIndex, "unSelected");
                }
                notifyItemChanged(position, "selected");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    /**
     * 获取选择Item的实体类
     *
     * @return
     */
    public SingleCheckBean getCheckItem() {
        if (currentIndex == -1) {
            return null;
        }
        return mData.get(currentIndex);
    }


    class SingleCheckVH extends RecyclerView.ViewHolder {

        AppCompatImageView imageView;
        TextView textView;
        RelativeLayout itemParent;

        public SingleCheckVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageCheck);
            textView = itemView.findViewById(R.id.tv);
            itemParent = itemView.findViewById(R.id.itemParent);
        }
    }

}
