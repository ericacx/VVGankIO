package com.gank.io.presenter;

import android.content.Context;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/7/7.
 */
//data 操作
public interface IPresenter<V> {
    void attachView(V view,Context context);
}
