package com.example.administrator.airportapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.adapter.AccountAdapter;
import com.example.administrator.javabean.AccountSet;
import com.example.administrator.javabean.LoginResult;
import com.example.administrator.utils.Constants;
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
 * 登陆页面
 * Created by quick_tech cpc on 2016/9/5.
 */
public class LoginActivity extends Activity {
    private EditText userName, password;//用户名，服务器，密码，账套
    private LinearLayout linearLayout;
    private TextView login, serverName;
    private HttpUtils httpUtils;
    private Spinner accountSets;

    private ProgressDialog progressDialog;
    private ArrayList<String> strings;
    private List<AccountSet.DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inni();
        inniAccount();


    }

    /**
     * 是否已经登陆，是，直接登陆，不是，重新登陆
     */
    private void hasLogin() {
        if (TokenKeeper.isLogining(this)) {
            userName.setText(TokenKeeper.getUser(this));
            password.setText(TokenKeeper.getPWD(this));
            /*login();*/
        }
    }

    /**
     * 初始化控件
     */
    private void inni() {
        serverName = (TextView) findViewById(R.id.edit_server);
        accountSets = (Spinner) findViewById(R.id.edit_account_set);
        userName = (EditText) findViewById(R.id.edit_username);
        password = (EditText) findViewById(R.id.edit_password);
        linearLayout = (LinearLayout) findViewById(R.id.linerlayout);
        login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(onClickListener);
        linearLayout.setOnClickListener(onClickListener);

        //监听输入框内容
        password.addTextChangedListener(textWatcher);
        userName.addTextChangedListener(textWatcher);
        setUnCLickable();
    }

    /**
     * 初始化账套
     */
    private void inniAccount() {
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.GETACCOUNT);

        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("dddd",result);
                Gson gson = new Gson();
                AccountSet accountSet = gson.fromJson(result, AccountSet.class);
                list = accountSet.getData();
                AccountAdapter accountAdapter = new AccountAdapter(LoginActivity.this, list);
                accountSets.setAdapter(accountAdapter);
                if (list.size() > 0) {
                    accountSets.setOnItemSelectedListener(onItemSelectedListener);
                }
                hasLogin();
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
                case R.id.login:
                    //登陆
                    login();
                    break;
                case R.id.linerlayout:
                    //让父控件获取焦点，关闭软键盘
                    clearFocus();
                    break;
                default:
                    clearFocus();
                    break;
            }

        }
    };

    /**
     * 登陆
     * Login、PWD、CNName、ENName、Gender、Employee_AId
     */
    private void login() {
        setUnCLickable();
        showProgress();
        httpUtils = new HttpUtils();

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Login", userName.getText().toString());
            jsonObject.put("PWD", password.getText().toString());
            String json = jsonObject.toString();
            Log.i("json", json);
            httpUtils.postJSON(Constants.BASE_URL + Constants.LOGIN, json, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    if (result != null && !result.equals("")) {
                        //  String format = JsonHelper.jsonFormat(result);
                        Gson gson = new Gson();
                        Log.i("format", result);
                        LoginResult loginResult = gson.fromJson(result, LoginResult.class);
                        String token = loginResult.getData().getToken();
                        if (token != null && !token.equals("")) {
                            Log.i("keeper", token + "");
                            TokenKeeper.saveToken(loginResult, LoginActivity.this);
                            //刷新登陆时间
                            TokenKeeper.saveLoginTime(LoginActivity.this);
                            startActivity(new Intent(LoginActivity.this, HomePageActivity.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                            setClickable();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "网络连接异常", Toast.LENGTH_SHORT).show();
                        setClickable();
                    }
                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {

                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    setClickable();
                }

                @Override
                public void onCancelled(CancelledException cex) {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    setClickable();
                }

                @Override
                public void onFinished() {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    setClickable();
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    AdapterView.OnItemSelectedListener onItemSelectedListener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String name=list.get(i).getServiceURL();
            if(name!=null){
                serverName.setText(name);
            }else{
                serverName.setText("");
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    /**
     * 监控输入框内容变化，有输入框为空时登陆不能点击
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
            //如果有内容没输入设置不可点击
            if (allNotEmpty()) {
                setClickable();
            } else {
                setUnCLickable();
            }
        }
    };


    /**
     * 设置登陆按钮不可点击
     */
    private void setUnCLickable() {
        login.setClickable(false);
        login.setBackground(getResources().getDrawable(R.drawable.solid_corner_unclick));
    }

    /**
     * 设置登陆按钮可以点击
     */
    private void setClickable() {
        login.setClickable(true);
        login.setBackground(getResources().getDrawable(R.drawable.solid_corner));
    }

    /**
     * 校验是否有不为空的输入框
     *
     * @return
     */
    private boolean allNotEmpty() {
        if (notEmpty(password) && notEmpty(userName)) {
            return true;
        }
        return false;
    }

    /**
     * 校验该输入框是否为空
     *
     * @param editText
     * @return
     */
    private boolean notEmpty(EditText editText) {
        String str = editText.getText().toString();
        return (str == null || str.equals("")) ? false : true;
    }


    /**
     * 点击空白区域取消输入框焦点
     */
    private void clearFocus() {
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        linearLayout.requestFocus();
        //隐藏软键盘
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(LoginActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

    }

    /**
     * 双击退出程序
     */
    private long exitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) // System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_LONG).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                //退出程序
                // System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("正在登陆");
        progressDialog.show();
    }
}
