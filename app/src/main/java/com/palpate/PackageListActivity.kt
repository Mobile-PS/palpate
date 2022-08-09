package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.HealthPackageAdapter
import com.palpate.adapter.NursingPackageAdapter
import kotlinx.android.synthetic.main.health_package_activity.*

class PackageListActivity : AppCompatActivity() {

    lateinit var listViews: ArrayList<ViewItem>
    lateinit var adapter: ViewPagerAdapter1
    lateinit var healthadapter: HealthPackageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_package_activity)


        initUI()

        back.setOnClickListener {
            finish();
        }
    }

    fun initUI() {
        listViews = ArrayList<ViewItem>()
        listViews.add(ViewItem(1, R.drawable.slide_img))
        listViews.add(ViewItem(2, R.drawable.slide_img))
        listViews.add(ViewItem(3, R.drawable.slide_img))
        listViews.add(ViewItem(4, R.drawable.slide_img))
        listViews.add(ViewItem(5, R.drawable.slide_img))

        adapter = ViewPagerAdapter1(applicationContext, listViews)
        view_pager.adapter = adapter
        pager_indicator.attachToPager(view_pager);


        package_rv.layoutManager = LinearLayoutManager(this)
        package_rv.setHasFixedSize(true)
        healthadapter = HealthPackageAdapter(-1)
        package_rv.adapter = healthadapter
    }


}