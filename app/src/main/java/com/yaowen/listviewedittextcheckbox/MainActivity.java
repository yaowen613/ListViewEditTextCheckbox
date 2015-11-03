package com.yaowen.listviewedittextcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button selectAllBtn;
    private Button deselectAllBtn;
    private Button cancelSelectAll;

    private ListView listView;
    private ListEditorAdapter mAdapter;

    private List<Map<String, String>> mData = new ArrayList<Map<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectAllBtn = (Button) findViewById(R.id.btn_selectAll);
        selectAllBtn.setOnClickListener(this);
        deselectAllBtn = (Button) findViewById(R.id.btn_cancleselectall);
        deselectAllBtn.setOnClickListener(this);
        cancelSelectAll = (Button) findViewById(R.id.btn_cancelAll);
        cancelSelectAll.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.list);
        mAdapter = new ListEditorAdapter(this);
        listView.setAdapter(mAdapter);
        for (int i = 0; i < 20; i++) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("list_item_inputvalue", i + "");
            mData.add(item);
        }
        mAdapter.setData(mData);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_selectAll:
                for (int i = 0; i < mData.size(); i++) {
                    mAdapter.getIsSelected().put(i, true);
                }
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_cancleselectall:
                // ±éÀúlistµÄ³¤¶È£¬½«ÒÑÑ¡µÄÉèÎªÎ´Ñ¡£¬Î´Ñ¡µÄÉèÎªÒÑÑ¡
                for (int i = 0; i < mData.size(); i++) {
                    if (mAdapter.getIsSelected().get(i)) {
                        mAdapter.getIsSelected().put(i, false);
                    } else {
                        mAdapter.getIsSelected().put(i, true);
                    }
                }
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_cancelAll:
                for (int i = 0; i < mData.size(); i++) {
                    if (mAdapter.getIsSelected().get(i)) {
                        mAdapter.getIsSelected().put(i, false);
                    }
                }
                mAdapter.notifyDataSetChanged();
                break;
        }
    }
}
