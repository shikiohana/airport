package com.example.administrator.javabean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/12.
 */
public class PlanOrder  {

    /**
     * Data : [{"BillCode":"201609091024-1","CustomerCode":"67987960","CustomerName":null,"OrderStatus":0,"Status":null,"BillDate":"2016-09-08T16:00:00","BillDateS":null,"InspectType_AId":"f82a2e21-70a6-4f5a-b10b-226c6fe4e8ef","ITypeName":"日检","OrderFinishDate":"2016-09-15T16:00:00","FinishDate":null,"CreateMan":"","SchedulWork":5,"OrderMemo":"备注就是备注，不是其他东西。","OrderMemoEN":"Note is the note, not other things.","ResidualTime":3},{"BillCode":"201609091024-2","CustomerCode":"67987960","CustomerName":null,"OrderStatus":0,"Status":null,"BillDate":"2016-09-08T16:00:00","BillDateS":null,"InspectType_AId":"f82a2e21-70a6-4f5a-b10b-226c6fe4e8ef","ITypeName":"日检","OrderFinishDate":"2016-09-15T16:00:00","FinishDate":null,"CreateMan":"","SchedulWork":5.2,"OrderMemo":"备注就是备注，不是其他东西。","OrderMemoEN":"Note is the note, not other things.","ResidualTime":3},{"BillCode":"201609121024-1","CustomerCode":"67987960","CustomerName":null,"OrderStatus":0,"Status":null,"BillDate":"2016-09-11T16:00:00","BillDateS":null,"InspectType_AId":"b62626b8-44d9-444d-8ead-da6c56f5cce8","ITypeName":"周检","OrderFinishDate":"2016-09-15T16:00:00","FinishDate":null,"CreateMan":"","SchedulWork":8,"OrderMemo":"这是新一轮计划工单。","OrderMemoEN":"This is a new round of planning work sheet.","ResidualTime":3},{"BillCode":"23132312312-1","CustomerCode":"67987960","CustomerName":null,"OrderStatus":0,"Status":null,"BillDate":"2016-09-08T16:00:00","BillDateS":null,"InspectType_AId":"f82a2e21-70a6-4f5a-b10b-226c6fe4e8ef","ITypeName":"日检","OrderFinishDate":"2016-09-09T16:00:00","FinishDate":null,"CreateMan":"","SchedulWork":5,"OrderMemo":"这是一个测试工单 测试内容是备注","OrderMemoEN":"This is a test content is the work order remarks","ResidualTime":-3},{"BillCode":"23132312312-2","CustomerCode":"67987960","CustomerName":null,"OrderStatus":0,"Status":null,"BillDate":"2016-09-08T16:00:00","BillDateS":null,"InspectType_AId":"f82a2e21-70a6-4f5a-b10b-226c6fe4e8ef","ITypeName":"日检","OrderFinishDate":"2016-09-09T16:00:00","FinishDate":null,"CreateMan":"","SchedulWork":5.2,"OrderMemo":"这是一个测试工单 测试内容是备注","OrderMemoEN":"This is a test content is the work order remarks","ResidualTime":-3},{"BillCode":"TTTTTTTTT-1","CustomerCode":"67987961","CustomerName":null,"OrderStatus":0,"Status":null,"BillDate":"2016-09-08T16:00:00","BillDateS":null,"InspectType_AId":"f82a2e21-70a6-4f5a-b10b-226c6fe4e8ef","ITypeName":"日检","OrderFinishDate":"2016-09-09T16:00:00","FinishDate":null,"CreateMan":"","SchedulWork":1,"OrderMemo":"这是工单测试","OrderMemoEN":"This is the repair order test","ResidualTime":-3},{"BillCode":"TTTTTTTTT-2","CustomerCode":"67987961","CustomerName":null,"OrderStatus":0,"Status":null,"BillDate":"2016-09-08T16:00:00","BillDateS":null,"InspectType_AId":"f82a2e21-70a6-4f5a-b10b-226c6fe4e8ef","ITypeName":"日检","OrderFinishDate":"2016-09-09T16:00:00","FinishDate":null,"CreateMan":"","SchedulWork":24,"OrderMemo":"这是工单测试","OrderMemoEN":"This is the repair order test","ResidualTime":-3}]
     * ErrorCode : 0
     * ErrorMessage : null
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * BillCode : 201609091024-1
     * CustomerCode : 67987960
     * CustomerName : null
     * OrderStatus : 0
     * Status : null
     * BillDate : 2016-09-08T16:00:00
     * BillDateS : null
     * InspectType_AId : f82a2e21-70a6-4f5a-b10b-226c6fe4e8ef
     * ITypeName : 日检
     * OrderFinishDate : 2016-09-15T16:00:00
     * FinishDate : null
     * CreateMan :
     * SchedulWork : 5.0
     * OrderMemo : 备注就是备注，不是其他东西。
     * OrderMemoEN : Note is the note, not other things.
     * ResidualTime : 3
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
        private int OrderStatus;
        private String Status;
        private String BillDate;
        private String BillDateS;
        private String InspectType_AId;
        private String ITypeName;
        private String OrderFinishDate;
        private String FinishDate;
        private String CreateMan;
        private double SchedulWork;
        private String OrderMemo;
        private String OrderMemoEN;
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

        public int getOrderStatus() {
            return OrderStatus;
        }

        public void setOrderStatus(int OrderStatus) {
            this.OrderStatus = OrderStatus;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
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

        public String getFinishDate() {
            return FinishDate;
        }

        public void setFinishDate(String FinishDate) {
            this.FinishDate = FinishDate;
        }

        public String getCreateMan() {
            return CreateMan;
        }

        public void setCreateMan(String CreateMan) {
            this.CreateMan = CreateMan;
        }

        public double getSchedulWork() {
            return SchedulWork;
        }

        public void setSchedulWork(double SchedulWork) {
            this.SchedulWork = SchedulWork;
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
            dest.writeInt(this.OrderStatus);
            dest.writeString(this.Status);
            dest.writeString(this.BillDate);
            dest.writeString(this.BillDateS);
            dest.writeString(this.InspectType_AId);
            dest.writeString(this.ITypeName);
            dest.writeString(this.OrderFinishDate);
            dest.writeString(this.FinishDate);
            dest.writeString(this.CreateMan);
            dest.writeDouble(this.SchedulWork);
            dest.writeString(this.OrderMemo);
            dest.writeString(this.OrderMemoEN);
            dest.writeInt(this.ResidualTime);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.BillCode = in.readString();
            this.CustomerCode = in.readString();
            this.CustomerName = in.readString();
            this.OrderStatus = in.readInt();
            this.Status = in.readString();
            this.BillDate = in.readString();
            this.BillDateS = in.readString();
            this.InspectType_AId = in.readString();
            this.ITypeName = in.readString();
            this.OrderFinishDate = in.readString();
            this.FinishDate = in.readString();
            this.CreateMan = in.readString();
            this.SchedulWork = in.readDouble();
            this.OrderMemo = in.readString();
            this.OrderMemoEN = in.readString();
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
