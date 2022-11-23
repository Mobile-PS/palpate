package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.HospitalDetailsActivity
import com.palpate.HospitalListActivity
import com.palpate.NursingListActivity
import com.palpate.R
import com.palpate.model.CategoryItemModel
import kotlinx.android.synthetic.main.item_nearby_hos.view.*


class NearbyHospListAdapter(
    private var items: ArrayList<CategoryItemModel>,
) : RecyclerView.Adapter<NearbyHospListAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_nearby_hos, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        holder.itemView.img_artical.setImageResource(items[position].icon)
        holder.itemView.txt_title.text = items[position].title
        holder.itemView.setOnClickListener {
            val intent = Intent(context, HospitalDetailsActivity::class.java)
            context.startActivity(intent)
        }

    }
}