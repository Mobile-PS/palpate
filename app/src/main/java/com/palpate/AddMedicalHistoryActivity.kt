package com.palpate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addmedicalhistory_activity.*

class AddMedicalHistoryActivity : AppCompatActivity() {
    val montharray = arrayOf<String?>("Month")
    val yeararray = arrayOf<String?>("Year")
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

        save.setOnClickListener {
            finish()
        }

        val monthAdapter: ArrayAdapter<Any?> = ArrayAdapter<Any?>(this, R.layout.spinner_text, montharray)
        monthAdapter.setDropDownViewResource(R.layout.spinner_text)
        spinner_from_month.adapter = monthAdapter
        spinner_to_month.adapter = monthAdapter

        val yearAdapter: ArrayAdapter<Any?> = ArrayAdapter<Any?>(this, R.layout.spinner_text, yeararray)
        yearAdapter.setDropDownViewResource(R.layout.spinner_text)
        spinner_from_year.adapter = yearAdapter
        spinner_to_year.adapter = yearAdapter


        val languages = resources.getStringArray(R.array.tags)
        val adapter = ArrayAdapter(this, R.layout.spinner_text, languages)
        autoTextView.setAdapter(adapter)

    }
}