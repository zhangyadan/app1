package com.example.shappingb.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.shappingb.R;
import com.example.shappingb.adapter.Collect_Adapter;
import com.example.shappingb.beans.DatasBean;
import com.example.shappingb.utils.DbUtild;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张亚丹 on 2019/6/21.
 */

public class Celloct_Fragment extends Fragment {
    private View view;
    private RecyclerView mRecy;
    private ArrayList<DatasBean> list;
    private Collect_Adapter adapter;
    private CheckBox box;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.collection_layout, null);
        initView(view);
       initData();
        return view;

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            list.clear();

        }else {
            initData();
        }
    }

    private void initData() {
        final List<DatasBean> datasBeans = DbUtild.qurryAll();
        list.addAll(datasBeans);
        adapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.Recy);

        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new Collect_Adapter(list, getActivity());
        mRecy.setAdapter(adapter);

        adapter.setOnclick(new Collect_Adapter.OnClick() {


            @Override
            public void onclick(View view, int position) {

            }
        });
    }
}
