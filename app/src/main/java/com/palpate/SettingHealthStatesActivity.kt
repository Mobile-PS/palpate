package com.palpate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.HealthStaticAdapter
import com.palpate.adapter.SettingHealthStatesAdapter
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.health_states_setting_activity.*


class SettingHealthStatesActivity : AppCompatActivity() {
    private var items = arrayListOf(
        HealthStateItemModel(
            R.drawable.weight_icon_blue, "Weight",
            "9 July 2021",
            "56.0"
        ),
        HealthStateItemModel(
            R.drawable.bmi_icon_blue, "BMI",
            "9 July 2021", "20.1"
        ),
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

    private lateinit var adapter: SettingHealthStatesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_states_setting_activity)

        back.setOnClickListener {
            finish()
        }

        healthstats_rv.layoutManager = LinearLayoutManager(this)
        healthstats_rv.setHasFixedSize(true)
        adapter = SettingHealthStatesAdapter(items, 0)
        healthstats_rv.adapter = adapter




    }


}