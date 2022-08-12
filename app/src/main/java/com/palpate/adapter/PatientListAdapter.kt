package com.palpate.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.palpate.AddAddressActivity
import com.palpate.AddPatientActivity
import com.palpate.EditMemberActivity
import com.palpate.R
import com.palpate.model.MemberItemModel
import kotlinx.android.synthetic.main.deleterecord_dailog.view.*
import kotlinx.android.synthetic.main.patientlist_item.view.*


class PatientListAdapter(
    private var items: ArrayList<MemberItemModel>,
    private var currentPos: Int,
    private var radiocheck: Boolean
) : RecyclerView.Adapter<PatientListAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.patientlist_item, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        if (radiocheck == true) {
            holder.itemView.radio_btn.visibility = View.VISIBLE
        } else {
            holder.itemView.radio_btn.visibility = View.GONE
        }

        holder.itemView.linear_more.setOnClickListener {
            performOptionsMenuClick(context, holder.itemView.linear_more)
        }


        holder.itemView.member_name.text = items[position].name
        holder.itemView.member_details.text = items[position].gender
        holder.itemView.member_details2.text = items[position].age
        holder.itemView.img_member.setImageResource(items[position].icon)



        holder.itemView.radio_btn.setOnCheckedChangeListener(null)
        holder.itemView.radio_btn.setChecked(position === currentPos)
        holder.itemView.radio_btn.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            currentPos = position
            notifyDataSetChanged()
        })


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
                        val intent = Intent(context, AddPatientActivity::class.java)
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
        dialogView.txt_title.text="Delete Patient"
        dialogView.txt_description.text="Are you sure want to delete this Patient?"
        dialogView.btn_yes.setOnClickListener {
            mAlertDialog.dismiss()
        }

        dialogView.btn_no.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }
}