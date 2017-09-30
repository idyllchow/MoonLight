package com.zhoushibo.moonlight.news;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geocentric.foundation.utils.LogUtil;
import com.zhoushibo.moonlight.BaseFragment;
import com.zhoushibo.moonlight.R;
import com.zhoushibo.moonlight.data.ApiConfig;
import com.zhoushibo.moonlight.databinding.FragNewsBinding;

/**
 * @author shibo
 * @description
 * @date 2017/9/26
 */
public class NewsFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragNewsBinding binding = DataBindingUtil.inflate(inflater, R.layout.frag_news, container, false);
        rootView = binding.getRoot();
        NewsModel newsModel = new NewsModel(getContext());
        binding.setViewmodel(newsModel);

        LogUtil.defaultLog("===baseUrl====" + ApiConfig.BASE_URL);
        return rootView;
    }
}
