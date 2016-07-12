package com.gank.io.network;

import com.gank.io.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/7/12.
 */

public class OkHttpClientProvider {
    private static OkHttpClient okHttpClient;
    private final OkHttpClient.Builder clientBuilder;
    private final Interceptor tokenInterceptor;

    OkHttpClientProvider() {
        /* add headers */
        tokenInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalResponse = chain.request();
                //TO DO add headers
                Request.Builder requestBuilder = originalResponse.newBuilder()
                        .addHeader("token", Constants.TOKEN)
                        .addHeader("", "")
                        .addHeader("", "");
                Request request = requestBuilder.build();
                return chain.proceed(request);

            }
        };

        clientBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            /* 拦截器,输出网络请求和结果的 Log */
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(loggingInterceptor);
        }

        okHttpClient = clientBuilder
                .retryOnConnectionFailure(true)//失败重连
                .connectTimeout(15, TimeUnit.SECONDS)//设置超时
                .addInterceptor(tokenInterceptor)//headers
                .build();
    }

    public static OkHttpClient get() {
        return okHttpClient;
    }
}
