package com.example.administrator.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.example.administrator.airportapplication.NotificationActivity;
import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.MyNotification;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by quick_tech cpc on 2016/9/24.
 */
public class NotificationHelper {
    public static void sendNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("你有新的消息");
        builder.setContentTitle("请在我的通知中查看");
        Intent intent = new Intent(context, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setWhen(System.currentTimeMillis());
        Notification notification = builder.build();
        notificationManager.notify(5, notification);
    }


    /**
     * 获取通知
     */
    public static  void inniNotification(final  Context context){
        RequestParams requestParams=new RequestParams(Constants.BASE_URL+Constants.NOTIFICATION+TokenKeeper.getUser(context));
        requestParams.addHeader("login", TokenKeeper.getUser(context));
        requestParams.addHeader("token", TokenKeeper.getToken(context));
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                MyNotification myNotification = gson.fromJson(result, MyNotification.class);
                if (myNotification.isSuccess()) {
                    NotificationHelper.sendNotification(context);
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

            }
        });
    }
}
