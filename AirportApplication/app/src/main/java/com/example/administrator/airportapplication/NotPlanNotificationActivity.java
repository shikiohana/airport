package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.javabean.NotPlanNotification;
import com.example.administrator.javabean.Response;
import com.example.administrator.javabean.UpAccept;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by quick_tech cpc on 2016/9/23.
 */
public class NotPlanNotificationActivity extends Activity {
    private TextView orderCode, next, startTime, endTime, content, planDue,save,workResult;//工单编号，完成，开始时间，结束时间，具体内容
    private ImageView back;//返回键
    private NotPlanNotification.DataBean dataBean;
    private String code;
    private EditText actulDue;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_plan_detail);
        inni();
        inniText();
    }


    /**
     * 初始化控件
     */
    private void inni() {
        next = (TextView) findViewById(R.id.next_step_not);
        next.setText("拒绝");
        next.setBackgroundResource(R.color.colorAccent);
        orderCode = (TextView) findViewById(R.id.order_code_not);
        startTime = (TextView) findViewById(R.id.start_time_not);
        endTime = (TextView) findViewById(R.id.end_time_not);
        save=(TextView)findViewById(R.id.save_not);
        save.setText("接受");

        back = (ImageView) findViewById(R.id.back_not);
        content = (TextView) findViewById(R.id.order_detail_content_not);
        planDue = (TextView) findViewById(R.id.plan_due_not);
        actulDue = (EditText) findViewById(R.id.end_due_not);
        actulDue.setEnabled(false);
        workResult = (TextView) findViewById(R.id.edit_detail_not);
        workResult.setHint("");
        workResult.setEnabled(false);
        back.setOnClickListener(onClickListener);
        next.setOnClickListener(onClickListener);
        save.setOnClickListener(onClickListener);
        linearLayout=(LinearLayout)findViewById(R.id.actual_line_not_plan);
        linearLayout.setVisibility(View.GONE);
    }

    /**
     * 更新内容
     */
    private void inniText() {
        Intent intent = getIntent();
        if (intent != null) {
            code = intent.getStringExtra(WorkOderFragment.DATABEAN);
            orderCode.setText(code);//工单编号
            getDetail(code);
        }
    }

    /**
     * 获取详情
     *
     * @param code
     */
    private void getDetail(String code) {
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.NOTNOTIF + code);
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));
        Log.i(TokenKeeper.getUser(this), TokenKeeper.getToken(this));
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("unplan", result);
                Gson gson = new Gson();
                NotPlanNotification unPlanOderDetail = gson.fromJson(result, NotPlanNotification.class);
                if (unPlanOderDetail.isSuccess()) {
                    dataBean = unPlanOderDetail.getData();

                    startTime.setText(dataBean.getBillDate());//开始日期
                    endTime.setText(dataBean.getDeviceName());//结束日期
                    content.setText(dataBean.getDoContentS() + "");//正文内容
                    planDue.setText(dataBean.getSchedulWork() + "（天）");
                    content.setText(dataBean.getDoContentS());

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

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.next_step_not:
                    done(true);
                    break;
                case R.id.back_not:
                    finish();
                    break;
                case R.id.save_not:
                    done(false);
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
