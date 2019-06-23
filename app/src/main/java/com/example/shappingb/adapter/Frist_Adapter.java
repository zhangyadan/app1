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

public class Frist_Adapter extends RecyclerView.Adapter<Frist_Adapter.ViewHolder> {

    private ArrayList<DatasBean> list;
    private Context context;

    public Frist_Adapter(ArrayList<DatasBean> list, Context context) {
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final DatasBean datasBean = list.get(position);
        holder.tv_title.setText(datasBean.getTitle());

        if (DbUtild.qurryone(datasBean)!=null){
            datasBean.setCheck(true);
        }else {
            datasBean.setCheck(false);
        }
        holder.box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                if (holder.box.isChecked()) {
                    if (DbUtild.qurryone(datasBean) == null) {
                        datasBean.setCheck(true);
                        DbUtild.insert(datasBean);
                        Toast.makeText(context, "收藏ok", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "有数据", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    datasBean.setCheck(true);
                    DbUtild.delete(DbUtild.qurryone(datasBean));
                    Toast.makeText(context, "删除ok", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.box.setChecked(datasBean.getCheck());
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

}
