package com.palpate

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



    }
}