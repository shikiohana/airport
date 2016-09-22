package com.example.administrator.javabean;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/22.
 */
public class Applys {

    /**
     * Data : [{"ApplyID":"e99f1434-de2a-4670-aea6-ecfcbe46bbef","BillCode":"sample string 2","ApplyDate":"2016-09-22T17:56:13.8816001+08:00","ApplyDateS":"sample string 4","Device_AId":"6aebf465-f1bc-404d-97e9-0df1bb66b0ab","DeviceName":"sample string 6","DeviceCode":"sample string 7","DeviceSPEC":"sample string 8","AirPoint_AId":"60f23c4f-d5da-4e50-84fb-c99a5bcd0332","PointName":"sample string 10","Fault_AId":"3e520af6-399b-4790-a120-99f790c1d063","FaultKey":"sample string 12","Status":13,"State":"sample string 14","ApplyDescription":"sample string 15","ApplyDescriptionEN":"sample string 16","SchedulWork":17},{"ApplyID":"e99f1434-de2a-4670-aea6-ecfcbe46bbef","BillCode":"sample string 2","ApplyDate":"2016-09-22T17:56:13.8816001+08:00","ApplyDateS":"sample string 4","Device_AId":"6aebf465-f1bc-404d-97e9-0df1bb66b0ab","DeviceName":"sample string 6","DeviceCode":"sample string 7","DeviceSPEC":"sample string 8","AirPoint_AId":"60f23c4f-d5da-4e50-84fb-c99a5bcd0332","PointName":"sample string 10","Fault_AId":"3e520af6-399b-4790-a120-99f790c1d063","FaultKey":"sample string 12","Status":13,"State":"sample string 14","ApplyDescription":"sample string 15","ApplyDescriptionEN":"sample string 16","SchedulWork":17},{"ApplyID":"e99f1434-de2a-4670-aea6-ecfcbe46bbef","BillCode":"sample string 2","ApplyDate":"2016-09-22T17:56:13.8816001+08:00","ApplyDateS":"sample string 4","Device_AId":"6aebf465-f1bc-404d-97e9-0df1bb66b0ab","DeviceName":"sample string 6","DeviceCode":"sample string 7","DeviceSPEC":"sample string 8","AirPoint_AId":"60f23c4f-d5da-4e50-84fb-c99a5bcd0332","PointName":"sample string 10","Fault_AId":"3e520af6-399b-4790-a120-99f790c1d063","FaultKey":"sample string 12","Status":13,"State":"sample string 14","ApplyDescription":"sample string 15","ApplyDescriptionEN":"sample string 16","SchedulWork":17}]
     * ErrorCode : 1
     * ErrorMessage : sample string 2
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * ApplyID : e99f1434-de2a-4670-aea6-ecfcbe46bbef
     * BillCode : sample string 2
     * ApplyDate : 2016-09-22T17:56:13.8816001+08:00
     * ApplyDateS : sample string 4
     * Device_AId : 6aebf465-f1bc-404d-97e9-0df1bb66b0ab
     * DeviceName : sample string 6
     * DeviceCode : sample string 7
     * DeviceSPEC : sample string 8
     * AirPoint_AId : 60f23c4f-d5da-4e50-84fb-c99a5bcd0332
     * PointName : sample string 10
     * Fault_AId : 3e520af6-399b-4790-a120-99f790c1d063
     * FaultKey : sample string 12
     * Status : 13
     * State : sample string 14
     * ApplyDescription : sample string 15
     * ApplyDescriptionEN : sample string 16
     * SchedulWork : 17.0
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
        private String ApplyID;
        private String BillCode;
        private String ApplyDate;
        private String ApplyDateS;
        private String Device_AId;
        private String DeviceName;
        private String DeviceCode;
        private String DeviceSPEC;
        private String AirPoint_AId;
        private String PointName;
        private String Fault_AId;
        private String FaultKey;
        private int Status;
        private String State;
        private String ApplyDescription;
        private String ApplyDescriptionEN;
        private double SchedulWork;

        public String getApplyID() {
            return ApplyID;
        }

        public void setApplyID(String ApplyID) {
            this.ApplyID = ApplyID;
        }

        public String getBillCode() {
            return BillCode;
        }

        public void setBillCode(String BillCode) {
            this.BillCode = BillCode;
        }

        public String getApplyDate() {
            return ApplyDate;
        }

        public void setApplyDate(String ApplyDate) {
            this.ApplyDate = ApplyDate;
        }

        public String getApplyDateS() {
            return ApplyDateS;
        }

        public void setApplyDateS(String ApplyDateS) {
            this.ApplyDateS = ApplyDateS;
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

        public String getApplyDescription() {
            return ApplyDescription;
        }

        public void setApplyDescription(String ApplyDescription) {
            this.ApplyDescription = ApplyDescription;
        }

        public String getApplyDescriptionEN() {
            return ApplyDescriptionEN;
        }

        public void setApplyDescriptionEN(String ApplyDescriptionEN) {
            this.ApplyDescriptionEN = ApplyDescriptionEN;
        }

        public double getSchedulWork() {
            return SchedulWork;
        }

        public void setSchedulWork(double SchedulWork) {
            this.SchedulWork = SchedulWork;
        }
    }
}
