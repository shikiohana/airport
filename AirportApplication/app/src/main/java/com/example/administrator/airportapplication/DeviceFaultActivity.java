package com.example.administrator.airportapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.adapter.CompanyAdapter;
import com.example.administrator.adapter.DeviceFaultAdapter;
import com.example.administrator.javabean.Company;
import com.example.administrator.javabean.DeviceFault;
import com.example.administrator.javabean.Response;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.DividerItemDecoration;
import com.example.administrator.utils.HttpUtils;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/21.
 */
public class DeviceFaultActivity extends Activity {
    private Spinner companyList;
    private RecyclerView recyclerView;
    private List<Company.DataBean> list;
    private CompanyAdapter companyAdapter;
    private Company.DataBean nowChosen;
    private ImageView back;
    private List<DeviceFault.DataBean> dataBeans;
    private DeviceFaultAdapter deviceFaultAdapter;
    private String originCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fault_list);
        inni();
    }

    /**
     * 初始化空间
     */
    private void inni(){
        companyList=(Spinner)findViewById(R.id.fault_company);
        recyclerView=(RecyclerView)findViewById(R.id.my_fault_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        back=(ImageView)findViewById(R.id.fault_back);
        dataBeans=new ArrayList<>();
        list=new ArrayList<>();
        inniCompany();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



    private void inniCompany(){
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.COMPANYS);
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));

        Log.i("url", Constants.BASE_URL + Constants.COMPANYS);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                if (result != null && !result.equals("")) {

                    Gson gson = new Gson();
                    Company company = gson.fromJson(result, Company.class);
                    list = company.getData();

                    companyAdapter = new CompanyAdapter(DeviceFaultActivity.this, list);
                    companyList.setAdapter(companyAdapter);
                    companyList.setOnItemSelectedListener(onItemSelectedListener);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("onError", ex.getMessage() + ex.getCause());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 获取
     */
    private void getFaultList(String companyCode){
        if(!companyCode.equals("")){
            RequestParams requestParams=new RequestParams(Constants.BASE_URL+Constants.DEVICEFAUTL);
            requestParams.addHeader("login", TokenKeeper.getUser(this));
            requestParams.addHeader("token", TokenKeeper.getToken(this));
            requestParams.setAsJsonContent(true);
            JSONObject jsonObject=new JSONObject();
            try {
                jsonObject.put("Login","xlf");
                jsonObject.put("CustomerCode",companyCode);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            requestParams.setBodyContent(jsonObject.toString());
            x.http().post(requestParams, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Log.i("result",result);
                    Gson gson=new Gson();
                    DeviceFault deviceFault=gson.fromJson(result,DeviceFault.class);
                    dataBeans=deviceFault.getData();
                    deviceFaultAdapter=new DeviceFaultAdapter(dataBeans);
                    deviceFaultAdapter.setDeviceApplyClick(deviceApplyClick);
                    recyclerView.setAdapter(deviceFaultAdapter);
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


    /**
     * 航空公司item选择后的点击时间
     */
    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            //根据选择的航空公司更新recyclerview

            nowChosen = list.get(i);
            if (TokenKeeper.isOverDue(DeviceFaultActivity.this)) {
                HttpUtils.refreshLogin(DeviceFaultActivity.this, new HttpUtils.RefreshListener() {
                    @Override
                    public void complete() {
                       getFaultList(nowChosen.getCustomerCode());
                    }
                });
            } else {
                getFaultList(nowChosen.getCustomerCode());
            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    DeviceFaultAdapter.DeviceApplyClick deviceApplyClick=new DeviceFaultAdapter.DeviceApplyClick() {
        @Override
        public void deviceClick(View view, View code, View schedule, int position) {
            DeviceFault.DataBean dataBean=(DeviceFault.DataBean)view.getTag();
            originCode=dataBean.getBillCode();
            EditText editCode=(EditText)code;
            EditText editSchedule=(EditText)schedule;
            String newCode=editCode.getText().toString();
            String newSch=editSchedule.getText().toString();
            if(newCode.equals(originCode)||newSch.equals("")){
                Toast.makeText(DeviceFaultActivity.this, "请填写新的工单号和工期", Toast.LENGTH_SHORT).show();
            }else{
                dataBean.setBillCode(newCode);
                dataBean.setSchedulWork(Integer.parseInt(newSch));
                apply(dataBean);
            }

        }
    };


    private  void apply(final DeviceFault.DataBean dataBean){
            RequestParams requestParams=new RequestParams(Constants.BASE_URL+Constants.APPLY+originCode);
            requestParams.setAsJsonContent(true);
            requestParams.addHeader("login", TokenKeeper.getUser(this));
            requestParams.addHeader("token", TokenKeeper.getToken(this));
            Gson gson=new Gson();
            String json= gson.toJson(dataBean);
            Log.i("json",json);
            requestParams.setBodyContent(json);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gsonResult=new Gson();
                Response response=gsonResult.fromJson(result,Response.class);
                if(response.isSuccess()){
                    dataBean.setIsApply(true);
                    Toast.makeText(DeviceFaultActivity.this, "申报成功", Toast.LENGTH_SHORT).show();
                }
                deviceFaultAdapter.notifyDataSetChanged();
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
