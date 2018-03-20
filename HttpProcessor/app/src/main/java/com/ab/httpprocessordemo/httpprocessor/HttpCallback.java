package com.ab.httpprocessordemo.httpprocessor;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by shenbinghong on 2018/3/19.
 */

public abstract class HttpCallback<Result> implements ICallback {
    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clz = analysisClassInfo(this);

        Result objResult = (Result) gson.fromJson(result, clz);
        onResult(objResult);
    }

    protected abstract void onResult(Result objResult);

    private static Class<?> analysisClassInfo(Object object) {
        Type genType = object.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        return (Class<?>) params[0];
    }
}
