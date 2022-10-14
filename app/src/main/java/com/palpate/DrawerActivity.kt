package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.NavigationRVAdapter
import com.palpate.model.NavigationItemModel
import kotlinx.android.synthetic.main.dashboard_layout.*
import kotlinx.android.synthetic.main.drawer_layout.*
import android.view.WindowManager

import android.os.Build
import android.view.Window


class DrawerActivity: AppCompatActivity() {


    private var items = arrayListOf(
        NavigationItemModel(R.drawable.home1, "Home"),
        NavigationItemModel(R.drawable.health, "My Health Stats"),
        NavigationItemModel(R.drawable.history, "Order History"),
        NavigationItemModel(R.drawable.preven, "Preventive Health Checkup"),
        NavigationItemModel(R.drawable.home, "Home Care Nursing / Health Assistance"),
        NavigationItemModel(R.drawable.organ_icon,"Organ Donation" ),
        NavigationItemModel(R.drawable.article, "Health Tips"),
        NavigationItemModel(R.drawable.setting, "Settings"),
        NavigationItemModel(R.drawable.logout, "Log Out")
    )
    private lateinit var adapter: NavigationRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.drawer_layout)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(resources.getColor(R.color.dashcolor2))
        }

        setSupportActionBar(toolbar);


        navigation_rv.layoutManager = LinearLayoutManager(this)
        navigation_rv.setHasFixedSize(true)
        adapter = NavigationRVAdapter(items, 0)
        navigation_rv.adapter = adapter

        back.setOnClickListener {

            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.nothing1, R.anim.slide_out);

           // overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
        }

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





    }
}