package com.palpate

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.MedicalRecordAdapter
import com.palpate.model.MedicalRecordItemModel
import kotlinx.android.synthetic.main.qrcode_details_activity.*


class QrCodeDetailsActivity : AppCompatActivity() {

    private var items = arrayListOf(
        MedicalRecordItemModel(
            "Allergy",
            "April 2020 - August 2021   .   1 yr 5 mos",

            ),
        MedicalRecordItemModel(
            "Allergy",
            "April 2020 - August 2021   .   1 yr 5 mos",

            ),
        MedicalRecordItemModel(
            "Allergy",
            "April 2020 - August 2021   .   1 yr 5 mos",

            ),
        MedicalRecordItemModel(
            "Allergy",
            "April 2020 - August 2021   .   1 yr 5 mos",

            ),
        MedicalRecordItemModel(
            "Allergy",
            "April 2020 - August 2021   .   1 yr 5 mos",

            ),

        )

    private lateinit var adapter: MedicalRecordAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qrcode_details_activity)

        back.setOnClickListener {
            finish()
        }


        medicalreport_rv.layoutManager = LinearLayoutManager(this)
        medicalreport_rv.setHasFixedSize(true)
        adapter = MedicalRecordAdapter(items, 0)
        medicalreport_rv.adapter = adapter



    }


}