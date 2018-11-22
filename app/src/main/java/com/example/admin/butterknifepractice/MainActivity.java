package com.example.admin.butterknifepractice;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.butterknifepractice.adapter.MainAdapter;
import com.example.admin.butterknifepractice.vo.DataManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rl)
    RecyclerView rl;

    Context mContext;
    MainAdapter adapter;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        unbinder = ButterKnife.bind(this);
        initRecyclerView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rl.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(DataManager.getList());
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            switch (position) {
                case 0:
                    BAct.launch(mContext);
                    break;
            }
        });
        rl.setAdapter(adapter);
    }
}
