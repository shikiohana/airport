package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.adapter.NotificaitonAdapter;
import com.example.administrator.javabean.MyNotification;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.DividerItemDecoration;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/23.
 */
public class NotificationActivity extends Activity {
    TextView title, clear;
    ImageView back;
    RecyclerView notificationList;
    NotificaitonAdapter notificaitonAdapter;
    List<MyNotification.DataBean> list;
    MyNotification.DataBean dataBean;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_apply);
        inni();
        getNotification();
    }

    /**
     * 初始化控件
     */
    private void inni() {
        title = (TextView) findViewById(R.id.title);
        clear = (TextView) findViewById(R.id.clear);
        back = (ImageView) findViewById(R.id.apply_back);
        textView=(TextView)findViewById(R.id.no_result);
        notificationList = (RecyclerView) findViewById(R.id.not_apply_list);
        notificationList.setLayoutManager(new LinearLayoutManager(this));
        notificationList.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        title.setText("我的通知");
        clear.setVisibility(View.GONE);
        back.setOnClickListener(onClickListener);
    }

    /**
     * 点击事件
     */
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };

    /**
     * 获取消息列表
     */
    private void getNotification() {
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.NOTIFICATION + TokenKeeper.getUser(this));
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("notification",result);
                Gson gson = new Gson();
                MyNotification myNotification = gson.fromJson(result, MyNotification.class);
                list = myNotification.getData();
                notificaitonAdapter = new NotificaitonAdapter(list);
                notificaitonAdapter.setNotificationClick(notificationClick);
                notificationList.setAdapter(notificaitonAdapter);
                if(list.size()==0){
                    textView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(NotificationActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
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
     * 消息列表点击事件
     */
    NotificaitonAdapter.NotificationClick notificationClick = new NotificaitonAdapter.NotificationClick() {
        @Override
        public void notificationClicked(View view, int position) {
            dataBean = (MyNotification.DataBean) view.getTag();
            if (dataBean.isIsPlan()) {
                //如果是计划工单
                Intent intent = new Intent(NotificationActivity.this, PlanNotificationActivity.class);
                intent.putExtra(WorkOderFragment.DATABEAN, dataBean.getBillCode());
                startActivity(intent);
            } else {
                //如果是非计划
                Intent intent = new Intent(NotificationActivity.this, NotPlanNotificationActivity.class);
                intent.putExtra(WorkOderFragment.DATABEAN, dataBean.getBillCode());
                startActivity(intent);
            }
        }
    };
}
