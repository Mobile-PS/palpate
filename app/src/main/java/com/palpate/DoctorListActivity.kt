package com.palpate

import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.text.Layout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.CategoryAdapter
import com.palpate.adapter.DoctorListAdapter
import com.palpate.adapter.HospListAdapter
import com.palpate.adapter.NearbyHospListAdapter
import com.palpate.model.CategoryItemModel
import kotlinx.android.synthetic.main.doclist_activity.*

class DoctorListActivity : AppCompatActivity() {

    lateinit var doctorListAdapter: DoctorListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.doclist_activity)


        initUI()

        back.setOnClickListener {
            finish();
        }
    }

    fun initUI() {

        doctor_rv.layoutManager = LinearLayoutManager(
            this
        )
        doctor_rv.setHasFixedSize(true)
        doctorListAdapter = DoctorListAdapter()
        doctor_rv.adapter = doctorListAdapter
    }




}