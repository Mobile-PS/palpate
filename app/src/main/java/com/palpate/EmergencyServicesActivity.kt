package com.palpate

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.EmergencyAdapter
import com.palpate.adapter.HospitalAdapter
import com.palpate.model.HealthStateItemModel
import com.palpate.model.HospitalItemModel
import kotlinx.android.synthetic.main.emergencyservices_activity.*

class EmergencyServicesActivity : AppCompatActivity() {
    private var items =
        arrayListOf("Ambulance", "Women help", "Police station", "Fire brigade", "Child care");

    private var items2 = arrayListOf(
        HospitalItemModel(
            R.drawable.medant_icon, "Medanta Superspeciality Hospital",
            "Gomti Nagar, Lucknow   ●   3 KM"
        ),
        HospitalItemModel(
            R.drawable.apollo_icon, "Apollo Superspeciality Hospital",
            "Gomti Nagar, Lucknow   ●   5 KM"
        ),
        HospitalItemModel(
            R.drawable.tata_icon, "Tata Memorial Center",
            "Gomti Nagar, Lucknow   ●   8 KM"
        ),

        )
    private lateinit var adapter: EmergencyAdapter
    private lateinit var adapter2: HospitalAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emergencyservices_activity)

        btn_emergency.setOnClickListener {
            btn_emergency.setBackground(ContextCompat.getDrawable(this, R.drawable.button_bg7));
            btn_hospital.setBackground(ContextCompat.getDrawable(this, R.drawable.button_bg8));
            btn_emergency.setTextColor(getResources().getColor(R.color.dashcolor5))
            btn_hospital.setTextColor(getResources().getColor(R.color.txtcolor1))
            emergency_rv.visibility = View.VISIBLE
            hospital_rv.visibility = View.GONE
        }

        btn_hospital.setOnClickListener {
            btn_hospital.setBackground(ContextCompat.getDrawable(this, R.drawable.button_bg7));
            btn_emergency.setBackground(ContextCompat.getDrawable(this, R.drawable.button_bg8));
            btn_hospital.setTextColor(getResources().getColor(R.color.dashcolor5))
            btn_emergency.setTextColor(getResources().getColor(R.color.txtcolor1))
            hospital_rv.visibility = View.VISIBLE
            emergency_rv.visibility = View.GONE
        }

        back.setOnClickListener {
            finish()
        }

        emergency_rv.layoutManager = LinearLayoutManager(this)
        emergency_rv.setHasFixedSize(true)
        adapter = EmergencyAdapter(items, 0)
        emergency_rv.adapter = adapter

        hospital_rv.layoutManager = LinearLayoutManager(this)
        hospital_rv.setHasFixedSize(true)
        adapter2 = HospitalAdapter(items2, 0)
        hospital_rv.adapter = adapter2

    }
}