package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.*
import com.palpate.model.SettingItemModel
import kotlinx.android.synthetic.main.item_settings.view.*


class SettingsAdapter(
    private var items: ArrayList<SettingItemModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<SettingsAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_settings, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        holder.itemView.img_icon.setImageResource(items[position].icon)
        holder.itemView.txt_title.text = items[position].title

        holder.itemView.setOnClickListener {
            if (position==0){
                val intent = Intent(context, QrCodeActivity::class.java)
                context.startActivity(intent)
            }
            if (position==1){
                val intent = Intent(context, SettingProfileActivity::class.java)
                context.startActivity(intent)
            }

            if (position==3){
                val intent = Intent(context, SettingHealthStatesActivity::class.java)
                context.startActivity(intent)
            }
            if (position==2)
            {
                GlobalStuff.mainNavState = 0
                val intent = Intent(context, AddressListActivity::class.java)
                context.startActivity(intent)
            }
        }

    }
}