package com.bw.movie.mvp.view;

/**
 * 作者：穆佳琪
 * 时间：2019/1/23 20:03.
 */

public interface IView<T> {
    void onSuccess(T data);
    void onError(String error);
}
