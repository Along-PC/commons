package com.tourye.commons

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.CoreComponentFactory
import android.util.Log
import com.tourye.library.net.HttpCallback
import com.tourye.library.net.HttpUtils

/**
 *
 * @ClassName:
 *
 * @Author:   along
 *
 * @Description:    kotlin调用commons实例
 *
 * @CreateDate:   2019/9/2 2:12 PM
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mutableMapOf = mutableMapOf<String,String>()
        mutableMapOf.put("area_code","86")
        mutableMapOf.put("phone","18811364210")

        HttpUtils.getInstance().post("http://wisdom-match.xorout.com/api/auth/send_login_sms"
                ,mutableMapOf,object:HttpCallback<Object>(){
            override fun onSuccessExecute(t: Object?) {
                Log.e("along","网络请求成功")
            }
        });
    }
}
