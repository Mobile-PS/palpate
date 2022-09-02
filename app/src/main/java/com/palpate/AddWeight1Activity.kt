package com.palpate

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addweight1_activity.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class AddWeight1Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addweight1_activity)

        rel_view.setDefaultSelectedValue(58f)
        id_txtcount.text = "58"
        txt_count.text = "58"
        txt_count1.text = "58"
        rel_view.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                id_txtcount.text = value.roundToInt().toString();
                txt_count.text = value.roundToInt().toString();
                txt_count1.text = value.roundToInt().toString();
            }
        })


        back.setOnClickListener {
            finish()
        }

        save.setOnClickListener {
            finish()
        }

        txt_selectdate.setOnClickListener {
            showDateTimeDialog(txt_datetime)
        }

    }

    private fun showDateTimeDialog(date_time_in: TextView) {
        val calendar: Calendar = Calendar.getInstance()
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val timeSetListener =
                    TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                        calendar.set(Calendar.MINUTE, minute)
                        val simpleDateFormat = SimpleDateFormat("EEE,MMM d,yyyy, HH:mm aaa")
                         date_time_in.setText(simpleDateFormat.format(calendar.getTime()))
                    }
                TimePickerDialog(
                    this,
                    R.style.DatePickerTheme,
                    timeSetListener,
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    false
                ).show()
            }
        DatePickerDialog(
            this,
            R.style.DatePickerTheme,
            dateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
}