package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.palpate.model.OrderStatus
import com.palpate.model.TimeLineModel
import com.palpate.timeline.ExampleTimeLineAdapter
import kotlinx.android.synthetic.main.nursing_list_details.back
import kotlinx.android.synthetic.main.nursingorderhistory_details_activity.*


class NursingOrderHistoryDetailActivity : AppCompatActivity() {
//
    private lateinit var mAdapter: ExampleTimeLineAdapter
   private val mDataList = ArrayList<TimeLineModel>()
    private lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nursingorderhistory_details_activity)

        setDataListItems()
        initRecyclerView()
        back.setOnClickListener {
            finish()
        }



    }


    private fun setDataListItems() {
        mDataList.add(TimeLineModel("Order Placed", "06 Aug 2021 05:38 PM", OrderStatus.ACTIVE))
        mDataList.add(TimeLineModel("Order Accepted", "", OrderStatus.INACTIVE))
        mDataList.add(TimeLineModel("Assigned", "", OrderStatus.INACTIVE))
        mDataList.add(TimeLineModel("Order Completed", "", OrderStatus.INACTIVE))
    }

    private fun initRecyclerView() {
        mLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        orderstatus_rv.layoutManager = mLayoutManager
        mAdapter = ExampleTimeLineAdapter(mDataList)
        orderstatus_rv.adapter = mAdapter
    }

}