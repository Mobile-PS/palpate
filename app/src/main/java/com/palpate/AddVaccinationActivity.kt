package com.palpate
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addvaccination_activity.*

class AddVaccinationActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addvaccination_activity)


        back.setOnClickListener {
            finish()
        }


        save.setOnClickListener {
            finish()
        }

    }
}