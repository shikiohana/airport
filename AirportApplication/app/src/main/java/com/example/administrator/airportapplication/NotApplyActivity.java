package com.example.administrator.airportapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.adapter.NotApplyAdapter;
import com.example.administrator.javabean.OrderDb;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.DividerItemDecoration;
import com.example.administrator.utils.SaveOrderData;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/21.
 */
public class NotApplyActivity extends Activity {
    private RecyclerView notApplyList;
    private List<OrderDb> list;
    private NotApplyAdapter applyAdapter;
    public static final String DELETE = "notify";
    private TextView clear;
    private ImageView back;
    private AlertDialog alertDialog;
    private TextView noResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_apply);
        inni();
        getList();
    }

    /**
     * 初始化控件
     */
    private void inni() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DELETE);
        //注册广播，更新被移除的工单
        registerReceiver(notApplyBroadcast, intentFilter);
        notApplyList = (RecyclerView) findViewById(R.id.not_apply_list);
        clear = (TextView) findViewById(R.id.clear);
        back = (ImageView) findViewById(R.id.apply_back);
        noResult=(TextView)findViewById(R.id.no_result);
        notApplyList.setLayoutManager(new LinearLayoutManager(this));
        notApplyList.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        list = new ArrayList<>();
        clear.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.apply_back:
                    finish();
                    break;
                case R.id.clear:
                    SaveOrderData.clear();
                    getList();
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 获取保存的工单列表
     */
    private void getList() {
        DbManager dbManager = x.getDb(SaveOrderData.getDaoConfig());
        try {
            Log.i("list", list.size() + "");
            list = dbManager.findAll(OrderDb.class);
            Log.i("list", list.size() + "");
            applyAdapter = new NotApplyAdapter(list);
            applyAdapter.setApplyClickListener(applyClickListener);
            notApplyList.setAdapter(applyAdapter);
            if(list.size()==0){
                noResult.setText("工单处理完毕");
                noResult.setVisibility(View.VISIBLE);

            }
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    NotApplyAdapter.ApplyClickListener applyClickListener = new NotApplyAdapter.ApplyClickListener() {
        @Override
        public void click(View view, int position) {
            OrderDb orderDb = (OrderDb) view.getTag();
            String code = orderDb.code;
            Intent intent = new Intent();

            if (orderDb.isPlan) {//是否为计划工单
                intent.setClass(NotApplyActivity.this, OrderDetailsActivity.class);//计划工单
                intent.putExtra(WorkOderFragment.DATABEAN, code);
            } else {
                intent.setClass(NotApplyActivity.this, NotPlanDetailActivity.class);//非计划工单
                intent.putExtra(Constants.CONTENT, code);
            }
            startActivity(intent);
        }

        @Override
        public void longClick(View view, int position) {
            delete(position);
        }
    };

    BroadcastReceiver notApplyBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(DELETE)) {
                for (int i = 0; i < list.size(); i++) {
                    OrderDb orderDb = list.get(i);
                    if (orderDb.code.equals(intent.getStringExtra("billCode"))) {
                        list.remove(i);
                        applyAdapter.notifyItemRemoved(i);
                        applyAdapter.notifyItemRangeRemoved(i, list.size() - i);
                        return;
                    }
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        //注销广播
        unregisterReceiver(notApplyBroadcast);
        super.onDestroy();

    }

    private void delete(final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("删除此记录");
        builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                list.remove(i);
                applyAdapter.notifyItemRemoved(position);
                applyAdapter.notifyItemRangeChanged(position, list.size() - i);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog.dismiss();
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }
}
