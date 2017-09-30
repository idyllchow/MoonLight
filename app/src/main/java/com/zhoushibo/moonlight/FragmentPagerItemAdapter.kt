package com.zhoushibo.moonlight

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.util.SparseArrayCompat
import android.view.ViewGroup
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.lang.ref.WeakReference

/**
 * @author shibo
 * @description
 * @date 2017/9/27
 */
class FragmentPagerItemAdapter(fm: FragmentManager, private val pages: FragmentPagerItems) : FragmentPagerAdapter(fm) {
    private val holder: SparseArrayCompat<WeakReference<Fragment>>

    init {
        this.holder = SparseArrayCompat(pages.size)
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getItem(position: Int): Fragment {
        return getPagerItem(position).instantiate(pages.context, position)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = super.instantiateItem(container, position)
        if (item is Fragment) {
            holder.put(position, WeakReference(item))
        }
        return item
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any) {
        holder.remove(position)
        super.destroyItem(container, position, `object`)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return getPagerItem(position).title
    }

    override fun getPageWidth(position: Int): Float {
        return super.getPageWidth(position)
    }

    fun getPage(position: Int): Fragment? {
        val weakRefItem = holder.get(position)
        return weakRefItem?.get()
    }

    protected fun getPagerItem(position: Int): FragmentPagerItem {
        return pages[position]
    }
}
