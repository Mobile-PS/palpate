package com.palpate

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.NursingPackageAdapter
import com.palpate.adapter.SpecialistAdapter
import com.palpate.model.SpecialistDataModel
import kotlinx.android.synthetic.main.addhealthrecord_dailog.view.*
import kotlinx.android.synthetic.main.nursing_list_activity.*

class NursingListActivity : AppCompatActivity() {

    lateinit var adapter: NursingPackageAdapter
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
        setContentView(R.layout.nursing_list_activity)
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
        healthpackage_rv.layoutManager = LinearLayoutManager(this)
        healthpackage_rv.setHasFixedSize(true)
        adapter = NursingPackageAdapter(0)
        healthpackage_rv.adapter = adapter
    }

}