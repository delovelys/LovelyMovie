package com.bw.movie.mvp.callback;

/**
 * 作者：穆佳琪
 * 时间：2019/1/23 20:06.
 */

public interface CallBack<T> {
    void onSuccess(T t);
    void onFail(String error);
}
