package com.palpate
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addheartrate_activity.*
import kotlinx.android.synthetic.main.addoxygen_activity.*
import kotlinx.android.synthetic.main.addoxygen_activity.id_txtcount
import kotlinx.android.synthetic.main.addoxygen_activity.rel_view
import kotlinx.android.synthetic.main.addoxygen_activity.txt_count
import kotlin.math.roundToInt

class AddOxygenActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addoxygen_activity)

        rel_view.setDefaultSelectedValue(93f)
        id_txtcount.text="93"
        txt_count.text="93"
        rel_view.setChooseValueChangeListener(object : RulerView.OnChooseResulterListener {
            override fun onChooseValueChange(value: Float) {
                id_txtcount.text=value.roundToInt().toString();
                txt_count.text=value.roundToInt().toString();
            }
        })



    }
}