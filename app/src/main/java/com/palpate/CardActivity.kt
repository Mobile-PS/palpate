package com.palpate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.cart_activity.*


class CardActivity : AppCompatActivity() {
    val x = GlobalStuff.mainNavState
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_activity)

        back.setOnClickListener {
            finish()
        }

        relative_proceed.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }


        btn_redme.setOnClickListener {
            btn_redme.visibility = View.GONE
            linear_delete1.visibility = View.VISIBLE
            linear_redme.visibility = View.VISIBLE
        }

        relative_discount.setOnClickListener {
            relative_discount.visibility = View.GONE
            relative_discount1.visibility = View.VISIBLE
            val intent = Intent(this, CouponListActivity::class.java)
            startActivity(intent)
        }

        if (x == 1) {
            layout_package.visibility = View.VISIBLE
            layout_nusring.visibility = View.GONE
        } else {
            layout_package.visibility = View.GONE
            layout_nusring.visibility = View.VISIBLE
        }

        relative_description.setOnClickListener {
            if (img_down_arrow.visibility == View.VISIBLE) {
                img_down_arrow.visibility = View.GONE
                img_up_arrow.visibility = View.VISIBLE
                linear_description.visibility = View.VISIBLE
            } else if (img_up_arrow.visibility == View.VISIBLE) {
                img_down_arrow.visibility = View.VISIBLE
                img_up_arrow.visibility = View.GONE
                linear_description.visibility = View.GONE
            }
        }

    }
}