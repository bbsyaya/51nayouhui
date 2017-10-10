package com.nayouhui.live.ui;

import android.util.Log;
import android.widget.TextView;

import com.nayouhui.live.BaseActivity;
import com.nayouhui.live.R;
import com.nayouhui.live.entity.HomeData;
import com.nayouhui.live.util.BeanCallback;
import com.nayouhui.live.util.Constant;
import com.nayouhui.live.util.OkHttpUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import okhttp3.Call;

import static com.nayouhui.live.util.Constant.URL_SMS;

public class MainActivity extends BaseActivity {


    @Bind(R.id.tv)
    TextView tv;

    @Override
    protected void initData() {
        tv.setText("修改数据");
        OkHttpUtil.getAsyn(this, Constant.URL_HOME, new BeanCallback<HomeData>() {
            @Override
            public void response(HomeData data) {
                Log.e(TAG, "response: " + data);
            }
        });

        //Content-Type=application/json
        OkHttpUtils
                .post()
                .url(Constant.URL_SMS)
                .addHeader("Content-Type", "application/json")
                .addParams("phone_num", "15311441217")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {

                    }

                    @Override
                    public void onResponse(String s, int i) {
                        Log.e(TAG, "onResponse: s = " + s);
                    }
                });

    }

    @Override
    protected int setView() {
        return R.layout.activity_main;
    }

}
