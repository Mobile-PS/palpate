package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.*
import com.palpate.model.CategoryItemModel
import kotlinx.android.synthetic.main.item_category.view.*


class CategoryAdapter(
    private var items: ArrayList<CategoryItemModel>,
    private var currentPos: Int = 0
) : RecyclerView.Adapter<CategoryAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.txt_category.text = items[position].title
        holder.itemView.img_category.setBackgroundResource(items[position].icon)
        holder.itemView.setOnClickListener {
            if (currentPos == 0) {
                val intent = Intent(context, NursingListActivity::class.java)
                context.startActivity(intent)
            }
            if (currentPos == 1) {
                val intent = Intent(context, HospitalListActivity::class.java)
                context.startActivity(intent)
            }
            if (currentPos == 2) {
                val intent = Intent(context, DoctorListActivity::class.java)
                context.startActivity(intent)
            }
        }


    }


}