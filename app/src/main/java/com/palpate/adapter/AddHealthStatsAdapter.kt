package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.AddWeightActivity
import com.palpate.EditMemberActivity
import com.palpate.R
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.item_add_health_stats.view.*


class AddHealthStatsAdapter(
    private var items: ArrayList<HealthStateItemModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<AddHealthStatsAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_add_health_stats, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.stat_title.text = items[position].title

        holder.itemView.stats_iconstart.setImageResource(items[position].icon)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, AddWeightActivity::class.java)
            context.startActivity(intent)
        }

    }
}