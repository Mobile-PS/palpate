package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.PatientListAdapter
import com.palpate.model.MemberItemModel
import kotlinx.android.synthetic.main.select_patient_activity.*


class PatientListActivity : AppCompatActivity() {


    private var items = arrayListOf(
        MemberItemModel(
            R.drawable.male_icon, "Rajesh Kumar",
            "Male", "25 years"
        ),
        MemberItemModel(
            R.drawable.male_icon, "Raj Kumar",
            "Male", "13 years"
        ),
        MemberItemModel(
            R.drawable.female_icon, "Archana",
            "Female", "6 years"
        )
    )

    private lateinit var adapter: PatientListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_patient_activity)

        patientlist_rv.layoutManager = LinearLayoutManager(this)
        patientlist_rv.setHasFixedSize(true)
        adapter = PatientListAdapter(items, 0,true)
        patientlist_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }

        linear_addpatient.setOnClickListener {
            val intent = Intent(this, AddPatientActivity::class.java)
            startActivity(intent)
        }

        btn_select_patient.setOnClickListener {
            finish()
        }


    }
}