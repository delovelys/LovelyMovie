package com.bw.movie.mvp.api;

import android.util.Log;

import com.bw.movie.mvp.contact.Contacts;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：穆佳琪
 * 时间：2019/1/3 19:16.
 */

public class NewRetrofitUtils {
    private MyApiService myApiService1;

    private NewRetrofitUtils(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Contacts.Z_url)
                .client(okHttpClient)
                .build();
        myApiService1 = retrofit.create(MyApiService.class);
    }

    //单例模式
    public static NewRetrofitUtils getInstance() {
        return RetroHolder.retro;
    }

    private static class RetroHolder {
        private static NewRetrofitUtils retro = new NewRetrofitUtils();
    }
    //get请求
    public void get(String url, Map<String,Object> headmap, Map<String,Object> map, final HttpListener listener){
        Observer observer = new Observer<ResponseBody>() {

            @Override
            public void onCompleted() {
                Log.e("onCompleted","get_onCompleted");
            }
            //网络处理失败
            @Override
            public void onError(Throwable e) {
                Log.e("onError","get_onError"+e.getMessage());
                if (listener != null) {
                    listener.onError(e.getMessage());
                }
            }
            //网络处理成功
            @Override
            public void onNext(ResponseBody responseBody) {
                Log.d("onNext","get_onNext");
                if (listener != null) {
                    try {
                        listener.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myApiService1.get(url, headmap,map)
                .subscribeOn(Schedulers.io())//io就是子线程
                //在主线程调用
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    //post请求
    public void post(String url, Map<String,Object> headmap, Map<String,Object> map, final HttpListener listener){
        Observer observer = new Observer<ResponseBody>() {

            @Override
            public void onCompleted() {
                Log.e("onCompleted","post_onCompleted");
            }
            //网络处理失败
            @Override
            public void onError(Throwable e) {
                Log.e("onError","post_onError"+e.getMessage());
                if (listener != null) {
                    listener.onError(e.getMessage());
                }
            }
            //网络处理成功
            @Override
            public void onNext(ResponseBody responseBody) {
                Log.d("onNext","post_onNext");
                if (listener != null) {
                    try {
                        listener.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myApiService1.post(url,headmap, map)
                .subscribeOn(Schedulers.io())//io就是子线程
                //在主线程调用
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //put请求
    public void put(String url, Map<String,Object> headmap, Map<String,Object> map, final HttpListener listener){
        Observer observer = new Observer<ResponseBody>() {

            @Override
            public void onCompleted() {
                Log.e("onCompleted","put_onCompleted");
            }
            //网络处理失败
            @Override
            public void onError(Throwable e) {
                Log.e("onError","put_onError"+e.getMessage());
                if (listener != null) {
                    listener.onError(e.getMessage());
                }
            }
            //网络处理成功
            @Override
            public void onNext(ResponseBody responseBody) {
                Log.d("onNext","put_onNext");
                if (listener != null) {
                    try {
                        listener.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myApiService1.put(url,headmap, map)
                .subscribeOn(Schedulers.io())//io就是子线程
                //在主线程调用
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    //del请求
    public void del(String url, Map<String,Object> headmap, Map<String,Object> map, final HttpListener listener){
        Observer observer = new Observer<ResponseBody>() {

            @Override
            public void onCompleted() {
                Log.e("onCompleted","put_onCompleted");
            }
            //网络处理失败
            @Override
            public void onError(Throwable e) {
                Log.e("onError","put_onError"+e.getMessage());
                if (listener != null) {
                    listener.onError(e.getMessage());
                }
            }
            //网络处理成功
            @Override
            public void onNext(ResponseBody responseBody) {
                Log.d("onNext","put_onNext");
                if (listener != null) {
                    try {
                        listener.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myApiService1.del(url,headmap, map)
                .subscribeOn(Schedulers.io())//io就是子线程
                //在主线程调用
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public interface HttpListener {
        void onSuccess(String jsonStr);

        void onError(String error);
    }
}
