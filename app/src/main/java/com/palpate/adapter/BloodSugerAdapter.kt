package com.palpate.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.BloodSugerItemModel
import kotlinx.android.synthetic.main.addhb_dailog.view.*
import kotlinx.android.synthetic.main.deleterecord_dailog.view.*
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
//        var sdk = android.os.Build.VERSION.SDK_INT;
//        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
//            holder.itemView.img_list.setBackgroundDrawable(
//                ContextCompat.getDrawable(
//                    context,
//                    items[position].icon
//                )
//            );
//        } else {
//            holder.itemView.img_list.setBackground(
//                ContextCompat.getDrawable(
//                    context,
//                    items[position].icon
//                )
//            );
//        }
        holder.itemView.setOnClickListener {
            currentPos = position
            setlayoutView(holder.itemView.relative_img, holder.itemView.img_list, position)
            notifyDataSetChanged()
            if(position==items.size-1)
            {
                addh1bc(context)
            }
        }

    }

    private fun addh1bc(context: Context) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.addhb_dailog, null)
        val mBuilder = AlertDialog.Builder(context).setView(dialogView)
        val mAlertDialog = mBuilder.show()
        dialogView.edtxt_hbc.addTextChangedListener(
            afterTextChanged = {
                if(dialogView.edtxt_hbc.text.toString().isEmpty() || dialogView.edtxt_hbc.text.toString().toInt()>10){
                    dialogView.speedView.speedTo(0.0F);
                }else {
                    dialogView.speedView.speedTo(dialogView.edtxt_hbc.text.toString().toFloat());
                }
            },
            onTextChanged = {s, start, before, count->


            },
            beforeTextChanged = {s, start, before, count->

            }
        )
        dialogView.btn_remove.setOnClickListener {
            mAlertDialog.dismiss()
        }

        dialogView.btn_submit.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }

    private fun setlayoutView(relativeImg: RelativeLayout, imgList: ImageView, position: Int) {
//        if (currentPos == position) {
//            relativeImg.setBackgroundResource(R.drawable.layout_bg9)
//        } else {
//            relativeImg.setBackgroundResource(R.drawable.layout_bg)
//        }
    }
}