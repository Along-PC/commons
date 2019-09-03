package com.tourye.library.net;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Title:HttpCallback
 * <p>
 * Description:网络请求回调
 * </p>
 * Author dragon.
 * Date 2018/4/16 11:29
 */

public abstract class HttpCallback<T> implements Callback {

    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(Call call, IOException e) {

        Log.d("onFailure", "#######################################################################");
        Log.d("onFailure", "错误信息：" + e.getMessage());
        Log.d("onFailure", "#######################################################################");

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                onFailureExecute();
            }
        });

    }

    /**
     * 网络请求失败
     */
    public void onFailureExecute() {
        onPreExcute();
    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {

        onPreExcute();

        if (response.isSuccessful()) {

            Log.d("onResponse", "#######################################################################");
            final String responseText = response.body().string();
            Log.d("onResponse", responseText);
            Logger.json(responseText);
            Log.d("onResponse", "#######################################################################");

            Gson gson = new Gson();

            //获取泛型的class对象
            Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
            Class<T> entityClass = (Class<T>) actualTypeArguments[0];
            try {
                final T t = gson.fromJson(responseText, entityClass);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        onForceExcute(responseText);

                        onSuccessExecute(t);

                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            Log.d("onResponse", "#######################################################################");
            Log.d("onResponse", "响应码：" + response.code() + "响应信息：" + response.message());
            Log.d("onResponse", "#######################################################################");
            mHandler.post(new Runnable() {
                @Override
                public void run() {

                    onErrorResponse(response);

                }
            });

        }
    }

    /**
     * 异地登录，强制退出
     *
     * @param response
     */
    private void onForceExcute(String response) {

    }

    /**
     * 得到服务器响应，统一处理一些操作，比如：终止刷新、加载更多。。。
     */
    public void onPreExcute() {

    }

    /**
     * 网络请求成功，http状态码不为200
     */
    public void onErrorResponse(Response response) {

    }

    /**
     * 网络请求成功，http状态码200
     *
     * @param t
     */
    public abstract void onSuccessExecute(T t);

}
