package com.example.myapp.presenter;

import com.example.myapp.beans.FristBeans;
import com.example.myapp.callback.ICallback;
import com.example.myapp.model.IModel;
import com.example.myapp.view.IView;

/**
 * Created by 张亚丹 on 2019/6/23.
 */

public class Presenter implements IPresenter,ICallback{

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
    public void OnFailed(String error) {
        mIViewm.OnFailed(error);
    }
}
