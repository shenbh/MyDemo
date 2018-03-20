package com.ab.httpprocessordemo.httpprocessor;

import java.util.Map;

/**
 * Created by shenbinghong on 2018/3/19.
 */

public interface IHttpProcessor {
    //网络访问：POST，GET，DEL，DELETE，PUT

    void post(String url, Map<String, Object> params, ICallback callback);

    void get(String url, Map<String, Object> params, ICallback callback);
}
