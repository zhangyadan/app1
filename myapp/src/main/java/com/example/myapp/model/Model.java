package com.example.myapp.model;

import com.example.myapp.Apiservice;
import com.example.myapp.beans.FristBeans;
import com.example.myapp.callback.ICallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张亚丹 on 2019/6/23.
 */

public class Model implements IModel{
    @Override
    public void getData(final ICallback callback) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Apiservice.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        final Apiservice apiservice = retrofit.create(Apiservice.class);
        final Observable<FristBeans> geturl = apiservice.geturl();
        geturl.observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FristBeans>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FristBeans fristBeans) {
                        callback.OnSuccess(fristBeans);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.OnFailed(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
