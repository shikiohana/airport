package com.example.administrator.airportapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.utils.Constants;

/**
 * Created by quick_tech cpc on 2016/9/18.
 */
public class NotImgRemarkActivity extends Activity {
    private ImageView back;
    private EditText remarkContent;
    private TextView done;
    private int position;
    private String content;
    public static final int NOTCHANGE = 1234;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_img_remark);
        inni();
    }


    private void inni() {
        back = (ImageView) findViewById(R.id.remark_back_no_img);
        done = (TextView) findViewById(R.id.done_remark_no_img);
        remarkContent = (EditText) findViewById(R.id.edit_remark_no_img);
        Intent intent = getIntent();
        if (intent != null) {
            position = intent.getIntExtra(Constants.POSITION, 0);
            content = intent.getStringExtra(Constants.CONTENT);
            if (content != null) {
                remarkContent.setText(content);
            }
        }
        back.setOnClickListener(onClickListener);
        done.setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.done_remark_no_img:
                    doneRemark();
                    break;
                case  R.id.remark_back_no_img:
                    back();
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
        if (content != null) {
            Intent intent = new Intent();
            intent.putExtra(Constants.CONTENT, content);
            intent.putExtra(Constants.POSITION, position);
            setResult(OrderDetailsActivity.REQUEST, intent);

        }
        finish();
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
}
