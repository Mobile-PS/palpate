package com.palpate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.SpecialistDataModel
import kotlinx.android.synthetic.main.row_item.view.*


class SpecialistAdapter(
    private var items: ArrayList<SpecialistDataModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<SpecialistAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.checkBox.text = items[position].title
        holder.itemView.checkBox.isChecked = items[position].check

    }
}