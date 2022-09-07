package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.NursingOrderHistoryListAdapter
import kotlinx.android.synthetic.main.nursingorderhistory_activity.*


class NursingOrderHistoryActivity : AppCompatActivity() {



    private lateinit var adapter: NursingOrderHistoryListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nursingorderhistory_activity)

        orderhistorylist_rv.layoutManager = LinearLayoutManager(this)
        orderhistorylist_rv.setHasFixedSize(true)
        adapter = NursingOrderHistoryListAdapter(0)
        orderhistorylist_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }




    }
}