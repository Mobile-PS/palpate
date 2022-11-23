package com.palpate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.*
import com.palpate.model.NavigationItemModel
import kotlinx.android.synthetic.main.row_nav_drawer.view.*


class NavigationRVAdapter(
    private var items: ArrayList<NavigationItemModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<NavigationRVAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.row_nav_drawer, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        // To highlight the selected Item, show different background color
        /*  if (position == currentPos) {
              holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
          } else {
              holder.itemView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
          }*/
        // holder.itemView.navigation_icon.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP)
        // holder.itemView.navigation_title.setTextColor(Color.BLACK)
        //val font = ResourcesCompat.getFont(context, R.font.mycustomfont)
        //holder.itemView.navigation_text.typeface = font
        //holder.itemView.navigation_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat())

        holder.itemView.setOnClickListener {

            if (position == 0) {
                val intent = Intent(context, DashboardActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent)
            }
            if (position == 1) {
                val intent = Intent(context, HealthStatsActivity::class.java)
                context.startActivity(intent)
            }
            if (position == 2) {
                val intent = Intent(context, OrderHistoryActivity::class.java)
                context.startActivity(intent)
            }
            if (position == 3) {
                val intent = Intent(context, PackageListActivity::class.java)
                context.startActivity(intent)
            }
            if (position == 4) {
                val intent = Intent(context, HomeNursingActivity::class.java)
                context.startActivity(intent)
            }
            if (position == 5) {
                val intent = Intent(context, SrchHospitalActivity::class.java)
                context.startActivity(intent)
            }
            if (position == 6) {
                val intent = Intent(context, OrganDonationActivity::class.java)
                context.startActivity(intent)
            }
            if (position == 7) {
                val intent = Intent(context, HealthTipsActivity::class.java)
                context.startActivity(intent)
            }
            if (position == 8) {
                val intent = Intent(context, SeetingsActivity::class.java)
                context.startActivity(intent)
            }


        }

        holder.itemView.navigation_title.text = items[position].title

        holder.itemView.navigation_icon.setImageResource(items[position].icon)

    }
}