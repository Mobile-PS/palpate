package com.palpate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.palpate.adapter.HelpAdapter
import com.palpate.model.CategoryItemModel
import com.palpate.model.OrderStatus
import com.palpate.model.TimeLineModel
import com.palpate.timeline.ExampleTimeLineAdapter
import kotlinx.android.synthetic.main.nursing_list_details.back
import kotlinx.android.synthetic.main.nursingorderhistory_details_activity.*
import kotlinx.android.synthetic.main.nursingorderhistory_details_activity.btn_Visit_details
import kotlinx.android.synthetic.main.nursingorderhistory_details_activity.btn_help
import kotlinx.android.synthetic.main.nursingorderhistory_details_activity.img_down_arrow
import kotlinx.android.synthetic.main.nursingorderhistory_details_activity.img_up_arrow
import kotlinx.android.synthetic.main.nursingorderhistory_details_activity.linear_description
import kotlinx.android.synthetic.main.nursingorderhistory_details_activity.orderstatus_rv
import kotlinx.android.synthetic.main.nursingorderhistory_details_activity.relative_description
import kotlinx.android.synthetic.main.packagehistory_details_activity.*


class NursingOrderHistoryDetailActivity : AppCompatActivity() {
//
    private lateinit var mAdapter: ExampleTimeLineAdapter
   private val mDataList = ArrayList<TimeLineModel>()
    private lateinit var mLayoutManager: LinearLayoutManager
    private var listCategoryItemModel = arrayListOf<CategoryItemModel>(
        CategoryItemModel(
            R.drawable.call_us,
            "Call Us"
        ),
        CategoryItemModel(
            R.drawable.callback_icon,
            "Call Back Request"
        ),
        CategoryItemModel(
            R.drawable.whatsapp_icon,
            "Whats App"
        ), CategoryItemModel(
            R.drawable.email_icon,
            "Email Us"
        )
    )
    lateinit var adapter: HelpAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nursingorderhistory_details_activity)

        setDataListItems()
        initRecyclerView()
        back.setOnClickListener {
            finish()
        }

        btn_Visit_details.setOnClickListener {
            val intent = Intent(this, VisitDetailsActivity::class.java)
            intent.putExtra("key", "visit")
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


        btn_help.setOnClickListener {
            openBottomHelp()
        }


    }

    private fun openBottomHelp() {
        val dialog =
            this?.let { it1 -> BottomSheetDialog(it1, R.style.MyBottomSheetDialogTheme) }
        val behavior = dialog?.behavior
        behavior?.state = BottomSheetBehavior.STATE_EXPANDED
        val view = layoutInflater.inflate(R.layout.helper_bottom_sheet, null)
        val recyclePlan = view.findViewById<RecyclerView>(R.id.help_rv)
        recyclePlan.layoutManager = GridLayoutManager(this, 3)
        recyclePlan.setHasFixedSize(true)
        adapter = HelpAdapter(listCategoryItemModel, 0)
        recyclePlan.adapter = adapter
        dialog?.setCancelable(true)
        dialog?.setContentView(view)
        dialog?.show()
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