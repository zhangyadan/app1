package com.example.myapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.beans.DatasBean;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/23.
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DatasBean datasBean = list.get(position);
        holder.tv_title.setText(datasBean.getTitle());
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
