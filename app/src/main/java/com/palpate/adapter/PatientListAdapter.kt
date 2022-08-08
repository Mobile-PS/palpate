package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.palpate.EditMemberActivity
import com.palpate.R
import com.palpate.model.MemberItemModel
import com.palpate.model.PatientListModel
import kotlinx.android.synthetic.main.addresslist_item.view.*
import kotlinx.android.synthetic.main.patientlist_item.view.*
import kotlinx.android.synthetic.main.patientlist_item.view.member_details
import kotlinx.android.synthetic.main.patientlist_item.view.member_name
import kotlinx.android.synthetic.main.patientlist_item.view.more_icon
import kotlinx.android.synthetic.main.patientlist_item.view.radio_btn


class PatientListAdapter(
    private var items: ArrayList<MemberItemModel>,
    private var currentPos: Int,
    private var radiocheck: Boolean
) : RecyclerView.Adapter<PatientListAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.patientlist_item, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        if (radiocheck == true) {
            holder.itemView.radio_btn.visibility = View.VISIBLE
        } else {
            holder.itemView.radio_btn.visibility = View.GONE
        }

        holder.itemView.member_name.text = items[position].name
        holder.itemView.member_details.text = items[position].gender
        holder.itemView.member_details2.text = items[position].age
        holder.itemView.img_member.setImageResource(items[position].icon)
        holder.itemView.more_icon.setOnClickListener {
            val intent = Intent(context, EditMemberActivity::class.java)
            context.startActivity(intent)
        }


        holder.itemView.radio_btn.setOnCheckedChangeListener(null)
        holder.itemView.radio_btn.setChecked(position === currentPos)
        holder.itemView.radio_btn.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            currentPos = position
            notifyDataSetChanged()
        })

    }
}