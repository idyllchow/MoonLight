package com.zhoushibo.moonlight.news.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.geocentric.foundation.utils.LogUtil;
import com.github.clans.fab.FloatingActionMenu;
import com.zhoushibo.moonlight.BaseActivity;
import com.zhoushibo.moonlight.R;
import com.zhoushibo.moonlight.databinding.NewsContentActivityBinding;
import com.zhoushibo.moonlight.news.model.NewsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @author shibo
 * @description
 * @date 2017/10/13
 */
public class NewsContentActivity extends BaseActivity {


//    @BindView(R.id.menu_labels_right)
//    FloatingActionMenu menuLabelsRight;
    private List<FloatingActionMenu> menus = new ArrayList<>();

    @Override
    protected void initActivity(@Nullable Bundle savedInstanceState) {
//        NewsContentActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.news_content_activity);
//        NewsBean obj = new NewsBean();
//        binding.setObj(obj);
        addMidView(R.layout.news_content_activity);
        NewsBean obj = getIntent().getParcelableExtra("Bean");
        setTitle(obj.title);
        LogUtil.defaultLog("obj title " + obj.title);
        ((NewsContentActivityBinding) dataBinding).setObj(obj);

//        menuLabelsRight.hideMenuButton(false);
//        menus.add(menuLabelsRight);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
