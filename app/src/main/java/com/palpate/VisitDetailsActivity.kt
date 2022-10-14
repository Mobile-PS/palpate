package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.VisitDetailsAdapter
import kotlinx.android.synthetic.main.visit_details_activity.*


class VisitDetailsActivity : AppCompatActivity() {


    private lateinit var adapter: VisitDetailsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.visit_details_activity)
        val value = intent.getStringExtra("key")

        if(value=="pacakge"){
            txt_title.text="Package Details"
        }else{
            txt_title.text="Visit Details"
        }

        rv_visitdetails.layoutManager = LinearLayoutManager(this)
        rv_visitdetails.setHasFixedSize(true)
        adapter = VisitDetailsAdapter(value)
        rv_visitdetails.adapter = adapter

        back.setOnClickListener {
            finish()
        }



    }
}