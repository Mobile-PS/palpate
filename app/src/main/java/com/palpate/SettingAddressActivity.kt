package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.AddressListAdapter
import com.palpate.adapter.SettingAddressListAdapter
import kotlinx.android.synthetic.main.select_address_activity.*


class SettingAddressActivity : AppCompatActivity() {


    private lateinit var adapter: SettingAddressListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_address_activity)

        addresslist_rv.layoutManager = LinearLayoutManager(this)
        addresslist_rv.setHasFixedSize(true)
        adapter = SettingAddressListAdapter(0,  2)
        addresslist_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }

        btn_contiune.setOnClickListener {
            finish()

        }

        linear_addaddress.setOnClickListener {
            val intent = Intent(this, AddAddressActivity::class.java)
            startActivity(intent)
        }


    }
}