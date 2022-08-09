package com.palpate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.NavigationRVAdapter
import com.palpate.model.NavigationItemModel
import kotlinx.android.synthetic.main.dashboard_layout.*

class DashboardActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_layout)

        setSupportActionBar(toolbar);
        getSupportActionBar()!!.setHomeButtonEnabled(true)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()!!.setHomeAsUpIndicator(R.drawable.ic_hamburg)

        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, DrawerActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in, R.anim.nothing);
        }

        emer.setOnClickListener {

            val intent = Intent(this, EmergencyServicesActivity::class.java)
            startActivity(intent)

        }

        point.setOnClickListener {
            val intent = Intent(this, PointHistoryActivity::class.java)
            startActivity(intent)
        }


        linear_healthcarenursing.setOnClickListener{
            val intent = Intent(this, HomeNursingActivity::class.java)
            startActivity(intent)
        }

        edit.setOnClickListener {
            val intent = Intent(this, HealthStatsActivity::class.java)
            startActivity(intent)
        }


    }
}