package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.palpate.adapter.BloodSugerAdapter
import com.palpate.model.BloodSugerItemModel
import kotlinx.android.synthetic.main.addbloodsugar_activity.*
import kotlin.math.roundToInt

class AddWeight1Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addweight1_activity)

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


        back.setOnClickListener {
            finish()
        }

        save.setOnClickListener {
            finish()
        }

    }
}