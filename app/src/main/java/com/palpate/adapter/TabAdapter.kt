package com.palpate.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.palpate.fragment.HealthRecordFragment
import com.palpate.fragment.HealthStatFragment
import com.palpate.fragment.MedicalRecordFragment

internal class TabAdapter (
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HealthStatFragment()
            }
            1 -> {
                HealthRecordFragment()
            }
            2 -> {
                MedicalRecordFragment()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}