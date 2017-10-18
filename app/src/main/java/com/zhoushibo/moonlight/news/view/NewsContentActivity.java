package com.zhoushibo.moonlight.news.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;

import com.geocentric.foundation.utils.LogUtil;
import com.github.clans.fab.FloatingActionButton;
import com.zhoushibo.moonlight.BaseActivity;
import com.zhoushibo.moonlight.R;
import com.zhoushibo.moonlight.databinding.NewsContentActivityBinding;
import com.zhoushibo.moonlight.news.model.NewContent;
import com.zhoushibo.moonlight.news.viewmodel.NewsContentModel;
import com.zhoushibo.moonlight.util.SnackbarUtils;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * @author shibo
 * @description
 * @date 2017/10/13
 */
public class NewsContentActivity extends BaseActivity implements ViewTreeObserver.OnScrollChangedListener {


    @Nullable
    @BindView(R.id.fab1)
    FloatingActionButton fab1;
    @Nullable
    @BindView(R.id.fab2)
    FloatingActionButton fab2;
    private NewContent obj;
    private String lang = "cn";
    private int scrollY;

    @Override
    protected void initActivity(@Nullable Bundle savedInstanceState) {
//        NewsContentActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.news_content_activity);
//        NewsBean obj = new NewsBean();
//        binding.setObj(obj);
        addMidView(R.layout.news_content_activity);
        obj = getIntent().getParcelableExtra("Bean");
        setTitle(obj.title);
        NewsContentModel newsContentModel = new NewsContentModel(this, ((NewsContentActivityBinding) dataBinding).scvNewsContent);
        ((NewsContentActivityBinding) dataBinding).scvNewsContent.getViewTreeObserver().addOnScrollChangedListener(this);
        ((NewsContentActivityBinding) dataBinding).setObj(obj);
    }


    @Optional
    @OnClick({R.id.fab1, R.id.fab2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab1:
                if (lang.equalsIgnoreCase("cn")) {
                    setTitle(obj.title_en);
                    lang = "en";
                } else {
                    setTitle(obj.title);
                    lang = "cn";
                }
                break;
            case R.id.fab2:
                if (!lang.equalsIgnoreCase("dual")) {

                }
                SnackbarUtils.INSTANCE.showSnackbar(fab1, "fab2");
                break;
            default:
                break;
        }
    }

    @Override
    public void onScrollChanged() {
        scrollY = ((NewsContentActivityBinding) dataBinding).scvNewsContent.getScrollY();
        LogUtil.defaultLog("scrollY: " + scrollY);
        if (scrollY > 0) {
            toolbar.setVisibility(View.GONE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                View decorView = getWindow().getDecorView();
                //SYSTEM_UI_FLAG_FULLSCREEN表示全屏的意思，也就是会将状态栏隐藏
                //设置系统UI元素的可见性
                decorView.setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

//                View decorView = getWindow().getDecorView();
//                //让应用主题内容占用系统状态栏的空间,注意:下面两个参数必须一起使用 stable 牢固的
//                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                decorView.setSystemUiVisibility(option);
//                //设置状态栏颜色为透明
//                getWindow().setStatusBarColor(Color.TRANSPARENT);
                //导航栏
//                int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN;
//                decorView.setSystemUiVisibility(option);

            }
        } else {
            toolbar.setVisibility(View.VISIBLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = this.getWindow();
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
                //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //设置状态栏颜色
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));

                //导航栏
//                int option = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
//                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                decorView.setSystemUiVisibility(option);
            }
        }
    }
}
