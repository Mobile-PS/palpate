package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.HealthTipArticalAdapter
import com.palpate.adapter.HealthTipListAdapter
import com.palpate.model.HealthTipItemModel
import kotlinx.android.synthetic.main.health_tips_detail_list.*


class HealthTipsListActivity : AppCompatActivity() {

    private var itemsArtical = arrayListOf(
        R.drawable.artical_1,
        R.drawable.artical_2,
        R.drawable.health_tip_cat1,
        R.drawable.health_tip_cat2,
        R.drawable.health_tip_cat3,
        R.drawable.health_tip_cat4,
        R.drawable.health_tip_cat5,
        R.drawable.health_tip_cat6
    )

    private var itemsVideo = arrayListOf(
        R.drawable.health_tip_video1,
        R.drawable.health_tip_video2,
        R.drawable.health_tip_video3,
        R.drawable.health_tip_video1,
        R.drawable.health_tip_video2,
        R.drawable.health_tip_video3,
        R.drawable.health_tip_video1,
        R.drawable.health_tip_video2,
        R.drawable.health_tip_video3,
    )


    private lateinit var adapterArtical: HealthTipListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_tips_detail_list)

        back.setOnClickListener {
            finish()
        }

        tips_rv.layoutManager = LinearLayoutManager(this)
        tips_rv.setHasFixedSize(true)
        val intent = getIntent();
        val myValue = intent.getStringExtra("type")

        if (myValue != null) {
            if (myValue == "video") {
                adapterArtical = HealthTipListAdapter(itemsVideo, myValue)
            } else {

                adapterArtical = HealthTipListAdapter(itemsArtical, myValue)
            }
        }
        tips_rv.adapter = adapterArtical


    }


}