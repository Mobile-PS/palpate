package com.palpate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.palpate.*
import com.palpate.model.VaccinationChildModel
import com.palpate.model.VaccinationParentModel
import kotlinx.android.synthetic.main.item_vaccinationlist.view.*


class VaccineParentAdapter(
    private var items: ArrayList<VaccinationParentModel>,
    private var currentPos: String
) : RecyclerView.Adapter<VaccineParentAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_vaccinationlist, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        holder.itemView.txt_title.text = items[position].title

        setData(position, holder.itemView.vaccinationitem_rv);


    }

    private fun setData(position: Int, vaccinationitemRv: RecyclerView) {

        var items1: ArrayList<VaccinationChildModel> = ArrayList<VaccinationChildModel>()
        var adapter: VaccineChildAdapter
        if (currentPos == "Completed") {
            if (items[position].title == "Covid Vaccine") {
                items1 = arrayListOf(
                    VaccinationChildModel(
                        R.drawable.injection_icon, "2nd Dose", "13 August 2021"
                    ),
                )
            } else if (items[position].title == "At Birth") {
                items1 = arrayListOf(
                    VaccinationChildModel(
                        R.drawable.oral_icon, "OPV 0", "17 March 1996"
                    ),
                    VaccinationChildModel(
                        R.drawable.injection_icon, "BCG", "19 March 1996"
                    ),
                )

            } else if (items[position].title == "10 Weeks") {
                items1 = arrayListOf(
                    VaccinationChildModel(
                        R.drawable.injection_icon, "DTwP", "27 April 2000"
                    ),
                    VaccinationChildModel(
                        R.drawable.oral_icon, "OPV2 IPV", "13 October 2001"
                    ),
                    VaccinationChildModel(
                        R.drawable.oral_icon, "Rotavirus", "25 December 2002"
                    ),
                    VaccinationChildModel(
                        R.drawable.injection_icon, "HIB", "13 October 2001"
                    ),
                    VaccinationChildModel(
                        R.drawable.injection_icon, "PCV", "13 October 2001"
                    ),
                )
            }

        }
        if (currentPos == "Not Completed") {
            if (items[position].title == "Covid Vaccine") {
                items1 = arrayListOf(
                    VaccinationChildModel(
                        R.drawable.injection_icon, "1nd Dose", "NA"
                    ),
                    VaccinationChildModel(
                        R.drawable.injection_icon, "2nd Dose", "NA"
                    ),
                )
            } else if (items[position].title == "At Birth") {
                items1 = arrayListOf(
                    VaccinationChildModel(
                        R.drawable.oral_icon, "OPV 0", "NA"
                    ),
                    VaccinationChildModel(
                        R.drawable.injection_icon, "BCG", "NA"
                    ),
                )

            } else if (items[position].title == "6 Weeks") {
                items1 = arrayListOf(
                    VaccinationChildModel(
                        R.drawable.injection_icon, "DTwP", "NA"
                    ),
                    VaccinationChildModel(
                        R.drawable.oral_icon, "OPV2 IPV", "NA"
                    ),
                    VaccinationChildModel(
                        R.drawable.oral_icon, "Rotavirus", "NA"
                    ),
                    VaccinationChildModel(
                        R.drawable.injection_icon, "HIB", "NA"
                    ),
                    VaccinationChildModel(
                        R.drawable.injection_icon, "PCV", "NA"
                    ),
                )
            } else if (items[position].title == "10 Weeks") {
                items1 = arrayListOf(
                    VaccinationChildModel(
                        R.drawable.injection_icon, "DTwP", "NA"
                    ),
                    VaccinationChildModel(
                        R.drawable.injection_icon, "HIB", "NA"
                    ),
                    VaccinationChildModel(
                        R.drawable.injection_icon, "PCV", "NA"
                    ),
                    VaccinationChildModel(
                        R.drawable.oral_icon, "OPV2 IPV", "NA"
                    ),
                    VaccinationChildModel(
                        R.drawable.oral_icon, "Rotavirus", "NA"
                    ),
                )
            } else if (items[position].title == "Other Vaccine") {
                items1 = arrayListOf(
                    VaccinationChildModel(
                        R.drawable.injection_icon, "Berirab-P", "13 August 2021"
                    ),
                    VaccinationChildModel(
                        R.drawable.oral_icon, "Other Vaccinne-1", "13 August 2021"
                    ),
                )
            }



        }

        vaccinationitemRv.layoutManager = LinearLayoutManager(context)
        vaccinationitemRv.setHasFixedSize(true)
        adapter = VaccineChildAdapter(items1, 0)
        vaccinationitemRv.adapter = adapter

    }
}