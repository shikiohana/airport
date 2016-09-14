package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.adapter.OrderDetailsAdapter;
import com.example.administrator.javabean.OrderDetails;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.DividerItemDecoration;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * 工单详情
 * Created by quick_tech cpc on 2016/9/12.
 */
public class OrderDetailsActivity extends Activity {
    private Intent intent;
    private OrderDetails.DataBean dataBean;
    private String code = null;
    private CheckBox selectAll;
    private RecyclerView recyclerView;
    private TextView orderCode, next,startTime,endTime;
    private ImageView back;
    private final static String ORDERDETAILS = "api/WorkOrder/";
   // private SwipeRefreshLayout refreshLayout;
    private OrderDetailsAdapter orderDetailsAdapter;
    public static final String POSITION = "air_position";
    public static final String CONTENT="remark_content";
    public static final int REQUEST = 2698;

    private List<OrderDetails.DataBean.DetailBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        inni();
        intent = getIntent();
        if (intent != null) {
            code = intent.getStringExtra(WorkOderFragment.DATABEAN);
            if (code != null) {
                orderCode.setText("工单编号:  " + code);
                inniDetals(code);
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
        startTime=(TextView)findViewById(R.id.start_time);
        endTime=(TextView)findViewById(R.id.end_time);
        back = (ImageView) findViewById(R.id.back);
        selectAll = (CheckBox) findViewById(R.id.select_all);
        recyclerView = (RecyclerView) findViewById(R.id.order_detail_list);
    //    refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_details);
        //监听下拉刷新
   //     refreshLayout.setOnRefreshListener(onRefreshListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        back.setOnClickListener(onClickListener);
    }

    /**
     * 点击事件
     */
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.back:
                    finish();
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
    private void inniDetals(String code) {
        RequestParams requesParams = new RequestParams(Constants.BASE_URL + ORDERDETAILS + code);
        requesParams.addHeader("login", TokenKeeper.getUser(this));
        requesParams.addHeader("token", TokenKeeper.getToken(this));
        x.http().get(requesParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                OrderDetails orderDetails = gson.fromJson(result, OrderDetails.class);
                list = orderDetails.getData().getDetail();
                startTime.setText("开始日期: "+orderDetails.getData().getBillDate());
                endTime.setText("截止日期: "+orderDetails.getData().getOrderFinishDate());
                orderDetailsAdapter = new OrderDetailsAdapter(list);
                orderDetailsAdapter.setOnClicked(onClicked);
                recyclerView.setAdapter(orderDetailsAdapter);
             /*   selectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        setSelectAll();
                    }
                });*/
                selectAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setSelectAll();
                        Log.i("checked",selectAll.isChecked()+"");
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
                //refreshLayout.setRefreshing(false);
                selectAll.setChecked(false);
            }
        });
    }

    /**
     * 下拉刷新
     */
   /* SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            if (code != null) {
                inniDetals(code);
            }

        }
    };*/
    /**
     * listItem的点击事件
     */
    OrderDetailsAdapter.OnClicked onClicked = new OrderDetailsAdapter.OnClicked() {
        @Override
        public void checked(View view, int position) {
            if (orderDetailsAdapter.getMaps().get(position)) {
                orderDetailsAdapter.getMaps().put(position, false);
                selectAll.setChecked(false);
                selectAll.setText("全选");
            } else {
                orderDetailsAdapter.getMaps().put(position, true);
                selectAll.setChecked(orderDetailsAdapter.isAllChecked());
                if(orderDetailsAdapter.isAllChecked()){
                    selectAll.setText("取消");
                }

            }

            orderDetailsAdapter.notifyDataSetChanged();
        }

        @Override
        public void clicked(View view, int position) {
            //跳转编辑备注页面
            Intent intent = new Intent(OrderDetailsActivity.this, RemarkActivity.class);
            intent.putExtra(POSITION, position);
            startActivityForResult(intent, REQUEST);
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
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==resultCode){
            String content=data.getStringExtra(CONTENT);
            if(content!=null){
                orderDetailsAdapter.getRemarks().put(data.getIntExtra(POSITION,0),content);
                orderDetailsAdapter.notifyDataSetChanged();
            }

        }
    }
}
