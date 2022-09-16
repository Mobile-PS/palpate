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
import com.palpate.model.HealthTipItemModel
import kotlinx.android.synthetic.main.item_healthtips_categvideo.view.*


class HealthTipCategoryVideoAdapter(
    private var items: ArrayList<HealthTipItemModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<HealthTipCategoryVideoAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_healthtips_categvideo, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        if (items[position].type == "video") {
            holder.itemView.linear_video.visibility = View.VISIBLE;
            holder.itemView.relative_categ.visibility = View.GONE;
            holder.itemView.img_video.setImageResource(items[position].icon);
            holder.itemView.txt_category_video.text = items[position].title;
        } else {
            holder.itemView.linear_video.visibility = View.GONE;
            holder.itemView.relative_categ.visibility = View.VISIBLE;
            holder.itemView.img_category.setImageResource(items[position].icon);
            holder.itemView.txt_category.text = items[position].title;
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, HealthTipsListActivity::class.java)
            if (items[position].type == "video") {
                intent.putExtra("type", "video")
            }else{
                intent.putExtra("type", "image")
            }
            context.startActivity(intent)
        }

    }
}