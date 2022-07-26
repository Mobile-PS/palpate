package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.palpate.adapter.BloodSugerAdapter
import com.palpate.model.BloodSugerItemModel
import kotlinx.android.synthetic.main.addbloodsugar_activity.*
import kotlin.math.roundToInt

class AddBloodSugerActivity : AppCompatActivity() {
    private var items = arrayListOf(
        BloodSugerItemModel(
            R.drawable.dish_icon, "Fasting",
        ),
        BloodSugerItemModel(
            R.drawable.dish_icon1, "Pre-meal",
        ),
        BloodSugerItemModel(
            R.drawable.dish_icon1, "Post-meal",
        ),

        BloodSugerItemModel(
            R.drawable.night_icon, "Before Sleep",
        ),

        BloodSugerItemModel(
            R.drawable.random_icon, "Random",
        ),

        BloodSugerItemModel(
            R.drawable.drop_icon, "HbA1c",
        ),

        )

    private lateinit var adapter: BloodSugerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addbloodsugar_activity)

        rel_view.setDefaultSelectedValue(58f)
        id_txtcount.text = "58"
        txt_count.text = "58"
        txt_count1.text = "58"
        rel_view.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                id_txtcount.text = value.roundToInt().toString();
                txt_count.text = value.roundToInt().toString();
                txt_count1.text = value.roundToInt().toString();
            }
        })

        blsugar_rv.layoutManager = GridLayoutManager(this, 3);
        blsugar_rv.setHasFixedSize(true)
        adapter = BloodSugerAdapter(items, 0)
        blsugar_rv.adapter = adapter


    }
}