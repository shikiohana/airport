package com.example.administrator.javabean;

/**
 * Created by quick_tech cpc on 2016/9/24.
 */
public class UpAccept {

    /**
     * Login : sting
     * BillCode : tring
     * Receive : true
     */

    private String Login;
    private String BillCode;
    private boolean Receive;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String BillCode) {
        this.BillCode = BillCode;
    }

    public boolean isReceive() {
        return Receive;
    }

    public void setReceive(boolean Receive) {
        this.Receive = Receive;
    }
}
