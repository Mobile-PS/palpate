package com.palpate.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.BloodSugerItemModel
import kotlinx.android.synthetic.main.addhb_dailog.view.*
import kotlinx.android.synthetic.main.item_bloodsuger.view.*
import kotlinx.android.synthetic.main.item_bloodsuger.view.txt_title


class BloodSugerAdapter(
    private var items: ArrayList<BloodSugerItemModel>,
    private var currentPos: Int = 0
) : RecyclerView.Adapter<BloodSugerAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_bloodsuger, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.txt_title.text = items[position].title
        holder.itemView.img_list.setBackgroundResource(items[position].icon)

        holder.itemView.setOnClickListener {
            currentPos = position
            notifyDataSetChanged()

            if (position == items.size - 1) {
                addh1bc(context)
            }
        }

        if (currentPos == position) {
            holder.itemView.relative_img.setBackgroundResource(R.drawable.layout_bg9)
            holder.itemView.img_list.setBackgroundTintList(
                ContextCompat.getColorStateList(
                    context,
                    R.color.white
                )
            )
        } else {
            holder.itemView.relative_img.setBackgroundResource(R.drawable.layout_bg)
            holder.itemView.img_list.setBackgroundTintList(
                ContextCompat.getColorStateList(
                    context,
                    R.color.iconcolor
                )
            )
        }

    }

    private fun addh1bc(context: Context) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.addhb_dailog, null)
        val mBuilder = AlertDialog.Builder(context).setView(dialogView)
        val mAlertDialog = mBuilder.show()
        dialogView.edtxt_hbc.addTextChangedListener(
            afterTextChanged = {
                if (dialogView.edtxt_hbc.text.toString()
                        .isEmpty() || dialogView.edtxt_hbc.text.toString().toInt() > 14
                ) {
                    dialogView.speedView.speedTo(4.0F);
                    setTextValue(4, dialogView.txt_status)
                } else {
                    dialogView.speedView.speedTo(dialogView.edtxt_hbc.text.toString().toFloat());
                    setTextValue(
                        dialogView.edtxt_hbc.text.toString().toInt(),
                        dialogView.txt_status
                    )
                }
            },
            onTextChanged = { s, start, before, count ->


            },
            beforeTextChanged = { s, start, before, count ->

            }
        )
        dialogView.btn_remove.setOnClickListener {
            mAlertDialog.dismiss()
        }

        dialogView.btn_submit.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }


    private fun setTextValue(hvbc: Int, txtStatus: TextView) {
        var status = "";
        if (hvbc in 4..6) {
            status = "Normal";
        } else if (hvbc in 7..8) {
            status = "Prediabetes";
        } else if (hvbc in 9..14) {
            status = "Diabetes";
        }

        txtStatus.text = status;

    }


}