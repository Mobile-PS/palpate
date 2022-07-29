package com.palpate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import kotlinx.android.synthetic.main.item_point.view.*


class PointHistoryAapter(
    //private var items: ArrayList<String>,
    private var currentPos: Int = 0
) : RecyclerView.Adapter<PointHistoryAapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_point, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        if ((position % 2) == 0) {
            holder.itemView.txt_status.text = "Debit"
            holder.itemView.txt_status.setTextColor(context.getResources().getColor(android.R.color.holo_red_light))

        } else {
            holder.itemView.txt_status.text = "Credit"
            holder.itemView.txt_status.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark))

        }


    }


}