package com.palpate


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addheartrate_activity.*
import kotlinx.android.synthetic.main.addheartrate_activity.back
import kotlinx.android.synthetic.main.addheartrate_activity.id_txtcount
import kotlinx.android.synthetic.main.addheartrate_activity.rel_view
import kotlinx.android.synthetic.main.addheartrate_activity.save
import kotlinx.android.synthetic.main.addheartrate_activity.txt_count
import kotlinx.android.synthetic.main.addheartrate_activity.txt_datetime
import kotlinx.android.synthetic.main.addheartrate_activity.txt_selectdate
import kotlinx.android.synthetic.main.addheight_activity.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class AddHeartRateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addheartrate_activity)

        rel_view.setDefaultSelectedValue(58F)
        id_txtcount.text="58"
        txt_count.text="58"
        rel_view.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                id_txtcount.text = value.roundToInt().toString();
                txt_count.text = value.roundToInt().toString();
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