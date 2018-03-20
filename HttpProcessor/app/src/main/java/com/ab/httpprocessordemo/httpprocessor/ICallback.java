package com.ab.httpprocessordemo.httpprocessor;

/**
 * Created by shenbinghong on 2018/3/19.
 */

public interface ICallback {
    void onSuccess(String result);
    void onFailure(String e);
}
