package com.example.administrator.javabean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/19.
 */
public class Device {

    /**
     * Data : [{"AId":"c6b07a80-e76c-46e8-972e-44e56d039416","BillCode":"201609091024-1","Device_AId":"e05d0655-c948-4463-9ee7-edff36b35335","DeviceName":"通天塔","DeviceCode":"1212","DeviceSPEC":"45345","Checked":true,"RecMan":"xlf","RecTime":"2016/9/20 12:14:38","Fault":{"AId":"69ee9308-ee6d-4a23-95cd-322473033564","AirPoint_AId":"27b35512-80f3-45ea-b892-0b7f95358b04","PointName":"机位23","Fault_AId":"3c897985-3120-4cfe-b306-5dd46f083c4c","FaultKey":"链子","Fault_Description":"125465","Fault_DescriptionEN":"Fly!","Image":[{"AId":"35865720-fca7-4957-bb6e-450ad8f96032","IMGUrl":"E:\\work\\MRO\\WebSite\\Image\\Fault\\7775e75b593049c9a74f34eb391590ed.png"}]}},{"AId":"5d750f9d-eae6-4460-8169-8aa9a5e61de3","BillCode":"201609091024-1","Device_AId":"a114ef50-e1c2-41b9-88c6-a3ceca239b86","DeviceName":"梯子","DeviceCode":"123456789","DeviceSPEC":"50*10*10","Checked":true,"RecMan":"xlf","RecTime":"2016/9/20 9:46:02","Fault":{"AId":"a1ed1a72-96f2-4f10-93a4-48f45e50f72f","AirPoint_AId":"27b35512-80f3-45ea-b892-0b7f95358b04","PointName":"机位23","Fault_AId":"1a771310-539a-4550-905d-c1a6a6885570","FaultKey":"加润滑油","Fault_Description":"梯子伸缩过程需要润滑油。","Fault_DescriptionEN":"Telescopic ladder process need lubricating oil.","Image":[]}}]
     * ErrorCode : 0
     * ErrorMessage :
     * Success : true
     */

    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;
    /**
     * AId : c6b07a80-e76c-46e8-972e-44e56d039416
     * BillCode : 201609091024-1
     * Device_AId : e05d0655-c948-4463-9ee7-edff36b35335
     * DeviceName : 通天塔
     * DeviceCode : 1212
     * DeviceSPEC : 45345
     * Checked : true
     * RecMan : xlf
     * RecTime : 2016/9/20 12:14:38
     * Fault : {"AId":"69ee9308-ee6d-4a23-95cd-322473033564","AirPoint_AId":"27b35512-80f3-45ea-b892-0b7f95358b04","PointName":"机位23","Fault_AId":"3c897985-3120-4cfe-b306-5dd46f083c4c","FaultKey":"链子","Fault_Description":"125465","Fault_DescriptionEN":"Fly!","Image":[{"AId":"35865720-fca7-4957-bb6e-450ad8f96032","IMGUrl":"E:\\work\\MRO\\WebSite\\Image\\Fault\\7775e75b593049c9a74f34eb391590ed.png"}]}
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
        private String BillCode;
        private String Device_AId;
        private String DeviceName;
        private String DeviceCode;
        private String DeviceSPEC;
        private boolean Checked;
        private String RecMan;
        private String RecTime;
        /**
         * AId : 69ee9308-ee6d-4a23-95cd-322473033564
         * AirPoint_AId : 27b35512-80f3-45ea-b892-0b7f95358b04
         * PointName : 机位23
         * Fault_AId : 3c897985-3120-4cfe-b306-5dd46f083c4c
         * FaultKey : 链子
         * Fault_Description : 125465
         * Fault_DescriptionEN : Fly!
         * Image : [{"AId":"35865720-fca7-4957-bb6e-450ad8f96032","IMGUrl":"E:\\work\\MRO\\WebSite\\Image\\Fault\\7775e75b593049c9a74f34eb391590ed.png"}]
         */

        private FaultBean Fault;

        public String getAId() {
            return AId;
        }

        public void setAId(String AId) {
            this.AId = AId;
        }

        public String getBillCode() {
            return BillCode;
        }

        public void setBillCode(String BillCode) {
            this.BillCode = BillCode;
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

        public boolean isChecked() {
            return Checked;
        }

        public void setChecked(boolean Checked) {
            this.Checked = Checked;
        }

        public String getRecMan() {
            return RecMan;
        }

        public void setRecMan(String RecMan) {
            this.RecMan = RecMan;
        }

        public String getRecTime() {
            return RecTime;
        }

        public void setRecTime(String RecTime) {
            this.RecTime = RecTime;
        }

        public FaultBean getFault() {
            return Fault;
        }

        public void setFault(FaultBean Fault) {
            this.Fault = Fault;
        }

        public static class FaultBean implements Parcelable {
            private String AId;
            private String AirPoint_AId;
            private String PointName;
            private String Fault_AId;
            private String FaultKey;
            private String Fault_Description;
            private String Fault_DescriptionEN;
            /**
             * AId : 35865720-fca7-4957-bb6e-450ad8f96032
             * IMGUrl : E:\work\MRO\WebSite\Image\Fault\7775e75b593049c9a74f34eb391590ed.png
             */

            private List<ImageBean> Image;

            public String getAId() {
                return AId;
            }

            public void setAId(String AId) {
                this.AId = AId;
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

            public String getFault_Description() {
                return Fault_Description;
            }

            public void setFault_Description(String Fault_Description) {
                this.Fault_Description = Fault_Description;
            }

            public String getFault_DescriptionEN() {
                return Fault_DescriptionEN;
            }

            public void setFault_DescriptionEN(String Fault_DescriptionEN) {
                this.Fault_DescriptionEN = Fault_DescriptionEN;
            }

            public List<ImageBean> getImage() {
                return Image;
            }

            public void setImage(List<ImageBean> Image) {
                this.Image = Image;
            }

            public static class ImageBean implements Parcelable {
                private String AId;
                private String IMGUrl;

                public String getAId() {
                    return AId;
                }

                public void setAId(String AId) {
                    this.AId = AId;
                }

                public String getIMGUrl() {
                    return IMGUrl;
                }

                public void setIMGUrl(String IMGUrl) {
                    this.IMGUrl = IMGUrl;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.AId);
                    dest.writeString(this.IMGUrl);
                }

                public ImageBean() {
                }

                protected ImageBean(Parcel in) {
                    this.AId = in.readString();
                    this.IMGUrl = in.readString();
                }

                public static final Creator<ImageBean> CREATOR = new Creator<ImageBean>() {
                    @Override
                    public ImageBean createFromParcel(Parcel source) {
                        return new ImageBean(source);
                    }

                    @Override
                    public ImageBean[] newArray(int size) {
                        return new ImageBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.AId);
                dest.writeString(this.AirPoint_AId);
                dest.writeString(this.PointName);
                dest.writeString(this.Fault_AId);
                dest.writeString(this.FaultKey);
                dest.writeString(this.Fault_Description);
                dest.writeString(this.Fault_DescriptionEN);
                dest.writeList(this.Image);
            }

            public FaultBean() {
            }

            protected FaultBean(Parcel in) {
                this.AId = in.readString();
                this.AirPoint_AId = in.readString();
                this.PointName = in.readString();
                this.Fault_AId = in.readString();
                this.FaultKey = in.readString();
                this.Fault_Description = in.readString();
                this.Fault_DescriptionEN = in.readString();
                this.Image = new ArrayList<ImageBean>();
                in.readList(this.Image, ImageBean.class.getClassLoader());
            }

            public static final Parcelable.Creator<FaultBean> CREATOR = new Parcelable.Creator<FaultBean>() {
                @Override
                public FaultBean createFromParcel(Parcel source) {
                    return new FaultBean(source);
                }

                @Override
                public FaultBean[] newArray(int size) {
                    return new FaultBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.AId);
            dest.writeString(this.BillCode);
            dest.writeString(this.Device_AId);
            dest.writeString(this.DeviceName);
            dest.writeString(this.DeviceCode);
            dest.writeString(this.DeviceSPEC);
            dest.writeByte(this.Checked ? (byte) 1 : (byte) 0);
            dest.writeString(this.RecMan);
            dest.writeString(this.RecTime);
            dest.writeParcelable(this.Fault, flags);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.AId = in.readString();
            this.BillCode = in.readString();
            this.Device_AId = in.readString();
            this.DeviceName = in.readString();
            this.DeviceCode = in.readString();
            this.DeviceSPEC = in.readString();
            this.Checked = in.readByte() != 0;
            this.RecMan = in.readString();
            this.RecTime = in.readString();
            this.Fault = in.readParcelable(FaultBean.class.getClassLoader());
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
