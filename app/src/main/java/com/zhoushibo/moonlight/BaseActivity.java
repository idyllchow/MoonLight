package com.zhoushibo.moonlight;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhoushibo.moonlight.news.viewmodel.ViewModel;
import com.zhoushibo.moonlight.util.SnackbarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author shibo
 * @description
 * @date 2017/10/16
 */
public abstract class BaseActivity<B extends ViewDataBinding, T extends ViewModel> extends AppCompatActivity {

    @BindView(R.id.img_title_left)
    ImageView imgTitleLeft;
    @BindView(R.id.fly_title_left)
    FrameLayout flyTitleLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_title_right)
    ImageView imgTitleRight;
    @BindView(R.id.tv_title_right)
    TextView tvTitleRight;
    @BindView(R.id.fly_title_right)
    FrameLayout flyTitleRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_sub)
    View toolbarSub;
    @BindView(R.id.base_content)
    FrameLayout baseContent;

    protected B dataBinding;
    protected T baseViewModel;
    //中部视图
    View midView;

    //退出应用时间
    private long exitTime = 0;
    //退出时间间隔
    private static final int EXIT_INTERVAL = 1500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
        initActivity(savedInstanceState);
    }

    @OnClick({R.id.fly_title_left, R.id.fly_title_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fly_title_left:
                break;
            case R.id.fly_title_right:
                break;
        }
    }

    /**
     * 添加中部类视图
     *
     * @param resId
     */
    public void addMidView(int resId) {
        dataBinding = DataBindingUtil.inflate(LayoutInflater.from(this), resId, null, false);
        midView = dataBinding.getRoot();
        baseContent.removeAllViews();
        baseContent.addView(midView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        ButterKnife.bind(this);
    }

    /**
     * 添加中部类视图
     *
     * @param view 添加视图
     */
    public void addMidView(View view) {
        this.midView = view;
        baseContent.removeAllViews();
        baseContent.addView(midView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }

    /**
     * 初始化子类视图
     */
    protected abstract void initActivity(@Nullable Bundle savedInstanceState);

    public void setToolbarGone() {
        toolbar.setVisibility(View.GONE);
        toolbarSub.setVisibility(View.GONE);
    }

    protected void setTitle(String title) {
        tvTitle.setText(title);
    }

    protected void exit() {
        if ((System.currentTimeMillis() - exitTime) > EXIT_INTERVAL) {
            SnackbarUtils.INSTANCE.showSnackbar(baseContent, getString(R.string.exit_prompt));
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            Process.killProcess(Process.myPid());
            System.exit(0); //退出
        }
    }
}
