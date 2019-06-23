package com.example.myapp.view;

import com.example.myapp.beans.DatasBean;
import com.example.myapp.beans.FristBeans;

/**
 * Created by 张亚丹 on 2019/6/23.
 */

public interface IView {
    void OnSuccess(FristBeans fristBeans);
    void OnFailed(String error);
}
