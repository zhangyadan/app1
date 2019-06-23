package com.example.myapp.callback;

import com.example.myapp.beans.FristBeans;

/**
 * Created by 张亚丹 on 2019/6/23.
 */

public interface ICallback {
    void OnSuccess(FristBeans fristBeans);
    void OnFailed(String error);
}
