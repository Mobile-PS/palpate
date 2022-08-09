package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.AddressListAdapter
import com.palpate.adapter.CouponListAdapter
import com.palpate.adapter.PackageHistoryListAdapter
import kotlinx.android.synthetic.main.packagehistory_activity.*


class PackageHistoryListActivity : AppCompatActivity() {



    private lateinit var adapter: PackageHistoryListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.packagehistory_activity)

        packagehistorylist_rv.layoutManager = LinearLayoutManager(this)
        packagehistorylist_rv.setHasFixedSize(true)
        adapter = PackageHistoryListAdapter(0)
        packagehistorylist_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }




    }
}