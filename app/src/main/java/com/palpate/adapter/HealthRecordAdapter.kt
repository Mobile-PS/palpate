package com.palpate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.HealthRecordItemModel
import kotlinx.android.synthetic.main.item_health_record.view.*


class HealthRecordAdapter(
    private var items: ArrayList<HealthRecordItemModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<HealthRecordAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_health_record, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.healthrecord_title.text = items[position].title
        holder.itemView.healthrecord_date.text = items[position].date
        holder.itemView.healthrecord_category.text = items[position].category

        holder.itemView.healthrecord_icon.setImageResource(items[position].icon)

    }
}