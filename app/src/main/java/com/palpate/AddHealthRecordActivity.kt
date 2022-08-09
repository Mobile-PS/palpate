package com.palpate

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.AddHealthStatsAdapter
import com.palpate.adapter.PrescribationAdapter
import com.palpate.adapter.SpecialistAdapter
import com.palpate.adapter.TagAdapter
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.addhealthrecord_activity.*
import kotlinx.android.synthetic.main.addhealthrecord_dailog.view.*

class AddHealthRecordActivity : AppCompatActivity() {
    private var items = arrayListOf(
        "Covid", "Eye Care", "Chest", "Dental", "Other"
    )

    private lateinit var adapter: TagAdapter
    private lateinit var adapter1: PrescribationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addhealthrecord_activity)

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

        intent.extras?.let {
            Log.d("TEST","Test")
            nested_saveform.visibility=View.GONE
            nested_viewdetails.visibility=View.VISIBLE
        }

        txt_save.setOnClickListener {
            if (txt_save.text == "Save") {
                txt_save.text = "Delete"
                nested_saveform.visibility=View.GONE
                nested_viewdetails.visibility=View.VISIBLE

            } else if (txt_save.text == "Delete") {
                txt_save.text = "Save"
                nested_saveform.visibility=View.VISIBLE
                nested_viewdetails.visibility=View.GONE
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

    }

    private fun openAddRecordDailog(context: Context?) {
        val dialogView = layoutInflater.inflate(R.layout.downloadimage_dailog, null)

        val customDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .show()

    }
}