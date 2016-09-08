package com.example.administrator.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.airportapplication.R;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelConfig;

/**
 * 访问相册和启动照相机的工具类
 * Created by quick_tech cpc on 2016/9/5.
 */
public class PhotoUtils {
    public static final int TAKE_PICTURE = 0x000001;
    public static final int GET_PHOTO = 0x000009;
    private TextView takePhoto, album, cancle;
    private PopupWindow pop;
    private Activity activity;
    private View view;


    /**
     * 默认为上传图片的popupwindow
     * 拍照和相册跳转均为startActivityForResult,拍照code TAKE_PICTURE,相册code GET_PHOTO
     * 设置ShowAtLocation
     *
     * @return
     */
    public PopupWindow updatePhotoPop(final Context context) {
        activity = (Activity) context;
        pop = new PopupWindow(context);

        //设置background  和 focusable 以及touchable 使得点击外部popupWindow消失
        pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        view = LayoutInflater.from(context).inflate(R.layout.dialog_photos, null);
        pop.setContentView(view);
        LinearLayout parent = (LinearLayout) view.findViewById(R.id.parent);
        takePhoto = (TextView) view.findViewById(R.id.take_photo);// 拍照
        album = (TextView) view.findViewById(R.id.album);// 从相册中取
        cancle = (TextView) view.findViewById(R.id.cancle);// 取消
        parent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pop.dismiss();

            }
        });
        takePhoto.setOnClickListener(new View.OnClickListener() {// 拍照

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                photo();
                pop.dismiss();

            }
        });
        album.setOnClickListener(new View.OnClickListener() {// 从相册中取

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // 跳转到相册选择Activity


                //     toImgSelect(context);

                //     activity.overridePendingTransition(R.anim.activity_translate_in, R.anim.activity_translate_out);
                pop.dismiss();

            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {// 取消监听

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pop.dismiss();
            }
        });

        return pop;

    }

    protected void photo() {
        // TODO Auto-generated method stub
        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activity.startActivityForResult(openCameraIntent, TAKE_PICTURE);
    }

	/*
     * 获取视图view 便于设置popupwindow按钮的监听事件
	 */

    public View getView() {

        return view;
    }


   /* public ArrayList<MyFile> getPhotoList(Context context) {
        ArrayList<MyFile> list = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Images.Media.DATE_ADDED + " DESC");


        if (cursor.moveToFirst()) {//cursor不为空
            while (cursor.moveToNext() && list.size() < 180) {
                MyFile myFile = new MyFile();
                int nameNum = cursor.getColumnIndex(MediaStore.Images.Media.TITLE);
                String name = cursor.getString(nameNum);
                int pathNum = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
                String path = cursor.getString(pathNum);

                myFile.setName(name);
                myFile.setPath(path);
                list.add(myFile);
            }
        }
        cursor.close();

        return list;
    }*/


    /**
     * 跳转到图片选择页面
     *
     * @param context
     */
    public void toImgSelect(Context context) {
        Activity activity = (Activity) context;
        // 自定义图片加载器
        ImageLoader loader = new ImageLoader() {
            @Override
            public void displayImage(Context context, String path, ImageView imageView) {
                // TODO 在这边可以自定义图片加载库来加载ImageView，例如Glide、Picasso、ImageLoader等
                Glide.with(context).load(path).into(imageView);
            }
        };

        // 自由配置选项
        ImgSelConfig config = new ImgSelConfig.Builder(loader)
                // 是否多选
                .multiSelect(true)
                        // “确定”按钮背景色
                .btnBgColor(Color.GRAY)
                        // “确定”按钮文字颜色
                .btnTextColor(Color.BLUE)
                        // 使用沉浸式状态栏
                .statusBarColor(Color.parseColor("#3F51B5"))
                        // 返回图标ResId
                .backResId(android.support.v7.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha)
                        // 标题
                .title("图片")
                        // 标题文字颜色
                .titleColor(Color.WHITE)
                        // TitleBar背景色
                .titleBgColor(Color.parseColor("#3F51B5"))
                        // 裁剪大小。needCrop为true的时候配置
                .cropSize(1, 1, 200, 200)
                .needCrop(true)
                        // 第一个是否显示相机
                .needCamera(false)
                        // 最大选择图片数量
                .maxNum(9)
                .build();

// 跳转到图片选择器
        //      ImgSelActivity.startActivity(activity, config, IMAGE_CROP_CODE);
    }

}
