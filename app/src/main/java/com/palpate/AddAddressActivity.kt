package com.palpate

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_address_activity.*


class AddAddressActivity : AppCompatActivity() {
    val cityarray = arrayOf<String?>("Select City")
    val statearray = arrayOf<String?>("Select State")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_address_activity)

        back.setOnClickListener {
            finish()
        }


        btn_contiune.setOnClickListener {
            finish()
        }


        val cityAdapter: ArrayAdapter<Any?> = ArrayAdapter<Any?>(this, R.layout.spinner_text, cityarray)
        cityAdapter.setDropDownViewResource(R.layout.spinner_text)
        spinner_city.adapter = cityAdapter

        val stateAdapter: ArrayAdapter<Any?> = ArrayAdapter<Any?>(this, R.layout.spinner_text, statearray)
        stateAdapter.setDropDownViewResource(R.layout.spinner_text)
        spinner_state.adapter = stateAdapter

    }
}