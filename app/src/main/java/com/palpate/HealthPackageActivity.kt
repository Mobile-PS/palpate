package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.HealthPackageAdapter
import com.palpate.model.CategoryItemModel
import kotlinx.android.synthetic.main.health_pacakage_activity.*

class HealthPackageActivity : AppCompatActivity() {

    lateinit var adapter: HealthPackageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_pacakage_activity)
        initUI()
        back.setOnClickListener {
            finish();
        }
    }

    fun initUI() {
        healthpackage_rv.layoutManager = LinearLayoutManager(this)
        healthpackage_rv.setHasFixedSize(true)
        adapter = HealthPackageAdapter(0)
        healthpackage_rv.adapter = adapter
    }

}