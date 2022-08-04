package com.palpate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import kotlinx.android.synthetic.main.addresslist_item.view.*


class AddressListAdapter(
    private var currentPos: Int,
    private var radiocheck: Boolean,
    private var size: Int
) : RecyclerView.Adapter<AddressListAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.addresslist_item, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        if (radiocheck == true) {
            holder.itemView.radio_btn.visibility = View.VISIBLE
            holder.itemView.img_home.visibility = View.GONE
        } else {
            holder.itemView.radio_btn.visibility = View.GONE
            holder.itemView.img_home.visibility = View.VISIBLE
        }


        holder.itemView.radio_btn.setOnCheckedChangeListener(null)
        holder.itemView.radio_btn.setChecked(position === currentPos)
        holder.itemView.radio_btn.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            currentPos = position
            notifyDataSetChanged()
        })


    }
}