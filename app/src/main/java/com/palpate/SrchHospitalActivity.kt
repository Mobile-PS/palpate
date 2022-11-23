package com.palpate

import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.text.Layout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.CategoryAdapter
import com.palpate.adapter.NearbyHospListAdapter
import com.palpate.model.CategoryItemModel
import kotlinx.android.synthetic.main.srchhospital_activity.*

class SrchHospitalActivity : AppCompatActivity() {

    lateinit var listViews: ArrayList<ViewItem>
    lateinit var listCategoryItemModel: ArrayList<CategoryItemModel>
    lateinit var listCategoryItemModel1: ArrayList<CategoryItemModel>
    lateinit var nearbyHospItemModel: ArrayList<CategoryItemModel>
    lateinit var adapter: ViewPagerAdapter1
    lateinit var categoryadapter: CategoryAdapter
    lateinit var categoryadapter1: CategoryAdapter
    lateinit var nearbyHospListAdapter: NearbyHospListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.srchhospital_activity)


        initUI()

        back.setOnClickListener {
            finish();
        }
    }

    fun initUI() {
        listViews = ArrayList<ViewItem>()
        listViews.add(ViewItem(1, R.drawable.hospital_slider))
        listViews.add(ViewItem(2, R.drawable.hospital_slider))
        listViews.add(ViewItem(3, R.drawable.hospital_slider))
        listViews.add(ViewItem(4, R.drawable.hospital_slider))
        listViews.add(ViewItem(5, R.drawable.hospital_slider))

        adapter = ViewPagerAdapter1(applicationContext, listViews)
        view_pager.adapter = adapter
        pager_indicator.attachToPager(view_pager);

        setCategoryData()

        category_rv.layoutManager = GridLayoutManager(this, 3)
        category_rv.setHasFixedSize(true)
        categoryadapter = CategoryAdapter(listCategoryItemModel, 1)
        category_rv.adapter = categoryadapter

        category_rv1.layoutManager = GridLayoutManager(this, 3)
        category_rv1.setHasFixedSize(true)
        categoryadapter1 = CategoryAdapter(listCategoryItemModel1, 1)
        category_rv1.adapter = categoryadapter1

        hospital_rv.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        hospital_rv.setHasFixedSize(true)
        nearbyHospListAdapter = NearbyHospListAdapter(nearbyHospItemModel)
        hospital_rv.adapter = nearbyHospListAdapter
    }

    private fun setCategoryData() {
        listCategoryItemModel = ArrayList<CategoryItemModel>()
        listCategoryItemModel.add(CategoryItemModel(R.drawable.icon_eye_care, "Eye Care"))
        listCategoryItemModel.add(CategoryItemModel(R.drawable.icon_hair_loss, "Hair Loss"))
        listCategoryItemModel.add(CategoryItemModel(R.drawable.icon_ear_wax, "Ear wax"))
        listCategoryItemModel.add(CategoryItemModel(R.drawable.icon_cold_cough, "Cold & Cough"))
        listCategoryItemModel.add(CategoryItemModel(R.drawable.icon_sexual_health, "Sexual Health"))
        listCategoryItemModel.add(CategoryItemModel(R.drawable.icon_stomach_pain, "Stomach pain"))


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


        nearbyHospItemModel = ArrayList<CategoryItemModel>()
        nearbyHospItemModel.add(
            CategoryItemModel(
                R.drawable.img_near2,
                "Apollo Hospitals"
            )
        )
        nearbyHospItemModel.add(
            CategoryItemModel(
                R.drawable.img_near1,
                "Medanta The Medicity"
            )
        )
        nearbyHospItemModel.add(
            CategoryItemModel(
                R.drawable.img_near2,
                "Apollo Hospitals"
            )
        )
        nearbyHospItemModel.add(
            CategoryItemModel(
                R.drawable.img_near1,
                "Medanta The Medicity"
            )
        )
        nearbyHospItemModel.add(
            CategoryItemModel(
                R.drawable.img_near2,
                "Apollo Hospitals"
            )
        )
        nearbyHospItemModel.add(
            CategoryItemModel(
                R.drawable.img_near1,
                "Medanta The Medicity"
            )
        )

    }


}