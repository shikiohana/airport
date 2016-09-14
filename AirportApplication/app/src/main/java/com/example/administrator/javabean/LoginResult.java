package com.example.administrator.javabean;

/**
 * Created by quick_tech cpc on 2016/9/7.
 */
public class LoginResult {


    /**
     * Token : 333FB06077A7137D2E0218C59E6DB880E341F5A499D5AF483C47ED2C207F32790230E0D0B61D3A0F
     * LoginInfo : {"Login":"admin","PWD":"admin","CNName":"陈佩超","ENName":"chengpeichao","Gender":"男","Employee_AId":"54bf6567-1007-11d1-b0aa-444553540000"}
     */

    private DataBean Data;
    /**
     * Data : {"Token":"333FB06077A7137D2E0218C59E6DB880E341F5A499D5AF483C47ED2C207F32790230E0D0B61D3A0F","LoginInfo":{"Login":"admin","PWD":"admin","CNName":"陈佩超","ENName":"chengpeichao","Gender":"男","Employee_AId":"54bf6567-1007-11d1-b0aa-444553540000"}}
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
        private String Token;
        /**
         * Login : admin
         * PWD : admin
         * CNName : 陈佩超
         * ENName : chengpeichao
         * Gender : 男
         * Employee_AId : 54bf6567-1007-11d1-b0aa-444553540000
         */

        private LoginInfoBean LoginInfo;

        public String getToken() {
            return Token;
        }

        public void setToken(String Token) {
            this.Token = Token;
        }

        public LoginInfoBean getLoginInfo() {
            return LoginInfo;
        }

        public void setLoginInfo(LoginInfoBean LoginInfo) {
            this.LoginInfo = LoginInfo;
        }

        public static class LoginInfoBean {
            private String Login;
            private String PWD;
            private String CNName;
            private String ENName;
            private String Gender;
            private String Employee_AId;

            public String getLogin() {
                return Login;
            }

            public void setLogin(String Login) {
                this.Login = Login;
            }

            public String getPWD() {
                return PWD;
            }

            public void setPWD(String PWD) {
                this.PWD = PWD;
            }

            public String getCNName() {
                return CNName;
            }

            public void setCNName(String CNName) {
                this.CNName = CNName;
            }

            public String getENName() {
                return ENName;
            }

            public void setENName(String ENName) {
                this.ENName = ENName;
            }

            public String getGender() {
                return Gender;
            }

            public void setGender(String Gender) {
                this.Gender = Gender;
            }

            public String getEmployee_AId() {
                return Employee_AId;
            }

            public void setEmployee_AId(String Employee_AId) {
                this.Employee_AId = Employee_AId;
            }
        }
    }
}
