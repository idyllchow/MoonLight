package com.zhoushibo.moonlight.news;

/**
 * @author shibo
 * @description
 * @date 2017/9/29
 */
public abstract class SingleLayoutAdapter extends MoonBaseAdapter {

    private final int layoutId;

    public SingleLayoutAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return position;
    }
}
