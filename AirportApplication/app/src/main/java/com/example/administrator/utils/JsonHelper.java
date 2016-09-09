package com.example.administrator.utils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by quick_tech cpc on 2016/9/7.
 */
public class JsonHelper {
    public static String jsonFormat(String json){
        if(json.length()>1){
            String format=json.substring(1, json.length() - 1);
            String result=format.replaceAll("\\\\","");
            return result;
        }
        return  json;
    }

    public  static ArrayList<Object> jsonList(String json, Class classOfT){
        ArrayList<Object> list=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(json);
            for(int i=0;i<jsonArray.length();i++){
                String obj=jsonArray.getString(i);
                Gson gson=new Gson();
                Object myClass=gson.fromJson(obj, classOfT);
                list.add(myClass);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }


    public  static JSONArray getArray(String json, Class classOfT){
        JSONArray jsonArray=null;
        try {
            jsonArray  =new JSONArray(json);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
