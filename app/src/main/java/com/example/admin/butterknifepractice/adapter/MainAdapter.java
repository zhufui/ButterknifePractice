package com.example.admin.butterknifepractice.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.admin.butterknifepractice.R;

import java.util.List;

public class MainAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MainAdapter(List<String> data) {
        super(R.layout.item_rl, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, item);
    }
}
