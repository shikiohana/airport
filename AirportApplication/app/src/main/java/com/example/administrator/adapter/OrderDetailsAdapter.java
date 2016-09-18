package com.example.administrator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.airportapplication.R;
import com.example.administrator.javabean.OrderDetails;

import java.util.HashMap;
import java.util.List;

/**
 * Created by quick_tech cpc on 2016/9/12.
 */
public class OrderDetailsAdapter extends RecyclerView.Adapter {
    HashMap<Integer, Boolean> maps;
    List<OrderDetails.DataBean.DetailBean> list;
    OrderDetails.DataBean.DetailBean dataBean;
    OnClicked onClicked;
    HashMap<Integer,String> remarks;
    public OrderDetailsAdapter(List<OrderDetails.DataBean.DetailBean> list) {
        this.list=list;
        setAllChecked(false);

        inniRemarks();
    }
    private void inniRemarks(){
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                getRemarks().put(i, "");
            }
        }
    }


     public void setOnClicked(OnClicked onClicked){
         this.onClicked=onClicked;
     }
    public interface OnClicked{
        void checked(View view, int position);
        void clicked(View view,int position);
        void detail(View view,int position);
    }

    public HashMap<Integer, Boolean> getMaps() {
        if (maps == null) {
            maps = new HashMap<>();
        }
        return maps;
    }

    public HashMap<Integer,String> getRemarks(){
        if(remarks==null){
            remarks=new HashMap<>();
        }
        return remarks;
    }

    @Override
    public int getItemCount() {
        return list.size()>0?list.size():0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order_details_item, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return new DetailHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final DetailHolder detailHolder=(DetailHolder) holder;
        dataBean=list.get(position);
        detailHolder.checkBox.setChecked(getMaps().get(position));
        detailHolder.count.setText(position + 1 + "");
        detailHolder.content.setText(dataBean.getContentS());
        detailHolder.itemView.setTag(dataBean);
        detailHolder.remarkContent.setText(getRemarks().get(position));
        if(onClicked!=null){
            detailHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClicked.checked(detailHolder.checkBox,position);
                }
            });
            //如果有更详细的目录，添加跳转页面，没有，则添加备注
            if(dataBean.isIsDetail()){
                detailHolder.forMore.setVisibility(View.VISIBLE);
                detailHolder.addRemark.setVisibility(View.GONE);
                detailHolder.forMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClicked.detail(detailHolder.forMore,position);
                    }
                });

            }else{
                detailHolder.addRemark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClicked.clicked(detailHolder.addRemark,position);
                    }
                });
            }
        }
    }

    class DetailHolder extends RecyclerView.ViewHolder {
        TextView count, content;
        CheckBox checkBox; //是否完成
        TextView remarkContent;//添加备注  备注内容
        LinearLayout addRemark;
        ImageView forMore;
        public DetailHolder(View itemView) {
            super(itemView);
            count = (TextView) itemView.findViewById(R.id.count);
            content = (TextView) itemView.findViewById(R.id.content);
            checkBox = (CheckBox) itemView.findViewById(R.id.been_done);
            addRemark=(LinearLayout) itemView.findViewById(R.id.add_tips);
            remarkContent=(TextView)itemView.findViewById(R.id.remark_content);
            forMore=(ImageView)itemView.findViewById(R.id.for_more_detail);
        }
    }

    public void setAllChecked(boolean checked){
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                getMaps().put(i,checked);
            }
        }
    }

    public boolean isAllChecked(){
        return  getMaps().containsValue(false)?false:true;
    }


}
