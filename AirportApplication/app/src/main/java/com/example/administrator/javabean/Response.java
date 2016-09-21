package com.example.administrator.javabean;

/**
 * Created by quick_tech cpc on 2016/9/20.
 */
public class Response {

    /**
     * Data : true
     * ErrorCode : 2
     * ErrorMessage : sample string 3
     * Success : true
     */

    private boolean Data;
    private int ErrorCode;
    private String ErrorMessage;
    private boolean Success;

    public boolean isData() {
        return Data;
    }

    public void setData(boolean Data) {
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
