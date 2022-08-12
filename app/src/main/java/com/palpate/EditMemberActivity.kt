package com.palpate

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.editmember_activity.*

class EditMemberActivity : AppCompatActivity() {
    val realtionarray = arrayOf<String?>("Father","Mother","Wife","Son","Daughter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editmember_activity)

        back.setOnClickListener {
            finish()
        }

        btn_remove.setOnClickListener {
            finish()
        }

        btn_submit.setOnClickListener {
            finish()
        }

        val realtionAdapter: ArrayAdapter<Any?> = ArrayAdapter<Any?>(this, R.layout.spinner_text, realtionarray)
        realtionAdapter.setDropDownViewResource(R.layout.spinner_text)
        spinner_relation.adapter = realtionAdapter
    }
}