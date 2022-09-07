package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.*
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
//            if (position == 0) {
//                val intent = Intent(context, AddWeight1Activity::class.java)
//                context.startActivity(intent)
//            } else if (position == 1) {
//                val intent = Intent(context, AddBMIActivity::class.java)
//                context.startActivity(intent)
//            } else if (position == 2) {
//                val intent = Intent(context, AddHeartRateActivity::class.java)
//                context.startActivity(intent)
//            } else if (position == 3) {
//                val intent = Intent(context, AddBPActivity::class.java)
//                context.startActivity(intent)
//            } else if (position == 4) {
//                val intent = Intent(context, AddTempActivity::class.java)
//                context.startActivity(intent)
//            } else if (position == 5) {
//                val intent = Intent(context, AddBloodSugerActivity::class.java)
//                context.startActivity(intent)
//            } else if (position == 6) {
//                val intent = Intent(context, AddHeightActivity::class.java)
//                context.startActivity(intent)
//            } else if (position == 7) {
//                val intent = Intent(context, AddOxygenActivity::class.java)
//                context.startActivity(intent)
//            } else if (position == 8) {
//                val intent = Intent(context, VaccinationDetailsActivity::class.java)
//                context.startActivity(intent)
//            }

            if (items[position].title == "Weight") {
                val intent = Intent(context, AddWeight1Activity::class.java)
               context.startActivity(intent)
            } else if (items[position].title == "BMI") {
                val intent = Intent(context, AddBMIActivity::class.java)
               context.startActivity(intent)
            } else if (items[position].title == "Heart Rate") {
                val intent = Intent(context, AddHeartRateActivity::class.java)
               context.startActivity(intent)
            } else if (items[position].title == "Blood Pressure") {
                val intent = Intent(context, AddBPActivity::class.java)
               context.startActivity(intent)
            } else if (items[position].title == "Temperature") {
                val intent = Intent(context, AddTempActivity::class.java)
               context.startActivity(intent)
            } else if (items[position].title == "Blood Sugar") {
                val intent = Intent(context, AddBloodSugerActivity::class.java)
               context.startActivity(intent)
            } else if (items[position].title == "Height") {
                val intent = Intent(context, AddHeightActivity::class.java)
               context.startActivity(intent)
            } else if (items[position].title == "Oxygen Saturation") {
                val intent = Intent(context, AddOxygenActivity::class.java)
               context.startActivity(intent)
            }

        }

    }
}