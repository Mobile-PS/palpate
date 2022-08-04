package com.palpate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addmedicalhistory_activity.*

class AddMedicalHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addmedicalhistory_activity)

        checkBox_current.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                txt_present.visibility = View.VISIBLE
                linear_dates.visibility = View.GONE
            } else {
                txt_present.visibility = View.GONE
                linear_dates.visibility = View.VISIBLE
            }
        }

        back.setOnClickListener {

            finish()
        }

    }
}