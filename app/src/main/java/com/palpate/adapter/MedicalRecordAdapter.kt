package com.palpate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.palpate.R
import com.palpate.model.HealthRecordItemModel
import com.palpate.model.MedicalRecordItemModel
import kotlinx.android.synthetic.main.item_health_record.view.*


class MedicalRecordAdapter(
    private var items: ArrayList<MedicalRecordItemModel>,
    private var currentPos: Int
) : RecyclerView.Adapter<MedicalRecordAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_medical_record, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {



    }
}