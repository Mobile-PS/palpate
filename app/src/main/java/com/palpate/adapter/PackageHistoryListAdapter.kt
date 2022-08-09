package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.palpate.PackageDetailActivity
import com.palpate.PackageHistoryDetailActivity
import com.palpate.R
import kotlinx.android.synthetic.main.packagehistory_list_item.view.*


class PackageHistoryListAdapter(
    private var currentPos: Int,
) : RecyclerView.Adapter<PackageHistoryListAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.packagehistory_list_item, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent = Intent(context, PackageHistoryDetailActivity::class.java)
            context.startActivity(intent)
        }


    }
}