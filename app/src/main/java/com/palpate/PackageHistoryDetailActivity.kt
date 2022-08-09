package com.palpate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.packagehistory_details_activity.*


class PackageHistoryDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.packagehistory_details_activity)

        back.setOnClickListener {
            finish()
        }

        relative_description.setOnClickListener {
            if (img_down_arrow.visibility == View.VISIBLE) {
                img_down_arrow.visibility = View.GONE
                img_up_arrow.visibility = View.VISIBLE
                linear_description.visibility = View.VISIBLE
            } else if (img_up_arrow.visibility == View.VISIBLE) {
                img_down_arrow.visibility = View.VISIBLE
                img_up_arrow.visibility = View.GONE
                linear_description.visibility = View.GONE
            }
        }



    }


}