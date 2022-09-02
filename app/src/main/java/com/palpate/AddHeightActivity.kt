package com.palpate


import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addheight_activity.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


class AddHeightActivity : AppCompatActivity() {
    var feetcount = 0
    var inchcount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addheight_activity)

        feetcount = 50
        inchcount = 8
        setTextContent()

        rel_view.setDefaultSelectedValue(5F)
        rel_view.setMaxValue(250F)
        rel_view.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                feetcount = value.roundToInt()
                setTextContent()
            }
        })

//        rel_view1.setDefaultSelectedValue(8F)
//        rel_view1.setMaxValue(15F)
//        rel_view1.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
//            override fun onChooseValueChange(value: Float) {
//                inchcount = value.roundToInt()
//                setTextContent()
//            }
//        })

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
            OnDateSetListener { view, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val timeSetListener =
                    OnTimeSetListener { view, hourOfDay, minute ->
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

    private fun setTextContent() {
        txt_count1.text = "$feetcount"
        txt_count.text = "$feetcount cm"
        id_txtcount.text = feetcount.toString()
        id_txtcount1.text = inchcount.toString()
    }


}