package com.palpate

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.HealthPackageAdapter
import com.palpate.adapter.NursingPackageAdapter
import com.palpate.adapter.SpecialistAdapter
import com.palpate.model.SpecialistDataModel
import kotlinx.android.synthetic.main.addhealthrecord_dailog.view.*
import kotlinx.android.synthetic.main.health_package_activity.*

class PackageListActivity : AppCompatActivity() {

    lateinit var listViews: ArrayList<ViewItem>
    lateinit var adapter: ViewPagerAdapter1
    lateinit var healthadapter: HealthPackageAdapter
    private var items1 = arrayListOf(
        SpecialistDataModel(
            "Basic package", false
        ),
        SpecialistDataModel(
            "Full Body Checkup", false
        ),
        SpecialistDataModel(
            "Advanced Package", false
        ),

        )

    private lateinit var adapter1: SpecialistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_package_activity)


        initUI()

        back.setOnClickListener {
            finish();
        }

        img_filter.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.filter_dailog, null)
            dialogView.speaclist_rv.layoutManager = LinearLayoutManager(this)
            val mBuilder = AlertDialog.Builder(this)
                .setView(dialogView)
            //show dialog
            val mAlertDialog = mBuilder.show()
            dialogView.speaclist_rv.setHasFixedSize(true)
            adapter1 = SpecialistAdapter(items1, 0)
            dialogView.speaclist_rv.adapter = adapter1


            dialogView.btn_submit.setOnClickListener {
                mAlertDialog.dismiss()
            }

            dialogView.btn_remove.setOnClickListener {
                mAlertDialog.dismiss()
            }
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