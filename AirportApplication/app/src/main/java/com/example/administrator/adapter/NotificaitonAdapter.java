package com.example.administrator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.MyNotification;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/23.
 */
public class NotificaitonAdapter extends RecyclerView.Adapter {
    List<MyNotification.DataBean> list;
    MyNotification.DataBean dataBean;
    NotificationClick notificationClick;


    public NotificaitonAdapter(List<MyNotification.DataBean> list){
        this.list=list;
    }
    public void setNotificationClick(NotificationClick notificationClick){
        this.notificationClick=notificationClick;
    }
    public interface  NotificationClick{
        void notificationClicked(View view,int position);
    }
    @Override
    public int getItemCount() {
        return list.size()>0?list.size():0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            final NotificationHolder notificationHolder=(NotificationHolder)holder;
            dataBean=list.get(position);
            notificationHolder.content.setText(dataBean.getOrderMemo());
            notificationHolder.code.setText(dataBean.getBillCode());
            notificationHolder.itemView.setTag(dataBean);
        if(notificationClick!=null){
            notificationHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    notificationClick.notificationClicked(notificationHolder.itemView,position);
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_work_order_item,null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new NotificationHolder(view);
    }

    class NotificationHolder extends RecyclerView.ViewHolder{
        TextView code,content;
        public NotificationHolder(View itemView) {
            super(itemView);
            code=(TextView)itemView.findViewById(R.id.work_order_username);
            content=(TextView)itemView.findViewById(R.id.work_order_content);
        }
    }
}
