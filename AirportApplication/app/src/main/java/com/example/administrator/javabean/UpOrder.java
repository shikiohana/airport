package com.example.administrator.javabean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/19.
 */
public class UpOrder {


    /**
     * BillCode : sample string 1
     * ActualWork : 2.0
     * OrderMemo : sample string 3
     * OrderMemoEN : sample string 4
     * Detail : [{"Detail_AId":"97eb48bb-0b3b-4c16-941b-a0f9ce48b799","Checked":true},{"Detail_AId":"97eb48bb-0b3b-4c16-941b-a0f9ce48b799","Checked":true},{"Detail_AId":"97eb48bb-0b3b-4c16-941b-a0f9ce48b799","Checked":true}]
     * Device : [{"AId":"cb01368e-9aaf-4fd8-af94-5a4c5cf70e2a","Checked":true,"RecMan":"sample string 3","Fault":{"AirPoint_AId":"394d260c-02ab-41d5-9811-021cf10f4d29","Fault_AId":"befa0e9b-0407-43e1-8ee4-f86367a19e18","Fault_Description":"sample string 3","Fault_DescriptionEN":"sample string 4","Image":["sample string 1","sample string 2","sample string 3"]}},{"AId":"cb01368e-9aaf-4fd8-af94-5a4c5cf70e2a","Checked":true,"RecMan":"sample string 3","Fault":{"AirPoint_AId":"394d260c-02ab-41d5-9811-021cf10f4d29","Fault_AId":"befa0e9b-0407-43e1-8ee4-f86367a19e18","Fault_Description":"sample string 3","Fault_DescriptionEN":"sample string 4","Image":["sample string 1","sample string 2","sample string 3"]}},{"AId":"cb01368e-9aaf-4fd8-af94-5a4c5cf70e2a","Checked":true,"RecMan":"sample string 3","Fault":{"AirPoint_AId":"394d260c-02ab-41d5-9811-021cf10f4d29","Fault_AId":"befa0e9b-0407-43e1-8ee4-f86367a19e18","Fault_Description":"sample string 3","Fault_DescriptionEN":"sample string 4","Image":["sample string 1","sample string 2","sample string 3"]}}]
     */

    private String BillCode;
    private double ActualWork;
    private String OrderMemo;
    private String OrderMemoEN;
    /**
     * Detail_AId : 97eb48bb-0b3b-4c16-941b-a0f9ce48b799
     * Checked : true
     */

    private List<DetailBean> Detail;
    /**
     * AId : cb01368e-9aaf-4fd8-af94-5a4c5cf70e2a
     * Checked : true
     * RecMan : sample string 3
     * Fault : {"AirPoint_AId":"394d260c-02ab-41d5-9811-021cf10f4d29","Fault_AId":"befa0e9b-0407-43e1-8ee4-f86367a19e18","Fault_Description":"sample string 3","Fault_DescriptionEN":"sample string 4","Image":["sample string 1","sample string 2","sample string 3"]}
     */

    private List<DeviceBean> Device;

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String BillCode) {
        this.BillCode = BillCode;
    }

    public double getActualWork() {
        return ActualWork;
    }

    public void setActualWork(double ActualWork) {
        this.ActualWork = ActualWork;
    }

    public String getOrderMemo() {
        return OrderMemo;
    }

    public void setOrderMemo(String OrderMemo) {
        this.OrderMemo = OrderMemo;
    }

    public String getOrderMemoEN() {
        return OrderMemoEN;
    }

    public void setOrderMemoEN(String OrderMemoEN) {
        this.OrderMemoEN = OrderMemoEN;
    }

    public List<DetailBean> getDetail() {
        return Detail;
    }

    public void setDetail(List<DetailBean> Detail) {
        this.Detail = Detail;
    }

    public List<DeviceBean> getDevice() {
        return Device;
    }

    public void setDevice(List<DeviceBean> Device) {
        this.Device = Device;
    }

    public static class DetailBean {
        private String Detail_AId;
        private boolean Checked;

        public String getDetail_AId() {
            return Detail_AId;
        }

        public void setDetail_AId(String Detail_AId) {
            this.Detail_AId = Detail_AId;
        }

        public boolean isChecked() {
            return Checked;
        }

        public void setChecked(boolean Checked) {
            this.Checked = Checked;
        }
    }

    public static class DeviceBean implements Parcelable {

        private String AId;
        private boolean Checked;
        private String RecMan;
        /**
         * AirPoint_AId : 394d260c-02ab-41d5-9811-021cf10f4d29
         * Fault_AId : befa0e9b-0407-43e1-8ee4-f86367a19e18
         * Fault_Description : sample string 3
         * Fault_DescriptionEN : sample string 4
         * Image : ["sample string 1","sample string 2","sample string 3"]
         */

        private FaultBean Fault;

        public String getAId() {
            return AId;
        }

        public void setAId(String AId) {
            this.AId = AId;
        }

        public boolean isChecked() {
            return Checked;
        }

        public void setChecked(boolean Checked) {
            this.Checked = Checked;
        }

        public String getRecMan() {
            return RecMan;
        }

        public void setRecMan(String RecMan) {
            this.RecMan = RecMan;
        }

        public FaultBean getFault() {
            return Fault;
        }

        public void setFault(FaultBean Fault) {
            this.Fault = Fault;
        }

        public static class FaultBean implements Parcelable {
            private String AirPoint_AId;
            private String Fault_AId;
            private String Fault_Description;
            private String Fault_DescriptionEN;
            private List<String> Image;

            public String getAirPoint_AId() {
                return AirPoint_AId;
            }

            public void setAirPoint_AId(String AirPoint_AId) {
                this.AirPoint_AId = AirPoint_AId;
            }

            public String getFault_AId() {
                return Fault_AId;
            }

            public void setFault_AId(String Fault_AId) {
                this.Fault_AId = Fault_AId;
            }

            public String getFault_Description() {
                return Fault_Description;
            }

            public void setFault_Description(String Fault_Description) {
                this.Fault_Description = Fault_Description;
            }

            public String getFault_DescriptionEN() {
                return Fault_DescriptionEN;
            }

            public void setFault_DescriptionEN(String Fault_DescriptionEN) {
                this.Fault_DescriptionEN = Fault_DescriptionEN;
            }

            public List<String> getImage() {
                return Image;
            }

            public void setImage(List<String> Image) {
                this.Image = Image;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.AirPoint_AId);
                dest.writeString(this.Fault_AId);
                dest.writeString(this.Fault_Description);
                dest.writeString(this.Fault_DescriptionEN);
                dest.writeStringList(this.Image);
            }

            public FaultBean() {
            }

            protected FaultBean(Parcel in) {
                this.AirPoint_AId = in.readString();
                this.Fault_AId = in.readString();
                this.Fault_Description = in.readString();
                this.Fault_DescriptionEN = in.readString();
                this.Image = in.createStringArrayList();
            }

            public static final Creator<FaultBean> CREATOR = new Creator<FaultBean>() {
                @Override
                public FaultBean createFromParcel(Parcel source) {
                    return new FaultBean(source);
                }

                @Override
                public FaultBean[] newArray(int size) {
                    return new FaultBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.AId);
            dest.writeByte(this.Checked ? (byte) 1 : (byte) 0);
            dest.writeString(this.RecMan);
            dest.writeParcelable(this.Fault, flags);
        }

        public DeviceBean() {
        }

        protected DeviceBean(Parcel in) {
            this.AId = in.readString();
            this.Checked = in.readByte() != 0;
            this.RecMan = in.readString();
            this.Fault = in.readParcelable(FaultBean.class.getClassLoader());
        }

        public static final Parcelable.Creator<DeviceBean> CREATOR = new Parcelable.Creator<DeviceBean>() {
            @Override
            public DeviceBean createFromParcel(Parcel source) {
                return new DeviceBean(source);
            }

            @Override
            public DeviceBean[] newArray(int size) {
                return new DeviceBean[size];
            }
        };
    }



    public  void setDetails(List<OrderDetails.DataBean.DetailBean> list,HashMap<Integer,Boolean> checkList){
        if(Detail==null){
            Detail=new ArrayList<>();
        }
        for (int i=0;i<list.size();i++){
           DetailBean detailBean=new DetailBean();
            OrderDetails.DataBean.DetailBean ordDetail=list.get(i);
            detailBean.setDetail_AId(ordDetail.getDetail_AId());
            detailBean.setChecked(checkList.get(i));
            Detail.add(detailBean);
        }
    }
    public  void setPlanDetails(List<PlanNotification.DataBean.DetailBean> list,HashMap<Integer,Boolean> checkList){
        if(Detail==null){
            Detail=new ArrayList<>();
        }
        for (int i=0;i<list.size();i++){
            DetailBean detailBean=new DetailBean();
            PlanNotification.DataBean.DetailBean ordDetail=list.get(i);
            detailBean.setDetail_AId(ordDetail.getDetail_AId());
            detailBean.setChecked(checkList.get(i));
            Detail.add(detailBean);
        }
    }

    public void setDevices(ArrayList<com.example.administrator.javabean.Device.DataBean> list){
        if(Device==null){
            Device=new ArrayList<>();
        }
        for(int i=0;i<list.size();i++){
            DeviceBean deviceBean=new DeviceBean();
            com.example.administrator.javabean.Device.DataBean dataBean=list.get(i);
            com.example.administrator.javabean.Device.DataBean.FaultBean myFaultbean=dataBean.getFault();
            DeviceBean.FaultBean faultBean=new DeviceBean.FaultBean();
            faultBean.setFault_AId(myFaultbean.getFault_AId());
            faultBean.setAirPoint_AId(myFaultbean.getAirPoint_AId());
            List<String> urls=new ArrayList<>();
            List<com.example.administrator.javabean.Device.DataBean.FaultBean.ImageBean> imgs
                    =myFaultbean.getImage();
            for(com.example.administrator.javabean.Device.DataBean.FaultBean.ImageBean imageBean:imgs){
                urls.add(imageBean.getIMGUrl());
            }
            faultBean.setImage(urls);
            faultBean.setFault_Description(myFaultbean.getFault_Description());
            faultBean.setFault_DescriptionEN(myFaultbean.getFault_DescriptionEN());

            deviceBean.setFault(faultBean);
            deviceBean.setRecMan(dataBean.getRecMan());
            deviceBean.setAId(dataBean.getAId());
            deviceBean.setChecked(dataBean.isChecked());
            Device.add(deviceBean);
        }
    }
}
