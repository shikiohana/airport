package com.example.administrator.airportapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.adapter.SelectUserAdapter;
import com.example.administrator.javabean.NotPlanNotification;
import com.example.administrator.javabean.OrderDb;
import com.example.administrator.javabean.OrderDetails;
import com.example.administrator.javabean.PlanNotification;
import com.example.administrator.javabean.Response;
import com.example.administrator.javabean.Submit;
import com.example.administrator.javabean.UnPlanOderDetail;
import com.example.administrator.javabean.UserResult;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.HttpUtils;
import com.example.administrator.utils.SaveOrderData;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/20.
 */
public class UploadOrderActivity extends Activity {
    private TextView code, start, end, plan, actual, recMan, selectDone;
    private ImageView back, add;
    private TextView confirm;
    private String billCode;
    private boolean isPlan, isNotification;
    private RecyclerView chosenMan, recManList;
    private String customerCode;
    private UserResult userResult;
    private List<UserResult.DataBean> list, chosenList, selectList;
    private List<String> users;
    private EditText select;
    private SelectUserAdapter allAdapter, chosenAdapter;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private double num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_plan_order);
        inni();
        inniText();
    }

    /**
     * 初始化
     */
    private void inni() {
        code = (TextView) findViewById(R.id.confirm_order_code);
        start = (TextView) findViewById(R.id.confrim_order_start_time);
        end = (TextView) findViewById(R.id.confrim_order_end_time);
        plan = (TextView) findViewById(R.id.confrim_order_plan_due);
        actual = (TextView) findViewById(R.id.confrim_order_actual_due);
        recMan = (TextView) findViewById(R.id.confrim_order_rec_man);
        back = (ImageView) findViewById(R.id.order_back);
        add = (ImageView) findViewById(R.id.add_rec_man);
        confirm = (TextView) findViewById(R.id.up_load_order);//提交工单
        back.setOnClickListener(onClickListener);
        confirm.setOnClickListener(onClickListener);
        list = new ArrayList<>();
        chosenList = new ArrayList<>();
        selectList = new ArrayList<>();
        users = new ArrayList<>();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.order_back:
                    setResult(0);
                    finish();
                    break;
                case R.id.up_load_order:
                    if (chosenList.size() == 0) {
                        Toast.makeText(UploadOrderActivity.this, "还未选择检查人员", Toast.LENGTH_SHORT).show();
                    } else {
                        if (TokenKeeper.isOverDue(UploadOrderActivity.this)) {
                            HttpUtils.refreshLogin(UploadOrderActivity.this, new HttpUtils.RefreshListener() {
                                @Override
                                public void complete() {
                                    post();
                                }
                            });
                        } else {
                            post();
                        }
                    }
                    break;
                case R.id.add_rec_man:
                    if (alertDialog != null) {
                        alertDialog.show();
                        WindowManager.LayoutParams params = alertDialog.getWindow().getAttributes();
                        params.width = 800;

                        params.height = 800;
                        alertDialog.getWindow().setAttributes(params);
                    }
                    break;

                default:
                    break;
            }
        }
    };


    private void inniRec(String content) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list.size() == 0 && content != null) {
            stringBuilder.append(content);
        } else {
            for (int i = 0; i < chosenList.size(); i++) {
                stringBuilder.append(" " + chosenList.get(i).getEName() + "");
            }
        }

        recMan.setText(stringBuilder.toString());
    }

    /**
     * 更新信息
     */
    private void inniText() {
        Intent intent = getIntent();

        isPlan = intent.getBooleanExtra("plan", true);
        isNotification = intent.getBooleanExtra("notification", false);
        if (isPlan && !isNotification) {//计划，非通知
            OrderDetails orderDetails = intent.getParcelableExtra("orderDetail");
            OrderDetails.DataBean dataBean = orderDetails.getData();
            billCode = dataBean.getBillCode();
            code.setText(billCode);
            start.setText(dataBean.getBillDate());
            end.setText(dataBean.getOrderFinishDate());
            plan.setText(dataBean.getSchedulWork() + "（天）");
            num = intent.getDoubleExtra("work_time", 0);
            actual.setText(dataBean.getActualWork());
            customerCode = dataBean.getCustomerCode();

        }
        if (!isPlan && !isNotification) {//非计划,非通知
            UnPlanOderDetail.DataBean dataBean = intent.getParcelableExtra("orderDetail");
            num = intent.getDoubleExtra("work_time", 0);
            billCode = dataBean.getBillCode();
            code.setText(billCode);
            start.setText(dataBean.getBillDate());
            end.setText(dataBean.getFinishDate());
            plan.setText(dataBean.getSchedulWork() + "（天）");
            actual.setText(num + "（天）");
           /* recMan.setText(TokenKeeper.getName(this));*/
            customerCode = dataBean.getCustomerCode();
        }
        if (isPlan && isNotification) {//通知，计划
            PlanNotification.DataBean dataBean = intent.getParcelableExtra("orderDetail");
            num = intent.getDoubleExtra("work_time", 0);
            billCode = dataBean.getBillCode();
            code.setText(billCode);
            start.setText(dataBean.getBillDate());
            end.setText(dataBean.getOrderFinishDate());
            plan.setText(dataBean.getSchedulWork() + "（天）");
            actual.setText(dataBean.getActualWork() + "（天）");
           /* recMan.setText(TokenKeeper.getName(this));*/
            customerCode = dataBean.getCustomerCode();
        }
        if (!isPlan && isNotification) {//非计划，通知
            NotPlanNotification.DataBean dataBean = intent.getParcelableExtra("orderDetail");
            num = intent.getDoubleExtra("work_time", 0);
            billCode = dataBean.getBillCode();
            code.setText(billCode);
            start.setText(dataBean.getBillDate());
            end.setText(dataBean.getFinishDateS());
            plan.setText(dataBean.getSchedulWork() + "（天）");
            actual.setText(num + "（天）");
           /* recMan.setText(TokenKeeper.getName(this));*/
            customerCode = dataBean.getCustomerCode();
        }
        getUsers();
    }

    /**
     * 提交
     */
    private void post() {
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.POSTORDER);
        requestParams.setAsJsonContent(true);
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));
        Gson gson = new Gson();
        Submit submit = new Submit();

        submit.setActualWork(num);
        submit.setBillCode(billCode);
        submit.setLogin(TokenKeeper.getUser(this));
        for (UserResult.DataBean userResult : chosenList) {
            users.add(userResult.getEName());
        }
        submit.setWorkers(users);
        String json = gson.toJson(submit);
        requestParams.setBodyContent(json);
        Log.i("jsono", json);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("result", result);
                Gson gson = new Gson();
                Response response = gson.fromJson(result, Response.class);
                if (response.isSuccess()) {
                    DbManager dbManager = x.getDb(SaveOrderData.getDaoConfig());

                    try {
                        dbManager.deleteById(OrderDb.class, billCode);
                        Intent intent = new Intent();
                        intent.putExtra("billcode", billCode);
                        intent.setAction(NotApplyActivity.DELETE);
                        sendBroadcast(intent);
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                    setResult(Constants.SUMBIT);
                    finish();
                } else {
                    Toast.makeText(UploadOrderActivity.this, response.getErrorMessage(), Toast.LENGTH_SHORT).show();
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

    /**
     * 获取员工列表
     */
    private void getUsers() {
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.GETUSERS + customerCode);
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("users", result);
                Gson gson = new Gson();
                userResult = gson.fromJson(result, UserResult.class);
                list = userResult.getData();
                if (list != null) {
                    add.setOnClickListener(onClickListener);
                    selectList = list;
                    inniPop();
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

    /**
     * 弹出筛选user
     */
    private void inniPop() {
        builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.select_user, null);
        selectDone = (TextView) view.findViewById(R.id.select_done);
        select = (EditText) view.findViewById(R.id.select_content);
        recManList = (RecyclerView) view.findViewById(R.id.user_list);//所有人
        chosenMan = (RecyclerView) view.findViewById(R.id.user_choosen);//已选择
        allAdapter = new SelectUserAdapter(selectList);
        allAdapter.setUserClickListener(userClickListener);
        chosenAdapter = new SelectUserAdapter(chosenList);
        chosenAdapter.setUserClickListener(removeUserClickListener);
        select.addTextChangedListener(textWatcher);
        recManList.setLayoutManager(new GridLayoutManager(this, 4));
        chosenMan.setLayoutManager(new GridLayoutManager(this, 3));
        recManList.setAdapter(allAdapter);
        chosenMan.setAdapter(chosenAdapter);
        selectDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }
                String content = select.getText().toString();
                inniRec(content);
            }
        });
        builder.setView(view);
        alertDialog = builder.create();
    }

    /**
     * 点击添加
     */
    SelectUserAdapter.UserClickListener userClickListener = new SelectUserAdapter.UserClickListener() {
        @Override
        public void click(View view, int position) {
            UserResult.DataBean dataBean = (UserResult.DataBean) view.getTag();
            if (!chosenList.contains(dataBean)) {
                chosenList.add(dataBean);
                chosenAdapter.notifyItemInserted(chosenList.size() - 1);
                chosenAdapter.notifyItemRangeChanged(chosenList.size() - 1, chosenList.size());
            }
        }
    };
    /**
     * 点击已选择的，移除
     */
    SelectUserAdapter.UserClickListener removeUserClickListener = new SelectUserAdapter.UserClickListener() {
        @Override
        public void click(View view, int position) {
            chosenList.remove(position);
            chosenAdapter.notifyItemRemoved(position);
            chosenAdapter.notifyItemRangeChanged(position, chosenList.size() - position);
        }
    };


    /**
     * 监听输入筛选
     */
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String content = select.getText().toString();
            selectList = new ArrayList<>();
            for (UserResult.DataBean dataBean : list) {
                if (dataBean.getEName().contains(content) || dataBean.getECode().contains(content)) {
                    //根据名字和工号筛选
                    selectList.add(dataBean);
                }
            }
            allAdapter = new SelectUserAdapter(selectList);
            allAdapter.setUserClickListener(userClickListener);
            recManList.setAdapter(allAdapter);

        }
    };
}
