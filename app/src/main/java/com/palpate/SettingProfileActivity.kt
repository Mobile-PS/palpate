package com.palpate

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.profile_activity.*


class SettingProfileActivity : AppCompatActivity() {
    val cityarray = arrayOf<String?>("Select City")
    val statearray = arrayOf<String?>("Select State")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)

        back.setOnClickListener {
            finish()
        }

        val cityAdapter: ArrayAdapter<Any?> = ArrayAdapter<Any?>(this, R.layout.spinner_text1, cityarray)
        cityAdapter.setDropDownViewResource(R.layout.spinner_text1)
        spinner_city.adapter = cityAdapter

        val stateAdapter: ArrayAdapter<Any?> = ArrayAdapter<Any?>(this, R.layout.spinner_text1, statearray)
        stateAdapter.setDropDownViewResource(R.layout.spinner_text1)
        spinner_state.adapter = stateAdapter


    }


}