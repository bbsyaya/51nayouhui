package com.nayouhui.live.util;

import android.app.Activity;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzz on 2016/3/1.
 */
public class OkHttpUtil {

    public static final String TAG = "OkHttpUtil";

    public static class Param {
        public Param() {
        }

        public Param(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Param{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }

        String key;
        String value;
    }


    /**
     * get 请求
     *
     * @param activity
     * @param url
     * @param callback
     */
    public static void getAsyn(final Activity activity, String url, BeanCallback callback) {
        addContext(activity, callback);
        OkHttpUtils
                .get()
                .url(url)
                .tag(activity)
                .build()
                .execute(callback);
    }

    /**
     * get 请求
     *
     * @param activity
     * @param url
     * @param callback
     */
    public static void getAsyn(final Activity activity, String url, BeanCallback callback, Map<String, String> params) {
        addContext(activity, callback);
        OkHttpUtils
                .get()
                .url(url)
                .params(params)
                .tag(activity)
                .build()
                .execute(callback);
    }

    public static void getAsyn(final Activity activity, String url, BeanCallback callback, Param... params) {
        Map<String, String> map = new HashMap<>();
        for (Param param : params) {
            map.put(param.key, param.value);
        }
        getAsyn(activity, url, callback, map);
    }


    /**
     * post 请求
     *
     * @param activity
     * @param url
     * @param callback
     * @param params
     */
    public static void postAsyn(final Activity activity, String url, BeanCallback callback, Map<String, String> params) {
        addContext(activity, callback);
        OkHttpUtils
                .post()
                .url(url)
                .tag(activity)
                .params(params)
                .build()
                .execute(callback);
    }


    public static void postAsyn(final Activity activity, String url, BeanCallback callback, Param... params) {
        Map<String, String> map = new HashMap<>();
        for (Param param : params) {
            map.put(param.key, param.value);
        }
        postAsyn(activity, url, callback, map);
    }

    /**
     * 为当前callback传入Activity上下文对象
     *
     * @param activity
     * @param callback
     */
    private static void addContext(Activity activity, BeanCallback callback) {
        callback.setActivity(activity);
    }


}



