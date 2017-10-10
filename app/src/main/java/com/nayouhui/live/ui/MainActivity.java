package com.nayouhui.live.ui;

import android.util.Log;
import android.widget.TextView;

import com.nayouhui.live.BaseActivity;
import com.nayouhui.live.R;
import com.nayouhui.live.entity.HomeData;
import com.nayouhui.live.util.BeanCallback;
import com.nayouhui.live.util.Constant;
import com.nayouhui.live.util.OkHttpUtil;

import butterknife.Bind;

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
    }

    @Override
    protected int setView() {
        return R.layout.activity_main;
    }


}
