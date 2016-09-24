package com.example.administrator.airportapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.adapter.PlanNotificationAdapter;
import com.example.administrator.javabean.Device;
import com.example.administrator.javabean.PlanNotification;
import com.example.administrator.javabean.Response;
import com.example.administrator.javabean.UpAccept;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.DividerItemDecoration;
import com.example.administrator.utils.HttpUtils;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/23.
 */
public class PlanNotificationActivity extends Activity {
    private Intent intent;

    private String code = "";
    private CheckBox selectAll;
    private RecyclerView recyclerView;
    private TextView orderCode, next, startTime, endTime, planDue, actualDue, upLoad;//工单编号，完成，开始时间，结束时间，计划工期，实际工期
    private ImageView back;
    private TextView deviceDetails;
    private PlanNotification planNotification;
    private PlanNotificationAdapter planNotificationAdapter;
    private AlertDialog alertDialog;

    public static final int DETAIL = 3568;
    private boolean up = false;
    private boolean change = false;
    private List<PlanNotification.DataBean.DetailBean> list;
    private ArrayList<Device.DataBean> devices;
    private LinearLayout linearLayout;
    private double dueNum;
    private String workDay = "";//初始工期

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        inni();
        intent = getIntent();
        if (intent != null) {
            code = intent.getStringExtra(WorkOderFragment.DATABEAN);
            if (!code.equals("") && code != null) {
                orderCode.setText(code);
                if (TokenKeeper.isOverDue(this)) {
                    HttpUtils.refreshLogin(this, new HttpUtils.RefreshListener() {
                        @Override
                        public void complete() {
                            inniDetals(code);
                        }
                    });
                } else {
                    inniDetals(code);
                }
            }
        } else {
            Toast.makeText(PlanNotificationActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 初始化控件
     */
    private void inni() {
        next = (TextView) findViewById(R.id.next_step);
        next.setText("拒绝");
        next.setBackgroundResource(R.color.colorAccent);
        orderCode = (TextView) findViewById(R.id.order_code);
        startTime = (TextView) findViewById(R.id.start_time);
        endTime = (TextView) findViewById(R.id.end_time);
        deviceDetails = (TextView) findViewById(R.id.device_details);
        deviceDetails.setVisibility(View.GONE);
        back = (ImageView) findViewById(R.id.back);
        upLoad = (TextView) findViewById(R.id.load_order);//提交并上传
        upLoad.setText("接受");
        planDue = (TextView) findViewById(R.id.plan_due);
        actualDue = (EditText) findViewById(R.id.actual_due);
        actualDue.setEnabled(false);
        selectAll = (CheckBox) findViewById(R.id.select_all);
        selectAll.setVisibility(View.GONE);
        recyclerView = (RecyclerView) findViewById(R.id.order_detail_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        back.setOnClickListener(onClickListener);
        next.setOnClickListener(onClickListener);
        upLoad.setOnClickListener(onClickListener);

        list = new ArrayList<>();
        devices = new ArrayList<>();
        linearLayout = (LinearLayout) findViewById(R.id.actual_line);
        linearLayout.setVisibility(View.GONE);

    }


    /**
     * 由工号获取工单详情，并更新list
     *
     * @param code
     */
    private void inniDetals(final String code) {
        if (TokenKeeper.isOverDue(this)) {
            HttpUtils.refreshLogin(this, new HttpUtils.RefreshListener() {
                @Override
                public void complete() {
                    inniDetals(code);
                }
            });
        }
        RequestParams requesParams = new RequestParams(Constants.BASE_URL + Constants.PLANNOTIF + code);
        requesParams.addHeader("login", TokenKeeper.getUser(this));
        requesParams.addHeader("token", TokenKeeper.getToken(this));
        x.http().get(requesParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                planNotification = gson.fromJson(result, PlanNotification.class);
                list = planNotification.getData().getDetail();

                startTime.setText(planNotification.getData().getBillDate());
                endTime.setText(planNotification.getData().getOrderFinishDate());
                planDue.setText(planNotification.getData().getSchedulWork() + "天");
                actualDue.setText(planNotification.getData().getActualWork() + "天");
                planNotificationAdapter = new PlanNotificationAdapter(list);

                recyclerView.setAdapter(planNotificationAdapter);


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(PlanNotificationActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {


            }
        });
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.back:
                    finish();
                    break;
                case R.id.next_step:
                    done(false);
                    break;

                case R.id.load_order:
                    done(true);


                    break;
                default:
                    break;
            }

        }
    };


    /**
     * 接受或者拒绝工单
     */


    private void done(Boolean accept) {
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.RECEIVE);
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));
        requestParams.setAsJsonContent(true);
        UpAccept upAccept = new UpAccept();
        upAccept.setBillCode(code);
        upAccept.setLogin(TokenKeeper.getUser(this));
        upAccept.setReceive(accept);
        Gson gson = new Gson();
        String json = gson.toJson(upAccept);
        requestParams.setBodyContent(json);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson1 = new Gson();
                Response response = gson1.fromJson(result, Response.class);
                if (response.isSuccess()) {
                    finish();
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
