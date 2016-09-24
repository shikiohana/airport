package com.example.administrator.javabean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/24.
 */
public class AirportBasic {

    /**
     * Data : [{"AId":"53863819-20e1-40ee-b897-3324d7422a0a","CustomerCode":"sample string 2","PointName":"sample string 3","PointNameEN":"sample string 4","Memo1":"sample string 5","Memo2":"sample string 6","Memo3":"sample string 7"},{"AId":"53863819-20e1-40ee-b897-3324d7422a0a","CustomerCode":"sample string 2","PointName":"sample string 3","PointNameEN":"sample string 4","Memo1":"sample string 5","Memo2":"sample string 6","Memo3":"sample string 7"},{"AId":"53863819-20e1-40ee-b897-3324d7422a0a","CustomerCode":"sample string 2","PointName":"sample string 3","PointNameEN":"sample string 4","Memo1":"sample string 5","Memo2":"sample string 6","Memo3":"sample string 7"}]
     * ErrorCode : 1
     * ErrorMessage : sample string 2
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * AId : 53863819-20e1-40ee-b897-3324d7422a0a
     * CustomerCode : sample string 2
     * PointName : sample string 3
     * PointNameEN : sample string 4
     * Memo1 : sample string 5
     * Memo2 : sample string 6
     * Memo3 : sample string 7
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
        private String AId;
        private String CustomerCode;
        private String PointName;
        private String PointNameEN;
        private String Memo1;
        private String Memo2;
        private String Memo3;

        public String getAId() {
            return AId;
        }

        public void setAId(String AId) {
            this.AId = AId;
        }

        public String getCustomerCode() {
            return CustomerCode;
        }

        public void setCustomerCode(String CustomerCode) {
            this.CustomerCode = CustomerCode;
        }

        public String getPointName() {
            return PointName;
        }

        public void setPointName(String PointName) {
            this.PointName = PointName;
        }

        public String getPointNameEN() {
            return PointNameEN;
        }

        public void setPointNameEN(String PointNameEN) {
            this.PointNameEN = PointNameEN;
        }

        public String getMemo1() {
            return Memo1;
        }

        public void setMemo1(String Memo1) {
            this.Memo1 = Memo1;
        }

        public String getMemo2() {
            return Memo2;
        }

        public void setMemo2(String Memo2) {
            this.Memo2 = Memo2;
        }

        public String getMemo3() {
            return Memo3;
        }

        public void setMemo3(String Memo3) {
            this.Memo3 = Memo3;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.AId);
            dest.writeString(this.CustomerCode);
            dest.writeString(this.PointName);
            dest.writeString(this.PointNameEN);
            dest.writeString(this.Memo1);
            dest.writeString(this.Memo2);
            dest.writeString(this.Memo3);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.AId = in.readString();
            this.CustomerCode = in.readString();
            this.PointName = in.readString();
            this.PointNameEN = in.readString();
            this.Memo1 = in.readString();
            this.Memo2 = in.readString();
            this.Memo3 = in.readString();
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
