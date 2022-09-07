package com.palpate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.MemberItemModel
import com.palpate.model.PatientListModel
import com.palpate.model.WalletItemModel
import kotlinx.android.synthetic.main.walletlist_item.view.*


class WalletListAdapter(
    private var items: ArrayList<WalletItemModel>,
    private var currentPos: Int,
    private var radiocheck: Boolean
) : RecyclerView.Adapter<WalletListAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.walletlist_item, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        if (radiocheck == true && position==items.size-1) {
            holder.itemView.btn_add_money.visibility = View.GONE
        } else {
            holder.itemView.btn_add_money.visibility = View.GONE
        }

        holder.itemView.wallet_name.text = items[position].title
        holder.itemView.wallet_details.text = items[position].description
        holder.itemView.img_wallet.setImageResource(items[position].icon)

        holder.itemView.radio_btn.setOnCheckedChangeListener(null)
        holder.itemView.radio_btn.setChecked(position === currentPos)
        holder.itemView.radio_btn.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            currentPos = position
            notifyDataSetChanged()
        })

    }
}