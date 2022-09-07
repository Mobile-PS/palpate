package com.palpate.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.R
import com.palpate.adapter.NursingOrderHistoryListAdapter
import kotlinx.android.synthetic.main.nursingorderhistory_activity.*


class NursingOrderHistoryFragment : Fragment() {


    private lateinit var adapter: NursingOrderHistoryListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.nursingorderhistory_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        relative_header.visibility = View.GONE
//        view.visibility = View.GONE

        orderhistorylist_rv.layoutManager = LinearLayoutManager(context)
        orderhistorylist_rv.setHasFixedSize(true)
        adapter = NursingOrderHistoryListAdapter(0)
        orderhistorylist_rv.adapter = adapter



    }
}