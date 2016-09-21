package com.example.administrator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.Device;

import java.util.HashMap;
import java.util.List;

/**
 * 设备详情
 * Created by quick_tech cpc on 2016/9/19.
 */
public class DeviceDetailAdapter extends RecyclerView.Adapter {
    List<Device.DataBean> list;
    HashMap<Integer, Boolean> checks;
    Device.DataBean dataBean;
    DeviceClicked deviceClicked;

    public DeviceDetailAdapter(List<Device.DataBean> list) {
        this.list = list;


        inniChecks();
    }


    private void inniChecks() {
        for (int i = 0; i < list.size(); i++) {
            getChecks().put(i, list.get(i).isChecked());

        }
    }

    public HashMap<Integer, Boolean> getChecks() {
        if (checks == null) {
            checks = new HashMap<>();
        }
        return checks;
    }


    public void setDeviceClicked(DeviceClicked deviceClicked) {
        this.deviceClicked = deviceClicked;
    }

    public interface DeviceClicked {
        void clicked(View view, int i);

        void checked(View view, int i);
    }

    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() : 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final DeviceHolder deviceHolder = (DeviceHolder) holder;
        dataBean = list.get(position);
        deviceHolder.name.setText(dataBean.getDeviceName() + "");
        deviceHolder.spec.setText(dataBean.getDeviceSPEC() + "");
        boolean isCheck = getChecks().get(position);
        deviceHolder.checkBox.setChecked(isCheck);
        Device.DataBean.FaultBean faultBean = dataBean.getFault();
        if (faultBean != null) {
            deviceHolder.content.setText(dataBean.getFault().getFaultKey() + "");
            deviceHolder.fault.setText(dataBean.getFault().getFault_Description() + "");
            deviceHolder.code.setText(dataBean.getDeviceCode() + "");
        }

        if (deviceClicked != null) {
            deviceHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deviceClicked.checked(deviceHolder.checkBox, position);
                }
            });
            deviceHolder.remark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deviceClicked.clicked(deviceHolder.remark, position);
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_device_item, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new DeviceHolder(view);
    }


    class DeviceHolder extends RecyclerView.ViewHolder {
        TextView name, spec, remark, content, fault, code;//设备名称，规格，备注
        CheckBox checkBox;

        public DeviceHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.device_name);
            spec = (TextView) itemView.findViewById(R.id.device_spec);
            remark = (TextView) itemView.findViewById(R.id.device_remark);
            checkBox = (CheckBox) itemView.findViewById(R.id.device_checked);
            content = (TextView) itemView.findViewById(R.id.device_content);
            fault = (TextView) itemView.findViewById(R.id.device_fault);
            code = (TextView) itemView.findViewById(R.id.device_code);
        }
    }


}
