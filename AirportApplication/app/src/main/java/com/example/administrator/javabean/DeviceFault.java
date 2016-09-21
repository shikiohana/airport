package com.example.administrator.javabean;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/21.
 */
public class DeviceFault {

    /**
     * Data : [{"RecordID":"ff88874c-975c-4a9c-b980-72355ad77b2c","BillCode":"sample string 2","Device_AId":"34d6a9d8-2b41-44d5-bb1b-781374cc53b4","DeviceName":"sample string 4","DeviceCode":"sample string 5","DeviceSPEC":"sample string 6","AirPoint_AId":"808f753b-2eb9-4d67-aba9-76b21c363601","PointName":"sample string 8","Fault_AId":"f5f66172-7b4a-462b-a8dc-1df6edaceea7","FaultKey":"sample string 10","Fault_Description":"sample string 11","Fault_DescriptionEN":"sample string 12","RecordTime":"2016-09-21T14:15:21.4423014+08:00","RecordTimeS":"sample string 14","IsApply":true,"IsApplyS":"sample string 16","ApplyMan":"sample string 17","SchedulWork":18},{"RecordID":"ff88874c-975c-4a9c-b980-72355ad77b2c","BillCode":"sample string 2","Device_AId":"34d6a9d8-2b41-44d5-bb1b-781374cc53b4","DeviceName":"sample string 4","DeviceCode":"sample string 5","DeviceSPEC":"sample string 6","AirPoint_AId":"808f753b-2eb9-4d67-aba9-76b21c363601","PointName":"sample string 8","Fault_AId":"f5f66172-7b4a-462b-a8dc-1df6edaceea7","FaultKey":"sample string 10","Fault_Description":"sample string 11","Fault_DescriptionEN":"sample string 12","RecordTime":"2016-09-21T14:15:21.4423014+08:00","RecordTimeS":"sample string 14","IsApply":true,"IsApplyS":"sample string 16","ApplyMan":"sample string 17","SchedulWork":18},{"RecordID":"ff88874c-975c-4a9c-b980-72355ad77b2c","BillCode":"sample string 2","Device_AId":"34d6a9d8-2b41-44d5-bb1b-781374cc53b4","DeviceName":"sample string 4","DeviceCode":"sample string 5","DeviceSPEC":"sample string 6","AirPoint_AId":"808f753b-2eb9-4d67-aba9-76b21c363601","PointName":"sample string 8","Fault_AId":"f5f66172-7b4a-462b-a8dc-1df6edaceea7","FaultKey":"sample string 10","Fault_Description":"sample string 11","Fault_DescriptionEN":"sample string 12","RecordTime":"2016-09-21T14:15:21.4423014+08:00","RecordTimeS":"sample string 14","IsApply":true,"IsApplyS":"sample string 16","ApplyMan":"sample string 17","SchedulWork":18}]
     * ErrorCode : 1
     * ErrorMessage : sample string 2
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * RecordID : ff88874c-975c-4a9c-b980-72355ad77b2c
     * BillCode : sample string 2
     * Device_AId : 34d6a9d8-2b41-44d5-bb1b-781374cc53b4
     * DeviceName : sample string 4
     * DeviceCode : sample string 5
     * DeviceSPEC : sample string 6
     * AirPoint_AId : 808f753b-2eb9-4d67-aba9-76b21c363601
     * PointName : sample string 8
     * Fault_AId : f5f66172-7b4a-462b-a8dc-1df6edaceea7
     * FaultKey : sample string 10
     * Fault_Description : sample string 11
     * Fault_DescriptionEN : sample string 12
     * RecordTime : 2016-09-21T14:15:21.4423014+08:00
     * RecordTimeS : sample string 14
     * IsApply : true
     * IsApplyS : sample string 16
     * ApplyMan : sample string 17
     * SchedulWork : 18.0
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

    public static class DataBean {
        private String RecordID;
        private String BillCode;
        private String Device_AId;
        private String DeviceName;
        private String DeviceCode;
        private String DeviceSPEC;
        private String AirPoint_AId;
        private String PointName;
        private String Fault_AId;
        private String FaultKey;
        private String Fault_Description;
        private String Fault_DescriptionEN;
        private String RecordTime;
        private String RecordTimeS;
        private boolean IsApply;
        private String IsApplyS;
        private String ApplyMan;
        private double SchedulWork;

        public String getRecordID() {
            return RecordID;
        }

        public void setRecordID(String RecordID) {
            this.RecordID = RecordID;
        }

        public String getBillCode() {
            return BillCode;
        }

        public void setBillCode(String BillCode) {
            this.BillCode = BillCode;
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

        public String getFault_AId() {
            return Fault_AId;
        }

        public void setFault_AId(String Fault_AId) {
            this.Fault_AId = Fault_AId;
        }

        public String getFaultKey() {
            return FaultKey;
        }

        public void setFaultKey(String FaultKey) {
            this.FaultKey = FaultKey;
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

        public String getRecordTime() {
            return RecordTime;
        }

        public void setRecordTime(String RecordTime) {
            this.RecordTime = RecordTime;
        }

        public String getRecordTimeS() {
            return RecordTimeS;
        }

        public void setRecordTimeS(String RecordTimeS) {
            this.RecordTimeS = RecordTimeS;
        }

        public boolean isIsApply() {
            return IsApply;
        }

        public void setIsApply(boolean IsApply) {
            this.IsApply = IsApply;
        }

        public String getIsApplyS() {
            return IsApplyS;
        }

        public void setIsApplyS(String IsApplyS) {
            this.IsApplyS = IsApplyS;
        }

        public String getApplyMan() {
            return ApplyMan;
        }

        public void setApplyMan(String ApplyMan) {
            this.ApplyMan = ApplyMan;
        }

        public double getSchedulWork() {
            return SchedulWork;
        }

        public void setSchedulWork(double SchedulWork) {
            this.SchedulWork = SchedulWork;
        }
    }
}
