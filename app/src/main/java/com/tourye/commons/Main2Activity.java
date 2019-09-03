package com.tourye.commons;


import com.tourye.library.base.BaseActivity;
import com.tourye.library.net.HttpCallback;
import com.tourye.library.net.HttpUtils;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @ClassName:   Main2Activity
 *
 * @Author:   along
 *
 * @Description: java调用commons实例
 *
 * @CreateDate:   2019/9/2 2:11 PM
 *
 */
public class Main2Activity extends BaseActivity {

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        Map<String,String> map=new HashMap<>();
        map.put("area_code","86");
        map.put("phone","18811364210");
        HttpUtils.getInstance().post("http://wisdom-match.xorout.com/api/auth/send_login_sms", map, new HttpCallback<Object>() {
            @Override
            public void onSuccessExecute(Object o) {

            }
        });
    }

    @Override
    public int getRootView() {
        return R.layout.activity_main2;
    }
}
