package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.AddressListAdapter
import kotlinx.android.synthetic.main.select_address_activity.*


class AddressListActivity : AppCompatActivity() {



    private lateinit var adapter: AddressListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_address_activity)

        addresslist_rv.layoutManager = LinearLayoutManager(this)
        addresslist_rv.setHasFixedSize(true)
        adapter = AddressListAdapter(0, true, 2)
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