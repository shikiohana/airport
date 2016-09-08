package com.example.administrator.javabean;

/**
 * Created by quick_tech cpc on 2016/9/7.
 */
public class LoginResult {
    /**
     * token : 1a5d32sd1f5s
     * result : {"Login":"admin","PWD":"admin","CNName":"陈佩超","ENName":"","Gender":"","Employee_AId":""}
     */

    private String token;
    /**
     * Login : admin
     * PWD : admin
     * CNName : 陈佩超
     * ENName :
     * Gender :
     * Employee_AId :
     */

    private ResultBean result;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
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
