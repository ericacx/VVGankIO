package com.gank.io.network.converter;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/7/8.
 */

public class FileRequestBodyConverter implements Converter<File, RequestBody> {
    @Override
    public RequestBody convert(File value) throws IOException {
        return RequestBody.create(MediaType.parse("application/otcet-stream"),value);
    }
}
