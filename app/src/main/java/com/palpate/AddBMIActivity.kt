package com.palpate


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addbmi_activity.*

class AddBMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addbmi_activity)

        back.setOnClickListener {
            finish()
        }

        save.setOnClickListener {
            finish()
        }


    }
}