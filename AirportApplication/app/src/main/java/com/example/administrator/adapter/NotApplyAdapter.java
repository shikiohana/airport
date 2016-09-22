package com.example.administrator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.OrderDb;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/21.
 */
public class NotApplyAdapter extends RecyclerView.Adapter {

    List<OrderDb> list;
    OrderDb orderDb;
    ApplyClickListener applyClickListener;
    public NotApplyAdapter(List<OrderDb> list){
        this.list=list;
    }

    public void setApplyClickListener(ApplyClickListener applyClickListener){
        this.applyClickListener=applyClickListener;
    }
    public interface ApplyClickListener{
        void click(View view,int position);
        void longClick(View view,int position);
    }

    @Override
    public int getItemCount() {
        return list.size()>0?list.size():0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            final ApplyHolder applyHolder=(ApplyHolder)holder;
        orderDb=list.get(position);
            applyHolder.code.setText(orderDb.code);
            applyHolder.content.setText(orderDb.content);
        applyHolder.itemView.setTag(orderDb);
        if(applyClickListener!=null){
            applyHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    applyClickListener.click(applyHolder.itemView,position);
                }
            });
            applyHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    applyClickListener.longClick(applyHolder.itemView,position);
                    return true;
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_work_order_item,null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ApplyHolder(view);
    }

    class ApplyHolder extends RecyclerView.ViewHolder{
        TextView code,content;
        public ApplyHolder(View itemView) {
            super(itemView);
            code=(TextView)itemView.findViewById(R.id.work_order_username);
            content=(TextView)itemView.findViewById(R.id.work_order_content);
        }
    }
}
