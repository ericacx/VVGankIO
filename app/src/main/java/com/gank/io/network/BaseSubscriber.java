package com.gank.io.network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.gank.io.util.NetWorkCheckUtil;

import rx.Subscriber;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/7/7.
 */

public class BaseSubscriber<T extends Result> extends Subscriber<T> {
    Context context;

    public BaseSubscriber(Context context) {
        this.context = context;
    }

    @Override
    public void onCompleted() {
        Log.e("onCompleted", "onCompleted");
    }

    /**
     * 统一处理异常
     * 刚开始有想写到 ErrorResultFunc 里边处理,不过大概因为订阅的线程是 io 线程,所以 toast 不会显示出来,所以还是在这边处理比较好
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        Log.e("onError", e.getMessage());
        if(!NetWorkCheckUtil.checkNet(context)){
            Toast.makeText(context,"网络不可用",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNext(T t) {

    }
}
