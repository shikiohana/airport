package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

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
    private  List<OrderDb> list;
    private NotApplyAdapter applyAdapter;
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
    private void inni(){
        notApplyList=(RecyclerView)findViewById(R.id.not_apply_list);
        notApplyList.setLayoutManager(new LinearLayoutManager(this));
        notApplyList.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        list=new ArrayList<>();
    }


    private void getList(){
       DbManager dbManager= x.getDb(SaveOrderData.getDaoConfig());
        try {
            Log.i("list",list.size()+"");
          list =dbManager.findAll(OrderDb.class);
            Log.i("list",list.size()+"");
            applyAdapter=new NotApplyAdapter(list);
            applyAdapter.setApplyClickListener(applyClickListener);
            notApplyList.setAdapter(applyAdapter);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    NotApplyAdapter.ApplyClickListener applyClickListener=new NotApplyAdapter.ApplyClickListener() {
        @Override
        public void click(View view) {
            OrderDb orderDb=(OrderDb)view.getTag();
            String code =orderDb.code;
            Intent intent=new Intent();

            if(orderDb.isPlan){
               intent.setClass(NotApplyActivity.this,OrderDetailsActivity.class);
                intent.putExtra(WorkOderFragment.DATABEAN, code);
            }else{
                intent.setClass(NotApplyActivity.this,NotPlanDetailActivity.class);
                intent.putExtra(Constants.CONTENT, code);
            }
            startActivity(intent);
        }
    };
}
