package listviewfirstitemdemo.ab.com.listviewfirstitemdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    private ListView listview;
    private ArrayList<HashMap<String,Object>> items = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        items = new ArrayList<HashMap<String, Object>>();

        WeakReference<HashMap<String,Object>> wf = new WeakReference<HashMap<String, Object>>(new HashMap<String,Object>());
        wf.get().put(Constants.TYPE,Constants.GROUP);
        wf.get().put(Constants.DATA,"组");
        items.add(wf.get());

        for (int i = 0; i < 5; i++) {
            WeakReference<HashMap<String,Object>> wf1 = new WeakReference<HashMap<String, Object>>(new HashMap<String,Object>());
            wf1.get().put(Constants.TYPE,Constants.ITEM);
            wf1.get().put(Constants.DATA,i+"子");
            items.add(wf1.get());
        }

        ListViewAdapter adapter = new ListViewAdapter(this,items);
        listview.setAdapter(adapter);
    }
}
