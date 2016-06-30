package com.gank.io.network;

import com.gank.io.bean.Girl;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/6/29.
 */

public interface GirlApi {
    @GET("福利/{month}/{day}")
    public rx.Observable<Result<Girl>> getGirlList(@Path("month")int month, @Path("day")int day);
}
