package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.AddressListAdapter
import com.palpate.adapter.CouponListAdapter
import kotlinx.android.synthetic.main.coupon_list_activity.*


class CouponListActivity : AppCompatActivity() {



    private lateinit var adapter: CouponListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coupon_list_activity)

        couponlist_rv.layoutManager = LinearLayoutManager(this)
        couponlist_rv.setHasFixedSize(true)
        adapter = CouponListAdapter(0)
        couponlist_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }




    }
}