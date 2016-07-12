package com.gank.io.network.apis;


import com.gank.io.bean.Message;
import com.gank.io.network.Result;

import retrofit2.http.GET;
import retrofit2.http.Path;
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

public interface MessageService {

//    @GET("Android/{month}/{day}")
    @GET("福利/{month}/{day}")
    Observable<Result<Message>> getMessageList(@Path("month") int month, @Path("day") int day);
}
