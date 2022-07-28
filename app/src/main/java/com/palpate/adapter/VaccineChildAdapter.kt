package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.*
import com.palpate.model.VaccinationChildModel
import kotlinx.android.synthetic.main.item_vaccinationdetails.view.*


class VaccineChildAdapter(
    private var items: ArrayList<VaccinationChildModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<VaccineChildAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_vaccinationdetails, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.vaccination_title.text = items[position].title

        holder.itemView.vaccination_icon.setImageResource(items[position].icon)

        if (items[position].date == "NA") {
            holder.itemView.vaccination_date.visibility = View.GONE
            holder.itemView.vaccination_edit.visibility = View.GONE
            holder.itemView.linear_edit.visibility = View.VISIBLE
        } else {
            holder.itemView.vaccination_date.visibility = View.VISIBLE
            holder.itemView.vaccination_edit.visibility = View.VISIBLE
            holder.itemView.linear_edit.visibility = View.GONE
            holder.itemView.vaccination_date.text = items[position].date
        }


    }
}