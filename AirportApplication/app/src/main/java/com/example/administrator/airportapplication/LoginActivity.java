package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by quick_tech cpc on 2016/9/5.
 */
public class LoginActivity extends Activity {
    EditText userName, serverName, password, accountSet;//用户名，服务器，密码，账套
    LinearLayout linearLayout;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inni();
    }

    /**
     * 初始化控件
     */
    private void inni() {
        serverName = (EditText) findViewById(R.id.edit_server);
        accountSet = (EditText) findViewById(R.id.edit_account_set);
        userName = (EditText) findViewById(R.id.edit_username);
        password = (EditText) findViewById(R.id.edit_password);
        linearLayout = (LinearLayout) findViewById(R.id.linerlayout);
        login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(onClickListener);
        linearLayout.setOnClickListener(onClickListener);
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
     */
    private void login() {
        startActivity(new Intent(LoginActivity.this, WorkOderActivity.class));
    }

    /**
     * 校验是否有不为空的输入框
     *
     * @return
     */
    private boolean empty() {
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

}
