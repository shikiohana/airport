package com.example.administrator.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/12.
 */
public class WorkViewPagerAdapter extends PagerAdapter {
    List<View> list;
    public WorkViewPagerAdapter (List<View> list){
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size()>0?list.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager) container).addView(list.get(position), 0);
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(list.get(position));

    }
}
