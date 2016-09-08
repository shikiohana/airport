package com.example.administrator.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/8.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public HomePagerAdapter(FragmentManager fm, List<Fragment> list) {

        super(fm);
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size()>0?list.size():0;
    }



    @Override
    public Fragment getItem(int position) {
        return  (list == null || list.size() == 0) ? null : list.get(position);
    }
}
