package com.example.administrator.javabean;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/24.
 */
public class FaultSelect {

    /**
     * Data : [{"FaultID":"4b89a297-ca4e-42d2-886c-be7ba2c067fa","CustomerCode":"sample string 2","CustomerName":"sample string 3","FaultKey":"sample string 4","FaultDescription":"sample string 5","FaultDescriptionEN":"sample string 6","DeviceCategory_AId":"13883dae-7f04-4b5d-83fc-f95738f58902","CategoryName":"sample string 8","DoMethods":"sample string 9","DoMethodsEN":"sample string 10","DoResult":"sample string 11","DoResultEN":"sample string 12"},{"FaultID":"4b89a297-ca4e-42d2-886c-be7ba2c067fa","CustomerCode":"sample string 2","CustomerName":"sample string 3","FaultKey":"sample string 4","FaultDescription":"sample string 5","FaultDescriptionEN":"sample string 6","DeviceCategory_AId":"13883dae-7f04-4b5d-83fc-f95738f58902","CategoryName":"sample string 8","DoMethods":"sample string 9","DoMethodsEN":"sample string 10","DoResult":"sample string 11","DoResultEN":"sample string 12"},{"FaultID":"4b89a297-ca4e-42d2-886c-be7ba2c067fa","CustomerCode":"sample string 2","CustomerName":"sample string 3","FaultKey":"sample string 4","FaultDescription":"sample string 5","FaultDescriptionEN":"sample string 6","DeviceCategory_AId":"13883dae-7f04-4b5d-83fc-f95738f58902","CategoryName":"sample string 8","DoMethods":"sample string 9","DoMethodsEN":"sample string 10","DoResult":"sample string 11","DoResultEN":"sample string 12"}]
     * ErrorCode : 1
     * ErrorMessage : sample string 2
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * FaultID : 4b89a297-ca4e-42d2-886c-be7ba2c067fa
     * CustomerCode : sample string 2
     * CustomerName : sample string 3
     * FaultKey : sample string 4
     * FaultDescription : sample string 5
     * FaultDescriptionEN : sample string 6
     * DeviceCategory_AId : 13883dae-7f04-4b5d-83fc-f95738f58902
     * CategoryName : sample string 8
     * DoMethods : sample string 9
     * DoMethodsEN : sample string 10
     * DoResult : sample string 11
     * DoResultEN : sample string 12
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
        private String FaultID;
        private String CustomerCode;
        private String CustomerName;
        private String FaultKey;
        private String FaultDescription;
        private String FaultDescriptionEN;
        private String DeviceCategory_AId;
        private String CategoryName;
        private String DoMethods;
        private String DoMethodsEN;
        private String DoResult;
        private String DoResultEN;

        public String getFaultID() {
            return FaultID;
        }

        public void setFaultID(String FaultID) {
            this.FaultID = FaultID;
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

        public String getFaultKey() {
            return FaultKey;
        }

        public void setFaultKey(String FaultKey) {
            this.FaultKey = FaultKey;
        }

        public String getFaultDescription() {
            return FaultDescription;
        }

        public void setFaultDescription(String FaultDescription) {
            this.FaultDescription = FaultDescription;
        }

        public String getFaultDescriptionEN() {
            return FaultDescriptionEN;
        }

        public void setFaultDescriptionEN(String FaultDescriptionEN) {
            this.FaultDescriptionEN = FaultDescriptionEN;
        }

        public String getDeviceCategory_AId() {
            return DeviceCategory_AId;
        }

        public void setDeviceCategory_AId(String DeviceCategory_AId) {
            this.DeviceCategory_AId = DeviceCategory_AId;
        }

        public String getCategoryName() {
            return CategoryName;
        }

        public void setCategoryName(String CategoryName) {
            this.CategoryName = CategoryName;
        }

        public String getDoMethods() {
            return DoMethods;
        }

        public void setDoMethods(String DoMethods) {
            this.DoMethods = DoMethods;
        }

        public String getDoMethodsEN() {
            return DoMethodsEN;
        }

        public void setDoMethodsEN(String DoMethodsEN) {
            this.DoMethodsEN = DoMethodsEN;
        }

        public String getDoResult() {
            return DoResult;
        }

        public void setDoResult(String DoResult) {
            this.DoResult = DoResult;
        }

        public String getDoResultEN() {
            return DoResultEN;
        }

        public void setDoResultEN(String DoResultEN) {
            this.DoResultEN = DoResultEN;
        }
    }
}
