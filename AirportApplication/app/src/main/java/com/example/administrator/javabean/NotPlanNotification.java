package com.example.administrator.javabean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by quick_tech cpc on 2016/9/23.
 */
public class NotPlanNotification {

    /**
     * BillCode : sample string 1
     * CustomerCode : sample string 2
     * CustomerName : sample string 3
     * BillDate : 2016-09-23T14:26:25.3404001+08:00
     * BillDateS : sample string 5
     * Device_AId : c4c20d9b-564b-4a4e-9b59-7a9e6a09b645
     * DeviceName : sample string 7
     * CreateMan : sample string 8
     * AirPoint_AId : 1965a5a8-d50e-4cfe-b233-9bbc661769d0
     * PointName : sample string 10
     * DeviceCode : sample string 11
     * DeviceSPEC : sample string 12
     * SchedulWork : 13.0
     * Status : 14
     * State : sample string 15
     * DoContentS : sample string 16
     * DoContentSEN : sample string 17
     * FinishDate : 2016-09-23T14:26:25.3424001+08:00
     * FinishDateS : sample string 19
     * ResidualTime : 20
     */

    private DataBean Data;
    /**
     * Data : {"BillCode":"sample string 1","CustomerCode":"sample string 2","CustomerName":"sample string 3","BillDate":"2016-09-23T14:26:25.3404001+08:00","BillDateS":"sample string 5","Device_AId":"c4c20d9b-564b-4a4e-9b59-7a9e6a09b645","DeviceName":"sample string 7","CreateMan":"sample string 8","AirPoint_AId":"1965a5a8-d50e-4cfe-b233-9bbc661769d0","PointName":"sample string 10","DeviceCode":"sample string 11","DeviceSPEC":"sample string 12","SchedulWork":13,"Status":14,"State":"sample string 15","DoContentS":"sample string 16","DoContentSEN":"sample string 17","FinishDate":"2016-09-23T14:26:25.3424001+08:00","FinishDateS":"sample string 19","ResidualTime":20}
     * ErrorCode : 1
     * ErrorMessage : sample string 2
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

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
        private String DeviceCode;
        private String DeviceSPEC;
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

        public String getDeviceCode() {
            return DeviceCode;
        }

        public void setDeviceCode(String DeviceCode) {
            this.DeviceCode = DeviceCode;
        }

        public String getDeviceSPEC() {
            return DeviceSPEC;
        }

        public void setDeviceSPEC(String DeviceSPEC) {
            this.DeviceSPEC = DeviceSPEC;
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
            dest.writeString(this.DeviceCode);
            dest.writeString(this.DeviceSPEC);
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
            this.DeviceCode = in.readString();
            this.DeviceSPEC = in.readString();
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
