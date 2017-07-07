package com.zwl9517.zutillibrary.sample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.zwl9517.zutillibrary.sample.R;
import com.zwl9517.zutillibrary.sample.adpater.ItemAdapter;
import com.zwl9517.zutillibrary.sample.adpater.ItemData;
import com.zwl9517.zutillibrary.sample.adpater.TagItem;
import com.zwl9517.zutilslibrary.log.crash.CrashFileManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<ItemData> items = new ArrayList<>();
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initItems();
    }

    private void initViews() {
        ListView listView = ((ListView) findViewById(R.id.listView));
        listView.setAdapter(adapter = new ItemAdapter(this, items));
        listView.setOnItemClickListener(this);
    }

    private void initItems() {
        items.clear();
        items.add(new ItemData(getString(R.string.take_photo), TagItem.TAG_TAKE_PHOTO, android.R.drawable.ic_menu_camera));
        items.add(new ItemData("测试奔溃", TagItem.TAG_CRASH_LOG));
        items.add(new ItemData("删除奔溃日志", TagItem.TAG_DELETE_CRASH_LOG));
        items.add(new ItemData("ANR", TagItem.TAG_ANR));


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int tag = items.get(position).getTag();
        switch (tag) {
            case TagItem.TAG_TAKE_PHOTO:
                TakePhotoActivity.start(this);
                break;
            case TagItem.TAG_CRASH_LOG:
                Integer.parseInt("s");
                break;
            case TagItem.TAG_DELETE_CRASH_LOG:
                CrashFileManager.deleteAllCrashLog();
                break;
            case TagItem.TAG_ANR:
                ProgressBar progressBar = new ProgressBar(this);
                double max = Math.pow(2, 30);
                Log.e("tag", "【MainActivity】类的方法：【onItemClick】: " + "max=" + max);
                progressBar.setMax((int) max);
                for (int i = 0; i < max; i++) {
                    progressBar.setProgress(i);
                }
                break;
        }
    }


}
