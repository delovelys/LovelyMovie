package com.bw.movie.mvp.api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 作者：穆佳琪
 * 时间：2019/1/23 20:10.
 */

public interface MyApiService {
    @GET
    Observable<ResponseBody> get(@Url String url, @HeaderMap Map<String, Object> headmap, @QueryMap Map<String, Object> map);

    @POST
    Observable<ResponseBody> post(@Url String url, @HeaderMap Map<String, Object> headmap, @QueryMap Map<String, Object> map);

    @PUT
    Observable<ResponseBody> put(@Url String url, @HeaderMap Map<String, Object> headmap, @QueryMap Map<String, Object> map);

    @DELETE
    Observable<ResponseBody> del(@Url String url, @HeaderMap Map<String, Object> headmap, @QueryMap Map<String, Object> map);

}
