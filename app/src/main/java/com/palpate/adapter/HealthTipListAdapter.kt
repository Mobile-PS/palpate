package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.HealthTipsDetailsActivity
import com.palpate.HealthTipsListActivity
import com.palpate.R
import kotlinx.android.synthetic.main.item_healthtips_artical.view.*
import kotlinx.android.synthetic.main.item_healthtips_categvideo_list.view.*
import kotlinx.android.synthetic.main.packagehistory_activity.view.*


class HealthTipListAdapter(
    private var items: ArrayList<Int>,
    private var currentPos: String
) : RecyclerView.Adapter<HealthTipListAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_healthtips_categvideo_list, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        if (currentPos=="video"){
            holder.itemView.btn_play.visibility=View.VISIBLE
        }else{
            holder.itemView.btn_play.visibility=View.GONE
        }
        holder.itemView.img_video.setImageResource(items[position]);

        holder.itemView.setOnClickListener {
            val intent = Intent(context, HealthTipsDetailsActivity::class.java)
            if (currentPos=="video") {
                intent.putExtra("type", "video")
            }else{
                intent.putExtra("type", "image")
            }
            context.startActivity(intent)
        }
    }
}