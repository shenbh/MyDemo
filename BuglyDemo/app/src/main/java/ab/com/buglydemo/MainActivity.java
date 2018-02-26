package ab.com.buglydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tencent.bugly.crashreport.CrashReport;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.helloTv)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrashReport.testJavaCrash();
            }
        });
    }
}
