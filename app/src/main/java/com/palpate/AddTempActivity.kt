package com.palpate
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addheartrate_activity.*
import kotlinx.android.synthetic.main.addtemp_activity.*
import kotlinx.android.synthetic.main.addtemp_activity.id_txtcount
import kotlinx.android.synthetic.main.addtemp_activity.rel_view
import kotlinx.android.synthetic.main.addtemp_activity.txt_count
import kotlin.math.roundToInt

class AddTempActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addtemp_activity)

        rel_view.setDefaultSelectedValue(58f)
        id_txtcount.text="58"
        txt_count.text="58"
        rel_view.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                id_txtcount.text=value.roundToInt().toString();
                txt_count.text=value.roundToInt().toString();
            }
        })



    }
}