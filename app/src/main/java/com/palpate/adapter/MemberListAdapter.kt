package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.AddMemberActivity
import com.palpate.EditMemberActivity
import com.palpate.R
import com.palpate.model.MemberItemModel
import kotlinx.android.synthetic.main.item_member.view.*
import kotlinx.android.synthetic.main.item_search_member.view.*
import kotlinx.android.synthetic.main.item_search_member.view.img_member
import kotlinx.android.synthetic.main.item_search_member.view.member_details
import kotlinx.android.synthetic.main.item_search_member.view.member_name


class MemberListAdapter(
    private var items: ArrayList<MemberItemModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<MemberListAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_member, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.member_name.text = items[position].name
        holder.itemView.member_details.text = items[position].gender
        holder.itemView.member_details2.text = items[position].age

        holder.itemView.img_member.setImageResource(items[position].icon)
        holder.itemView.more_icon.setOnClickListener {
            val intent = Intent(context, EditMemberActivity::class.java)
            context.startActivity(intent)
        }

    }
}