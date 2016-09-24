package com.example.administrator.apiservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by quick_tech cpc on 2016/9/22.
 */
public class AirportService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("socket", "oncreat");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("socket","start");
        startSocket();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private void startSocket(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ServerSocket serivce=null;

                Socket socket=null;
                try {
                    serivce = new ServerSocket(8088);
                    System.out.println(serivce.getLocalPort());
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                Log.i("socket","connecting");
                while (true) {
                    //等待客户端连�?
                    Log.i("socket","success");

                    try {
                        socket = serivce.accept();
                        //接受服务器信息
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));
                        //得到服务器信息
                        String msg = in.readLine();
                        //在页面上进行显示

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                }

            }
        }).start();

    }

}
