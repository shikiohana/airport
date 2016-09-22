package com.example.administrator.airportapplication;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.utils.Constants;
import com.example.administrator.utils.TokenKeeper;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by quick_tech cpc on 2016/9/22.
 */
public class ApplyListActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    private void getActivityList(){
        RequestParams requestParams=new RequestParams(Constants.BASE_URL+Constants.APPLY+TokenKeeper.getUser(this));
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token",TokenKeeper.getToken(this));
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
