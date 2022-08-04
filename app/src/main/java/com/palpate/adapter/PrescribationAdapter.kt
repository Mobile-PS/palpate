package com.palpate.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import kotlinx.android.synthetic.main.item_prescription.view.*


class PrescribationAdapter(
    private var currentPos: Int=0
) : RecyclerView.Adapter<PrescribationAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_prescription, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {


    }

}