package com.gank.io.network;

import android.content.Context;
import android.widget.Toast;

import com.gank.io.util.NetWorkCheckUtil;

import rx.functions.Func1;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/7/7.
 */

public class ErrorResultFunc<T> implements Func1<Throwable, Result<T>> {
    Context context;

    public ErrorResultFunc(Context context) {
        this.context = context;
    }

    @Override
    public Result<T> call(Throwable throwable) {
        //处理异常
        if(!NetWorkCheckUtil.checkNet(context)){
            Toast.makeText(context, "网络不可用", Toast.LENGTH_LONG).show();
        }
        return null;
    }
}
