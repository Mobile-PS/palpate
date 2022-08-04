package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addmember_activity.*

class AddMemberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addmember_activity)

        linear_addchild_member.setOnClickListener {
            val intent = Intent(this, AddMemberDataActivity::class.java)
            startActivity(intent)
        }

        linear_addparent_member.setOnClickListener {
            val intent = Intent(this, SearchMemberActivity::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            finish()
        }
    }
}