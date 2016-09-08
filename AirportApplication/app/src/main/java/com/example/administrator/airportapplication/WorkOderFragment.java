package com.example.administrator.airportapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.administrator.adapter.CompanyAdapter;
import com.example.administrator.adapter.WorkOrderAdapter;
import com.example.administrator.utils.DividerItemDecoration;

/**
 * 工单页面
 * Created by quick_tech cpc on 2016/9/5.
 */
public class WorkOderFragment extends Fragment {
    private RecyclerView recyclerView;
    private Spinner companyList;
    private WorkOrderAdapter workOrderAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RadioButton onPlan, notOnPlan, allPlan;
    private RadioGroup radioGroup;
    private CompanyAdapter companyAdapter;
    private View parent;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parent = inflater.inflate(R.layout.activity_work_orders_list, null);
        inni(parent);
        inniRecyclerView("");
        return parent;
    }

    /**
     * 初始化控件
     */
    private void inni(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.work_order_list);
        companyList = (Spinner) view.findViewById(R.id.company_list);
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        onPlan = (RadioButton) view.findViewById(R.id.on_plan);
        notOnPlan = (RadioButton) view.findViewById(R.id.not_on_plan);
        allPlan = (RadioButton) view.findViewById(R.id.all_plan);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        //  swipeRefreshLayout.setOnRefreshListener();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.all_plan:
                        break;
                    case R.id.on_plan:
                        switchToPlan();
                        break;
                    case R.id.not_on_plan:
                        switchToNotPlan();
                        break;
                    default:
                        break;
                }
            }
        });
        allPlan.setChecked(true);

    }

    /**
     * 更新recyclerView
     */
    private void inniRecyclerView(String company) {
        workOrderAdapter = new WorkOrderAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        workOrderAdapter.setOnWorkItemClickListener(workItemClickListener);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
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
        companyAdapter = new CompanyAdapter();
        companyList.setAdapter(companyAdapter);
    }

    /**
     * 计划工单
     */
    private void switchToPlan() {

    }

    /**
     * 非计划工单
     */
    private void switchToNotPlan() {

    }


}
