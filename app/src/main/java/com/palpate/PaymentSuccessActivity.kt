package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.payment_sccuess_activity.*


class PaymentSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_sccuess_activity)

        back.setOnClickListener {
            finish()
        }

        btn_backhome.setOnClickListener {
            val i = Intent(this, DashboardActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        }

        btn_orderhistory.setOnClickListener {
            val intent = Intent(this, PackageHistoryListActivity::class.java)
            startActivity(intent)
        }


    }
}