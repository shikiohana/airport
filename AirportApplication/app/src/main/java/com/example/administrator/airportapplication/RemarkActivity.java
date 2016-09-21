package com.example.administrator.airportapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.adapter.UpImageAdapter;
import com.example.administrator.javabean.UpResult;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.GridItemDecoration;
import com.example.administrator.utils.TokenKeeper;
import com.google.gson.Gson;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 添加备注
 * Created by quick_tech cpc on 2016/9/14.
 */
public class RemarkActivity extends Activity {
    private TextView done, album;
    private ImageView back;
    private EditText remarkContent;
    private int position;
    public static final int NOTCHANGE = 1234;
    private StringBuilder tvResult;
    private String content;
    private RecyclerView recyclerView;
    private List<String> list;
    private UpImageAdapter imageAdapter;
    private AlertDialog alertDialog;
    public static final int REQUEST_CODE = 12006;

    private ProgressDialog progressDialog;
    private ArrayList<String> results, error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remark);
        inni();
    }

    /**
     * 初始化控件
     */
    private void inni() {
        position = 0;
        back = (ImageView) findViewById(R.id.remark_back);
        done = (TextView) findViewById(R.id.done_remark);
        album = (TextView) findViewById(R.id.open_album);
        remarkContent = (EditText) findViewById(R.id.edit_remark);
        recyclerView = (RecyclerView) findViewById(R.id.img_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new GridItemDecoration(this));
        list = new ArrayList<>();
        results = new ArrayList<>();//保存返回的网络图片地址
        error = new ArrayList<>();//上传失败的图片
        //上传图片时候的提示dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("图片上传中");
        back.setOnClickListener(onClickListener);
        done.setOnClickListener(onClickListener);
        album.setOnClickListener(onClickListener);
        Intent intent = getIntent();
        if (intent != null) {
            position = intent.getIntExtra(Constants.POSITION, 0);
            content = intent.getStringExtra(Constants.CONTENT);
            if (content != null) {
                remarkContent.setText(content);
            }
        }
        inniRecycler(list);
        tvResult = new StringBuilder();
    }
    private long exitTime;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.remark_back:
                    //返回
                    back();
                    break;
                case R.id.done_remark:
                    //提交

                    if(list.size()>0) {
                        upLoadImg(list);
                    }else{
                        doneRemark();
                    }

                    break;
                case R.id.open_album:
                    //打开相册
                    openAblum();
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 完成备注
     */
    private void doneRemark() {
        String content = remarkContent.getText().toString();
        if (content != null&&results!=null) {
            Intent intent = new Intent();
            intent.putExtra(Constants.CONTENT, content);
            intent.putExtra(Constants.POSITION, position);
            intent.putStringArrayListExtra(Constants.IMGS,results);
            setResult(OrderDetailsActivity.REQUEST, intent);
            Log.i("done","done");
        }
        finish();
    }

    /**
     * 更新recylerview
     *
     * @param strings
     */
    private void inniRecycler(List<String> strings) {
        imageAdapter = new UpImageAdapter(strings, false);
        recyclerView.setAdapter(imageAdapter);
    }

    /**
     * 返回键
     */
    private void back() {
        if (!remarkContent.getText().toString().equals(content)) {
            warning();
        } else {
            Intent intent = new Intent();
            setResult(NOTCHANGE, intent);
            finish();
        }

    }

    /**
     * 取消时候的提示
     */
    private void warning() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("要放弃正在编辑的内容吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                setResult(NOTCHANGE, intent);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 图片选择结果回调
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
            for (String path : pathList) {
                tvResult.append(path + "\n");

            }
            list = pathList;

            inniRecycler(list);
            imageAdapter.notifyDataSetChanged();
        }
    }


    /**
     * 监听返回键
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


    /**
     * 打开相册
     */
    private void openAblum() {

        ImgSelConfig config = new ImgSelConfig.Builder(loader)
                // 是否多选
                .multiSelect(true)
                        // “确定”按钮背景色
                .btnBgColor(Color.parseColor("#67ccff"))
                        // “确定”按钮文字颜色
                .btnTextColor(Color.WHITE)
                        // 使用沉浸式状态栏
                .statusBarColor(Color.parseColor("#67ccff"))
                        // 返回图标ResId
                .backResId(R.drawable.back)
                        // 标题
                .title("图片")
                        // 标题文字颜色
                .titleColor(Color.WHITE)
                        // TitleBar背景色
                .titleBgColor(Color.parseColor("#67ccff"))
                        // 裁剪大小。needCrop为true的时候配置
                .cropSize(1, 1, 200, 200)
                .needCrop(true)
                        // 第一个是否显示相机
                .needCamera(true)
                        // 最大选择图片数量
                .maxNum(9)
                .build();

// 跳转到图片选择器
        ImgSelActivity.startActivity(this, config, REQUEST_CODE);
    }

    // 自定义图片加载器
    private ImageLoader loader = new ImageLoader() {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            // TODO 在这边可以自定义图片加载库来加载ImageView，例如Glide、Picasso、ImageLoader等
            Glide.with(context).load(path).into(imageView);
        }
    };

    /**
     * 上传图片
     */
    private void upLoadImg(final List<String> stringList) {
        final int size = stringList.size();
        Log.e("size",size+"");
        if (stringList != null && stringList.size() > 0) {
            int i;
            progressDialog.show();

            for (i = 0; i < stringList.size(); i++) {
                final int time = i;


                RequestParams requestParams = new RequestParams(Constants.BASE_URL + Constants.UPLOAD);
                String path = stringList.get(i);
                //设置上传图片文件和权限的header
                requestParams.addParameter("upLoadFile", new File(path));
                requestParams.addHeader("token", TokenKeeper.getToken(this));
                requestParams.addHeader("login", TokenKeeper.getUser(this));

                x.http().post(requestParams, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Gson gson = new Gson();
                        UpResult upResult = gson.fromJson(result, UpResult.class);
                        Log.i("upResult",upResult.getData()+"");
                        if (!upResult.isSuccess()) {
                            error.add(upResult.getData());
                        }
                        if(upResult.getData()!=null) {

                            results.add(upResult.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.i("ex", ex.getMessage() + "");
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {
                        //上传完毕后隐藏提示
                        Log.e("time",time+"");
                        Log.e("size",size+"");
                        if (time == size - 1) {



                                //所有图片上传完毕后
                                if (progressDialog.isShowing()) {
                                    progressDialog.dismiss();

                            }
                            imageAdapter = new UpImageAdapter(error, true);
                            recyclerView.setAdapter(imageAdapter);
                            if (error.size() == 0) {
                                Toast.makeText(RemarkActivity.this, "图片上传完毕", Toast.LENGTH_SHORT).show();
                              doneRemark();
                            } else {
                                list=error;//上传列表更新为上传失败的图片列表
                                Toast.makeText(RemarkActivity.this, "图片上传异常", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                });
            }
        }


    }

}
