package com.bw.movie.mvp.model;

import com.bw.movie.mvp.callback.CallBack;

import java.util.Map;

/**
 * 作者：穆佳琪
 * 时间：2019/1/23 20:04.
 */

public interface IModel {
    //get
    void get(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz, CallBack callBack);
    //post
    void post(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz, CallBack callBack);
    //put
    void put(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz, CallBack callBack);
    //del
    void delete(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz, CallBack callBack);

}
