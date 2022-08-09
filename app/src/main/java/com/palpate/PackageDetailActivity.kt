package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.health_list_details.*


class PackageDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_list_details)

        back.setOnClickListener {
            finish()
        }

        btn_subscribe.setOnClickListener {
            GlobalStuff.mainNavState = 1
            val intent = Intent(this, AddressListActivity::class.java)
            startActivity(intent)
        }


    }


}