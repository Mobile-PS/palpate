package com.palpate
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addoxygen_activity.*
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

      back.setOnClickListener {
          finish()
      }

        save.setOnClickListener {
            finish()
        }


    }
}