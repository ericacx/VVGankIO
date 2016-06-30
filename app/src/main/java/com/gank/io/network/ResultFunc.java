package com.gank.io.network;

import rx.functions.Func1;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/6/29.
 */

public class ResultFunc<T> implements Func1<Result<T>, Boolean> {

    @Override
    public Boolean call(Result<T> result){
        return !result.isError();
    }
}
