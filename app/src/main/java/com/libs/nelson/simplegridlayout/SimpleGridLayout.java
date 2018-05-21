package com.libs.nelson.simplegridlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

public class SimpleGridLayout extends LinearLayout {

    private SimpleGridLayoutAdapter mAdapter;

    public SimpleGridLayout(Context context) {
        this(context,null);
    }

    public SimpleGridLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);

    }

    private void layoutViews(){
        removeAllViews();
        if(mAdapter == null){
            return;
        }

        List<View> allViews = mAdapter.getItemViews(getContext());
        int rows = allViews.size() / mAdapter.getItemColumns();

        int totalRows = 0;
        if(allViews.size()%mAdapter.getItemColumns()!=0){
            totalRows = rows + 1;
        }else {
            totalRows = rows;
        }


        for (int i = 0; i < totalRows; i++) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(HORIZONTAL);
            linearLayout.setWeightSum(mAdapter.getItemColumns());
            List<View> itemViews;

            if(i<totalRows-1){
                itemViews = allViews.subList(i * mAdapter.getItemColumns(), (i + 1) * mAdapter.getItemColumns());
            }else {
                itemViews = allViews.subList(i * mAdapter.getItemColumns(), allViews.size());
            }


            for (View view : itemViews) {
                LayoutParams layoutParams = new LayoutParams(0,
                        ViewGroup.LayoutParams.WRAP_CONTENT, mAdapter.getItemWeight(allViews.indexOf(view)));
                view.setLayoutParams(layoutParams);
                linearLayout.addView(view);
            }

            addView(linearLayout);

        }

        invalidate();

    }

    public void setAdapter(SimpleGridLayoutAdapter adapter){
        mAdapter = adapter;
        adapter.attachToSimpleGridLayout(this);
        layoutViews();

    }




    public static abstract class SimpleGridLayoutAdapter {

        private SimpleGridLayout instance;

        void attachToSimpleGridLayout(SimpleGridLayout gridLayout){
            this.instance = gridLayout;
        }

        public abstract int getItemColumns();

        public abstract List<View> getItemViews(Context context);

        public int getItemWeight(int position){
            return 1;
        }

        public void notifyDataSetChanged(){
            instance.layoutViews();
        }
    }





}
