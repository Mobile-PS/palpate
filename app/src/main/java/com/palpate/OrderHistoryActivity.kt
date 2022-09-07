package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.palpate.adapter.HistoryTabAdapter
import kotlinx.android.synthetic.main.orderhistory_activity.*

class OrderHistoryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.orderhistory_activity)
        tabLayout.addTab(tabLayout.newTab().setText("Home Care Nursing"))
        tabLayout.addTab(tabLayout.newTab().setText("Preventive Health Checkup"))
        val adapter = HistoryTabAdapter(this, supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        back.setOnClickListener {
            finish()
        }



    }


}

