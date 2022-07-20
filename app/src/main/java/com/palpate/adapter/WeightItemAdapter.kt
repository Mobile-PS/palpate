package com.palpate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.WeigthItemModel
import kotlinx.android.synthetic.main.item_weight.view.*


class WeightItemAdapter(
    private var items: ArrayList<WeigthItemModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<WeightItemAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_weight, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.weight_date.text = items[position].date
        holder.itemView.weight_time.text = items[position].time
        holder.itemView.weight_count.text = items[position].count


    }
}