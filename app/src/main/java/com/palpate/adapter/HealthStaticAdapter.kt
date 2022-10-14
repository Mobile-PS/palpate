package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.*
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.item_health_stats.view.*


class HealthStaticAdapter(
    private var items: ArrayList<HealthStateItemModel>,
    private var currentPos: Int,
    var status: Boolean
) : RecyclerView.Adapter<HealthStaticAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_health_stats, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.stat_title.text = items[position].title
        holder.itemView.stat_date.text = items[position].date
        holder.itemView.stat_count.text = items[position].count

        holder.itemView.stats_icon.setImageResource(items[position].icon)

        if(status) {
            holder.itemView.setOnClickListener {

                if (position == 8) {
                    val intent = Intent(context, VaccinationDetailsActivity::class.java)
                    context.startActivity(intent)
                } else {

                    val intent = Intent(context, AddWeightActivity::class.java)
                    intent.putExtra("title", items[position].title)
                    context.startActivity(intent)

                }
                /* val intent = Intent(context, AddHealthStatsActivity::class.java)
            context.startActivity(intent)*/
            }
        }

    }
}