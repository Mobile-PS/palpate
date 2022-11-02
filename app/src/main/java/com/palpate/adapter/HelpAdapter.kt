package com.palpate.adapter


import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.CategoryItemModel
import kotlinx.android.synthetic.main.item_help.view.*
import java.net.URLEncoder


class HelpAdapter(
    private var items: ArrayList<CategoryItemModel>,
    private var currentPos: Int=0
) : RecyclerView.Adapter<HelpAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_help, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.txt_help.text = items[position].title
        holder.itemView.img_help.setBackgroundResource(items[position].icon)
        holder.itemView.setOnClickListener {
            if (position==0){
                val intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:123456789"))
                context.startActivity(intent);
            }
           if (position==1){
               val dialogView =
                   LayoutInflater.from(context).inflate(R.layout.callback_dailog, null)
               val customDialog = AlertDialog.Builder(context)
                   .setView(dialogView)
                   .show()
           }
            if (position==2){
//                val i = Intent(Intent.ACTION_VIEW)
//                val url =
//                    "https://api.whatsapp.com/send?phone=123456789"  + "&text=" + URLEncoder.encode(
//                        "Hello",
//                        "UTF-8"
//                    )
//                i.setPackage("com.whatsapp")
//                i.data = Uri.parse(url)
            }
            if (position==3){
//                val intent = Intent(Intent.ACTION_VIEW)
//                val data = Uri.parse("mailto:customer@something.com?subject=Feedback")
//                intent.data = data
//                context.startActivity(intent);
            }
        }



    }


}