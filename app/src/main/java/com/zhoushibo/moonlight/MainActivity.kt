package com.zhoushibo.moonlight

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.ogaclejapan.smarttablayout.utils.v4.Bundler
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import com.zhoushibo.moonlight.bbc.BBCFragment
import com.zhoushibo.moonlight.news.view.NewsFragment

class MainActivity : AppCompatActivity() {

    var adapter:FragmentPagerItemAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val tabLayout = findViewById(R.id.tabs) as TabLayout
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"))
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"))
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"))

        val viewPager = findViewById(R.id.viewpager) as ViewPager
        tabLayout.setupWithViewPager(viewPager)

        adapter = FragmentPagerItemAdapter(supportFragmentManager, FragmentPagerItems.with(this)
                .add("Tab1", NewsFragment::class.java, Bundler().get())
                .add("Tab2", BBCFragment::class.java, Bundler().get())
                .add("Tab3", BBCFragment::class.java, Bundler().get())
                .add("Tab4", BBCFragment::class.java, Bundler().get())
                .create())

        viewPager.adapter = adapter

//        val fab = findViewById(R.id.fab) as FloatingActionButton
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
