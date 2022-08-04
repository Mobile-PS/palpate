
package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

    }
}