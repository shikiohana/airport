package com.example.administrator.javabean;

/**
 * Created by quick_tech cpc on 2016/9/24.
 */
public class Translate {

    /**
     * Data : sample string 1
     * ErrorCode : 2
     * ErrorMessage : sample string 3
     * Success : true
     */

    private String Data;
    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
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
}
