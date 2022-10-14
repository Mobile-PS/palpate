package com.palpate.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.HealthStateItemModel
import kotlinx.android.synthetic.main.item_visit_details.view.*
import kotlinx.android.synthetic.main.packagehistory_details_activity.*
import kotlinx.android.synthetic.main.visit_health_stats.view.*


class VisitDetailsAdapter(val type: String?) : RecyclerView.Adapter<VisitDetailsAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context
    private var currentPos: Int = -1
    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_visit_details, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        if(type=="pacakge")
        {
            holder.itemView.linear_pacakge.visibility=View.VISIBLE
            holder.itemView.linear_visit.visibility=View.GONE
        }else{
            holder.itemView.linear_pacakge.visibility=View.GONE
            holder.itemView.linear_visit.visibility=View.VISIBLE
        }
        holder.itemView.btn_health_sat.setOnClickListener {
            openAddRecordDailog(context,"status")
        }

        holder.itemView.btn_docs.setOnClickListener {
            openAddRecordDailog(context,"docs")
        }

        holder.itemView.relative_description.setOnClickListener {
            currentPos=position
            notifyDataSetChanged()

        }

        if(currentPos==position) {
            if (holder.itemView.img_down_arrow.visibility == View.VISIBLE) {
                holder.itemView.img_down_arrow.visibility = View.GONE
                holder.itemView.img_up_arrow.visibility = View.VISIBLE
                holder.itemView.linear_description.visibility = View.VISIBLE
            } else if (holder.itemView.img_up_arrow.visibility == View.VISIBLE) {
                holder.itemView.img_down_arrow.visibility = View.VISIBLE
                holder.itemView.img_up_arrow.visibility = View.GONE
                holder.itemView.linear_description.visibility = View.GONE
            }
        }else{
            holder.itemView.img_down_arrow.visibility = View.VISIBLE
            holder.itemView.img_up_arrow.visibility = View.GONE
            holder.itemView.linear_description.visibility = View.GONE
        }

    }


    private fun openAddRecordDailog(context: Context?, type: String) {
         var items = arrayListOf(
            HealthStateItemModel(
                R.drawable.weight_icon_blue, "Weight",
                "9 July 2021",
                "56.0"
            ),
            HealthStateItemModel(
                R.drawable.bmi_icon_blue, "BMI",
                "9 July 2021", "20.1"
            ),
            HealthStateItemModel(
                R.drawable.hrtrate_icon_blue, "Heart Rate",
                "1h ago", "76"
            ),
            HealthStateItemModel(
                R.drawable.bp_icon_blue, "Blood Pressure",
                "9 July 2021", "120/80"
            ),
            HealthStateItemModel(
                R.drawable.temp_icon_blue, "Temperature",
                "9 July 2021", "19.8"
            ),
            HealthStateItemModel(
                R.drawable.blood_icon_blue, "Blood Sugar",
                "9 July 2021", "70-130"
            ),
            HealthStateItemModel(
                R.drawable.height_icon_blue, "Height",
                "9 July 2021", "5’8"
            ),
            HealthStateItemModel(
                R.drawable.oxgn_icon_blue, "Oxygen Saturation",
                "9 July 2021", "78"
            ),
            HealthStateItemModel(
                R.drawable.vac_icon_blue, "Vaccination",
                "9 July 2021", "16"
            ),
        )
        lateinit var adapter: HealthStaticAdapter
        lateinit var adapter2: UploadAdapter
        val dialogView = LayoutInflater.from(context).inflate(R.layout.visit_health_stats, null)
        val mBuilder = AlertDialog.Builder(context).setView(dialogView)
        val mAlertDialog = mBuilder.show()

        dialogView.img_close.setOnClickListener {
            mAlertDialog.dismiss()
        }
        if(type=="status") {
            dialogView.txt_title.text="Health Stats"
            dialogView.healthstat_rv.layoutManager = LinearLayoutManager(context)
            dialogView.healthstat_rv.setHasFixedSize(true)
            adapter = HealthStaticAdapter(items, 0, false)
            dialogView.healthstat_rv.adapter = adapter
        }else{
            dialogView.txt_title.text="Uploads"
            dialogView.healthstat_rv.layoutManager = GridLayoutManager(context,2)
            dialogView.healthstat_rv.setHasFixedSize(true)
            adapter2 = UploadAdapter()
            dialogView.healthstat_rv.adapter = adapter2
        }




    }

}