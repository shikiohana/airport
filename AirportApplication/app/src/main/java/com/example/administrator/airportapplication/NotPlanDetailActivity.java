package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.javabean.NotPlanOrder;

/**
 * 非计划工单详情
 * Created by quick_tech cpc on 2016/9/18.
 */
public class NotPlanDetailActivity extends Activity {
    private TextView orderCode, next,startTime,endTime,content;//工单编号，完成，开始时间，结束时间，具体内容
    private ImageView back;//返回键
    NotPlanOrder.DataBean dataBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_plan_detail);
        inni();
        inniText();
    }

    /**
     * 初始化控件
     */
    private void inni() {
        next = (TextView) findViewById(R.id.next_step_not);
        orderCode = (TextView) findViewById(R.id.order_code_not);
        startTime=(TextView)findViewById(R.id.start_time_not);
        endTime=(TextView)findViewById(R.id.end_time_not);
        back = (ImageView) findViewById(R.id.back_not);
        content=(TextView)findViewById(R.id.order_detail_content_not);
        back.setOnClickListener(onClickListener);
    }

    /**
     * 更新内容
     */
    private void inniText(){
        Intent intent=getIntent();

        if(intent!=null){

            dataBean=intent.getParcelableExtra(WorkOderFragment.DATABEAN);
            if(dataBean!=null){
                orderCode.setText(dataBean.getBillCode());//工单编号
                startTime.setText(dataBean.getBillDate());//开始日期
                endTime.setText(dataBean.getFinishDate());//结束日期
                content.setText(dataBean.getDoContentS()+"");//正文内容
            }
        }
    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
