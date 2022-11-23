package com.palpate

import android.graphics.Color
import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.text.Layout
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.CategoryAdapter
import com.palpate.adapter.NearbyHospListAdapter
import com.palpate.model.CategoryItemModel
import kotlinx.android.synthetic.main.hospitaldetails_activity.*

class HospitalDetailsActivity : AppCompatActivity() {

    lateinit var listViews: ArrayList<ViewItem>
    lateinit var listCategoryItemModel1: ArrayList<CategoryItemModel>
    lateinit var adapter: ViewPagerAdapter1
    lateinit var categoryadapter1: CategoryAdapter
    var selected = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hospitaldetails_activity)


        initUI()
        setButtonUI()

        back.setOnClickListener {
            finish();
        }
    }

    fun initUI() {
        listViews = ArrayList<ViewItem>()
        listViews.add(ViewItem(1, R.drawable.hosdetails_slider))
        listViews.add(ViewItem(2, R.drawable.hosdetails_slider))
        listViews.add(ViewItem(3, R.drawable.hosdetails_slider))
        listViews.add(ViewItem(4, R.drawable.hosdetails_slider))
        listViews.add(ViewItem(5, R.drawable.hosdetails_slider))

        adapter = ViewPagerAdapter1(applicationContext, listViews)
        view_pager.adapter = adapter
        pager_indicator.attachToPager(view_pager);

        setCategoryData()

        category_rv.layoutManager = GridLayoutManager(this, 2)
        category_rv.setHasFixedSize(true)
        categoryadapter1 = CategoryAdapter(listCategoryItemModel1, 2)
        category_rv.adapter = categoryadapter1

        btn_hosp_details.setOnClickListener {
            selected = 1
            setButtonUI()
        }

        btn_department.setOnClickListener {
            selected = 2
            setButtonUI()
        }

    }

    private fun setCategoryData() {
        listCategoryItemModel1 = ArrayList<CategoryItemModel>()
        listCategoryItemModel1.add(
            CategoryItemModel(
                R.drawable.icon_general_physician,
                "General Physician"
            )
        )
        listCategoryItemModel1.add(CategoryItemModel(R.drawable.icon_skin_hair, "Skin & Hair"))
        listCategoryItemModel1.add(
            CategoryItemModel(
                R.drawable.icon_child_specialist,
                "Child Specialist"
            )
        )
        listCategoryItemModel1.add(
            CategoryItemModel(
                R.drawable.icon_womens_health,
                "Women’s Health"
            )
        )
        listCategoryItemModel1.add(CategoryItemModel(R.drawable.icon_dental_care, "Dental Care"))
        listCategoryItemModel1.add(
            CategoryItemModel(
                R.drawable.icon_ear_nose_throat,
                "Ear Nose Throat"
            )
        )
        listCategoryItemModel1.add(CategoryItemModel(R.drawable.icon_homoeopathy, "Homoeopathy"))
        listCategoryItemModel1.add(
            CategoryItemModel(
                R.drawable.icon_bone_muccels,
                "Bone, Joint & Muccels"
            )
        )


    }


    private fun setButtonUI() {
        if (selected == 1) {
            btn_hosp_details.setBackground(ContextCompat.getDrawable(this, R.drawable.button_bg7));
            btn_hosp_details.setTextColor(Color.parseColor("#FFFFFF"))
            btn_department.setBackground(ContextCompat.getDrawable(this, R.drawable.button_bg8));
            btn_department.setTextColor(Color.parseColor("#5F5F5F"))
            category_rv.visibility = View.GONE
            lienar_details.visibility = View.VISIBLE
        } else {
            btn_department.setBackground(ContextCompat.getDrawable(this, R.drawable.button_bg7));
            btn_department.setTextColor(Color.parseColor("#FFFFFF"))
            btn_hosp_details.setBackground(ContextCompat.getDrawable(this, R.drawable.button_bg8));
            btn_hosp_details.setTextColor(Color.parseColor("#5F5F5F"))
            category_rv.visibility = View.VISIBLE
            lienar_details.visibility = View.GONE
        }
    }


}