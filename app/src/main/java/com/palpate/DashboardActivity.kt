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

class DashboardActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_layout)

        setSupportActionBar(toolbar);



     /*   var toggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerClosed(drawerView: View) {
                // Triggered once the drawer closes
                super.onDrawerClosed(drawerView)
                try {
                    val inputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
                } catch (e: Exception) {
                    e.stackTrace
                }
            }

            override fun onDrawerOpened(drawerView: View) {
                // Triggered once the drawer opens
                super.onDrawerOpened(drawerView)
                try {
                    val inputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
                } catch (e: Exception) {
                    e.stackTrace
                }
            }
        }
        back.setOnClickListener {

            drawer_layout.closeDrawer(GravityCompat.START)
        }
        *//* toggle.setDrawerIndicatorEnabled(false);

         activity_main_toolbar.setNavigationIcon(R.drawable.draweric);*//*

       // drawerLayout.addDrawerListener(toggle)

        toggle.syncState()*/


        getSupportActionBar()!!.setHomeButtonEnabled(true)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()!!.setHomeAsUpIndicator(R.drawable.ic_hamburg)

        toolbar.setNavigationOnClickListener {

            val intent = Intent(this, DrawerActivity::class.java)
            startActivity(intent)
        }



    }
}