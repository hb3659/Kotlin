package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPager2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("One"))
        tab_layout.addTab(tab_layout.newTab().setText("Two"))
        tab_layout.addTab(tab_layout.newTab().setText("Three"))

        val adapter = ThreePageAdapter(LayoutInflater.from(this))
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(tab_layout)
        )
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }
        })
    }
}

class ThreePageAdapter(
    val Inflater: LayoutInflater
) : PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when (position) {
            0 -> {
                val view = Inflater.inflate(
                    R.layout.fragment_one,
                    container,
                    false
                )
                container.addView(view)
                return view
            }
            1 -> {
                val view = Inflater.inflate(
                    R.layout.fragment_two,
                    container,
                    false
                )
                container.addView(view)
                return view
            }
            2 -> {
                val view = Inflater.inflate(
                    R.layout.fragment_three,
                    container,
                    false
                )
                container.addView(view)
                return view
            }
            else -> {
                val view = Inflater.inflate(
                    R.layout.fragment_one,
                    container,
                    false
                )
                container.addView(view)
                return view
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun getCount(): Int {
        return 3
    }
}
