package com.palpate.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.AddHealthStatsActivity
import com.palpate.R
import com.palpate.adapter.HealthStaticAdapter
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.healthstats_fragment.*

class HealthStatFragment : Fragment() {

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

    private lateinit var adapter: HealthStaticAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.healthstats_fragment, container, false)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        healthstat_rv.layoutManager = LinearLayoutManager(context)
        healthstat_rv.setHasFixedSize(true)
        adapter = HealthStaticAdapter(items, 0, true)
        healthstat_rv.adapter = adapter

        btn_add_health_stat.setOnClickListener {
            val intent = Intent(context, AddHealthStatsActivity::class.java)
            startActivity(intent)
        }

    }
}