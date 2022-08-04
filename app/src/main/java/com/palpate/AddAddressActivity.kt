package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_address_activity.*


class AddAddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_address_activity)

        back.setOnClickListener {
            finish()
        }


        btn_contiune.setOnClickListener {
            finish()
        }


    }
}