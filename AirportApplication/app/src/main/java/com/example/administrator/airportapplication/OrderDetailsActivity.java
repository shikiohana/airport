package com.example.administrator.airportapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.adapter.OrderDetailsAdapter;
import com.example.administrator.javabean.Device;
import com.example.administrator.javabean.OrderDb;
import com.example.administrator.javabean.OrderDetails;
import com.example.administrator.javabean.UpOrder;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.DividerItemDecoration;
import com.example.administrator.utils.HttpUtils;
import com.example.administrator.utils.SaveOrderData;
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
 * 工单详情
 * Created by quick_tech cpc on 2016/9/12.
 */
public class OrderDetailsActivity extends Activity {
    private Intent intent;

    private String code = "";
    private CheckBox selectAll;
    private RecyclerView recyclerView;
    private TextView orderCode, next, startTime, endTime, planDue, actualDue, upLoad;//工单编号，完成，开始时间，结束时间，计划工期，实际工期
    private ImageView back;
    private TextView deviceDetails;
    private OrderDetails orderDetails;
    private OrderDetailsAdapter orderDetailsAdapter;
    private AlertDialog alertDialog;

    private boolean up = false;
    private boolean change = false;
    private List<OrderDetails.DataBean.DetailBean> list;
    private ArrayList<Device.DataBean> devices;
    private double dueNum;
    private String workDay="";//初始工期

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
            Toast.makeText(OrderDetailsActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 初始化控件
     */
    private void inni() {
        next = (TextView) findViewById(R.id.next_step);
        orderCode = (TextView) findViewById(R.id.order_code);
        startTime = (TextView) findViewById(R.id.start_time);
        endTime = (TextView) findViewById(R.id.end_time);
        deviceDetails = (TextView) findViewById(R.id.device_details);
        back = (ImageView) findViewById(R.id.back);
        upLoad = (TextView) findViewById(R.id.load_order);//提交并上传
        planDue = (TextView) findViewById(R.id.plan_due);
        actualDue = (EditText) findViewById(R.id.actual_due);
        selectAll = (CheckBox) findViewById(R.id.select_all);
        recyclerView = (RecyclerView) findViewById(R.id.order_detail_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        back.setOnClickListener(onClickListener);
        next.setOnClickListener(onClickListener);
        upLoad.setOnClickListener(onClickListener);
        deviceDetails.setOnClickListener(onClickListener);
        list=new ArrayList<>();
        devices = new ArrayList<>();
        actualDue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String content=actualDue.getText().toString();
                if(!content.equals(workDay)){
                    workDay=content;
                    change=true;
                }
            }
        });
    }

    /**
     * 点击事件
     */
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.back:
                    back();
                    break;
                case R.id.next_step:
                    doneList();
                    break;
                case R.id.device_details:
                    Intent intent = new Intent(OrderDetailsActivity.this, MoreDetailActivity.class);
                    intent.putExtra(Constants.DEVICE_AID, code);
                    startActivityForResult(intent, Constants.DETAIL);
                    break;
                case R.id.load_order:

                        up = true;
                        doneList();

                    break;
                default:
                    break;
            }
        }
    };

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
        RequestParams requesParams = new RequestParams(Constants.BASE_URL + Constants.ORDERDETAILS + code);
        requesParams.addHeader("login", TokenKeeper.getUser(this));
        requesParams.addHeader("token", TokenKeeper.getToken(this));
        x.http().get(requesParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                orderDetails = gson.fromJson(result, OrderDetails.class);
                list = orderDetails.getData().getDetail();

                startTime.setText(orderDetails.getData().getBillDate());
                endTime.setText(orderDetails.getData().getOrderFinishDate());
                planDue.setText(orderDetails.getData().getSchedulWork() + "天");
                orderDetailsAdapter = new OrderDetailsAdapter(list);
                orderDetailsAdapter.setOnClicked(onClicked);
                recyclerView.setAdapter(orderDetailsAdapter);

                selectAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setSelectAll();
                    }
                });
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(OrderDetailsActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {

                selectAll.setChecked(false);
            }
        });
    }


    /**
     * listItem的点击事件
     */
    OrderDetailsAdapter.OnClicked onClicked = new OrderDetailsAdapter.OnClicked() {
        /**
         * 设置选中状态
         * @param view
         * @param position
         */
        @Override
        public void checked(View view, int position) {
            change = true;
            if (orderDetailsAdapter.getMaps().get(position)) {
                orderDetailsAdapter.getMaps().put(position, false);
                selectAll.setChecked(false);
                selectAll.setText("全选");
            } else {
                orderDetailsAdapter.getMaps().put(position, true);
                selectAll.setChecked(orderDetailsAdapter.isAllChecked());
                if (orderDetailsAdapter.isAllChecked()) {
                    selectAll.setText("取消");
                }
            }
            orderDetailsAdapter.notifyDataSetChanged();
        }
    };

    /**
     * 全选和取消全选
     */
    private void setSelectAll() {
        if (orderDetailsAdapter != null) {
            orderDetailsAdapter.setAllChecked(selectAll.isChecked());
            orderDetailsAdapter.notifyDataSetChanged();
        }
        if (selectAll.isChecked()) {
            selectAll.setText("取消");
        } else {
            selectAll.setText("全选");
        }

    }

    /**
     * 添加备注后回调备注正文
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("cdoooo",requestCode+"-------"+resultCode);
        if (resultCode == resultCode) {
            switch (resultCode) {
                case Constants.DETAIL:
                    ArrayList<Device.DataBean> list = data.getParcelableArrayListExtra(MoreDetailActivity.CHECKRESULT);
                    if (list != null && list.size() > 0) {
                        for (Device.DataBean dataBean : list) {
                            devices.add(dataBean);
                        }
                        change = true;
                    }
                    break;
                case Constants.SUMBIT:
                    finish();
                    break;
                default:
                    break;
            }


        }
    }

    /**
     * 保存，上传
     */
    private void doneList() {

        if(list.size()>0) {
            Gson gson = new Gson();
            UpOrder upOrder = new UpOrder();
            upOrder.setBillCode(code);
            upOrder.setDetails(list, orderDetailsAdapter.getMaps());
            upOrder.setDevices(devices);
            upOrder.setOrderMemo("");
            upOrder.setOrderMemoEN("");
            String due = actualDue.getText().toString();
            Log.i("due",due);
            if (due.equals("")) {
                due = "0";
            }
            dueNum = Integer.parseInt(due);
            upOrder.setActualWork(dueNum);
            orderDetails.getData().setActualWork(dueNum+"（天）");
            String json = gson.toJson(upOrder);
            Log.i("json", json);
            RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.DEVICE);
            requestParams.addHeader("login", TokenKeeper.getUser(this));
            requestParams.addHeader("token", TokenKeeper.getToken(this));
            requestParams.setAsJsonContent(true);
            requestParams.setBodyContent(json);
            x.http().post(requestParams, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Log.i("post", result);
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        boolean success = jsonObject.getBoolean("Success");
                        if (success) {//上传成功
                            Toast.makeText(OrderDetailsActivity.this, "保存完毕", Toast.LENGTH_SHORT).show();
                            OrderDb orderDb=new OrderDb();
                            orderDb.code=code;
                            orderDb.isPlan=true;
                            orderDb.content=orderDetails.getData().getOrderMemo();
                            SaveOrderData.saveOrder(orderDb);
                            change = false;
                            if (up) {//如果是上传
                                Intent intent = new Intent(OrderDetailsActivity.this, UploadOrderActivity.class);
                                intent.putExtra("orderDetail", orderDetails);
                                intent.putExtra("plan", true);
                                intent.putExtra("work_time", dueNum);
                                startActivity(intent);
                                startActivityForResult(intent,Constants.SUMBIT);
                            }
                        } else {
                            Toast.makeText(OrderDetailsActivity.this, "保存失败，请重试", Toast.LENGTH_SHORT).show();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
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
                    up = false;
                }
            });
        }



    }

    /**
     * 返回，退出
     */
    private void back() {
        if (change) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("警告");
            builder.setMessage("处理结果未上传，请先保存");
            builder.setNegativeButton("不保存", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    finish();
                }
            });
            builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.dismiss();
                }
            });
            builder.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    doneList();
                }
            });
            alertDialog = builder.create();
            alertDialog.show();
        } else {
            finish();
        }

    }

    /**
     * 返回键监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
