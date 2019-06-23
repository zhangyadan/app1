package com.example.shappingb.fragments;

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
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.shappingb.Apiservice;
import com.example.shappingb.R;
import com.example.shappingb.adapter.Frist_Adapter;
import com.example.shappingb.beans.DatasBean;
import com.example.shappingb.beans.FristBeans;
import com.example.shappingb.model.Model;
import com.example.shappingb.presenter.Presenter;
import com.example.shappingb.utils.DbUtild;
import com.example.shappingb.view.IView;

import org.greenrobot.greendao.DbUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张亚丹 on 2019/6/21.
 */

public class Frist_Fragment extends Fragment implements IView {
    private View view;
    private RecyclerView mRecy;
    private ArrayList<DatasBean> list;
    private Frist_Adapter adapter;
    private static final String TAG = "Frist_Fragment";
    private CheckBox box;

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            adapter.notifyDataSetChanged();
        }
    }

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
    public void OnFiled(String error) {
        Log.i(TAG, "OnFiled: "+error);
    }
}
