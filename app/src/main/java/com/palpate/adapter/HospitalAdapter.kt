package com.palpate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.HospitalItemModel
import kotlinx.android.synthetic.main.item_hospital.view.*


class HospitalAdapter(
    private var items: ArrayList<HospitalItemModel>,
    private var currentPos: Int=0
) : RecyclerView.Adapter<HospitalAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hospital, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.hospital_name.text = items[position].title
        holder.itemView.hospital_details.text = items[position].description
        holder.itemView.img_hospital.setImageResource(items[position].icon)



    }


}