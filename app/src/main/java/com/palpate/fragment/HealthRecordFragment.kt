package com.palpate.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.AddHealthRecordActivity
import com.palpate.R
import com.palpate.adapter.HealthRecordAdapter
import com.palpate.adapter.SpecialistAdapter
import com.palpate.model.HealthRecordItemModel
import com.palpate.model.SpecialistDataModel
import kotlinx.android.synthetic.main.addhealthrecord_dailog.view.*
import kotlinx.android.synthetic.main.healthrecord_fragment.*


class HealthRecordFragment : Fragment() {

    private var items = arrayListOf(
        HealthRecordItemModel(
            R.drawable.record_img, "Dr. PL Agrawal",
            "06 July 20211",
            "Eye Care"
        ),
        HealthRecordItemModel(
            R.drawable.record_img, "Dr. Nesar Ahmad Ansari",
            "12 July 2021", "Ortho"
        ),
        HealthRecordItemModel(
            R.drawable.record_img, "Dr. Pawan Kumar Gupta",
            "18 July 2021", "Dental"
        ),

        )

    private var items1 = arrayListOf(
        SpecialistDataModel(
            "Eye Care", false
        ),
        SpecialistDataModel(
            "Ortho", false
        ),
        SpecialistDataModel(
            "Dental", false
        ),
        SpecialistDataModel(
            "General", false
        ),
        SpecialistDataModel(
            "Ear Care", false
        ),
     
        )

    private lateinit var adapter: HealthRecordAdapter
    private lateinit var adapter1: SpecialistAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.healthrecord_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        healthrecord_rv.layoutManager = LinearLayoutManager(context)
        healthrecord_rv.setHasFixedSize(true)
        adapter = HealthRecordAdapter(items, 0)
        healthrecord_rv.adapter = adapter

        btn_add_health_record.setOnClickListener { 
           // openAddRecordDailog(context);
            val intent = Intent(context, AddHealthRecordActivity::class.java)
            startActivity(intent)
        }

    }

    private fun openAddRecordDailog(context: Context?) {
        val dialogView = layoutInflater.inflate(R.layout.addhealthrecord_dailog, null)
        dialogView.speaclist_rv.layoutManager = LinearLayoutManager(context)
        dialogView.speaclist_rv.setHasFixedSize(true)
        adapter1 = SpecialistAdapter(items1, 0)
        dialogView.speaclist_rv.adapter = adapter1

        val customDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .show()


    }
}