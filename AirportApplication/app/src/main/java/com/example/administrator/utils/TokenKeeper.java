package com.example.administrator.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.administrator.javabean.LoginResult;

/**
 * Created by quick_tech cpc on 2016/9/12.
 * 保存token，用户登录数据
 */
public class TokenKeeper {

    /**
     * token : 1a5d32sd1f5s
     * result : {"Login":"admin","PWD":"admin","CNName":"陈佩超","ENName":"","Gender":"","Employee_AId":""}
     */
    public static final String TOKEN = "user_token";//token
    public static final String USERNAME = "user_name";//用户名
    public static final String EN_NAME = "user_en_name";//用户英文名
    public static final String ACCOUNT = "login_account";//登录账号
    public static final String GENDER = "user_gender";//用户性别
    public static final String AID = "user_aid";//员工ID
    public static final String HASTOKEN = "token_not_null";//是否存在token;
    public static final String AIRPORT_TOKEN = "air_port_quick";


    /**
     * 保存token
     *
     * @param loginResult
     * @param context
     * @return 成功返回true，失败返回false
     */
    public static void saveToken(LoginResult loginResult, Context context) {
        String token = loginResult.getData().getToken();
        SharedPreferences sharedPreferences = context.getSharedPreferences(AIRPORT_TOKEN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(HASTOKEN, true);
        editor.putString(TOKEN, token);
        LoginResult.DataBean.LoginInfoBean loginInfoBean = loginResult.getData().getLoginInfo();
        editor.putString(USERNAME, loginInfoBean.getCNName());
        editor.putString(ACCOUNT, loginInfoBean.getLogin());
        editor.putString(EN_NAME, loginInfoBean.getENName());
        editor.putString(GENDER, loginInfoBean.getGender());
        editor.putString(AID, loginInfoBean.getEmployee_AId());
        editor.commit();
        Log.i("tokensave", "success");
    }

    /**
     * 获取账号
     *
     * @param context
     * @return 无返回null, 存在返回token的String对象
     */
    public static String getToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AIRPORT_TOKEN, Context.MODE_PRIVATE);
        boolean hasToken = sharedPreferences.getBoolean(HASTOKEN, false);
        if (hasToken) {
            String token = sharedPreferences.getString(TOKEN, "");
            return token;
        } else {
            return null;
        }

    }

    /**
     * 获取token
     *
     * @param context
     * @return 无返回null, 存在返回token的String对象
     */
    public static String getUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AIRPORT_TOKEN, Context.MODE_PRIVATE);
        boolean hasToken = sharedPreferences.getBoolean(HASTOKEN, false);
        if (hasToken) {
            String token = sharedPreferences.getString(ACCOUNT, "");
            return token;
        } else {
            return null;
        }

    }

    /**
     * 清除token
     *
     * @param context
     */
    public static void clearToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AIRPORT_TOKEN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
