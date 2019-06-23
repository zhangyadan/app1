package com.example.shappingb.view;

import com.example.shappingb.beans.DatasBean;
import com.example.shappingb.beans.FristBeans;

/**
 * Created by 张亚丹 on 2019/6/21.
 */

public interface IView {

    void OnSuccess(FristBeans fristBeans);
    void OnFiled(String error);
}
