package com.example.administrator.airportapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.administrator.adapter.WorkOrderAdapter;
import com.example.administrator.utils.DividerItemDecoration;

/**
 * Created by quick_tech cpc on 2016/9/5.
 */
public class WorkOderActivity extends Activity {
    RecyclerView recyclerView;
    Spinner companyList;
    WorkOrderAdapter workOrderAdapter;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_orders_list);
        inni();
        inniRecyclerView();
    }

    /**
     * 初始化控件
     */
    private void inni() {
        recyclerView = (RecyclerView) findViewById(R.id.work_order_list);
        companyList = (Spinner) findViewById(R.id.company_list);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        //  swipeRefreshLayout.setOnRefreshListener();
    }

    /**
     * 更新recyclerView
     */
    private void inniRecyclerView() {
        workOrderAdapter = new WorkOrderAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        workOrderAdapter.setOnWorkItemClickListener(workItemClickListener);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(workOrderAdapter);


    }

    /**
     * recyclerview 的点击事件
     */
    WorkOrderAdapter.WorkItemClickListener workItemClickListener = new WorkOrderAdapter.WorkItemClickListener() {
        @Override
        public void itemCLicked(View view, int position) {

        }
    };

    /**
     * 更新航空公司
     */
    private void inniCompanyList() {

    }
}
