package com.example.administrator.javabean;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/20.
 */
public class AccountSet {

    /**
     * Data : [{"AccountCode":"sample string 1","AccountName":"sample string 2","ServiceURL":"sample string 3"},{"AccountCode":"sample string 1","AccountName":"sample string 2","ServiceURL":"sample string 3"},{"AccountCode":"sample string 1","AccountName":"sample string 2","ServiceURL":"sample string 3"}]
     * ErrorCode : 1
     * ErrorMessage : sample string 2
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * AccountCode : sample string 1
     * AccountName : sample string 2
     * ServiceURL : sample string 3
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
        private String AccountCode;
        private String AccountName;
        private String ServiceURL;

        public String getAccountCode() {
            return AccountCode;
        }

        public void setAccountCode(String AccountCode) {
            this.AccountCode = AccountCode;
        }

        public String getAccountName() {
            return AccountName;
        }

        public void setAccountName(String AccountName) {
            this.AccountName = AccountName;
        }

        public String getServiceURL() {
            return ServiceURL;
        }

        public void setServiceURL(String ServiceURL) {
            this.ServiceURL = ServiceURL;
        }
    }
}
