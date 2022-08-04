package com.palpate


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addbp_activity.*
import kotlin.math.roundToInt

class AddBPActivity : AppCompatActivity() {
    var systoliccount = 0
    var diastoliccount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addbp_activity)

        systoliccount = 123
        diastoliccount = 78
        setTextContent()

        rel_view.setDefaultSelectedValue(123F)
        rel_view.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                systoliccount = value.roundToInt()
                setTextContent()
            }
        })

        rel_view1.setDefaultSelectedValue(78F)
        rel_view1.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                diastoliccount = value.roundToInt()
                setTextContent()
            }
        })

        back.setOnClickListener {
            finish()
        }

        save.setOnClickListener {
            finish()
        }

    }

    private fun setTextContent() {
        txt_count1.text = "$systoliccount/$diastoliccount"
        txt_count.text = "$systoliccount/$diastoliccount"
        id_txtcount.text = systoliccount.toString()
        id_txtcount1.text = diastoliccount.toString()
    }
}