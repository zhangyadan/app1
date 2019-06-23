package com.example.myapp;

import com.example.myapp.beans.FristBeans;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 张亚丹 on 2019/6/23.
 */

public interface Apiservice {
    //http://106.13.63.54:8080/sys/xin195yk/jiekou2.json

    String url = "http://106.13.63.54:8080/";

    @GET("sys/xin195yk/jiekou2.json")
    Observable<FristBeans> geturl();
}
