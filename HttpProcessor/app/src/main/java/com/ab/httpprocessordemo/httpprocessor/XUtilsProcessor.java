package com.ab.httpprocessordemo.httpprocessor;

import android.util.Log;

import com.ab.httpprocessordemo.MyApplication;

import org.xutils.BuildConfig;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * Created by shenbinghong on 2018/3/19.
 */

public class XUtilsProcessor implements IHttpProcessor {
    private static final String TAG = "XUtilsProcessor";

    public XUtilsProcessor(MyApplication a) {
        x.Ext.init(a);
        //是否开启开发、调试模式（开启debug模式会影响性能）
        x.Ext.setDebug(BuildConfig.DEBUG);
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
        requestParams = appendParams(requestParams, params);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: "+result);
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: "+ex.toString());
                callback.onFailure(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
        requestParams = appendParams(requestParams, params);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, result);
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, ex.toString());
                callback.onFailure(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private static RequestParams appendParams(RequestParams requestParams, Map<String, Object> params) {
        for (Map.Entry<String, Object> entry: params.entrySet()) {
            requestParams.addParameter(entry.getKey(), entry.getValue());
        }
        return requestParams;
    }
}
