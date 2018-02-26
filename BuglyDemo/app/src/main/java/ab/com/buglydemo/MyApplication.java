package ab.com.buglydemo;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by shenbinghong on 2018/1/23.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "55f56d536a", false);
    }
}
