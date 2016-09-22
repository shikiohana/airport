package com.example.administrator.utils;

import android.content.Context;
import android.util.Log;

import com.example.administrator.javabean.LoginResult;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by quick_tech cpc on 2016/9/6.
 */
public class HttpUtils {
    /**
     * 上传json参数
     * @param url
     * @param json
     * @param callback
     */
    public void postJSON(String url,String json,org.xutils.common.Callback.CommonCallback<String> callback){
        Log.i("url",url);
        RequestParams params = new RequestParams(url);
        params.setAsJsonContent(true);
        params.setBodyContent(json);
        x.http().post(params,callback);
    }


    public interface RefreshListener{
        void complete();

    }


    public static void refreshLogin( final Context context, final RefreshListener refreshListener){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("Login", TokenKeeper.getUser(context));
            jsonObject.put("PWD",TokenKeeper.getPWD(context));
            String json=jsonObject.toString();
            RequestParams requestParams=new RequestParams(Constants.BASE_URL+ Constants.LOGIN);
            requestParams.setAsJsonContent(true);
            requestParams.setBodyContent(json);
            x.http().post(requestParams, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Gson gson=new Gson();
                    LoginResult loginResult = gson.fromJson(result, LoginResult.class);
                    String token = loginResult.getData().getToken();
                    if (token != null && !token.equals("")) {
                        Log.i("keeper", token + "");
                        TokenKeeper.saveToken(loginResult, context);
                        TokenKeeper.saveLoginTime(context);
                    }
                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {

                }

                @Override
                public void onCancelled(CancelledException cex) {

                }

                @Override
                public void onFinished() {
                    refreshListener.complete();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
