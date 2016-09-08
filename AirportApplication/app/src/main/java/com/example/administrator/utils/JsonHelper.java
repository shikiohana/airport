package com.example.administrator.utils;

/**
 * Created by quick_tech cpc on 2016/9/7.
 */
public class JsonHelper {
    public static String jsonFormat(String json){
        String format=json.substring(1, json.length() - 1);
        String result=format.replaceAll("\\\\","");
        return result;
    }
}
