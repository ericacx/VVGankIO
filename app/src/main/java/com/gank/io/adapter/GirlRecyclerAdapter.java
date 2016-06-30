package com.gank.io.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.gank.io.R;

import java.util.List;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/6/29.
 */

public class GirlRecyclerAdapter extends BaseRecyclerAdapter {
    public GirlRecyclerAdapter(Context context, List data, int id) {
        super(context, data, id);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerAdapter.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    public class ViewHolder extends BaseRecyclerAdapter.ViewHolder {
        public ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
