package com.palpate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.SerachMemberAdapter
import com.palpate.model.MemberItemModel
import kotlinx.android.synthetic.main.searchmember_activity.*


class SearchMemberActivity : AppCompatActivity() {


    private var items = arrayListOf(
        MemberItemModel(
            R.drawable.male_icon, "Harikesh Kumar",
            "Male", "50 years"
        )
    )
    private lateinit var adapter: SerachMemberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchmember_activity)

        memberlist_rv.layoutManager = LinearLayoutManager(this)
        memberlist_rv.setHasFixedSize(true)
        adapter = SerachMemberAdapter(items, 0)
        memberlist_rv.adapter = adapter

        back.setOnClickListener {
            finish()
        }

    }
}