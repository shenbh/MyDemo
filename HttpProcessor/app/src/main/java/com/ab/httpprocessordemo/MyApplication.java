package com.ab.httpprocessordemo;

import android.app.Application;

import com.ab.httpprocessordemo.httpprocessor.HttpHelper;
import com.ab.httpprocessordemo.httpprocessor.OkHttpProcessor;
import com.ab.httpprocessordemo.httpprocessor.VolleyProcessor;
import com.ab.httpprocessordemo.httpprocessor.XUtilsProcessor;

/**
 * Created by shenbinghong on 2018/3/19.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.init(new VolleyProcessor(this));
//        HttpHelper.init(new OkHttpProcessor());
//        HttpHelper.init(new XUtilsProcessor(this));
    }
}
