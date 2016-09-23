package com.example.administrator.javabean;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/23.
 */
public class Submit {

    /**
     * BillCode : sample string 1
     * Login : sample string 2
     * ActualWork : 3.1
     * Workers : ["92cec81e-04f2-4f11-a0ce-0bc4103f2b10","2e8c64d6-1405-4f59-97cb-61f452e7bf87","7b6447f6-6e72-4e98-ac6c-e16b4195813d"]
     */

    private String BillCode;
    private String Login;
    private double ActualWork;
    private List<String> Workers;

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String BillCode) {
        this.BillCode = BillCode;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public double getActualWork() {
        return ActualWork;
    }

    public void setActualWork(double ActualWork) {
        this.ActualWork = ActualWork;
    }

    public List<String> getWorkers() {
        return Workers;
    }

    public void setWorkers(List<String> Workers) {
        this.Workers = Workers;
    }
}
