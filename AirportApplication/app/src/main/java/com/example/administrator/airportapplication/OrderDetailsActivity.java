package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;
import java.util.HashMap;
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
    private TextView orderCode, next,startTime,endTime,planDue,actualDue;//工单编号，完成，开始时间，结束时间，计划工期，实际工期
    private ImageView back;
    private final static String ORDERDETAILS = "api/WorkOrder/";
    private OrderDetailsAdapter orderDetailsAdapter;
    public static final String POSITION = "air_position";
    public static final String CONTENT="remark_content";
    public static final String IMGS="remark_imgs";
    public static final int REQUEST = 2698;
    public static final int DETAIL=3568;
    private List<OrderDetails.DataBean.DetailBean> list;
    private HashMap<Integer,ArrayList<String >> imgs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        inni();
        intent = getIntent();
        if (intent != null) {
            code = intent.getStringExtra(WorkOderFragment.DATABEAN);
            if (code != null) {
                orderCode.setText(code);
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
        planDue=(TextView) findViewById(R.id.plan_due);
        actualDue=(TextView)findViewById(R.id.actual_due);
        selectAll = (CheckBox) findViewById(R.id.select_all);
        recyclerView = (RecyclerView) findViewById(R.id.order_detail_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        back.setOnClickListener(onClickListener);
        imgs=new HashMap<>();
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

                startTime.setText(orderDetails.getData().getBillDate());
                endTime.setText(orderDetails.getData().getOrderFinishDate());
                planDue.setText(orderDetails.getData().getSchedulWork()+"天");
                orderDetailsAdapter = new OrderDetailsAdapter(list);
                orderDetailsAdapter.setOnClicked(onClicked);
                recyclerView.setAdapter(orderDetailsAdapter);

                selectAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setSelectAll();

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

                selectAll.setChecked(false);
            }
        });
    }


    /**
     * listItem的点击事件
     */
    OrderDetailsAdapter.OnClicked onClicked = new OrderDetailsAdapter.OnClicked() {
        /**
         * 设置选中状态
         * @param view
         * @param position
         */
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

        /**
         * 跳转备注页面
         * @param view
         * @param position
         */
        @Override
        public void clicked(View view, int position) {
            //跳转编辑备注页面
            Intent intent = new Intent(OrderDetailsActivity.this, RemarkActivity.class);
            intent.putExtra(POSITION, position);
            intent.putExtra(CONTENT,orderDetailsAdapter.getRemarks().get(position));
            startActivityForResult(intent, REQUEST);
        }

        /**
         * 如果有更详细的细节，则跳转
         * @param view
         * @param position
         */
        @Override
        public void detail(View view,int position){
            Intent intent = new Intent(OrderDetailsActivity.this, ActivityMoreDetail.class);
            intent.putExtra(POSITION, position);
            intent.putExtra(CONTENT,orderDetailsAdapter.getRemarks().get(position));
            startActivityForResult(intent, DETAIL);
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
            switch (requestCode){
                case REQUEST:
                    //如果是备注请求
                    String content=data.getStringExtra(CONTENT);
                    if(content!=null){
                        int position=data.getIntExtra(POSITION,0);
                        orderDetailsAdapter.getRemarks().put(position, content);
                        orderDetailsAdapter.notifyDataSetChanged();
                        ArrayList<String> list=data.getStringArrayListExtra(IMGS);
                        if(list!=null&&list.size()>0){
                            imgs.put(position,data.getStringArrayListExtra(IMGS));
                        }

                    }
                    break;
                case DETAIL:
                    break;
                default:
                    break;
            }


        }
    }
}
