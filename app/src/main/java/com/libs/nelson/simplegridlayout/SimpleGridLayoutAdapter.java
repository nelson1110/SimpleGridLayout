package com.libs.nelson.simplegridlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SimpleGridLayoutAdapter extends SimpleGridLayout.SimpleGridLayoutAdapter {

    private List<String> strings;

    public SimpleGridLayoutAdapter(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public int getItemColumns() {
        return 5;
    }

    @Override
    public List<View> getItemViews(Context context) {

        List<View> viewList = new ArrayList<>();

        for (String string : strings) {
            viewList.add(LayoutInflater.from(context).inflate(R.layout.item_test,null,false));
        }

        return viewList;
    }

    @Override
    public int getItemWeight(int position) {

        return 1;
    }
}
