package com.zhoushibo.moonlight.news;

import android.content.Context;
import android.databinding.ObservableBoolean;

/**
 * @author shibo
 * @description
 * @date 2017/9/28
 */
public class NewsModel {

    public final ObservableBoolean dataLoading = new ObservableBoolean(false);

    private final Context mContext;

    public String text = "show text";

    public NewsModel(Context mContext) {
        this.mContext = mContext;
    }

    public void start(){

    }
}
