package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.javabean.OrderDb;
import com.example.administrator.javabean.Response;
import com.example.administrator.javabean.UnPlanOderDetail;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.SaveOrderData;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 非计划工单详情
 * Created by quick_tech cpc on 2016/9/18.
 */
public class NotPlanDetailActivity extends Activity {
    private TextView orderCode, next, startTime, endTime, content, planDue,save,workResult;//工单编号，完成，开始时间，结束时间，具体内容
    private ImageView back;//返回键
    private UnPlanOderDetail.DataBean  dataBean;
    private String code;
    private EditText actulDue;
    private boolean up = false;
    double number;

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
        orderCode = (TextView) findViewById(R.id.order_code_not);
        startTime = (TextView) findViewById(R.id.start_time_not);
        endTime = (TextView) findViewById(R.id.end_time_not);
        save=(TextView)findViewById(R.id.save_not);
        back = (ImageView) findViewById(R.id.back_not);
        content = (TextView) findViewById(R.id.order_detail_content_not);
        planDue = (TextView) findViewById(R.id.plan_due_not);
        actulDue = (EditText) findViewById(R.id.end_due_not);
        workResult = (TextView) findViewById(R.id.edit_detail_not);
        back.setOnClickListener(onClickListener);
        next.setOnClickListener(onClickListener);
        save.setOnClickListener(onClickListener);
        workResult.setOnClickListener(onClickListener);
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
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.NOTDETAIL + code);
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));
        Log.i(TokenKeeper.getUser(this),TokenKeeper.getToken(this));
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("unplan", result);
                Gson gson = new Gson();
                UnPlanOderDetail unPlanOderDetail = gson.fromJson(result, UnPlanOderDetail.class);
                if (unPlanOderDetail.isSuccess()) {
                    dataBean = unPlanOderDetail.getData();

                    startTime.setText(dataBean.getBillDate());//开始日期
                    endTime.setText(dataBean.getDeviceName());//结束日期
                    content.setText(dataBean.getDoContentS() + "");//正文内容
                    planDue.setText(dataBean.getSchedulWork() + "（天）");

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
                    up=true;
                    save();
                    finish();
                    break;
                case R.id.back_not:
                    finish();
                    break;
                case R.id.save_not:
                    up=false;
                    save();

                    break;
                case R.id.edit_detail_not:
                    Intent intent=new Intent(NotPlanDetailActivity.this,EditActivity.class);
                    String content=workResult.getText().toString();
                    if(content==null){
                        content="";
                    }
                    intent.putExtra("content",content);
                    startActivityForResult(intent,1000);
                    break;
                default:


                    break;
            }

        }
    };

    /**
     * 提交，保存
     */
    private void save() {
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.SAVE_NOT_PLAN);
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));
        requestParams.setAsJsonContent(true);
        JSONObject jsonObject = new JSONObject();
        String num = actulDue.getText().toString();
        number = 0;
        if (!num.equals("")) {
            number = Integer.parseInt(num);
        }
        try {
            jsonObject.put("BillCode", code);
            jsonObject.put("ActualWork", number);
            jsonObject.put("DoResult", workResult.getText().toString());
            jsonObject.put("DoResultEN", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        requestParams.setBodyContent(jsonObject.toString());
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("result", result);
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if (response.isSuccess()) {
                    OrderDb orderDb=new OrderDb();
                    orderDb.code=code;
                    orderDb.content=workResult.getText().toString();
                    orderDb.isPlan=false;
                    SaveOrderData.saveOrder(orderDb);
                    if (up) {
                        //如果需要提交
                        Intent intent = new Intent(NotPlanDetailActivity.this, UploadOrderActivity.class);
                        intent.putExtra("orderDetail", dataBean);
                        intent.putExtra("plan", false);
                        intent.putExtra("work_time", number);
                        startActivity(intent);
                    }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("ddd",requestCode+"~~~~~~~"+resultCode);
        if(requestCode==resultCode){
          if(resultCode==1000){
              String content = data.getStringExtra("content");
              Log.i("content",content);
              workResult.setText(content);
          }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
