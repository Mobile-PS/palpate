package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.*
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.item_health_stats_setting.view.*


class SettingHealthStatesAdapter(
    private var items: ArrayList<HealthStateItemModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<SettingHealthStatesAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_health_stats_setting, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.stat_title.text = items[position].title
        holder.itemView.stats_icon.setImageResource(items[position].icon)

    }
}