package com.example.administrator.javabean;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/22.
 */
public class UserResult {

    /**
     * Data : [{"AId":"cb6456fd-71e0-4a81-8f9e-bbd4da073e92","EName":"sample string 2","DName":"sample string 3","Gender":"sample string 4","ECode":"sample string 5"},{"AId":"cb6456fd-71e0-4a81-8f9e-bbd4da073e92","EName":"sample string 2","DName":"sample string 3","Gender":"sample string 4","ECode":"sample string 5"},{"AId":"cb6456fd-71e0-4a81-8f9e-bbd4da073e92","EName":"sample string 2","DName":"sample string 3","Gender":"sample string 4","ECode":"sample string 5"}]
     * ErrorCode : 1
     * ErrorMessage : sample string 2
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * AId : cb6456fd-71e0-4a81-8f9e-bbd4da073e92
     * EName : sample string 2
     * DName : sample string 3
     * Gender : sample string 4
     * ECode : sample string 5
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
        private String AId;
        private String EName;
        private String DName;
        private String Gender;
        private String ECode;

        public String getAId() {
            return AId;
        }

        public void setAId(String AId) {
            this.AId = AId;
        }

        public String getEName() {
            return EName;
        }

        public void setEName(String EName) {
            this.EName = EName;
        }

        public String getDName() {
            return DName;
        }

        public void setDName(String DName) {
            this.DName = DName;
        }

        public String getGender() {
            return Gender;
        }

        public void setGender(String Gender) {
            this.Gender = Gender;
        }

        public String getECode() {
            return ECode;
        }

        public void setECode(String ECode) {
            this.ECode = ECode;
        }
    }
}
