package com.gank.io.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static android.R.attr.id;


/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/6/27.
 */

public abstract class BaseRecyclerAdapter<T extends BaseRecyclerAdapter.ViewHolder> extends RecyclerView.Adapter<T> {
    protected List<T> mData;
    protected Context mContext;
    protected int mLayoutRes;

    public BaseRecyclerAdapter(Context context, List<T> data, int layoutRes) {
        mContext = context;
        mData = data;
        mLayoutRes = id;
    }

    public void setmData(List<T> data) {
        this.mData = data;
    }

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutRes, null);
        T viewHolder=(T)(new ViewHolder(view));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(T holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
