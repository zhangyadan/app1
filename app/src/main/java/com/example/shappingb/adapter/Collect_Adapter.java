package com.example.shappingb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shappingb.R;
import com.example.shappingb.beans.DatasBean;
import com.example.shappingb.utils.DbUtild;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/21.
 */

public class Collect_Adapter extends RecyclerView.Adapter<Collect_Adapter.ViewHolder> {

    private ArrayList<DatasBean> list;
    private Context context;

    public Collect_Adapter(ArrayList<DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = View.inflate(context, R.layout.item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final DatasBean datasBean = list.get(position);
        holder.tv_title.setText(datasBean.getTitle());
        //初始化状态
        holder.box.setChecked(true);
        holder.box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == false){
                    DbUtild.delete(DbUtild.qurryone(datasBean));
                    list.remove(datasBean);
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private CheckBox box;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            box = itemView.findViewById(R.id.box);
        }
    }
    private OnClick onclick;
    public void setOnclick(OnClick onclick) {
        this.onclick = onclick;
    }
    public interface OnClick{
        void onclick(View view, int position);
    }
}
