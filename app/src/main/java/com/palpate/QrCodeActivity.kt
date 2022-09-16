package com.palpate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.qrcode_activity.*


class QrCodeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qrcode_activity)

        back.setOnClickListener {
            finish()
        }

        bt_qr_details.setOnClickListener {
            val intent = Intent(this, QrCodeDetailsActivity::class.java)
            startActivity(intent)
        }



    }


}