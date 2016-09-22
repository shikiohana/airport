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
import com.example.administrator.javabean.DeviceFault;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/21.
 */
public class DeviceFaultAdapter extends RecyclerView.Adapter {
    List<DeviceFault.DataBean> list;
    DeviceFault.DataBean dataBean;
    DeviceApplyClick deviceApplyClick;

    public void setDeviceApplyClick(DeviceApplyClick deviceApplyClick){
        this.deviceApplyClick=deviceApplyClick;
    }
    public interface  DeviceApplyClick{
        void deviceClick(View view,View code,View schedule,int position);
    }


    public DeviceFaultAdapter(List<DeviceFault.DataBean> list) {
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
        if (dataBean.isIsApply()) {
            faultHolder.apply.setText("已申报");
        } else {
            faultHolder.apply.setText("未申报");
            faultHolder.rewrite.setTextColor(Color.parseColor("#67ccff"));
            faultHolder.schedule.setEnabled(true);
            faultHolder.code.setEnabled(true);
            if(deviceApplyClick!=null){
                faultHolder.rewrite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deviceApplyClick.deviceClick(faultHolder.itemView,faultHolder.code,faultHolder.schedule,position);
                    }
                });
            }
        }
        faultHolder.device.setText(dataBean.getDeviceName()+"(编号"+dataBean.getDeviceCode()+",规格"+dataBean.getDeviceSPEC()+")");
        faultHolder.faultKey.setText(dataBean.getFaultKey());
        faultHolder.faultContent.setText(dataBean.getFault_Description());
        faultHolder.schedule.setText(dataBean.getSchedulWork()+"");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_fault_item, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new FaultHolder(view);
    }

    class FaultHolder extends RecyclerView.ViewHolder {
        TextView rewrite,  device, apply, faultKey, faultContent;
        EditText schedule,code;
        public FaultHolder(View itemView) {
            super(itemView);
            rewrite=(TextView)itemView.findViewById(R.id.rewrite);
            code = (EditText) itemView.findViewById(R.id.fault_code);
            schedule = (EditText) itemView.findViewById(R.id.fault_schedule);
            device = (TextView) itemView.findViewById(R.id.fault_device);
            apply = (TextView) itemView.findViewById(R.id.fault_apply);
            faultKey = (TextView) itemView.findViewById(R.id.fault_key);
            faultContent = (TextView) itemView.findViewById(R.id.fault_content);
        }
    }
}
