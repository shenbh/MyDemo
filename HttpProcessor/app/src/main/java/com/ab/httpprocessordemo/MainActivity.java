package com.ab.httpprocessordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ab.httpprocessordemo.httpprocessor.bean.LoginBean;
import com.ab.httpprocessordemo.httpprocessor.HttpCallback;
import com.ab.httpprocessordemo.httpprocessor.HttpHelper;

import java.util.HashMap;
import java.util.Map;
/**
 * 代理设计模式：项目创建时，就创建一个可切换网络请求框架的代理框架
 *
 *
 * @author shenbinghong
 * @time 2018/3/19 18:27
 * @path com.ab.httpprocessordemo.MainActivity.java
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private String url = "http://debugsfj.bouncebank.com/api/index/login";
    private Map<String, Object> params = new HashMap<>();

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        button = findViewById(R.id.btn_click);
        button.setOnClickListener(this);

        initParams();
    }

    private void initParams() {
        params.put("user_login", "3333");
        params.put("user_pass", "3333");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_click:
                HttpHelper.obtain().post(url, params, new HttpCallback<LoginBean>() {
                    @Override
                    protected void onResult(LoginBean objResult) {
                        StringBuilder sb = new StringBuilder();
                        if (objResult != null) {
                            sb.append("来源: ")
                                    .append("\n")
                                    .append(objResult.getCode())
                                    .append("\n")
                                    .append(objResult.getData().getToken())
                                    .append("\n")
                                    .append(objResult.getData().getInfo().getAvatar())
                                    .append("\n")
                                    .append(objResult.getData().getInfo().getId())
                                    .append("\n")
                                    .append(objResult.getData().getInfo().getUser_name());
                        }
                        System.out.println(sb.toString());
                        textView.setText(sb.toString());
                    }

                    @Override
                    public void onFailure(String e) {
                        Toast.makeText(MainActivity.this, "Oh, My God@@@@@, 网络失败了", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, e);
                    }
                });
                break;
            default:
                break;
        }
    }
}
