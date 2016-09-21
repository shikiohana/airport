package com.example.administrator.airportapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by quick_tech cpc on 2016/9/21.
 */
public class EditActivity extends Activity {
    private ImageView back;
    private TextView done;
    private EditText editText;
    private String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        inni();
    }

    /**
     * 初始化控件
     */
    private void inni(){
        back=(ImageView)findViewById(R.id.work_back);
        done=(TextView)findViewById(R.id.work_done);
        editText=(EditText)findViewById(R.id.work_edit);
        Intent intent=getIntent();
        content=intent.getStringExtra("content");
        editText.setText(content);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                content=editText.getText().toString();
            }
        });
        back.setOnClickListener(clickListener);
        done.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.work_back:
                    back();
                    break;
                case  R.id.work_done:
                    done();
                    break;

                default:
                    break;
            }
        }
    };
    private void back(){
        setResult(9009);
        finish();
    }

    private void done(){

            Intent intent=new Intent();
            intent.putExtra("content",content);
            setResult(1000, intent);
            finish();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK&&event.getAction()==KeyEvent.ACTION_DOWN){
            back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
