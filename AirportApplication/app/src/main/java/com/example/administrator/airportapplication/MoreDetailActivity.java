package com.example.administrator.airportapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.adapter.DeviceDetailAdapter;
import com.example.administrator.javabean.Device;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.DividerItemDecoration;
import com.example.administrator.utils.HttpUtils;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/18.
 */
public class MoreDetailActivity extends Activity {
    private String aid;
    private DeviceDetailAdapter deviceDetailAdapter;
    private RecyclerView deviceList;
    private List<Device.DataBean> list;
    private TextView done, save;
    private ImageView back;
    private boolean change;
    private ArrayList<Device.DataBean> beans;
    private AlertDialog alertDialog;
    public static final String CHECKRESULT = "check_result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);
        inni();
    }


    /**
     * 初始化
     */
    private void inni() {
        change = false;//没有改变
        list = new ArrayList<>();
        beans = new ArrayList<>();

        deviceList = (RecyclerView) findViewById(R.id.device_list);
        save = (TextView) findViewById(R.id.device_next_step);
        back = (ImageView) findViewById(R.id.device_back);
        deviceList.setLayoutManager(new LinearLayoutManager(this));
        deviceList.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        aid = "";
        Intent intent = getIntent();
        if (intent != null) {
            aid = intent.getStringExtra(Constants.DEVICE_AID);

        }
        if (!aid.equals("")) {
            getDevice();
        }
        save.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }

    /**
     * 获取设备详情
     */
    private void getDevice() {
        if (TokenKeeper.isOverDue(this)) {
            HttpUtils.refreshLogin(this, new HttpUtils.RefreshListener() {
                @Override
                public void complete() {
                    getDevice();
                }
            });
        } else {
            RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.DEVICE + aid);
            requestParams.setHeader("login", TokenKeeper.getUser(this));
            requestParams.setHeader("token", TokenKeeper.getToken(this));
            x.http().get(requestParams, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Log.i("result", result);
                    Gson gson = new Gson();
                    Device device = gson.fromJson(result, Device.class);
                    list = device.getData();
                    Log.i("list", list.size() + "");

                    deviceDetailAdapter = new DeviceDetailAdapter(list);
                    deviceDetailAdapter.setDeviceClicked(deviceClicked);
                    deviceList.setAdapter(deviceDetailAdapter);
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

    DeviceDetailAdapter.DeviceClicked deviceClicked = new DeviceDetailAdapter.DeviceClicked() {
        @Override
        public void clicked(View view, int i) {
            Intent intent = new Intent(MoreDetailActivity.this, RemarkActivity.class);
            String content = "";
            if (list.get(i).getFault() != null) {
                content = list.get(i).getFault().getFault_Description();
                if (content == null) {
                    content = "";
                }

                intent.putExtra(Constants.CONTENT, content);
                intent.putExtra(Constants.POSITION, i);
                startActivityForResult(intent, OrderDetailsActivity.REQUEST);
            } else {
                Toast.makeText(MoreDetailActivity.this, "没有更多内容", Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        public void checked(View view, int i) {
            if (deviceDetailAdapter.getChecks().get(i)) {
                deviceDetailAdapter.getChecks().put(i, false);
            } else {
                deviceDetailAdapter.getChecks().put(i, true);
            }
            deviceDetailAdapter.notifyDataSetChanged();
        }
    };


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.device_back:
                    back();
                    break;
                case R.id.device_next_step:
                    done();
                    break;
                default:
                    break;
            }
        }
    };


    /**
     * 备注回调
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("data", requestCode + "--------" + resultCode);
        if (requestCode == resultCode) {
            switch (requestCode) {
                case OrderDetailsActivity.REQUEST:
                    int position = data.getIntExtra(Constants.POSITION, 0);
                    String content = data.getStringExtra(Constants.CONTENT);
                    Device.DataBean dataBean = list.get(position);
                    List<String> imgs = data.getStringArrayListExtra(Constants.IMGS);
                    Device.DataBean.FaultBean faultBean = dataBean.getFault();

                    if (imgs != null && content != null) {
                        if (faultBean != null) {
                            Log.i("data", dataBean.getFault() + "");
                            Log.i("data", dataBean.getFault().getAId() + "");
                            List<Device.DataBean.FaultBean.ImageBean> list = new ArrayList<>();
                            if (imgs.size() > 0) {
                                for (String url : imgs) {
                                    Device.DataBean.FaultBean.ImageBean imageBean = new Device.DataBean.FaultBean.ImageBean();
                                    imageBean.setIMGUrl(url);
                                    Log.i("url", url);
                                    list.add(imageBean);
                                }
                            }
                            faultBean.setImage(list);
                            faultBean.setFault_Description(content);
                            Log.i("ccccc", content);
                        } else if (content.equals("") && imgs.size() == 0) {
                            Log.i("data", dataBean.getFault() + "");
                            dataBean.setFault(null);
                        }
                    }

                    beans.add(dataBean);
                    deviceDetailAdapter.notifyDataSetChanged();
                    change = true;
                    break;

                default:
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 退出，返回键
     */
    private void back() {
        if (!change) {
            //如果没有进行任何修改，直接退出
            Intent intent = new Intent();
            setResult(RemarkActivity.NOTCHANGE, intent);
            finish();
        } else {
            //有修改弹出提示保存
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("确认退出？");
            builder.setMessage("退出会清除本次编辑,请保存");
            builder.setNegativeButton("保存", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.dismiss();
                    done();

                }
            });
            builder.setPositiveButton("不保存", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    setResult(RemarkActivity.NOTCHANGE, intent);
                    finish();
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

    /**
     * 保存
     */
    private void done() {
        if (change) {

            Intent intent = new Intent();
            intent.putParcelableArrayListExtra(CHECKRESULT, beans);
            setResult(OrderDetailsActivity.DETAIL, intent);
            Toast.makeText(MoreDetailActivity.this, "设备处理结果已保存", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            back();
        }
    }

    /**
     * 返回键监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
