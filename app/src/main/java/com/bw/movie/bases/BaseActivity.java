package com.bw.movie.bases;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * 作者：穆佳琪
 * 时间：2019/1/23 20:39.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    //这个方法用来动态更改布局资源
    protected abstract int getLayoutId();

    //数据
    protected abstract void initData();

    //注册监听
    protected abstract void setListener();

    //页面逻辑书写
    protected abstract void progressLogic();

    void init() {
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
            setRootViewFitsSystemWindows(this,true);
            setImmersion();
            initData();
            setListener();
            progressLogic();

        } else {
            Log.e("BaseActivity", "操作异常");
        }
    }

    /*
     * 加入沉浸式状态栏效果
     * */
    public void setImmersion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentStatus | flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }

    /*
    * 解决沉浸式头部顶住头
    * */
    public static void setRootViewFitsSystemWindows(Activity activity, boolean fitSystemWindows) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ViewGroup winContent = (ViewGroup) activity.findViewById(android.R.id.content);
            if (winContent.getChildCount() > 0) {
                ViewGroup rootView = (ViewGroup) winContent.getChildAt(0);
                if (rootView != null) {
                    rootView.setFitsSystemWindows(fitSystemWindows);
                }
            }
        }

    }


}
