package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.HealthPackageHistoryListAdapter
import kotlinx.android.synthetic.main.packagehistory_activity.*


class HealthPackageHistoryListActivity : AppCompatActivity() {



    private lateinit var adapter: HealthPackageHistoryListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.packagehistory_activity)

        packagehistorylist_rv.layoutManager = LinearLayoutManager(this)
        packagehistorylist_rv.setHasFixedSize(true)
        adapter = HealthPackageHistoryListAdapter(0)
        packagehistorylist_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }




    }
}