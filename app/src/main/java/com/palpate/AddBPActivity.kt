package com.palpate


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addbp_activity.*
import kotlinx.android.synthetic.main.addbp_activity.back
import kotlinx.android.synthetic.main.addbp_activity.id_txtcount
import kotlinx.android.synthetic.main.addbp_activity.id_txtcount1
import kotlinx.android.synthetic.main.addbp_activity.rel_view
import kotlinx.android.synthetic.main.addbp_activity.rel_view1
import kotlinx.android.synthetic.main.addbp_activity.save
import kotlinx.android.synthetic.main.addbp_activity.txt_count
import kotlinx.android.synthetic.main.addbp_activity.txt_count1
import kotlinx.android.synthetic.main.addbp_activity.txt_datetime
import kotlinx.android.synthetic.main.addbp_activity.txt_selectdate
import kotlinx.android.synthetic.main.addheight_activity.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class AddBPActivity : AppCompatActivity() {
    var systoliccount = 0
    var diastoliccount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addbp_activity)

        systoliccount = 123
        diastoliccount = 78
        setTextContent()

        rel_view.setDefaultSelectedValue(123F)
        rel_view.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                systoliccount = value.roundToInt()
                setTextContent()
            }
        })

        rel_view1.setDefaultSelectedValue(78F)
        rel_view1.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                diastoliccount = value.roundToInt()
                setTextContent()
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

    private fun setTextContent() {
        txt_count1.text = "$systoliccount/$diastoliccount"
        txt_count.text = "$systoliccount/$diastoliccount"
        id_txtcount.text = systoliccount.toString()
        id_txtcount1.text = diastoliccount.toString()
    }
}