package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.NursingPackageAdapter
import kotlinx.android.synthetic.main.nursing_list_activity.*

class NursingListActivity : AppCompatActivity() {

    lateinit var adapter: NursingPackageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nursing_list_activity)
        initUI()
        back.setOnClickListener {
            finish();
        }
    }

    fun initUI() {
        healthpackage_rv.layoutManager = LinearLayoutManager(this)
        healthpackage_rv.setHasFixedSize(true)
        adapter = NursingPackageAdapter(0)
        healthpackage_rv.adapter = adapter
    }

}