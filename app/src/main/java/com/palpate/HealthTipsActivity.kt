package com.palpate

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.palpate.adapter.BottomFilterAdapter
import com.palpate.adapter.HealthTipArticalAdapter
import com.palpate.adapter.HealthTipCategoryVideoAdapter
import com.palpate.model.HealthStateItemModel
import com.palpate.model.HealthTipItemModel
import kotlinx.android.synthetic.main.health_tips_activity.*


class HealthTipsActivity : AppCompatActivity() {

    private var itemsArtical = arrayListOf(
        R.drawable.artical_1, R.drawable.artical_2, R.drawable.artical_1, R.drawable.artical_2
    )

    private var itemFilter = arrayListOf(
       "Fitness","Nutrition","Mental Health","Staying Health","Mind & Mood","Diet"
    )

    lateinit var bottomAdapter: BottomFilterAdapter
    private var itemsCategory = arrayListOf(
        HealthTipItemModel(
            R.drawable.health_tip_cat1, "Fitness",
            "category",
        ),
        HealthTipItemModel(
            R.drawable.health_tip_cat2, "Nutrition",
            "category",
        ),
        HealthTipItemModel(
            R.drawable.health_tip_cat3, "Mental Health",
            "category",
        ),
        HealthTipItemModel(
            R.drawable.health_tip_cat4, "Staying Healthy",
            "category",
        ),
        HealthTipItemModel(
            R.drawable.health_tip_cat5, "Mind & Mood",
            "category",
        ),
        HealthTipItemModel(
            R.drawable.health_tip_cat6, "Diet",
            "category",
        ),
    )

    private var itemsVideo = arrayListOf(
        HealthTipItemModel(
            R.drawable.health_tip_video1, "Fitness",
            "video",
        ),
        HealthTipItemModel(
            R.drawable.health_tip_video2, "Diet",
            "video",
        ),
        HealthTipItemModel(
            R.drawable.health_tip_video3, "Mind & Mood",
            "video",
        ),

        )

    private lateinit var adapterArtical: HealthTipArticalAdapter

    private lateinit var adapterCategory: HealthTipCategoryVideoAdapter
    private lateinit var adapterVideo: HealthTipCategoryVideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_tips_activity)

        back.setOnClickListener {
            finish()
        }

        artical_rv.layoutManager = LinearLayoutManager( this,
            LinearLayoutManager.HORIZONTAL,
            false)
        artical_rv.setHasFixedSize(true)
        adapterArtical = HealthTipArticalAdapter(itemsArtical, 0)
        artical_rv.adapter = adapterArtical

        artical_category.layoutManager = GridLayoutManager(this, 3);
        artical_category.setHasFixedSize(true)
        adapterCategory = HealthTipCategoryVideoAdapter(itemsCategory, 0)
        artical_category.adapter = adapterCategory

        artical_Videos.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        artical_Videos.setHasFixedSize(true)
        adapterVideo = HealthTipCategoryVideoAdapter(itemsVideo, 0)
        artical_Videos.adapter = adapterVideo

        img_filter.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val behavior = dialog?.behavior
            behavior?.state = BottomSheetBehavior.STATE_EXPANDED
            val view = layoutInflater.inflate(R.layout.filter_bottom_sheet, null)
            val recyclePlan = view.findViewById<RecyclerView>(R.id.recycler_filtercateg)
            var close=view.findViewById<ImageView>(R.id.img_close)
            recyclePlan.layoutManager = LinearLayoutManager(this)
            recyclePlan.setHasFixedSize(true)
            bottomAdapter = BottomFilterAdapter(itemFilter,0)
            recyclePlan.adapter = bottomAdapter
            close.setOnClickListener {
                dialog?.dismiss()
            }
            dialog?.setCancelable(true)
            dialog?.setContentView(view)
            dialog?.show()
        }

    }


}