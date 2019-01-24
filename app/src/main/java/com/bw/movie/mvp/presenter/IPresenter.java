package com.bw.movie.mvp.presenter;

import java.util.Map;

/**
 * 作者：穆佳琪
 * 时间：2019/1/23 20:03.
 */

public interface IPresenter {
    //get
    void get(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz);
    //post
    void post(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz);
    //put
    void put(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz);
    //del
    void delete(String url, Map<String, Object> headmap, Map<String, Object> params, Class clazz);

}
