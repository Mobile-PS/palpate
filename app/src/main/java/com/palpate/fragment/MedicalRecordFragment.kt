package com.palpate.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.AddMedicalHistoryActivity
import com.palpate.DrawerActivity
import com.palpate.R
import com.palpate.adapter.HealthRecordAdapter
import com.palpate.adapter.MedicalRecordAdapter
import com.palpate.model.HealthRecordItemModel
import com.palpate.model.MedicalRecordItemModel
import kotlinx.android.synthetic.main.medicalhistory_fragment.*

class MedicalRecordFragment : Fragment() {
    private var items = arrayListOf(
        MedicalRecordItemModel(
            "Allergy",
            "April 2020 - August 2021   ●   1 yr 5 mos",

            ),
        MedicalRecordItemModel(
            "Allergy",
            "April 2020 - August 2021   ●   1 yr 5 mos",

            ),
        MedicalRecordItemModel(
            "Allergy",
            "April 2020 - August 2021   ●   1 yr 5 mos",

            ),
        MedicalRecordItemModel(
            "Allergy",
            "April 2020 - August 2021   ●   1 yr 5 mos",

            ),
        MedicalRecordItemModel(
            "Allergy",
            "April 2020 - August 2021   ●   1 yr 5 mos",

            ),

        )

    private lateinit var adapter: MedicalRecordAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.medicalhistory_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        medicalreport_rv.layoutManager = LinearLayoutManager(context)
        medicalreport_rv.setHasFixedSize(true)
        adapter = MedicalRecordAdapter(items, 0)
        medicalreport_rv.adapter = adapter

        btn_add_medical_report.setOnClickListener {
            val intent = Intent(context, AddMedicalHistoryActivity::class.java)
            startActivity(intent)
        }

    }
}