package com.palpate.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.R
import com.palpate.adapter.HealthPackageHistoryListAdapter
import kotlinx.android.synthetic.main.packagehistory_activity.*


class HealthPackageHistoryFragment : Fragment() {


    private lateinit var adapter: HealthPackageHistoryListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.packagehistory_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        packagehistorylist_rv.layoutManager = LinearLayoutManager(context)
        packagehistorylist_rv.setHasFixedSize(true)
        adapter = HealthPackageHistoryListAdapter(0)
        packagehistorylist_rv.adapter = adapter

        relative_header.visibility = View.GONE
      //  view.visibility = View.GONE


    }

}