package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.javabean.OrderDetails;
import com.example.administrator.javabean.Response;
import com.example.administrator.javabean.UnPlanOderDetail;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by quick_tech cpc on 2016/9/20.
 */
public class UploadOrderActivity extends Activity {
    TextView code, start, end, plan, actual, recMan;
    ImageView back;
    TextView confirm;
    String account, billCode;
    boolean isPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_plan_order);
        inni();
        inniText();
    }


    private void inni() {
        code = (TextView) findViewById(R.id.confirm_order_code);
        start = (TextView) findViewById(R.id.confrim_order_start_time);
        end = (TextView) findViewById(R.id.confrim_order_end_time);
        plan = (TextView) findViewById(R.id.confrim_order_plan_due);
        actual = (TextView) findViewById(R.id.confrim_order_actual_due);
        recMan = (TextView) findViewById(R.id.confrim_order_rec_man);
        back = (ImageView) findViewById(R.id.order_back);
        confirm = (TextView) findViewById(R.id.up_load_order);//提交工单
        back.setOnClickListener(onClickListener);
        confirm.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.order_back:
                    finish();
                    break;
                case R.id.up_load_order:
                    post();
                    break;
                default:
                    break;
            }
        }
    };

    private void inniText() {
        Intent intent = getIntent();

        isPlan = intent.getBooleanExtra("plan", true);
        if (isPlan) {
            OrderDetails orderDetails = intent.getParcelableExtra("orderDetail");
            OrderDetails.DataBean dataBean = orderDetails.getData();
            billCode = dataBean.getBillCode();
            code.setText(billCode);
            start.setText(dataBean.getBillDate());
            end.setText(dataBean.getOrderFinishDate());
            plan.setText(dataBean.getSchedulWork() + "（天）");
            actual.setText(dataBean.getActualWork());
            recMan.setText(TokenKeeper.getName(this));
        } else {
            UnPlanOderDetail.DataBean dataBean = intent.getParcelableExtra("orderDetail");
            double num = intent.getDoubleExtra("work_time", 0);
            billCode = dataBean.getBillCode();
            code.setText(billCode);
            start.setText(dataBean.getBillDate());
            end.setText(dataBean.getFinishDate());
            plan.setText(dataBean.getSchedulWork() + "（天）");
            actual.setText(num + "（天）");
            recMan.setText(TokenKeeper.getName(this));
        }
    }


    private void post() {
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.POSTORDER);
        requestParams.setAsJsonContent(true);
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("BillCode", billCode);
            jsonObject.put("Login", TokenKeeper.getUser(this));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        requestParams.setBodyContent(jsonObject.toString());
        Log.i("jsono", jsonObject.toString());
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("result", result);
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if (response.isSuccess()) {
                    finish();
                } else {
                    Toast.makeText(UploadOrderActivity.this, "提交失败，请重试", Toast.LENGTH_SHORT).show();
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
