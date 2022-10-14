package com.palpate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.palpate.model.OrderStatus
import com.palpate.model.TimeLineModel
import com.palpate.timeline.ExampleTimeLineAdapter
import kotlinx.android.synthetic.main.packagehistory_details_activity.*


class HealthPackageHistoryDetailActivity : AppCompatActivity() {

    private lateinit var mAdapter: ExampleTimeLineAdapter
    private val mDataList = ArrayList<TimeLineModel>()
    private lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.packagehistory_details_activity)

        setDataListItems()
        initRecyclerView()

        back.setOnClickListener {
            finish()
        }

        btn_Visit_details.setOnClickListener {
            val intent = Intent(this, VisitDetailsActivity::class.java)
            intent.putExtra("key", "pacakge")
            startActivity(intent)
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