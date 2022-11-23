package com.palpate

import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.text.Layout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.CategoryAdapter
import com.palpate.adapter.HospListAdapter
import com.palpate.adapter.NearbyHospListAdapter
import com.palpate.model.CategoryItemModel
import kotlinx.android.synthetic.main.hospitallist_activity.*

class HospitalListActivity : AppCompatActivity() {


    lateinit var listCategoryItemModel: ArrayList<CategoryItemModel>
    lateinit var hospListAdapter: HospListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hospitallist_activity)


        initUI()

        back.setOnClickListener {
            finish();
        }
    }

    fun initUI() {
        setCategoryData()

        hospital_rv.layoutManager = LinearLayoutManager(
            this
        )
        hospital_rv.setHasFixedSize(true)
        hospListAdapter = HospListAdapter(listCategoryItemModel)
        hospital_rv.adapter = hospListAdapter
    }

    private fun setCategoryData() {
        listCategoryItemModel = ArrayList<CategoryItemModel>()
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.hosp1,
                "Appolomedics Super Speciality Hospital"
            )
        )
        listCategoryItemModel.add(CategoryItemModel(R.drawable.hosp2, "Jagrani Hospital"))
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.hosp3,
                "Galaxy Super Speciality Hospital"
            )
        )
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.hosp1,
                "Appolomedics Super Speciality Hospital"
            )
        )
        listCategoryItemModel.add(CategoryItemModel(R.drawable.hosp2, "Jagrani Hospital"))
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.hosp3,
                "Galaxy Super Speciality Hospital"
            )
        )
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.hosp1,
                "Appolomedics Super Speciality Hospital"
            )
        )
        listCategoryItemModel.add(CategoryItemModel(R.drawable.hosp2, "Jagrani Hospital"))
        listCategoryItemModel.add(
            CategoryItemModel(
                R.drawable.hosp3,
                "Galaxy Super Speciality Hospital"
            )
        )


    }


}