package com.gank.io.network.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 上传文件的时候需要用到的转换工厂类
 * 否则用 GsonConverterFactory 会把 File 类型转换成文件路径
 * Usage:addConverterFactory(new FileRequestBodyConverterFactory())
 */

public class FileRequestBodyConverterFactory extends Converter.Factory {
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new FileRequestBodyConverter();
    }
}
