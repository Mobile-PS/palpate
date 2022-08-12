package com.palpate.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.palpate.AddAddressActivity
import com.palpate.R
import kotlinx.android.synthetic.main.addhealthrecord_dailog.view.*
import kotlinx.android.synthetic.main.addresslist_item.view.*
import kotlinx.android.synthetic.main.deleterecord_dailog.view.*


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

        holder.itemView.linear_more.setOnClickListener {
            performOptionsMenuClick(context, holder.itemView.linear_more)
        }


    }

    private fun performOptionsMenuClick(context: Context, moreIcon: LinearLayout) {
        val popupMenu = PopupMenu(context, moreIcon)
        // add the menu
        popupMenu.inflate(R.menu.options_menu)
        // implement on menu item click Listener
        popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when (item?.itemId) {
                    R.id.menu1 -> {
                        val intent = Intent(context, AddAddressActivity::class.java)
                        context.startActivity(intent)
                        return true
                    }
                    // in the same way you can implement others
                    R.id.menu2 -> {
                        deleteAddress(context)
                        return true
                    }
                }
                return false
            }
        })
        popupMenu.show()
    }

    private fun deleteAddress(context: Context) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.deleterecord_dailog, null)
        val mBuilder = AlertDialog.Builder(context).setView(dialogView)
        val mAlertDialog = mBuilder.show()
        dialogView.txt_title.text="Delete Address"
        dialogView.txt_description.text="Are you sure want to delete this address?"
        dialogView.btn_yes.setOnClickListener {
            mAlertDialog.dismiss()
        }

        dialogView.btn_no.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }
}