package com.palpate

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.add_patient_activity.*


class AddPatientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_patient_activity)

        back.setOnClickListener {
            finish()
        }

        btn_save_confirm.setOnClickListener {
            finish()
        }

        radio_group.setOnCheckedChangeListener({ radioGroup, optionId ->
            {
                when (optionId) {
                    R.id.radio1 -> {
                        edtxt_dob.visibility = View.VISIBLE
                        edtxt_age.visibility = View.GONE
                    }
                    R.id.radio2 -> {
                        edtxt_dob.visibility = View.GONE
                        edtxt_age.visibility = View.VISIBLE
                    }
                    // add more cases here to handle other buttons in the RadioGroup
                }
            }
        })

        radio_group.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId -> // checkedId is the RadioButton selected
            val rb: RadioButton = findViewById<View>(checkedId) as RadioButton
            if (rb.text == "Date of Birth") {
                edtxt_dob.visibility = View.VISIBLE
                edtxt_age.visibility = View.GONE
            } else if (rb.text == "Age") {
                edtxt_dob.visibility = View.GONE
                edtxt_age.visibility = View.VISIBLE
            }
        })
        img_male.setOnClickListener {
            img_male.setBackground(ContextCompat.getDrawable(this, R.drawable.image_bg2));
            img_female.setBackground(ContextCompat.getDrawable(this, R.drawable.image_bg1));
        }

        img_female.setOnClickListener {
            img_male.setBackground(ContextCompat.getDrawable(this, R.drawable.image_bg1));
            img_female.setBackground(ContextCompat.getDrawable(this, R.drawable.image_bg2));
        }
    }
}