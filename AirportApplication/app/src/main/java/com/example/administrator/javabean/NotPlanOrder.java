package com.example.administrator.javabean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/12.
 */
public class NotPlanOrder {

    /**
     * Data : [{"BillCode":"201609091024","CustomerCode":"67987961","CustomerName":null,"BillDate":"2016-09-08T16:00:00","BillDateS":null,"Device_AId":"a114ef50-e1c2-41b9-88c6-a3ceca239b86","DeviceName":"梯子","CreateMan":"向凌峰","AirPoint_AId":"27b35512-80f3-45ea-b892-0b7f95358b04","PointName":"机位23","Device_Code":"123456789","SchedulWork":0.5,"Status":0,"State":null,"DoContentS":"快点去加润滑油。","DoContentSEN":"Hurry up to add lubricant.","FinishDate":"0001-01-01T00:00:00","FinishDateS":null,"ResidualTime":0}]
     * ErrorCode : 0
     * ErrorMessage : null
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * BillCode : 201609091024
     * CustomerCode : 67987961
     * CustomerName : null
     * BillDate : 2016-09-08T16:00:00
     * BillDateS : null
     * Device_AId : a114ef50-e1c2-41b9-88c6-a3ceca239b86
     * DeviceName : 梯子
     * CreateMan : 向凌峰
     * AirPoint_AId : 27b35512-80f3-45ea-b892-0b7f95358b04
     * PointName : 机位23
     * Device_Code : 123456789
     * SchedulWork : 0.5
     * Status : 0
     * State : null
     * DoContentS : 快点去加润滑油。
     * DoContentSEN : Hurry up to add lubricant.
     * FinishDate : 0001-01-01T00:00:00
     * FinishDateS : null
     * ResidualTime : 0
     */

    private List<DataBean> Data;

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean implements Parcelable {

        private String BillCode;
        private String CustomerCode;
        private String CustomerName;
        private String BillDate;
        private String BillDateS;
        private String Device_AId;
        private String DeviceName;
        private String CreateMan;
        private String AirPoint_AId;
        private String PointName;
        private String Device_Code;
        private double SchedulWork;
        private int Status;
        private String State;
        private String DoContentS;
        private String DoContentSEN;
        private String FinishDate;
        private String FinishDateS;
        private int ResidualTime;

        public String getBillCode() {
            return BillCode;
        }

        public void setBillCode(String BillCode) {
            this.BillCode = BillCode;
        }

        public String getCustomerCode() {
            return CustomerCode;
        }

        public void setCustomerCode(String CustomerCode) {
            this.CustomerCode = CustomerCode;
        }

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getBillDate() {
            return BillDate;
        }

        public void setBillDate(String BillDate) {
            this.BillDate = BillDate;
        }

        public String getBillDateS() {
            return BillDateS;
        }

        public void setBillDateS(String BillDateS) {
            this.BillDateS = BillDateS;
        }

        public String getDevice_AId() {
            return Device_AId;
        }

        public void setDevice_AId(String Device_AId) {
            this.Device_AId = Device_AId;
        }

        public String getDeviceName() {
            return DeviceName;
        }

        public void setDeviceName(String DeviceName) {
            this.DeviceName = DeviceName;
        }

        public String getCreateMan() {
            return CreateMan;
        }

        public void setCreateMan(String CreateMan) {
            this.CreateMan = CreateMan;
        }

        public String getAirPoint_AId() {
            return AirPoint_AId;
        }

        public void setAirPoint_AId(String AirPoint_AId) {
            this.AirPoint_AId = AirPoint_AId;
        }

        public String getPointName() {
            return PointName;
        }

        public void setPointName(String PointName) {
            this.PointName = PointName;
        }

        public String getDevice_Code() {
            return Device_Code;
        }

        public void setDevice_Code(String Device_Code) {
            this.Device_Code = Device_Code;
        }

        public double getSchedulWork() {
            return SchedulWork;
        }

        public void setSchedulWork(double SchedulWork) {
            this.SchedulWork = SchedulWork;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getState() {
            return State;
        }

        public void setState(String State) {
            this.State = State;
        }

        public String getDoContentS() {
            return DoContentS;
        }

        public void setDoContentS(String DoContentS) {
            this.DoContentS = DoContentS;
        }

        public String getDoContentSEN() {
            return DoContentSEN;
        }

        public void setDoContentSEN(String DoContentSEN) {
            this.DoContentSEN = DoContentSEN;
        }

        public String getFinishDate() {
            return FinishDate;
        }

        public void setFinishDate(String FinishDate) {
            this.FinishDate = FinishDate;
        }

        public String getFinishDateS() {
            return FinishDateS;
        }

        public void setFinishDateS(String FinishDateS) {
            this.FinishDateS = FinishDateS;
        }

        public int getResidualTime() {
            return ResidualTime;
        }

        public void setResidualTime(int ResidualTime) {
            this.ResidualTime = ResidualTime;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.BillCode);
            dest.writeString(this.CustomerCode);
            dest.writeString(this.CustomerName);
            dest.writeString(this.BillDate);
            dest.writeString(this.BillDateS);
            dest.writeString(this.Device_AId);
            dest.writeString(this.DeviceName);
            dest.writeString(this.CreateMan);
            dest.writeString(this.AirPoint_AId);
            dest.writeString(this.PointName);
            dest.writeString(this.Device_Code);
            dest.writeDouble(this.SchedulWork);
            dest.writeInt(this.Status);
            dest.writeString(this.State);
            dest.writeString(this.DoContentS);
            dest.writeString(this.DoContentSEN);
            dest.writeString(this.FinishDate);
            dest.writeString(this.FinishDateS);
            dest.writeInt(this.ResidualTime);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.BillCode = in.readString();
            this.CustomerCode = in.readString();
            this.CustomerName = in.readString();
            this.BillDate = in.readString();
            this.BillDateS = in.readString();
            this.Device_AId = in.readString();
            this.DeviceName = in.readString();
            this.CreateMan = in.readString();
            this.AirPoint_AId = in.readString();
            this.PointName = in.readString();
            this.Device_Code = in.readString();
            this.SchedulWork = in.readDouble();
            this.Status = in.readInt();
            this.State = in.readString();
            this.DoContentS = in.readString();
            this.DoContentSEN = in.readString();
            this.FinishDate = in.readString();
            this.FinishDateS = in.readString();
            this.ResidualTime = in.readInt();
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }

}
