package com.example.myapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.adapter.Frist_Adapter;
import com.example.myapp.beans.DatasBean;
import com.example.myapp.beans.FristBeans;
import com.example.myapp.model.Model;
import com.example.myapp.presenter.Presenter;
import com.example.myapp.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张亚丹 on 2019/6/23.
 */

public class Frist_Fragment extends Fragment implements IView {
    private View view;
    private RecyclerView mRecy;
    private ArrayList<DatasBean> list;
    private Frist_Adapter adapter;
    private static final String TAG = "Frist_Fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frist_layout, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        final Presenter presenter = new Presenter(new Model(), this);
        presenter.getData();
    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.Recy);

        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new Frist_Adapter(list, getActivity());
        mRecy.setAdapter(adapter);
    }

    @Override
    public void OnSuccess(FristBeans fristBeans) {
        final List<DatasBean> datas = fristBeans.getData().getDatas();
        list.addAll(datas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnFailed(String error) {
        Log.i(TAG, "OnFailed: "+error);
    }
}
