package com.example.administrator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.UserResult;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/22.
 */
public class SelectUserAdapter extends RecyclerView.Adapter {
    List<UserResult.DataBean> list;
    UserResult.DataBean dataBean;
    UserClickListener userClickListener;
    public SelectUserAdapter(List<UserResult.DataBean> list){
        this.list=list;
    }

    public void setUserClickListener(UserClickListener userClickListener){
        this.userClickListener=userClickListener;
    }
    public interface UserClickListener{
        void click(View view,int position);
    }
    @Override
    public int getItemCount() {
        return list.size()>0?list.size():0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            final UserHolder userHolder=(UserHolder)holder;
        dataBean=list.get(position);
        userHolder.userName.setText(dataBean.getEName());
        userHolder.itemView.setTag(dataBean);
        if(userClickListener!=null){
            userHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userClickListener.click(userHolder.itemView,position);
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_text,null);

        return new UserHolder(view);
    }

    class UserHolder extends RecyclerView.ViewHolder{
        TextView userName;
        public UserHolder(View itemView) {
            super(itemView);
            userName=(TextView)itemView.findViewById(R.id.single_text);
        }
    }
}
