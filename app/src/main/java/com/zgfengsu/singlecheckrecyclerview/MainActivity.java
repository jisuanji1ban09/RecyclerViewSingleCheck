package com.zgfengsu.singlecheckrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    SingleCheckAdapter mAdapter;
    private List<SingleCheckBean> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new SingleCheckAdapter(MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
        getData();
    }

    private void getData() {
        for (int i = 0; i < 20; i++) {
            mData.add(new SingleCheckBean(i,"This is message Item "+i,false));
        }
        mAdapter.addData(mData);
    }
}
