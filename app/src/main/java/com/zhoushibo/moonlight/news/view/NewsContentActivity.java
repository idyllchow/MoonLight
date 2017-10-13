package com.zhoushibo.moonlight.news.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhoushibo.moonlight.R;
import com.zhoushibo.moonlight.databinding.NewsContentActivityBinding;
import com.zhoushibo.moonlight.news.model.NewsBean;

/**
 * @author shibo
 * @description
 * @date 2017/10/13
 */
public class NewsContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NewsContentActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.news_content_activity);
        NewsBean obj = new NewsBean();
        binding.setObj(obj);
    }
}
