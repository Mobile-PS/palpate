package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.*
import kotlinx.android.synthetic.main.health_package_item.view.*


class HealthPackageAdapter(
    private var currentPos: Int = 0
) : RecyclerView.Adapter<HealthPackageAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.health_package_item, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            val intent = Intent(context, HealthPackageDetailActivity::class.java)
            context.startActivity(intent)
        }
        holder.itemView.btn_book_now.setOnClickListener {
            val intent = Intent(context, PatientDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

}