package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.AddHealthRecordActivity
import com.palpate.HealthTipsListActivity
import com.palpate.R
import kotlinx.android.synthetic.main.item_healthtips_artical.view.*


class HealthTipArticalAdapter(
    private var items: ArrayList<Int>,
    private var currentPos: Int
) : RecyclerView.Adapter<HealthTipArticalAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_healthtips_artical, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        holder.itemView.img_artical.setImageResource(items[position]);
        holder.itemView.setOnClickListener {
            val intent = Intent(context, HealthTipsListActivity::class.java)
            intent.putExtra("type", "image")
            context.startActivity(intent)
        }
    }
}