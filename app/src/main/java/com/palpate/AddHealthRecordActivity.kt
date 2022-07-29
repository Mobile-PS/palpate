package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.AddHealthStatsAdapter
import com.palpate.adapter.TagAdapter
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.addhealthrecord_activity.*

class AddHealthRecordActivity : AppCompatActivity() {
    private var items = arrayListOf(
       "Covid","Eye Care","Chest","Dental","Other"
    )

    private lateinit var adapter: TagAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addhealthrecord_activity)

        tag_rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        tag_rv.setHasFixedSize(true)
        adapter = TagAdapter(items, 0)
        tag_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }

    }
}