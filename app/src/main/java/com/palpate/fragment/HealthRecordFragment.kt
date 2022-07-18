package com.palpate.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.R
import com.palpate.adapter.HealthRecordAdapter
import com.palpate.adapter.HealthStaticAdapter
import com.palpate.model.HealthRecordItemModel
import kotlinx.android.synthetic.main.healthrecord_fragment.*


class HealthRecordFragment : Fragment() {

    private var items = arrayListOf(
        HealthRecordItemModel(
            R.drawable.record_img, "Dr. PL Agrawal" ,
                    "06 July 20211",
            "Eye Care"
        ),
        HealthRecordItemModel(
            R.drawable.record_img, "Dr. Nesar Ahmad Ansari",
                    "12 July 2021", "Ortho"
        ),
        HealthRecordItemModel(
            R.drawable.record_img, "Dr. Pawan Kumar Gupta" ,
                    "18 July 2021", "Dental"
        ),

    )

    private lateinit var adapter: HealthRecordAdapter
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

    }
}