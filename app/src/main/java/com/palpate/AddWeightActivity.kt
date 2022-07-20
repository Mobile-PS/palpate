package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.WeightItemAdapter
import com.palpate.model.WeigthItemModel
import kotlinx.android.synthetic.main.addweight_activity.*


class AddWeightActivity : AppCompatActivity() {
    private var items = arrayListOf(
        WeigthItemModel(
            "15 July 2021",
            "08:13 AM",
            "80.2"
        ),
        WeigthItemModel(
            "15 July 2021",
            "11:16 AM",
            "80.3"
        ),
        WeigthItemModel(
            "16 July 2021",
            "01:19 PM",
            "80.3"
        ),
        WeigthItemModel(
            "15 July 2021",
            "08:13 AM",
            "80.2"
        ),
        WeigthItemModel(
            "17 July 2021",
            "05:13 PM",
            "80.2"
        ),
        WeigthItemModel(
            "18 July 2021",
            "09:40 AM",
            "80.2"
        ),
        WeigthItemModel(
            "18 July 2021",
            "07:52 PM",
            "80.4"
        ),

        )

    private lateinit var adapter: WeightItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addweight_activity)

        weightItem_rv.layoutManager = LinearLayoutManager(this)
        weightItem_rv.setHasFixedSize(true)
        adapter = WeightItemAdapter(items, 0)
        weightItem_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }

    }


}