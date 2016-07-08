package com.gank.io.network;

import com.gank.io.bean.Girl;
import com.gank.io.bean.Message;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/6/28.
 */

public class Api {
    private static Api api;
    private final Retrofit retrofit;
    private final MessageApi messageApi;
    private final GirlApi girlApi;

    public static Api getInstance() {
        if (api == null) {
            api = new Api();
        }
        return api;
    }

    public Api() {
        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        messageApi = retrofit.create(MessageApi.class);
        girlApi = retrofit.create(GirlApi.class);
    }

    public Observable<Result<Message>> getMessageList(int month, int day) {
        return messageApi.getAndroid(month, day);
    }

    public Observable<Result<Girl>> getGirlList(int month, int day) {
        return girlApi.getGirlList(month, day);
    }

}
