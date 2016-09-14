package com.example.administrator.airportapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.utils.PhotoUtils;

/**
 * 个人中心
 * Created by quick_tech cpc on 2016/9/8.
 */
public class MineFragment extends Fragment {
    private View parent;
    private TextView done, notDone, notification, logOut;
    private Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parent = inflater.inflate(R.layout.activity_mine, null);
        inni(parent);
        return parent;
    }


    private void inni(View view) {
        done = (TextView) view.findViewById(R.id.done_list);
        notDone = (TextView) view.findViewById(R.id.not_done_list);
        logOut = (TextView) view.findViewById(R.id.logout);
        notification = (TextView) view.findViewById(R.id.notification_list);
        notification.setOnClickListener(onClickListener);
        done.setOnClickListener(onClickListener);
        notDone.setOnClickListener(onClickListener);
        logOut.setOnClickListener(onClickListener);
    }

    /**
     * 点击时间
     */
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.done_list:
                    break;
                case R.id.not_done_list:
                    PhotoUtils photoUtils = new PhotoUtils();
                    PopupWindow popupWindow = photoUtils.updatePhotoPop(getContext());
                    popupWindow.showAtLocation(parent, Gravity.BOTTOM|Gravity.CENTER_VERTICAL,0,0);


                    break;
                case R.id.notification_list:
                    break;
                case R.id.logout:
                    creatDialog();
                    break;
                default:
                    break;
            }
        }
    };

    private void creatDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("退出");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        dialog = builder.create();
        dialog.show();
    }
}
