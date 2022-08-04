package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.CategoryAdapter
import com.palpate.adapter.EmergencyAdapter
import com.palpate.model.CategoryItemModel
import kotlinx.android.synthetic.main.homecarenursing_activity.*

class HomeNursingActivity : AppCompatActivity() {

    lateinit var listViews: ArrayList<ViewItem>
    lateinit var listCategoryItemModel: ArrayList<CategoryItemModel>
    lateinit var adapter: ViewPagerAdapter1
    lateinit var categoryadapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homecarenursing_activity)


        initUI()

        back.setOnClickListener {
            finish();
        }
    }

    fun initUI() {
        listViews = ArrayList<ViewItem>()
        listViews.add(ViewItem(1, R.drawable.slide_img))
        listViews.add(ViewItem(2, R.drawable.slide_img))
        listViews.add(ViewItem(3, R.drawable.slide_img))
        listViews.add(ViewItem(4, R.drawable.slide_img))
        listViews.add(ViewItem(5, R.drawable.slide_img))

        adapter = ViewPagerAdapter1(applicationContext, listViews)
        view_pager.adapter = adapter
        pager_indicator.attachToPager(view_pager);


        listCategoryItemModel = ArrayList<CategoryItemModel>()
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.preventive_hc_icon,
                "Preventive Health Care"
            )
        )
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.general_nc_icon,
                "General Nursing Care"
            )
        )
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.palliative_care_icon,
                "Palliative Care"
            )
        )
        listCategoryItemModel.add(CategoryItemModel(R.drawable.critical_care_icon, "Critical Care"))
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.past_surgical_care_icon,
                "Past Surgical Care"
            )
        )
        listCategoryItemModel.add(CategoryItemModel(R.drawable.physiotherapy_icon, "Physiotherapy"))
        listCategoryItemModel.add(CategoryItemModel(R.drawable.dietician_icon, "Dietician"))
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.fitness_instructor_icon,
                "Fitness Instructor"
            )
        )

        category_rv.layoutManager = GridLayoutManager(this, 2)
        category_rv.setHasFixedSize(true)
        categoryadapter = CategoryAdapter(listCategoryItemModel, 0)
        category_rv.adapter = categoryadapter
    }


}