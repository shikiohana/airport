package com.example.administrator.airportapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.adapter.ApplyAdapter;
import com.example.administrator.javabean.Applys;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.DividerItemDecoration;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/22.
 */
public class ApplyListActivity extends Activity {
    RecyclerView recyclerView;
    List<Applys.DataBean> list;
    ImageView back;
    Applys applys;
    Applys.DataBean dataBean;
    ApplyAdapter applyAdapter;
    TextView noResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_apply);
        inni();
    }

    /**
     * 初始化控件
     */
    private void inni() {
        recyclerView = (RecyclerView) findViewById(R.id.my_apply_list);
        back = (ImageView) findViewById(R.id.my_apply_back);
        noResult=(TextView)findViewById(R.id.no_result);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        list = new ArrayList<>();
        getApplyList();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * 获取申请列表
     */
    private void getApplyList() {
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.APPLY + TokenKeeper.getUser(this));
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));
      /*  RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.APPLY + "admin");

        requestParams.addHeader("login", "admin");
        requestParams.addHeader("token", "admin");*/
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("apply", result);
                Gson gson = new Gson();
                applys = gson.fromJson(result, Applys.class);
                list = applys.getData();
                applyAdapter = new ApplyAdapter(list);
                applyAdapter.setApplyClick(applyClick);
                recyclerView.setAdapter(applyAdapter);
                if(list.size()==0){
                    noResult.setText("没有申请记录");
                    noResult.setVisibility(View.VISIBLE);
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

    ApplyAdapter.ApplyClick applyClick = new ApplyAdapter.ApplyClick() {
        @Override
        public void deviceClick(View view, View code, View schedule, int position) {
            dataBean = (Applys.DataBean) view.getTag();
            String id = dataBean.getApplyID();
            deleteApply(id);
        }
    };

    /**
     * 删除申请
     *
     * @param code
     */
    private void deleteApply(String code) {
        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.APPLY + code);
        requestParams.addHeader("login", TokenKeeper.getUser(this));
        requestParams.addHeader("token", TokenKeeper.getToken(this));
        x.http().request(HttpMethod.DELETE, requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("delete",result);
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
