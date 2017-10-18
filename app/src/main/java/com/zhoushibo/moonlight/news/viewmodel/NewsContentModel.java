package com.zhoushibo.moonlight.news.viewmodel;

import android.content.Context;
import android.widget.ScrollView;

/**
 * @author shibo
 * @description
 * @date 2017/10/18
 */
public class NewsContentModel implements Model {

    private final Context mContext;
    private ScrollView mScrollView;

    public NewsContentModel(Context context, ScrollView scrollView) {
        this.mContext = context;
        this.mScrollView = scrollView;
    }

    private void handleTitlebar() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
