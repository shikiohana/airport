package com.example.administrator.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by quick_tech cpc on 2016/9/6.
 */
public class HttpUtils {
    private static int SOCKET_TIME_OUT = 20000;
   /* private String url = " http://192.168.15.247:90/home/api/";

    private StringBuilder Url, UrlParam;// URL地址 拼接参数 返回结果
    private String result;*/


    private final int TIMEOUT_IN_MILLIONS = 5000;// 连接时间

    public String httpPost(String url,String params){
        PrintWriter out = null;
        StringBuilder stringBuilder = new StringBuilder();// 初始化StringBuilder对象
        String result = "";

        try {
            URL httpUrl=new URL(url);
            HttpURLConnection httpURLConnection=(HttpURLConnection)httpUrl.openConnection();



            // 设置通用的请求属性
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("charset", "utf-8");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(TIMEOUT_IN_MILLIONS);
            httpURLConnection.setConnectTimeout(SOCKET_TIME_OUT);
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (params != null && !params.trim().equals("")) {
                // 获取URLConnection对象对应的输出流
                out = new PrintWriter(httpURLConnection.getOutputStream());
                // 发送请求参数
                out.print(params);
                // flush输出流的缓冲
                out.flush();
            }
            // 获取输入流，得到响应内容
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));// 使用BuffereadReader读取接收到的数据
                String line = bufferedReader.readLine();
                while (line != null && line.length() > 0) {
                    stringBuilder.append(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
                inputStream.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    /**
     * Get请求，获得返回数据
     *
     * @param urlStr
     * @return
     * @throws Exception
     */
    public String doGet(String urlStr) {
        URL url = null;
        HttpURLConnection conn = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        Log.i("url",urlStr);
        try {
            url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                baos = new ByteArrayOutputStream();
                int len = -1;
                byte[] buf = new byte[128];

                while ((len = is.read(buf)) != -1) {
                    baos.write(buf, 0, len);
                }
                baos.flush();
                Log.i("baos",baos.toString());
                return baos.toString();
            } else {
                throw new RuntimeException(" responseCode is not 200 ... ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
            }
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
            }
            conn.disconnect();
        }

        return null;

    }

}
