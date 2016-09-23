package com.example.administrator.javabean;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/23.
 */
public class MyNotification {

    /**
     * Data : [{"BillCode":"sample string 1","BillDate":"2016-09-23T09:39:59.1654001+08:00","BillDateS":"sample string 3","CreateMan":"sample string 4","OrderMemo":"sample string 5","OrderMemoEN":"sample string 6","IsPlan":true,"IsPlanText":"sample string 8"},{"BillCode":"sample string 1","BillDate":"2016-09-23T09:39:59.1654001+08:00","BillDateS":"sample string 3","CreateMan":"sample string 4","OrderMemo":"sample string 5","OrderMemoEN":"sample string 6","IsPlan":true,"IsPlanText":"sample string 8"},{"BillCode":"sample string 1","BillDate":"2016-09-23T09:39:59.1654001+08:00","BillDateS":"sample string 3","CreateMan":"sample string 4","OrderMemo":"sample string 5","OrderMemoEN":"sample string 6","IsPlan":true,"IsPlanText":"sample string 8"}]
     * ErrorCode : 1
     * ErrorMessage : sample string 2
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * BillCode : sample string 1
     * BillDate : 2016-09-23T09:39:59.1654001+08:00
     * BillDateS : sample string 3
     * CreateMan : sample string 4
     * OrderMemo : sample string 5
     * OrderMemoEN : sample string 6
     * IsPlan : true
     * IsPlanText : sample string 8
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
        private String BillCode;
        private String BillDate;
        private String BillDateS;
        private String CreateMan;
        private String OrderMemo;
        private String OrderMemoEN;
        private boolean IsPlan;
        private String IsPlanText;

        public String getBillCode() {
            return BillCode;
        }

        public void setBillCode(String BillCode) {
            this.BillCode = BillCode;
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

        public String getCreateMan() {
            return CreateMan;
        }

        public void setCreateMan(String CreateMan) {
            this.CreateMan = CreateMan;
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

        public boolean isIsPlan() {
            return IsPlan;
        }

        public void setIsPlan(boolean IsPlan) {
            this.IsPlan = IsPlan;
        }

        public String getIsPlanText() {
            return IsPlanText;
        }

        public void setIsPlanText(String IsPlanText) {
            this.IsPlanText = IsPlanText;
        }
    }
}
