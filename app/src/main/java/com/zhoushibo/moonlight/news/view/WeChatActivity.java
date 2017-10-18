package com.zhoushibo.moonlight.news.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhoushibo.moonlight.BaseActivity;
import com.zhoushibo.moonlight.R;

/**
 * @author shibo
 * @description
 * @date 2017/10/18
 */
public class WeChatActivity extends BaseActivity{

    @Override
    protected void initActivity(@Nullable Bundle savedInstanceState) {
        addMidView(R.layout.activity_listview);
        setToolbarGone();
    }
}
