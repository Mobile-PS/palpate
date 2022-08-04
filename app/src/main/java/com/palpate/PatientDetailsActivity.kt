package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.AddressListAdapter
import com.palpate.adapter.PatientListAdapter
import com.palpate.model.MemberItemModel
import kotlinx.android.synthetic.main.patient_detail_activity.*


class PatientDetailsActivity : AppCompatActivity() {
    private lateinit var addressadapter: AddressListAdapter

    private var items = arrayListOf(
        MemberItemModel(
            R.drawable.male_icon, "Rajesh Kumar",
            "Male", "25 years"
        ),
    )

    private lateinit var adapter: PatientListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.patient_detail_activity)

        addresslist_rv.layoutManager = LinearLayoutManager(this)
        addresslist_rv.setHasFixedSize(true)
        addressadapter = AddressListAdapter( 0,false,1)
        addresslist_rv.adapter = addressadapter


        patientlist_rv.layoutManager = LinearLayoutManager(this)
        patientlist_rv.setHasFixedSize(true)
        adapter = PatientListAdapter(items, 0,false)
        patientlist_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }

        linear_addpatient.setOnClickListener {
            val intent = Intent(this, PatientListActivity::class.java)
            startActivity(intent)
        }

        linear_addaddress.setOnClickListener {
            val intent = Intent(this, AddressListActivity::class.java)
            startActivity(intent)
        }

        btn_proceed.setOnClickListener {
            val intent = Intent(this, CardActivity::class.java)
            startActivity(intent)
        }
    }
}