package com.gank.io.presenter;

import android.os.Handler;

import com.gank.io.adapter.RecyclerAdapter;
import com.gank.io.bean.Message;
import com.gank.io.network.Api;
import com.gank.io.network.BaseSubscriber;
import com.gank.io.network.Result;
import com.gank.io.network.ResultFunc;
import com.gank.io.network.apis.MessageService;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/7/7.
 */

public class MainActivityPresenter extends BasePresenter {
    public int[] days = {31, 28, 30, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int month = 10;
    int day = 1;
    public boolean isPull = true;

    public List<Message> mData = new ArrayList<>();
    public RecyclerAdapter recyclerAdapter;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    operatorView.setRefreshing(false);
                    recyclerAdapter.notifyDataSetChanged();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void initData() {
        Observable<Result<Message>> messageListCall;
        BaseSubscriber<Result<Message>> subscriber;
        //请求数据
        messageListCall= Api.createApi(MessageService.class).getMessageList(month,day);
        subscriber = new BaseSubscriber<Result<Message>>(context) {
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(Result<Message> messageResult) {
                super.onNext(messageResult);
                if (isPull) {
                    mData = messageResult.getResultList();
                } else {
                    mData.addAll(messageResult.getResultList());
                }
                recyclerAdapter.setmData(mData);

                mHandler.sendEmptyMessage(1);
            }

        };
        messageListCall.
                filter(new ResultFunc<Message>() {
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void refresh() {
        isPull = true;
        //刷新数据
        initData();
    }

    public void loadMore() {
        isPull = false;

        day++;
        if (day > days[month - 1]) {
            month = (month++) % 12;
            day = 1;
        }
        initData();
    }
}
