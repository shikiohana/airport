package com.example.administrator.airportapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.administrator.adapter.CompanyAdapter;
import com.example.administrator.adapter.NotPlanWorkAdapter;
import com.example.administrator.adapter.PlanWorkOrderAdapter;
import com.example.administrator.adapter.WorkViewPagerAdapter;
import com.example.administrator.javabean.Company;
import com.example.administrator.javabean.NotPlanOrder;
import com.example.administrator.javabean.PlanOrder;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.DividerItemDecoration;
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
 * 工单页面
 * Created by quick_tech cpc on 2016/9/5.
 */
public class WorkOderFragment extends Fragment {
    private RecyclerView planRecyclerView, notPlanRecyclerView;
    private Spinner companyList;
    private PlanWorkOrderAdapter planAdapter;
    private NotPlanWorkAdapter notPlanAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RadioButton onPlan, notOnPlan;
    private RadioGroup radioGroup, orderType;
    private CompanyAdapter companyAdapter;
    private View parent;
    private List<Company.DataBean> list;
    private ViewPager viewPager;
    private ArrayList<View> views;
    private List<PlanOrder.DataBean> select;
    public static final String DATABEAN = "databean";
    private  RadioButton allSelect;

    private List<PlanOrder.DataBean> planList;
    private List<NotPlanOrder.DataBean> notPlanList;
    private Company.DataBean nowChosen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parent = inflater.inflate(R.layout.activity_work_orders_list, null);
        inni(parent);
        inniViewPager();
        inniCompanyList();
        return parent;
    }

    /**
     * 初始化控件
     */
    private void inni(final View view) {

        companyList = (Spinner) view.findViewById(R.id.company_list);
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        onPlan = (RadioButton) view.findViewById(R.id.on_plan);
        notOnPlan = (RadioButton) view.findViewById(R.id.not_on_plan);

        allSelect=(RadioButton)view.findViewById(R.id.all);
        viewPager = (ViewPager) view.findViewById(R.id.list_container);
        planList = new ArrayList<>();
        notPlanList = new ArrayList<>();
        select = new ArrayList<>();
        orderType = (RadioGroup) view.findViewById(R.id.order_type);
        orderType.setOnCheckedChangeListener(typeChange);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {

                    case R.id.on_plan:
                        viewPager.setCurrentItem(0);
                        orderType.setVisibility(View.VISIBLE);
                        break;
                    case R.id.not_on_plan:
                        viewPager.setCurrentItem(1);
                        orderType.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }
        });
        onPlan.setChecked(true);
        companyList.setOnItemSelectedListener(onItemSelectedListener);

    }


    RadioGroup.OnCheckedChangeListener typeChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.all:
                        inniSelect(null);
                    break;
                case R.id.day:
                    inniSelect("日检");
                    break;
                case R.id.week:
                    inniSelect("周检");
                    break;
                case R.id.season:
                    inniSelect("季度检");
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * @param type
     */
    private void inniSelect(String type) {
        select=new ArrayList<>();
        if(type!=null&&planList.size()>0){
            for(PlanOrder.DataBean dataBean:planList){
                if(dataBean.getITypeName().equals(type)){
                    select.add(dataBean);
                }
                planAdapter=new PlanWorkOrderAdapter(getContext(),select);
                planAdapter.setOnWorkItemClickListener(planItemClickListener);
                planRecyclerView.setAdapter(planAdapter);
            }
        }else{
            planAdapter=new PlanWorkOrderAdapter(getContext(),planList);
            planAdapter.setOnWorkItemClickListener(planItemClickListener);
            planRecyclerView.setAdapter(planAdapter);
        }
    }

    /**
     * 更新 plan
     */
    private void updatePlant() {

        RequestParams plan = new RequestParams(Constants.BASE_URL + Constants.PLANLIST);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("CustomerCode", nowChosen.getCustomerCode());
            //  jsonObject.put("Login",TokenKeeper.getUser(getContext()));
            jsonObject.put("Login", TokenKeeper.getUser(getContext()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        plan.setAsJsonContent(true);
        plan.setBodyContent(jsonObject.toString());
        Log.i("plan", jsonObject.toString());
        plan.addHeader("login", TokenKeeper.getUser(getContext()));
        plan.addHeader("token", TokenKeeper.getToken(getContext()));
        x.http().post(plan, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("plan", result);
                if (result != null && !result.equals("")) {
                    Gson gson = new Gson();
                    PlanOrder planOrder = gson.fromJson(result, PlanOrder.class);
                    planList = planOrder.getData();
                    if (planList != null) {
                        planAdapter = new PlanWorkOrderAdapter(getContext(), planList);
                        planAdapter.setOnWorkItemClickListener(planItemClickListener);
                        planRecyclerView.setAdapter(planAdapter);
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
                swipeRefreshLayout.setRefreshing(false);
                allSelect.setChecked(true);
            }
        });

    }


    /**
     * 更新非plan
     */
    private void updateNotPlan() {

        RequestParams notPlan = new RequestParams(Constants.BASE_URL + Constants.NOTONPLAN);
        notPlan.addHeader("login", TokenKeeper.getUser(getContext()));
        notPlan.addHeader("token", TokenKeeper.getToken(getContext()));
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("CustomerCode", nowChosen.getCustomerCode());
            //   jsonObject.put("Login",TokenKeeper.getUser(getContext()));
            jsonObject.put("Login", TokenKeeper.getUser(getContext()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        notPlan.setAsJsonContent(true);
        notPlan.setBodyContent(jsonObject.toString());
        Log.i("notPlan", jsonObject.toString());
        x.http().post(notPlan, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("notPlan", result);
                if (result != null && !result.equals("")) {
                    Gson gson = new Gson();
                    NotPlanOrder notPlanOrder = gson.fromJson(result, NotPlanOrder.class);
                    notPlanList = notPlanOrder.getData();
                    if (notPlanList != null) {
                        notPlanAdapter = new NotPlanWorkAdapter(getContext(), notPlanList);
                        notPlanAdapter.setOnWorkItemClickListener(notPlanItemClickListener);
                        notPlanRecyclerView.setAdapter(notPlanAdapter);
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
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    /**
     * 初始化viewPager
     */
    private void inniViewPager() {
        views = new ArrayList<>();
        View plan = LayoutInflater.from(getContext()).inflate(R.layout.work_order_list, null);
        planRecyclerView = (RecyclerView) plan.findViewById(R.id.work_list);
        planRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        planRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        View notPlan = LayoutInflater.from(getContext()).inflate(R.layout.work_order_list, null);

        notPlanRecyclerView = (RecyclerView) notPlan.findViewById(R.id.work_list);
        notPlanRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        notPlanRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        views.add(plan);
        views.add(notPlan);
        WorkViewPagerAdapter pagerAdapter = new WorkViewPagerAdapter(views);
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    onPlan.setChecked(true);
                } else if (position == 1) {
                    notOnPlan.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    /**
     * 航空公司item选择后的点击时间
     */
    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            //根据选择的航空公司更新recyclerview

            nowChosen = list.get(i);
            if (TokenKeeper.isOverDue(getContext())) {
                HttpUtils.refreshLogin(getContext(), new HttpUtils.RefreshListener() {
                    @Override
                    public void complete() {
                        updatePlant();
                        updateNotPlan();
                    }
                });
            } else {
                updatePlant();
                updateNotPlan();
            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    /**
     * recyclerview 的点击事件
     */
    PlanWorkOrderAdapter.WorkItemClickListener planItemClickListener = new PlanWorkOrderAdapter.WorkItemClickListener() {
        @Override
        public void itemCLicked(View view, int position) {
            PlanOrder.DataBean dataBean = (PlanOrder.DataBean) view.getTag();
            Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
            intent.putExtra(DATABEAN, dataBean.getBillCode());

            startActivity(intent);

        }
    };
    /**
     * recyclerview 的点击事件
     */
    NotPlanWorkAdapter.WorkItemClickListener notPlanItemClickListener = new NotPlanWorkAdapter.WorkItemClickListener() {
        @Override
        public void itemCLicked(View view, int position) {
            NotPlanOrder.DataBean dataBean = (NotPlanOrder.DataBean) view.getTag();
            Intent intent = new Intent(getActivity(), NotPlanDetailActivity.class);
            intent.putExtra(DATABEAN, dataBean.getBillCode());

            startActivity(intent);
        }
    };

    /**
     * 更新航空公司
     */
    private void inniCompanyList() {

        RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.COMPANYS);
        requestParams.addHeader("login", TokenKeeper.getUser(getContext()));
        requestParams.addHeader("token", TokenKeeper.getToken(getContext()));
        Log.i("account", TokenKeeper.getUser(getContext()) + "");
        Log.i("token", TokenKeeper.getToken(getContext()) + "");
        Log.i("url", Constants.BASE_URL + Constants.COMPANYS);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("s", result + "");
                if (result != null && !result.equals("")) {

                    Gson gson = new Gson();
                    Company company = gson.fromJson(result, Company.class);
                    list = company.getData();

                    companyAdapter = new CompanyAdapter(getContext(), list);
                    companyList.setAdapter(companyAdapter);
                    //更新第一个公司对应的工单
                    nowChosen = list.get(0);
                    swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
                    updateNotPlan();
                    updatePlant();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("onError", ex.getMessage() + ex.getCause());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            swipeRefreshLayout.setRefreshing(true);
            if (TokenKeeper.isOverDue(getContext()) && TokenKeeper.isLogining(getContext())) {
                HttpUtils.refreshLogin(getContext(), new HttpUtils.RefreshListener() {
                    @Override
                    public void complete() {
                        //更新登陆状态后再刷新
                        updateNotPlan();
                        updatePlant();
                    }
                });
            } else {
                updateNotPlan();
                updatePlant();
            }
        }
    };
}
