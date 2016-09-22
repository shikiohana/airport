package com.example.administrator.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.Applys;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/22.
 */
public class ApplyAdapter extends RecyclerView.Adapter {
    List<Applys.DataBean> list;
    Applys.DataBean dataBean;
    ApplyClick applyClick;

    public void setApplyClick(ApplyClick applyClick) {
        this.applyClick = applyClick;
    }

    public interface ApplyClick {
        void deviceClick(View view, View code, View schedule, int position);
    }


    public ApplyAdapter(List<Applys.DataBean> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() : 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        dataBean = list.get(position);

        final FaultHolder faultHolder = (FaultHolder) holder;
        faultHolder.code.setText(dataBean.getBillCode());
        faultHolder.itemView.setTag(dataBean);
        faultHolder.applyKey.setText("申请状态:");
        faultHolder.applyDetail.setText("内容详情:");
        faultHolder.applyKey.setText("申请内容:");
        if (dataBean.getStatus() == 1) {
            faultHolder.apply.setText("已处理");
            faultHolder.rewrite.setText("取消申请");
        } else {
            faultHolder.apply.setText("未处理");
            faultHolder.rewrite.setTextColor(Color.parseColor("#67ccff"));
            faultHolder.rewrite.setText("取消申请");
            if (applyClick != null) {
                faultHolder.rewrite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        applyClick.deviceClick(faultHolder.itemView, faultHolder.code, faultHolder.schedule, position);
                    }
                });
            }
        }
        //设备详情，故障描述，故障详情，计划工期
        faultHolder.device.setText(dataBean.getDeviceName() + "(编号" + dataBean.getDeviceCode() + ",规格" + dataBean.getDeviceSPEC() + ")");
        faultHolder.faultKey.setText(dataBean.getFaultKey());
        faultHolder.faultContent.setText(dataBean.getApplyDescription());
        faultHolder.schedule.setText(dataBean.getSchedulWork() + "");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_fault_item, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new FaultHolder(view);
    }

    class FaultHolder extends RecyclerView.ViewHolder {
        TextView rewrite, device, apply, faultKey, faultContent;
        EditText schedule, code;
        TextView applyState,applyKey,applyDetail;
        public FaultHolder(View itemView) {
            super(itemView);
            rewrite = (TextView) itemView.findViewById(R.id.rewrite);
            code = (EditText) itemView.findViewById(R.id.fault_code);
            schedule = (EditText) itemView.findViewById(R.id.fault_schedule);
            device = (TextView) itemView.findViewById(R.id.fault_device);
            apply = (TextView) itemView.findViewById(R.id.fault_apply);
            faultKey = (TextView) itemView.findViewById(R.id.fault_key);
            faultContent = (TextView) itemView.findViewById(R.id.fault_content);
            applyState=(TextView)itemView.findViewById(R.id.apply_state);
            applyDetail=(TextView)itemView.findViewById(R.id.apply_detail);
            applyKey=(TextView)itemView.findViewById(R.id.apply_key);
        }
    }
}
