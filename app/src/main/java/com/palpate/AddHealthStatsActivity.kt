package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.AddHealthStatsAdapter
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.addhealthstate_activity.*


class AddHealthStatsActivity : AppCompatActivity() {
    private var items = arrayListOf(
        HealthStateItemModel(
            R.drawable.weight_icon_blue, "Weight",
            "9 July 2021",
            "56.0"
        ),
//        HealthStateItemModel(
//            R.drawable.bmi_icon_blue, "BMI",
//            "9 July 2021", "20.1"
//        ),
        HealthStateItemModel(
            R.drawable.hrtrate_icon_blue, "Heart Rate",
            "1h ago", "76"
        ),
        HealthStateItemModel(
            R.drawable.bp_icon_blue, "Blood Pressure",
            "9 July 2021", "120/80"
        ),
        HealthStateItemModel(
            R.drawable.temp_icon_blue, "Temperature",
            "9 July 2021", "19.8"
        ),
        HealthStateItemModel(
            R.drawable.blood_icon_blue, "Blood Sugar",
            "9 July 2021", "70-130"
        ),
        HealthStateItemModel(
            R.drawable.height_icon_blue, "Height",
            "9 July 2021", "5’8"
        ),
        HealthStateItemModel(
            R.drawable.oxgn_icon_blue, "Oxygen Saturation",
            "9 July 2021", "78"
        ),
        HealthStateItemModel(
            R.drawable.vac_icon_blue, "Vaccination",
            "9 July 2021", "16"
        ),
    )

    private lateinit var adapter: AddHealthStatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addhealthstate_activity)

        addhealthstat_rv.layoutManager = LinearLayoutManager(this)
        addhealthstat_rv.setHasFixedSize(true)
        adapter = AddHealthStatsAdapter(items, 0)
        addhealthstat_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }

    }


}