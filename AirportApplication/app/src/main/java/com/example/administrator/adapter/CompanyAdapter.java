package com.example.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.Company;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/7.
 */
public class CompanyAdapter extends BaseAdapter {
    private List<Company.DataBean> list;
    private Context context;
    private LayoutInflater inflater;
    public CompanyAdapter(Context context,List<Company.DataBean> list){
        this.list=list;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TitleHolder titleHolder;
        if(view==null){
            view=inflater.inflate(R.layout.company_item,null);
            titleHolder=new TitleHolder();
            titleHolder.textView=(TextView)view.findViewById(R.id.company_name);
            view.setTag(titleHolder);
        }
        titleHolder=(TitleHolder)view.getTag();
        titleHolder.textView.setText(list.get(i).getCustomerName());
        return view;
    }

    class TitleHolder{
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
        return list.size()>0?list.size():0;
    }
}
