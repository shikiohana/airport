package com.example.administrator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/18.
 *
 */
public class UpImageAdapter extends RecyclerView.Adapter {
    List<String> list;

    ImageOptions imageOptions;
    boolean fail;


    /**
     * 是否显示上传失败
     * @param list
     * @param fail true显示，false不显示
     */
    public UpImageAdapter(List<String> list,boolean fail) {
        this.list = list;
        this.fail=fail;

        imageOptions = new ImageOptions.Builder()
                .setIgnoreGif(false)//是否忽略gif图。false表示不忽略。不写这句，默认是true
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                .setSize(240,240)
                .build();
    }

    @Override
    public int getItemCount() {
        return  list.size()>0?list.size():0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImgHolder imgHolder = (ImgHolder) holder;

            x.image().bind(imgHolder.imageView, list.get(position), imageOptions);
            if(fail){
                imgHolder.upLoadOnFail.setVisibility(View.VISIBLE);
            }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_img, null);
        return new ImgHolder(view);
    }

    class ImgHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView upLoadOnFail;
        public ImgHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.single_img);
            upLoadOnFail=(TextView)itemView.findViewById(R.id.on_fail);
        }
    }



}
