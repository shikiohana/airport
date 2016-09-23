package com.example.administrator.apiservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by quick_tech cpc on 2016/9/22.
 */
public class AirportService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
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
        ServerSocket serivce=null;

        Socket socket=null;
        try {
            serivce = new ServerSocket(9999);
            System.out.println(serivce.getLocalPort());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        while (true) {
            //等待客户端连�?

            try {
                socket = serivce.accept();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            new Thread(new AndroidRunable(socket)).start();
        }
    }

}
