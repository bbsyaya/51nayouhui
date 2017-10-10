package com.nayouhui.live;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();


    //是否拒绝网络请求的响应；true表示拒绝；false表示接收，默认false，在onDestroy中设置为true
    protected boolean isOnDestroy;

    public boolean isOnDestroy() {
        return isOnDestroy;
    }

    public void setOnDestroy(boolean onDestroy) {
        isOnDestroy = onDestroy;
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        //1.取消请求
        OkHttpUtils.getInstance().cancelTag(this);
        //2.拒绝响应
        setOnDestroy(true);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //填充布局
        setContentView(setView());
        //注解ButterKnife
        ButterKnife.bind(this);
        //findView或initData
        initData();
    }

    /**
     * 子类初始化数据
     */
    protected abstract void initData();

    /**
     * 子类填充布局
     *
     * @return
     */
    protected abstract int setView();
}
