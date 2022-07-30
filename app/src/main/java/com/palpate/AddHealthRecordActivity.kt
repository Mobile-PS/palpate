package com.palpate

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.AddHealthStatsAdapter
import com.palpate.adapter.PrescribationAdapter
import com.palpate.adapter.TagAdapter
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.addhealthrecord_activity.*

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

    }
}