package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.palpate.*
import kotlinx.android.synthetic.main.item_weight_button.view.*
import kotlinx.android.synthetic.main.package_list_item.view.*


class HealthPackageAdapter(
    private var currentPos: Int = -1
) : RecyclerView.Adapter<HealthPackageAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.package_list_item, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        setlayoutbg(holder.itemView.layout_package_item,position)

        holder.itemView.btn_subscribe.setOnClickListener {
            GlobalStuff.mainNavState = 1
            val intent = Intent(context, PatientDetailsActivity::class.java)
            context.startActivity(intent)
        }

        holder.itemView.layout_package_item.setOnClickListener {
            currentPos=position
            setlayoutbg(holder.itemView.layout_package_item,position)
            notifyDataSetChanged()
            val intent = Intent(context, PackageDetailActivity::class.java)
            context.startActivity(intent)

        }
    }

    private fun setlayoutbg(layoutPackageItem: LinearLayout?, position: Int) {
//        if (currentPos == position) {
//            layoutPackageItem?.setBackgroundResource(R.drawable.layout_bg13);
//        } else {
            layoutPackageItem?.setBackgroundResource(R.drawable.layout_bg12);
//        }

    }

}