package com.tourye.library.base;

import android.content.Context;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 *
 * @ClassName:   CommonInitHelper
 *
 * @Author:   along
 *
 * @Description:    工具库初始化
 *
 * @CreateDate:   2019/9/2 1:30 PM
 *
 */
public class CommonInitHelper {
    private static CommonInitHelper commonInitHelper;

    public static Context BASECONTEXT;

    private CommonInitHelper(){

    }

    public static CommonInitHelper getInstance(){
        if (commonInitHelper==null) {
            commonInitHelper=new CommonInitHelper();
        }
        return commonInitHelper;
    }

    public void init(Context context){
        BASECONTEXT=context;

        //日志工具
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(L) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("run")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

    }
}
