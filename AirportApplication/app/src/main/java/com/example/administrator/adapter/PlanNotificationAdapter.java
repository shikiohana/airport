package com.example.administrator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.PlanNotification;

import java.util.HashMap;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/23.
 */
public class PlanNotificationAdapter extends RecyclerView.Adapter {
    NotificationClick notificationClick;
    List<PlanNotification.DataBean.DetailBean> list;
    PlanNotification.DataBean.DetailBean dataBean;
    HashMap<Integer, Boolean> maps;

    public PlanNotificationAdapter(List<PlanNotification.DataBean.DetailBean> list) {
        this.list = list;
        setAllChecked(false);
    }

    public interface NotificationClick {
        void notificationClicked(View view, int position);
    }

    public void setNotificationClick(NotificationClick notificationClick) {
        this.notificationClick = notificationClick;
    }


    public HashMap<Integer, Boolean> getMaps() {
        if (maps == null) {
            maps = new HashMap<>();
        }
        return maps;
    }


    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() : 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order_details_item, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return new DetailHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final DetailHolder detailHolder = (DetailHolder) holder;
        dataBean = list.get(position);
        detailHolder.checkBox.setChecked(getMaps().get(position));
        detailHolder.count.setText(position + 1 + "");
        detailHolder.content.setText(dataBean.getContentS());
        detailHolder.itemView.setTag(dataBean);
        // detailHolder.remarkContent.setText(getRemarks().get(position));
        if (notificationClick != null) {
            detailHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    notificationClick.notificationClicked(detailHolder.checkBox, position);
                }
            });

        }
    }

    class DetailHolder extends RecyclerView.ViewHolder {
        TextView count, content;
        CheckBox checkBox; //是否完成

        public DetailHolder(View itemView) {
            super(itemView);
            count = (TextView) itemView.findViewById(R.id.count);
            content = (TextView) itemView.findViewById(R.id.content);
            checkBox = (CheckBox) itemView.findViewById(R.id.been_done);

        }
    }

    /**
     * 设置全选和不选
     *
     * @param checked
     */
    public void setAllChecked(boolean checked) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                getMaps().put(i, checked);
            }
        }
    }

    public boolean isAllChecked() {
        return getMaps().containsValue(false) ? false : true;
    }


}
