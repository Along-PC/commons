package com.tourye.commons;

import android.app.Application;

import com.tourye.library.base.CommonInitHelper;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CommonInitHelper.getInstance().init(getApplicationContext());

    }
}
