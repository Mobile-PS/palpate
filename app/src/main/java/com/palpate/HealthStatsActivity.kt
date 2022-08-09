package com.palpate

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.palpate.adapter.SpecialistAdapter
import com.palpate.adapter.TabAdapter
import com.palpate.model.SpecialistDataModel
import kotlinx.android.synthetic.main.sharerecord_dailog.view.*
import kotlinx.android.synthetic.main.healthstats_activity.*

class HealthStatsActivity : AppCompatActivity() {

    private var items1 = arrayListOf(
        SpecialistDataModel(
            "Blood Pressure", false
        ),
        SpecialistDataModel(
            "Temperature", false
        ),
        SpecialistDataModel(
            "Blood Sugar", false
        ),
        SpecialistDataModel(
            "Medical History", false
        ),

        )

    private lateinit var adapter1: SpecialistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.healthstats_activity)
        tabLayout.addTab(tabLayout.newTab().setText("Health Stats"))
        tabLayout.addTab(tabLayout.newTab().setText("Health Record"))
        tabLayout.addTab(tabLayout.newTab().setText("Medical History"))
        val adapter = TabAdapter(this, supportFragmentManager, tabLayout.tabCount)
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

        raj.setOnClickListener {


                val intent = Intent(this, MyHealthStatsActivity::class.java)
                startActivity(intent)


        }

        card_sharedoctor.setOnClickListener {
                openShareDialog();


        }
    }

    private fun openShareDialog() {
        val dialogView = layoutInflater.inflate(R.layout.sharerecord_dailog, null)
        dialogView.speaclist_rv.layoutManager = LinearLayoutManager(this)
        dialogView.speaclist_rv.setHasFixedSize(true)
        adapter1 = SpecialistAdapter(items1, 0)
        dialogView.speaclist_rv.adapter = adapter1


        val customDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .show()

        dialogView.btn_submit.setOnClickListener {

            customDialog.dismiss()
        }

    }


}