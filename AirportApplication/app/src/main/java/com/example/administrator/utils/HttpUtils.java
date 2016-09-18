package com.example.administrator.utils;

import android.util.Log;

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


}
