package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.HealthPackageActivity
import com.palpate.R
import com.palpate.VaccinationDetailsActivity
import com.palpate.model.CategoryItemModel
import kotlinx.android.synthetic.main.item_category.view.*


class CategoryAdapter(
    private var items: ArrayList<CategoryItemModel>,
    private var currentPos: Int=0
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
            val intent = Intent(context, HealthPackageActivity::class.java)
            context.startActivity(intent)
        }



    }


}