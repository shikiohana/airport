package com.example.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.AccountSet;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/20.
 */
public class AccountAdapter extends BaseAdapter {
    private List<AccountSet.DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public AccountAdapter(Context context, List<AccountSet.DataBean> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TitleHolder titleHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.account_item, null);
            titleHolder = new TitleHolder();
            titleHolder.textView = (TextView) view.findViewById(R.id.account_name);
            view.setTag(titleHolder);
        }
        titleHolder = (TitleHolder) view.getTag();
        titleHolder.textView.setText(list.get(i).getAccountName());
        return view;
    }

    class TitleHolder {
        TextView textView;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size() > 0 ? list.size() : 0;
    }


}
