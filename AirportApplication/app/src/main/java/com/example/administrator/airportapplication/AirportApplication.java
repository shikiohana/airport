package com.example.administrator.airportapplication;

import android.app.Application;

import org.xutils.x;

/**
 * Created by quick_tech cpc on 2016/9/12.
 */
public class AirportApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.

    }
}
