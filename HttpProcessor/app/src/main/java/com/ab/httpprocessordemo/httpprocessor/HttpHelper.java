package com.ab.httpprocessordemo.httpprocessor;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**代理类
 * Created by shenbinghong on 2018/3/19.
 */

public class HttpHelper implements IHttpProcessor{

    private static IHttpProcessor mHttpProcessor = null;
    private Map<String, Object> params;
    private static HttpHelper _instance;


    private HttpHelper(){
        params = new HashMap<>();
    }

    public static HttpHelper obtain(){
        synchronized (HttpHelper.class){
            if (_instance == null){
                _instance = new HttpHelper();
            }
        }
        return _instance;
    }

    public static void init(IHttpProcessor httpProcessor){
        mHttpProcessor = httpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
//        final String finalUrl = appendParams(url, params);
//        mHttpProcessor.post(finalUrl,params,callback);
        mHttpProcessor.post(url,params,callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
//        final String finalUrl = appendParams(url, params);
        mHttpProcessor.get(url, params, callback);
    }


    private static String appendParams(String url, Map<String, Object> params) {
        if(params ==null ||params.isEmpty()){
            return  url;
        }

        StringBuilder urlBuilder = new StringBuilder();

        if(urlBuilder.indexOf("?")<=0){
            urlBuilder.append("?");
        }else{
            if(!urlBuilder.toString().endsWith("?")){
                urlBuilder.append("&");
            }
        }

        for (Map.Entry<String,Object> entry : params.entrySet()){
            urlBuilder.append(entry.getKey()).append("=").append(encode(entry.getValue().toString()));

        }
        return  urlBuilder.toString();
    }

    //URI不允许有空格等字符，如果参数值有空格，需要此方法进行转换
    private static String encode(String str){
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            //针对不支持的编码进行报错，utf-8应该是支持
            Log.e("参数转码异常", e.toString());
            throw new RuntimeException(e);
        }
    }
}
