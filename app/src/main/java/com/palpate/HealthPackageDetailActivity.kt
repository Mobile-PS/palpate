package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.WeightItemButtonAdapter
import kotlinx.android.synthetic.main.health_package_details.*


class HealthPackageDetailActivity : AppCompatActivity() {

    private var items2 = arrayListOf("Includes", "Description", "Instructions");
    private lateinit var adapter2: WeightItemButtonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_package_details)


        itemButton_rv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        itemButton_rv.setHasFixedSize(true)
        adapter2 = WeightItemButtonAdapter(items2, 0)
        itemButton_rv.adapter = adapter2

        back.setOnClickListener {
            finish()
        }

        btn_book_now.setOnClickListener {
            val intent = Intent(this, PatientDetailsActivity::class.java)
            startActivity(intent)
        }


    }


}