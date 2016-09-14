package com.example.administrator.javabean;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/8.
 */
public class Company  {


    /**
     * Data : [{"CustomerCode":"67987960","CustomerName":"东方航空","Tel":null,"Address":null,"TaxCode":null,"BankCode":null,"CustomerNameEN":null,"CustomerABBR":null},{"CustomerCode":"67987961","CustomerName":"南方航空","Tel":null,"Address":null,"TaxCode":null,"BankCode":null,"CustomerNameEN":null,"CustomerABBR":null}]
     * ErrorCode : 0
     * ErrorMessage : null
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * CustomerCode : 67987960
     * CustomerName : 东方航空
     * Tel : null
     * Address : null
     * TaxCode : null
     * BankCode : null
     * CustomerNameEN : null
     * CustomerABBR : null
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
        private String CustomerCode;
        private String CustomerName;
        private String Tel;
        private String Address;
        private String TaxCode;
        private String BankCode;
        private String CustomerNameEN;
        private String CustomerABBR;

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

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getTaxCode() {
            return TaxCode;
        }

        public void setTaxCode(String TaxCode) {
            this.TaxCode = TaxCode;
        }

        public String getBankCode() {
            return BankCode;
        }

        public void setBankCode(String BankCode) {
            this.BankCode = BankCode;
        }

        public String getCustomerNameEN() {
            return CustomerNameEN;
        }

        public void setCustomerNameEN(String CustomerNameEN) {
            this.CustomerNameEN = CustomerNameEN;
        }

        public String getCustomerABBR() {
            return CustomerABBR;
        }

        public void setCustomerABBR(String CustomerABBR) {
            this.CustomerABBR = CustomerABBR;
        }
    }
}
