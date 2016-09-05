package com.example.administrator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;

/**
 * Created by quick_tech cpc on 2016/9/5.
 */
public class WorkOrderAdapter extends RecyclerView.Adapter {
    WorkItemClickListener workItemClickListener;

    /**
     * 点击事件
     */
    public interface  WorkItemClickListener{
        void itemCLicked(View view,int position);
    }

    public void setOnWorkItemClickListener(WorkItemClickListener workItemClickListener){
        this.workItemClickListener=workItemClickListener;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,  int position) {
        final OrderHolder orderHolder=(OrderHolder)holder;
        final int itemId=position;
        if(workItemClickListener!=null){
            orderHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    workItemClickListener.itemCLicked(orderHolder.itemView,itemId);
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_work_order_item,null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new OrderHolder(view);
    }


    class OrderHolder extends RecyclerView.ViewHolder{
        TextView user,orderType,orderContent;
        public OrderHolder(View itemView) {
            super(itemView);
            user=(TextView)itemView.findViewById(R.id.work_order_username);
            orderType=(TextView)itemView.findViewById(R.id.work_order_type);
            orderContent=(TextView)itemView.findViewById(R.id.work_order_content);
        }
    }
}
