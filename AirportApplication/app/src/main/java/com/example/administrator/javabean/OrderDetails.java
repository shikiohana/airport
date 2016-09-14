package com.example.administrator.javabean;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/13.
 */
public class OrderDetails {

    /**
     * BillCode : 201609091024-1
     * CustomerCode : 67987960
     * OrderStatus : 0
     * OrderState : null
     * BillDate : 2016-09-08T16:00:00
     * BillDateS : null
     * InspectType_AId : f82a2e21-70a6-4f5a-b10b-226c6fe4e8ef
     * ITypeName : 日检
     * OrderFinishDate : 2016-09-15T16:00:00
     * CreateMan :
     * OrderMemo : 备注就是备注，不是其他东西。
     * OrderMemoEN : Note is the note, not other things.
     * VerifyMan : null
     * SchedulWork : 5.0
     * ActualWork : 0001-01-01T00:00:00
     * ActualWorkS : null
     * Tel : null
     * Detail : [{"Detail_AId":"883fda6d-5fd7-4d5d-ba23-36f08d6afb6a","DeviceCategory_AId":"6fa53901-ae6e-44b2-86de-48c7e48963ee","CategoryName":"类别111","DeviceCategory_isOK":false,"ContentS":"类别111内容111","ContentSEN":"jhbsdviuvhbisdubhviusdfivbhisdhbvisibfdvb","isDetail":true,"Memo":"备忘备忘备忘","MemoEN":"memomemomemo"},{"Detail_AId":"97ac42f3-e0ae-41f4-bdcf-47c247ddd4d5","DeviceCategory_AId":"6fa53901-ae6e-44b2-86de-48c7e48963ee","CategoryName":"类别111","DeviceCategory_isOK":false,"ContentS":"5444","ContentSEN":"451541541","isDetail":true,"Memo":"备忘备忘备忘","MemoEN":"memomemomemo"},{"Detail_AId":"56b8fdaa-f66a-45aa-b1cc-54d180ecbe5c","DeviceCategory_AId":"6fa53901-ae6e-44b2-86de-48c7e48963ee","CategoryName":"类别111","DeviceCategory_isOK":false,"ContentS":"内容2","ContentSEN":"Content2","isDetail":true,"Memo":"备忘备忘备忘","MemoEN":"memomemomemo"},{"Detail_AId":"229c4b73-4cab-4f7c-b0f6-f3eb110ffe65","DeviceCategory_AId":"6fa53901-ae6e-44b2-86de-48c7e48963ee","CategoryName":"类别111","DeviceCategory_isOK":false,"ContentS":"还不i何必当初","ContentSEN":"jabhscibsdicbisdbci","isDetail":true,"Memo":"备忘备忘备忘","MemoEN":"memomemomemo"}]
     */

    private DataBean Data;
    /**
     * Data : {"BillCode":"201609091024-1","CustomerCode":"67987960","OrderStatus":0,"OrderState":null,"BillDate":"2016-09-08T16:00:00","BillDateS":null,"InspectType_AId":"f82a2e21-70a6-4f5a-b10b-226c6fe4e8ef","ITypeName":"日检","OrderFinishDate":"2016-09-15T16:00:00","CreateMan":"","OrderMemo":"备注就是备注，不是其他东西。","OrderMemoEN":"Note is the note, not other things.","VerifyMan":null,"SchedulWork":5,"ActualWork":"0001-01-01T00:00:00","ActualWorkS":null,"Tel":null,"Detail":[{"Detail_AId":"883fda6d-5fd7-4d5d-ba23-36f08d6afb6a","DeviceCategory_AId":"6fa53901-ae6e-44b2-86de-48c7e48963ee","CategoryName":"类别111","DeviceCategory_isOK":false,"ContentS":"类别111内容111","ContentSEN":"jhbsdviuvhbisdubhviusdfivbhisdhbvisibfdvb","isDetail":true,"Memo":"备忘备忘备忘","MemoEN":"memomemomemo"},{"Detail_AId":"97ac42f3-e0ae-41f4-bdcf-47c247ddd4d5","DeviceCategory_AId":"6fa53901-ae6e-44b2-86de-48c7e48963ee","CategoryName":"类别111","DeviceCategory_isOK":false,"ContentS":"5444","ContentSEN":"451541541","isDetail":true,"Memo":"备忘备忘备忘","MemoEN":"memomemomemo"},{"Detail_AId":"56b8fdaa-f66a-45aa-b1cc-54d180ecbe5c","DeviceCategory_AId":"6fa53901-ae6e-44b2-86de-48c7e48963ee","CategoryName":"类别111","DeviceCategory_isOK":false,"ContentS":"内容2","ContentSEN":"Content2","isDetail":true,"Memo":"备忘备忘备忘","MemoEN":"memomemomemo"},{"Detail_AId":"229c4b73-4cab-4f7c-b0f6-f3eb110ffe65","DeviceCategory_AId":"6fa53901-ae6e-44b2-86de-48c7e48963ee","CategoryName":"类别111","DeviceCategory_isOK":false,"ContentS":"还不i何必当初","ContentSEN":"jabhscibsdicbisdbci","isDetail":true,"Memo":"备忘备忘备忘","MemoEN":"memomemomemo"}]}
     * ErrorCode : 0
     * ErrorMessage :
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

    public static class DataBean {
        private String BillCode;
        private String CustomerCode;
        private int OrderStatus;
        private String OrderState;
        private String BillDate;
        private String BillDateS;
        private String InspectType_AId;
        private String ITypeName;
        private String OrderFinishDate;
        private String CreateMan;
        private String OrderMemo;
        private String OrderMemoEN;
        private String VerifyMan;
        private double SchedulWork;
        private String ActualWork;
        private String ActualWorkS;
        private String Tel;
        /**
         * Detail_AId : 883fda6d-5fd7-4d5d-ba23-36f08d6afb6a
         * DeviceCategory_AId : 6fa53901-ae6e-44b2-86de-48c7e48963ee
         * CategoryName : 类别111
         * DeviceCategory_isOK : false
         * ContentS : 类别111内容111
         * ContentSEN : jhbsdviuvhbisdubhviusdfivbhisdhbvisibfdvb
         * isDetail : true
         * Memo : 备忘备忘备忘
         * MemoEN : memomemomemo
         */

        private List<DetailBean> Detail;

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

        public int getOrderStatus() {
            return OrderStatus;
        }

        public void setOrderStatus(int OrderStatus) {
            this.OrderStatus = OrderStatus;
        }

        public String getOrderState() {
            return OrderState;
        }

        public void setOrderState(String OrderState) {
            this.OrderState = OrderState;
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

        public String getInspectType_AId() {
            return InspectType_AId;
        }

        public void setInspectType_AId(String InspectType_AId) {
            this.InspectType_AId = InspectType_AId;
        }

        public String getITypeName() {
            return ITypeName;
        }

        public void setITypeName(String ITypeName) {
            this.ITypeName = ITypeName;
        }

        public String getOrderFinishDate() {
            return OrderFinishDate;
        }

        public void setOrderFinishDate(String OrderFinishDate) {
            this.OrderFinishDate = OrderFinishDate;
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

        public String getVerifyMan() {
            return VerifyMan;
        }

        public void setVerifyMan(String VerifyMan) {
            this.VerifyMan = VerifyMan;
        }

        public double getSchedulWork() {
            return SchedulWork;
        }

        public void setSchedulWork(double SchedulWork) {
            this.SchedulWork = SchedulWork;
        }

        public String getActualWork() {
            return ActualWork;
        }

        public void setActualWork(String ActualWork) {
            this.ActualWork = ActualWork;
        }

        public String getActualWorkS() {
            return ActualWorkS;
        }

        public void setActualWorkS(String ActualWorkS) {
            this.ActualWorkS = ActualWorkS;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public List<DetailBean> getDetail() {
            return Detail;
        }

        public void setDetail(List<DetailBean> Detail) {
            this.Detail = Detail;
        }

        public static class DetailBean {
            private String Detail_AId;
            private String DeviceCategory_AId;
            private String CategoryName;
            private boolean DeviceCategory_isOK;
            private String ContentS;
            private String ContentSEN;
            private boolean isDetail;
            private String Memo;
            private String MemoEN;

            public String getDetail_AId() {
                return Detail_AId;
            }

            public void setDetail_AId(String Detail_AId) {
                this.Detail_AId = Detail_AId;
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

            public boolean isDeviceCategory_isOK() {
                return DeviceCategory_isOK;
            }

            public void setDeviceCategory_isOK(boolean DeviceCategory_isOK) {
                this.DeviceCategory_isOK = DeviceCategory_isOK;
            }

            public String getContentS() {
                return ContentS;
            }

            public void setContentS(String ContentS) {
                this.ContentS = ContentS;
            }

            public String getContentSEN() {
                return ContentSEN;
            }

            public void setContentSEN(String ContentSEN) {
                this.ContentSEN = ContentSEN;
            }

            public boolean isIsDetail() {
                return isDetail;
            }

            public void setIsDetail(boolean isDetail) {
                this.isDetail = isDetail;
            }

            public String getMemo() {
                return Memo;
            }

            public void setMemo(String Memo) {
                this.Memo = Memo;
            }

            public String getMemoEN() {
                return MemoEN;
            }

            public void setMemoEN(String MemoEN) {
                this.MemoEN = MemoEN;
            }
        }
    }
}
