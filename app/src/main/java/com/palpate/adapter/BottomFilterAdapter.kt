package com.palpate.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import kotlinx.android.synthetic.main.item_bottom_filter.view.*


class BottomFilterAdapter(
    private var items: ArrayList<String>,
    private var currentPos: Int,
) : RecyclerView.Adapter<BottomFilterAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_bottom_filter, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        holder.itemView.txt_title.text = items[position];
        holder.itemView.radio_btn.setOnCheckedChangeListener(null)
        holder.itemView.radio_btn.setChecked(position === currentPos)
        holder.itemView.radio_btn.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            currentPos = position
            notifyDataSetChanged()
        })


    }


}