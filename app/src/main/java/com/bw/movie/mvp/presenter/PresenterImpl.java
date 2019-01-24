package com.bw.movie.mvp.presenter;

import com.bw.movie.mvp.callback.CallBack;
import com.bw.movie.mvp.model.ModelImpl;
import com.bw.movie.mvp.view.IView;

import java.util.Map;

/**
 * 作者：穆佳琪
 * 时间：2019/1/23 20:09.
 */

public class PresenterImpl implements IPresenter {
    private IView view;
    private ModelImpl modelimpl;

    public PresenterImpl(IView view) {
        this.view = view;
        modelimpl = new ModelImpl();
    }

    @Override
    public void get(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz) {
        modelimpl.get(url, headmap, params, clazz, new CallBack() {
            @Override
            public void onSuccess(Object o) {
                view.onSuccess(o);
            }

            @Override
            public void onFail(String error) {
                view.onError(error);
            }
        });
    }

    @Override
    public void post(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz) {
        modelimpl.post(url, headmap, params, clazz, new CallBack() {
            @Override
            public void onSuccess(Object o) {
                view.onSuccess(o);
            }

            @Override
            public void onFail(String error) {
                view.onError(error);
            }
        });
    }

    @Override
    public void put(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz) {
        modelimpl.put(url, headmap, params, clazz, new CallBack() {
            @Override
            public void onSuccess(Object o) {
                view.onSuccess(o);
            }

            @Override
            public void onFail(String error) {
                view.onError(error);
            }
        });
    }

    @Override
    public void delete(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz) {
        modelimpl.delete(url, headmap, params, clazz, new CallBack() {
            @Override
            public void onSuccess(Object o) {
                view.onSuccess(o);
            }

            @Override
            public void onFail(String error) {
                view.onError(error);
            }
        });
    }
}
