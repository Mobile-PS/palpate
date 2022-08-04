package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.MemberListAdapter
import com.palpate.adapter.MemberListAdapter1
import com.palpate.model.MemberItemModel
import com.palpate.model.MemberItemModel1
import kotlinx.android.synthetic.main.myhealthstat_activity.*


class MyHealthStatsActivity : AppCompatActivity() {


    private var items = arrayListOf(
        MemberItemModel(
            R.drawable.male_icon, "Rajesh Kumar",
            "Male", "25 years"
        )
    )
    private var items2 = arrayListOf(
        MemberItemModel(
            R.drawable.male_icon, "Raj Kumar",
            "Male", "13 years"
        ),
        MemberItemModel(
            R.drawable.female_icon, "Archana",
            "Female", "6 years"
        )
    )
    private var items3 = arrayListOf(
        MemberItemModel1(
            R.drawable.male_icon, "Harikesh Kumar",
            "Father","Male", "50 years"
        ),
        MemberItemModel1(
            R.drawable.female_icon, "Monika Devi",
            "Mother" ,"Female", "45 years"
        )
    )
    private lateinit var adapter: MemberListAdapter
    private lateinit var adapter1: MemberListAdapter
    private lateinit var adapter2: MemberListAdapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myhealthstat_activity)

        self_rv.layoutManager = LinearLayoutManager(this)
        self_rv.setHasFixedSize(true)
        adapter = MemberListAdapter(items, 0)
        self_rv.adapter = adapter

        child_rv.layoutManager = LinearLayoutManager(this)
        child_rv.setHasFixedSize(true)
        adapter1 = MemberListAdapter(items2, 0)
        child_rv.adapter = adapter1

        parent_rv.layoutManager = LinearLayoutManager(this)
        parent_rv.setHasFixedSize(true)
        adapter2 = MemberListAdapter1(items3, 0)
        parent_rv.adapter = adapter2

        back.setOnClickListener {
            finish()
        }

        btn_add_member.setOnClickListener {

            val intent = Intent(this, AddMemberActivity::class.java)
            startActivity(intent)
        }
    }
}