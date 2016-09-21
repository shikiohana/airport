package com.example.administrator.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.PlanOrder;

import java.util.List;

/**
 * 计划工单adapter
 * Created by quick_tech cpc on 2016/9/5.
 */
public class PlanWorkOrderAdapter extends RecyclerView.Adapter {
    WorkItemClickListener workItemClickListener;

    Context context;
    List<PlanOrder.DataBean> list;
    PlanOrder.DataBean dataBean;

    /**
     * 点击事件
     */
    public interface WorkItemClickListener {
        void itemCLicked(View view, int position);
    }

    public PlanWorkOrderAdapter(Context context, List<PlanOrder.DataBean> list) {

        this.context = context;
        this.list = list;
    }

    public void setOnWorkItemClickListener(WorkItemClickListener workItemClickListener) {
        this.workItemClickListener = workItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size()>0?list.size():1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final OrderHolder orderHolder = (OrderHolder) holder;
        final int itemId = position;
        if(list.size()==0){
            orderHolder.content.setVisibility(View.GONE);
            orderHolder.aid.setVisibility(View.GONE);
            orderHolder.user.setText("此条目没有数据");
            orderHolder.user.setGravity(Gravity.CENTER);
            orderHolder.user.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }else{
            dataBean=list.get(position);
            orderHolder.orderContent.setText(dataBean.getOrderMemo());
            orderHolder.user.setText(dataBean.getBillCode());
            orderHolder.itemView.setTag(dataBean);
            if (workItemClickListener != null) {
                orderHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        workItemClickListener.itemCLicked(orderHolder.itemView, itemId);
                    }
                });
            }
        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_work_order_item, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new OrderHolder(view);
    }


    class OrderHolder extends RecyclerView.ViewHolder {
        TextView user, orderContent;

        TextView content,aid;

        public OrderHolder(View itemView) {
            super(itemView);
            user = (TextView) itemView.findViewById(R.id.work_order_username);

            orderContent = (TextView) itemView.findViewById(R.id.work_order_content);
            aid=(TextView)itemView.findViewById(R.id.aid);
            content=(TextView)itemView.findViewById(R.id.content);
        }
    }
}
