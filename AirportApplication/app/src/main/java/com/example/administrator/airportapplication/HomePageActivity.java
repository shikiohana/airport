package com.example.administrator.airportapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.adapter.HomePagerAdapter;
import com.example.administrator.utils.PhotoUtils;
import com.yuyh.library.imgsel.ImgSelActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/8.
 */
public class HomePageActivity extends FragmentActivity {
    private ViewPager viewPager;
    private RadioGroup bottomMenu;
    private TextView title;
    private WorkOderFragment workOderFragment;
    private HomePagerAdapter homePagerAdapter;
    private FragmentManager fragmentManager;
    private RadioButton workOrder, mine;
    private List<Fragment> list;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        inni();
        inniViewPager();
    }

    /**
     * 初始化控件
     */
    private void inni() {
        viewPager = (ViewPager) findViewById(R.id.container);
     //   title = (TextView) findViewById(R.id.home_page_title);
        bottomMenu = (RadioGroup) findViewById(R.id.bottom_menu);
        workOrder=(RadioButton)findViewById(R.id.work_order);
        mine=(RadioButton)findViewById(R.id.mine);
        bottomMenu.setOnCheckedChangeListener(onCheckedChangeListener);
        //默认工单页面为选中
        workOrder.setChecked(true);
    }

    /**
     * 初始化viewPager
     */
    private void inniViewPager() {
        fragmentManager = getSupportFragmentManager();
        list = new ArrayList<>();
        workOderFragment = new WorkOderFragment();
        mineFragment=new MineFragment();
        list.add(workOderFragment);
        list.add(mineFragment);
        homePagerAdapter = new HomePagerAdapter(fragmentManager, list);
        viewPager.setAdapter(homePagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position);
                if(position==0){
                    workOrder.setChecked(true);
                }else if(position==1){
                    mine.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.work_order:
                  //  title.setText("工单列表");
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.mine:
                  //  title.setText("个人中心");
                    viewPager.setCurrentItem(1);
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
     //   StringBuilder tvResult=null;
        // 图片选择结果回调
        if (requestCode == PhotoUtils.GET_PHOTO && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
            for (String path : pathList) {
               // tvResult.append(path + "\n");
            }
        }
    }
}
