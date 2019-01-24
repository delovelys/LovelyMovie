package com.bw.movie.mvp.model;

import com.bw.movie.mvp.api.NewRetrofitUtils;
import com.bw.movie.mvp.callback.CallBack;
import com.google.gson.Gson;

import java.util.Map;

/**
 * 作者：穆佳琪
 * 时间：2019/1/23 20:09.
 */

public class ModelImpl implements IModel {
    //get
    @Override
    public void get(String url, Map<String, Object> headmap, Map<String, Object> params, final Class clazz, final CallBack callBack) {
        NewRetrofitUtils.getInstance().get(url, headmap, params, new NewRetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String jsonStr) {
                Object o = new Gson().fromJson(jsonStr, clazz);
                callBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                callBack.onFail(error);
            }
        });
    }

    //post
    @Override
    public void post(String url, Map<String, Object> headmap, Map<String, Object> params, final Class clazz, final CallBack callBack) {
        NewRetrofitUtils.getInstance().post(url, headmap, params, new NewRetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String jsonStr) {
                Object o = new Gson().fromJson(jsonStr, clazz);
                callBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                callBack.onFail(error);
            }
        });
    }

    //put
    @Override
    public void put(String url, Map<String, Object> headmap, Map<String, Object> params, final Class clazz, final CallBack callBack) {
        NewRetrofitUtils.getInstance().put(url, headmap, params, new NewRetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String jsonStr) {
                Object o = new Gson().fromJson(jsonStr, clazz);
                callBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                callBack.onFail(error);
            }
        });
    }

    //delete
    @Override
    public void delete(String url, Map<String, Object> headmap, Map<String, Object> params, final Class clazz, final CallBack callBack) {
        NewRetrofitUtils.getInstance().del(url, headmap, params, new NewRetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String jsonStr) {
                Object o = new Gson().fromJson(jsonStr, clazz);
                callBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                callBack.onFail(error);
            }
        });
    }
}
