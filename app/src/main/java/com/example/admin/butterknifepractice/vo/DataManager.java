package com.example.admin.butterknifepractice.vo;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    public static List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("绑定activity中的视图");
        list.add("绑定fragment中的视图");
        return list;
    }
}
