package com.zhoushibo.moonlight.news.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.geocentric.foundation.utils.LogUtil;
import com.zhoushibo.moonlight.databinding.ItemNewsBinding;
import com.zhoushibo.moonlight.news.model.NewContent;

/**
 * @author shibo
 * @description
 * @date 2017/9/29
 */
public abstract class MoonBaseAdapter extends RecyclerView.Adapter<MoonBaseAdapter.MoonViewHolder> {

    private final int layoutId;
    private Context context;

    public MoonBaseAdapter(Context context, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
    }

    @Override
    public MoonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        ItemNewsBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new MoonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MoonViewHolder holder, int position) {
        final NewContent obj = (NewContent) getObjForPosition(position);
        holder.bind(obj);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                context.startActivity(new Intent(context, NewsContentActivity.class).putExtra("Bean", obj));
                context.startActivity(new Intent(context, WeChatActivity.class));
            }
        });
    }

    protected abstract Object getObjForPosition(int position);

    protected abstract int getLayoutIdForPosition(int position);

    class MoonViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public MoonViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(NewContent obj) {
            binding.setVariable(BR.obj, obj);
            binding.executePendingBindings();
            LogUtil.defaultLog("========binding======");
        }
    }
}
