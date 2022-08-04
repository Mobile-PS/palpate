package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addmember_activity.*

class AddMemberDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addmemberdata_activity)

        back.setOnClickListener {
            finish()
        }

    }
}