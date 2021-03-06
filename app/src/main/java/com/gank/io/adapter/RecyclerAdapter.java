package com.gank.io.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gank.io.R;
import com.gank.io.bean.Message;
import com.gank.io.network.GlideUtil;

import java.util.List;

import butterknife.BindView;


/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/6/27.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Message> mData;
    private Context mContext;

    public RecyclerAdapter(Context context, List<Message> data) {
        mContext = context;
        mData = data;
    }

    public void setmData(List<Message> data) {
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GlideUtil.loadPic(mContext, mData.get(position).getUrl(), holder.mImage);
//        Glide.with(mContext).load(mData.get(position).getUrl()).crossFade().into(holder.mImage);
//        holder.mTitle.setText(mData.get(position).getWho());
//        holder.mContent.setText(mData.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        public ImageView mImage;
        public TextView mTitle;
        public TextView mContent;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
