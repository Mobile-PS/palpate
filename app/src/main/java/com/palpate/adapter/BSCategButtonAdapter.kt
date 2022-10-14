package com.palpate.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.BSCategItemModel
import kotlinx.android.synthetic.main.item_weight_button.view.*


class BSCategButtonAdapter(
    private var items: ArrayList<BSCategItemModel>,
    private var currentPos: Int = 0
) : RecyclerView.Adapter<BSCategButtonAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_weight_button, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.btn_timeline.text = items[position].title

        setButtonView(holder.itemView.btn_timeline, position)

        holder.itemView.btn_timeline.setOnClickListener {
            if (items[position].status) {
                items[position].status = false
            } else {
                items[position].status = true
            }

            setButtonView(holder.itemView.btn_timeline, position)
            notifyDataSetChanged()
        }

    }

    private fun setButtonView(btnTimeline: AppCompatButton?, position: Int) {
        if (items[position].status) {
            btnTimeline?.setBackground(ContextCompat.getDrawable(context, R.drawable.button_bg7));
            btnTimeline?.setTextColor(Color.parseColor("#FFFFFF"))
        } else {
            btnTimeline?.setBackground(ContextCompat.getDrawable(context, R.drawable.button_bg8));
            btnTimeline?.setTextColor(Color.parseColor("#5F5F5F"))
        }
    }
}