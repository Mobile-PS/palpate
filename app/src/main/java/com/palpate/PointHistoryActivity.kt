package com.palpate

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.PointHistoryAapter
import kotlinx.android.synthetic.main.pointhistory_activity.*

class PointHistoryActivity : AppCompatActivity() {
    private lateinit var adapter: PointHistoryAapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pointhistory_activity)


        btn_tablepoint.setOnClickListener {
            btn_tablepoint.setBackgroundColor(getResources().getColor(R.color.txtcolor3))
            btn_tablepoint.setTextColor(getResources().getColor(R.color.white))
            btn_usedponit.setBackgroundColor(getResources().getColor(R.color.dashcolor5))
            btn_usedponit.setTextColor(getResources().getColor(R.color.txtcolor1))
        }

        btn_usedponit.setOnClickListener {
            btn_usedponit.setBackgroundColor(getResources().getColor(R.color.txtcolor3))
            btn_usedponit.setTextColor(getResources().getColor(R.color.white))
            btn_tablepoint.setBackgroundColor(getResources().getColor(R.color.dashcolor5))
            btn_tablepoint.setTextColor(getResources().getColor(R.color.txtcolor1))
        }


        back.setOnClickListener {
            finish()
        }


        ponit_rv.layoutManager = LinearLayoutManager(this)
        ponit_rv.setHasFixedSize(true)
        adapter = PointHistoryAapter(0)
        ponit_rv.adapter = adapter

    }
}