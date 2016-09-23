package com.example.administrator.javabean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/23.
 */
public class PlanNotification implements Parcelable {

    /**
     * BillCode : sample string 1
     * CustomerCode : sample string 2
     * OrderStatus : 3
     * OrderState : sample string 4
     * BillDate : 2016-09-23T14:25:35.9474001+08:00
     * BillDateS : sample string 6
     * InspectType_AId : 0cbb3441-88b0-4f8e-91c5-6d1ac0b917c6
     * ITypeName : sample string 8
     * OrderFinishDate : 2016-09-23T14:25:35.9484001+08:00
     * CreateMan : sample string 10
     * OrderMemo : sample string 11
     * OrderMemoEN : sample string 12
     * VerifyMan : sample string 13
     * SchedulWork : 14.0
     * ActualWork : 15.0
     * Tel : sample string 16
     * Detail : [{"Detail_AId":"010163c0-686b-4ec2-9fa3-9996ca45efb6","DeviceCategory_AId":"e769800c-7e75-4f58-9a16-fe23da6f118c","CategoryName":"sample string 3","DeviceCategory_isOK":true,"Device_isOK":"sample string 5","ContentS":"sample string 6","ContentSEN":"sample string 7","isDetail":true,"Memo":"sample string 9","MemoEN":"sample string 10"},{"Detail_AId":"010163c0-686b-4ec2-9fa3-9996ca45efb6","DeviceCategory_AId":"e769800c-7e75-4f58-9a16-fe23da6f118c","CategoryName":"sample string 3","DeviceCategory_isOK":true,"Device_isOK":"sample string 5","ContentS":"sample string 6","ContentSEN":"sample string 7","isDetail":true,"Memo":"sample string 9","MemoEN":"sample string 10"},{"Detail_AId":"010163c0-686b-4ec2-9fa3-9996ca45efb6","DeviceCategory_AId":"e769800c-7e75-4f58-9a16-fe23da6f118c","CategoryName":"sample string 3","DeviceCategory_isOK":true,"Device_isOK":"sample string 5","ContentS":"sample string 6","ContentSEN":"sample string 7","isDetail":true,"Memo":"sample string 9","MemoEN":"sample string 10"}]
     */

    private DataBean Data;
    /**
     * Data : {"BillCode":"sample string 1","CustomerCode":"sample string 2","OrderStatus":3,"OrderState":"sample string 4","BillDate":"2016-09-23T14:25:35.9474001+08:00","BillDateS":"sample string 6","InspectType_AId":"0cbb3441-88b0-4f8e-91c5-6d1ac0b917c6","ITypeName":"sample string 8","OrderFinishDate":"2016-09-23T14:25:35.9484001+08:00","CreateMan":"sample string 10","OrderMemo":"sample string 11","OrderMemoEN":"sample string 12","VerifyMan":"sample string 13","SchedulWork":14,"ActualWork":15,"Tel":"sample string 16","Detail":[{"Detail_AId":"010163c0-686b-4ec2-9fa3-9996ca45efb6","DeviceCategory_AId":"e769800c-7e75-4f58-9a16-fe23da6f118c","CategoryName":"sample string 3","DeviceCategory_isOK":true,"Device_isOK":"sample string 5","ContentS":"sample string 6","ContentSEN":"sample string 7","isDetail":true,"Memo":"sample string 9","MemoEN":"sample string 10"},{"Detail_AId":"010163c0-686b-4ec2-9fa3-9996ca45efb6","DeviceCategory_AId":"e769800c-7e75-4f58-9a16-fe23da6f118c","CategoryName":"sample string 3","DeviceCategory_isOK":true,"Device_isOK":"sample string 5","ContentS":"sample string 6","ContentSEN":"sample string 7","isDetail":true,"Memo":"sample string 9","MemoEN":"sample string 10"},{"Detail_AId":"010163c0-686b-4ec2-9fa3-9996ca45efb6","DeviceCategory_AId":"e769800c-7e75-4f58-9a16-fe23da6f118c","CategoryName":"sample string 3","DeviceCategory_isOK":true,"Device_isOK":"sample string 5","ContentS":"sample string 6","ContentSEN":"sample string 7","isDetail":true,"Memo":"sample string 9","MemoEN":"sample string 10"}]}
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
        private double ActualWork;
        private String Tel;
        /**
         * Detail_AId : 010163c0-686b-4ec2-9fa3-9996ca45efb6
         * DeviceCategory_AId : e769800c-7e75-4f58-9a16-fe23da6f118c
         * CategoryName : sample string 3
         * DeviceCategory_isOK : true
         * Device_isOK : sample string 5
         * ContentS : sample string 6
         * ContentSEN : sample string 7
         * isDetail : true
         * Memo : sample string 9
         * MemoEN : sample string 10
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

        public double getActualWork() {
            return ActualWork;
        }

        public void setActualWork(double ActualWork) {
            this.ActualWork = ActualWork;
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

        public static class DetailBean implements Parcelable {
            private String Detail_AId;
            private String DeviceCategory_AId;
            private String CategoryName;
            private boolean DeviceCategory_isOK;
            private String Device_isOK;
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

            public String getDevice_isOK() {
                return Device_isOK;
            }

            public void setDevice_isOK(String Device_isOK) {
                this.Device_isOK = Device_isOK;
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.Detail_AId);
                dest.writeString(this.DeviceCategory_AId);
                dest.writeString(this.CategoryName);
                dest.writeByte(this.DeviceCategory_isOK ? (byte) 1 : (byte) 0);
                dest.writeString(this.Device_isOK);
                dest.writeString(this.ContentS);
                dest.writeString(this.ContentSEN);
                dest.writeByte(this.isDetail ? (byte) 1 : (byte) 0);
                dest.writeString(this.Memo);
                dest.writeString(this.MemoEN);
            }

            public DetailBean() {
            }

            protected DetailBean(Parcel in) {
                this.Detail_AId = in.readString();
                this.DeviceCategory_AId = in.readString();
                this.CategoryName = in.readString();
                this.DeviceCategory_isOK = in.readByte() != 0;
                this.Device_isOK = in.readString();
                this.ContentS = in.readString();
                this.ContentSEN = in.readString();
                this.isDetail = in.readByte() != 0;
                this.Memo = in.readString();
                this.MemoEN = in.readString();
            }

            public static final Parcelable.Creator<DetailBean> CREATOR = new Parcelable.Creator<DetailBean>() {
                @Override
                public DetailBean createFromParcel(Parcel source) {
                    return new DetailBean(source);
                }

                @Override
                public DetailBean[] newArray(int size) {
                    return new DetailBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.BillCode);
            dest.writeString(this.CustomerCode);
            dest.writeInt(this.OrderStatus);
            dest.writeString(this.OrderState);
            dest.writeString(this.BillDate);
            dest.writeString(this.BillDateS);
            dest.writeString(this.InspectType_AId);
            dest.writeString(this.ITypeName);
            dest.writeString(this.OrderFinishDate);
            dest.writeString(this.CreateMan);
            dest.writeString(this.OrderMemo);
            dest.writeString(this.OrderMemoEN);
            dest.writeString(this.VerifyMan);
            dest.writeDouble(this.SchedulWork);
            dest.writeDouble(this.ActualWork);
            dest.writeString(this.Tel);
            dest.writeTypedList(this.Detail);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.BillCode = in.readString();
            this.CustomerCode = in.readString();
            this.OrderStatus = in.readInt();
            this.OrderState = in.readString();
            this.BillDate = in.readString();
            this.BillDateS = in.readString();
            this.InspectType_AId = in.readString();
            this.ITypeName = in.readString();
            this.OrderFinishDate = in.readString();
            this.CreateMan = in.readString();
            this.OrderMemo = in.readString();
            this.OrderMemoEN = in.readString();
            this.VerifyMan = in.readString();
            this.SchedulWork = in.readDouble();
            this.ActualWork = in.readDouble();
            this.Tel = in.readString();
            this.Detail = in.createTypedArrayList(DetailBean.CREATOR);
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.Data, flags);
        dest.writeInt(this.ErrorCode);
        dest.writeString(this.ErrorMessage);
        dest.writeByte(this.Success ? (byte) 1 : (byte) 0);
    }

    public PlanNotification() {
    }

    protected PlanNotification(Parcel in) {
        this.Data = in.readParcelable(DataBean.class.getClassLoader());
        this.ErrorCode = in.readInt();
        this.ErrorMessage = in.readString();
        this.Success = in.readByte() != 0;
    }

    public static final Parcelable.Creator<PlanNotification> CREATOR = new Parcelable.Creator<PlanNotification>() {
        @Override
        public PlanNotification createFromParcel(Parcel source) {
            return new PlanNotification(source);
        }

        @Override
        public PlanNotification[] newArray(int size) {
            return new PlanNotification[size];
        }
    };
}
