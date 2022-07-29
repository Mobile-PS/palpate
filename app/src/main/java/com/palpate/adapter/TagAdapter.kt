package com.palpate.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import kotlinx.android.synthetic.main.item_tag.view.*


class TagAdapter(
    private var items: ArrayList<String>,
    private var currentPos: Int=0
) : RecyclerView.Adapter<TagAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tag, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.txt_tag.text = items[position]

        setButtonView(holder.itemView.linear_tag, position, holder.itemView.txt_tag)

        holder.itemView.linear_tag.setOnClickListener {
            currentPos=position
            setButtonView(holder.itemView.linear_tag,position,holder.itemView.txt_tag)
            notifyDataSetChanged()
        }

    }

    private fun setButtonView(btnTimeline: LinearLayout, position: Int, txtTag: TextView) {
        if (currentPos == position) {
            btnTimeline?.setBackgroundResource(R.drawable.tag_bg2);
            txtTag?.setTextColor(Color.parseColor("#FFFFFF"))
        } else {
            btnTimeline?.setBackgroundResource(R.drawable.tag_bg);
            txtTag?.setTextColor(Color.parseColor("#5F5F5F"))
        }
    }
}