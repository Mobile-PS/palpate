package com.palpate

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.*
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.add_address_activity.*
import kotlinx.android.synthetic.main.addhealthrecord_activity.*
import kotlinx.android.synthetic.main.addhealthrecord_activity.back
import kotlinx.android.synthetic.main.addhealthrecord_dailog.view.*

class AddHealthRecordActivity : AppCompatActivity() {
    private var items = arrayListOf(
        "Covid", "Eye Care", "Chest", "Dental", "Other"
    )

    val frequencyarray = arrayOf<String?>("Frequency")
    private lateinit var adapter: TagAdapter
    private lateinit var adapterReporterAdapter: ReporterAdapter
    private lateinit var adapter1: PrescribationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addhealthrecord_activity)

        val intent = getIntent();
        val myValue = intent.getStringExtra("type")

        if(myValue!=null){
            txt_save.text = "Delete"
            nested_saveform.visibility=View.GONE
            nested_viewdetails.visibility=View.VISIBLE
            txt_save.setBackgroundResource(R.drawable.layout_bg14);
            txt_title.text="View Health Record"
        }

        tag_rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        tag_rv.setHasFixedSize(true)
        adapter = TagAdapter(items, 0)
        tag_rv.adapter = adapter

        prescription_rv.layoutManager = LinearLayoutManager(this)
        prescription_rv.setHasFixedSize(true)
        adapter1 = PrescribationAdapter(0)
        prescription_rv.adapter = adapter1

        back.setOnClickListener {
            finish()
        }

//        intent.extras?.let {
//            Log.d("TEST","Test")
//            nested_saveform.visibility=View.GONE
//            nested_viewdetails.visibility=View.VISIBLE
//            txt_title.text="View Health Record"
//
//        }

        if(myValue==null) {
            txt_save.setOnClickListener {
                if (txt_save.text == "Save") {
                    txt_save.text = "Delete"
                    nested_saveform.visibility = View.GONE
                    nested_viewdetails.visibility = View.VISIBLE
                    txt_save.setBackgroundResource(R.drawable.layout_bg14);

                } else if (txt_save.text == "Delete") {
                    txt_save.text = "Save"
                    nested_saveform.visibility = View.VISIBLE
                    nested_viewdetails.visibility = View.GONE
                    txt_save.setBackgroundResource(R.drawable.layout_bg9);
                }
            }
        }

        img1.setOnClickListener {

            openAddRecordDailog(this);
        }

        img2.setOnClickListener {

            openAddRecordDailog(this);
        }

        img3.setOnClickListener {

            openAddRecordDailog(this);
        }


        val frequencyAdapter: ArrayAdapter<Any?> = ArrayAdapter<Any?>(this, R.layout.spinner_text, frequencyarray)
        frequencyAdapter.setDropDownViewResource(R.layout.spinner_text)
        spinner_frequancy.adapter = frequencyAdapter


        val languages = resources.getStringArray(R.array.tags)
        val adapter = ArrayAdapter(this, R.layout.spinner_text, languages)
        autoTextView.setAdapter(adapter)

        report_img.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        val adapterReporterAdapter = ReporterAdapter()
        report_img.setAdapter(adapterReporterAdapter)


    }

    private fun openAddRecordDailog(context: Context?) {
        val dialogView = layoutInflater.inflate(R.layout.downloadimage_dailog, null)

        val customDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .show()

    }
}