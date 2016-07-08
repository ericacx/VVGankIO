package com.gank.io.presenter;

import android.content.Context;

import com.gank.io.activity.OperatorView;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/7/7.
 */

public class BasePresenter implements IPresenter<OperatorView> {
    OperatorView operatorView;
    Context context;

    void initData() {

    }

    @Override
    public void attachView(OperatorView view, Context context) {
        this.operatorView = view;
        this.context = context;
    }
}
