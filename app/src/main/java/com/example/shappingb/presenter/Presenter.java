package com.example.shappingb.presenter;

import com.example.shappingb.beans.FristBeans;
import com.example.shappingb.callback.ICallback;
import com.example.shappingb.model.IModel;
import com.example.shappingb.view.IView;

/**
 * Created by 张亚丹 on 2019/6/21.
 */

public class Presenter implements IPresenter,ICallback {

    private IModel mIModelm;
    private IView mIViewm;

    public Presenter(IModel IModel, IView IView) {
        mIModelm = IModel;
        mIViewm = IView;
    }

    @Override
    public void getData() {
        mIModelm.getData(this);

    }

    @Override
    public void OnSuccess(FristBeans fristBeans) {
        mIViewm.OnSuccess(fristBeans);
    }

    @Override
    public void OnFiled(String error) {
        mIViewm.OnFiled(error);
    }
}
