package com.palpate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.NursingPackageAdapter
import com.palpate.adapter.OrganListAdapter
import kotlinx.android.synthetic.main.organ_donation_activity.*


class OrganDonationActivity : AppCompatActivity() {
    val cityarray = arrayOf<String?>("Select City")
    val statearray = arrayOf<String?>("Select State")
    val bloodgrpArray = arrayOf<String?>("Select Blood Group")
    private var items = arrayListOf(
        "All Organs",
        "Liver",
        "Corneas (Eyes)",
        "Pancreas",
        "Kidneys",
        "Small Intestine",
        "Heart",
        "Skin",
        "Lungs"
    )
    lateinit var adapter: OrganListAdapter
    private var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.organ_donation_activity)

        back.setOnClickListener {
            finish()
        }

        linear_personal_details.visibility = View.VISIBLE
        linear_address_details.visibility = View.GONE
        linear_organ_details.visibility = View.GONE
        btn_contiune.text = "Next"
        position = 0

        btn_contiune.setOnClickListener {
            when (position) {
                0 -> {
                    linear_personal_details.visibility = View.GONE
                    linear_address_details.visibility = View.VISIBLE
                    linear_organ_details.visibility = View.GONE
                    btn_contiune.text = "Next"
                    position = 1
                    step_view.done(false)
                    step_view.go(position, true)
                }
                1 -> {
                    linear_personal_details.visibility = View.GONE
                    linear_address_details.visibility = View.GONE
                    linear_organ_details.visibility = View.VISIBLE
                    btn_contiune.text = "Submit"
                    position = 2
                    step_view.done(false)
                    step_view.go(position, true)
                }
                2 -> {
                   finish()
                    val i = Intent(this, OrganDonationSuccessActivity::class.java)
                    startActivity(i)
                }
            }

        }


        organ_rv.layoutManager = GridLayoutManager(this,2)
        organ_rv.setHasFixedSize(true)
        adapter = OrganListAdapter(items)
        organ_rv.adapter = adapter

        val cityAdapter: ArrayAdapter<Any?> =
            ArrayAdapter<Any?>(this, R.layout.spinner_text1, cityarray)
        cityAdapter.setDropDownViewResource(R.layout.spinner_text1)
        spinner_city.adapter = cityAdapter

        val stateAdapter: ArrayAdapter<Any?> =
            ArrayAdapter<Any?>(this, R.layout.spinner_text1, statearray)
        stateAdapter.setDropDownViewResource(R.layout.spinner_text1)
        spinner_state.adapter = stateAdapter

        val bloodgrpAdapter: ArrayAdapter<Any?> =
            ArrayAdapter<Any?>(this, R.layout.spinner_text1, bloodgrpArray)
        bloodgrpAdapter.setDropDownViewResource(R.layout.spinner_text1)
        spinner_bloodgrp.adapter = bloodgrpAdapter
    }
}