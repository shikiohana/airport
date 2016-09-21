package com.example.administrator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    public DeviceFaultAdapter(List<DeviceFault.DataBean> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() : 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        dataBean = list.get(position);
        FaultHolder faultHolder = (FaultHolder) holder;
        faultHolder.code.setText(dataBean.getBillCode());
        if (dataBean.isIsApply()) {
            faultHolder.apply.setText("已提交");
        } else {
            faultHolder.apply.setText("未提交");
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
        TextView code, schedule, device, apply, faultKey, faultContent;

        public FaultHolder(View itemView) {
            super(itemView);
            code = (TextView) itemView.findViewById(R.id.fault_code);
            schedule = (TextView) itemView.findViewById(R.id.fault_schedule);
            device = (TextView) itemView.findViewById(R.id.fault_device);
            apply = (TextView) itemView.findViewById(R.id.fault_apply);
            faultKey = (TextView) itemView.findViewById(R.id.fault_key);
            faultContent = (TextView) itemView.findViewById(R.id.fault_content);
        }
    }
}
