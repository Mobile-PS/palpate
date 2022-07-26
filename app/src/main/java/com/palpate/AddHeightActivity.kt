package com.palpate


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addheight_activity.*
import kotlin.math.roundToInt

class AddHeightActivity : AppCompatActivity() {
    var feetcount = 0
    var inchcount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addheight_activity)

        feetcount = 5
        inchcount = 8
        setTextContent()

        rel_view.setDefaultSelectedValue(5F)
        rel_view.setMaxValue(15F)
        rel_view.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                feetcount = value.roundToInt()
                setTextContent()
            }
        })

        rel_view1.setDefaultSelectedValue(8F)
        rel_view1.setMaxValue(15F)
        rel_view1.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                inchcount = value.roundToInt()
                setTextContent()
            }
        })


    }

    private fun setTextContent() {
        txt_count1.text = "$feetcount' $inchcount''"
        txt_count.text = "$feetcount' $inchcount''"
        id_txtcount.text = feetcount.toString()
        id_txtcount1.text = inchcount.toString()
    }
}