package com.nayouhui.live.util;

import android.app.Activity;
import android.widget.Toast;

import com.nayouhui.live.BaseActivity;
import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;


public abstract class BeanCallback<T> extends Callback<String> {

//    public static final String TAG = BeanCallback.class.getSimpleName();

    private Type type;

    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public BeanCallback() {
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        type = parameterized.getActualTypeArguments()[0];
    }

    @Override
    public String parseNetworkResponse(Response response, int i) throws Exception {
        ResponseBody body = response.body();

        if (body == null) {
            return null;
        }

        return body.string();

    }

    @Override
    public void onResponse(String resp, int i) {
        if (resp == null) return;
        if (activity == null)
            throw new RuntimeException("activity must not be null");
        if (!(activity instanceof BaseActivity))
            throw new RuntimeException("activity must be instance of BaseActivity");

        BaseActivity act = (BaseActivity) activity;

        //发生错误
        if (!resp.startsWith("{")) {
            if (!act.isOnDestroy())
                fail(resp);
            return;
        }

        if (type == String.class) {
            if (!act.isOnDestroy())
                response((T) resp);
        } else {
            T fromJson = new Gson().fromJson(resp, type);
            if (!act.isOnDestroy())
                response(fromJson);
        }
    }

    @Override
    public void onError(Call call, Exception e, int i) {
        error(call, e, i);
    }

    //code==200时的处理方法
    public abstract void response(T data);

    //code!=200时的处理方法
    public void fail(String data) {
        Toast.makeText(activity, data, Toast.LENGTH_SHORT).show();
    }

    //异常处理
    public void error(Call call, Exception e, int i) {
        //空实现
    }

}
