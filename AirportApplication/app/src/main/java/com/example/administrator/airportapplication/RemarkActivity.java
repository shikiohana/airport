package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 添加备注
 * Created by quick_tech cpc on 2016/9/14.
 */
public class RemarkActivity extends Activity {
    private TextView done;
    private ImageView back;
    private EditText remarkContent;
    private int position;
    public static final int NOTCHANGE=1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remark);
        inni();
    }

    private void inni() {
        position =0;
        back = (ImageView) findViewById(R.id.remark_back);
        done = (TextView) findViewById(R.id.done_remark);
        remarkContent = (EditText) findViewById(R.id.edit_remark);
        back.setOnClickListener(onClickListener);
        done.setOnClickListener(onClickListener);
        Intent intent = getIntent();
        if (intent != null) {
            position = intent.getIntExtra(OrderDetailsActivity.POSITION, 0);
        }

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.remark_back:
                    back();
                    break;
                case R.id.done_remark:
                    doneRemark();
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
            intent.putExtra(OrderDetailsActivity.CONTENT, content);
            intent.putExtra(OrderDetailsActivity.POSITION,position);
            setResult(OrderDetailsActivity.REQUEST, intent);

        }
        finish();
    }

    private void back(){
        Intent intent = new Intent();
        setResult(NOTCHANGE, intent);
        finish();
    }
}
