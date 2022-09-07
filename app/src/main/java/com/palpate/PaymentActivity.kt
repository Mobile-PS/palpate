package com.palpate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.MemberListAdapter
import com.palpate.adapter.WalletListAdapter
import com.palpate.model.WalletItemModel
import kotlinx.android.synthetic.main.payment_activity.*
import kotlinx.android.synthetic.main.payment_activity.back
import kotlinx.android.synthetic.main.payment_activity.relative_proceed


class PaymentActivity : AppCompatActivity() {
    private var itemWallet = arrayListOf(
        WalletItemModel(
            R.drawable.paytm_icon, "Paytm",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        ),
        WalletItemModel(
            R.drawable.amzon_icon, "Amazon Pay",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        ),
        WalletItemModel(
            R.drawable.mobi_icon, "Mobikwik",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        ),
//        WalletItemModel(
//            R.drawable.wallet_icon, "Palpate Wallet",
//            "Wallet Balance ₹1300 "
//        )
    )

    private var itemOther = arrayListOf(
        WalletItemModel(
            R.drawable.upi_icon, "Add New UPI ID",
            "Pay using supported UPI apps"
        ),
        WalletItemModel(
            R.drawable.card_icon, "Credit & Debit Cards",
            "Add New Card for Payment"
        ),

        )

    private lateinit var adapterWallet: WalletListAdapter
    private lateinit var adapterOther: WalletListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_activity)

        back.setOnClickListener {
            finish()
        }


        wallet_rv.layoutManager = LinearLayoutManager(this)
        wallet_rv.setHasFixedSize(true)
        adapterWallet = WalletListAdapter(itemWallet, 0, true)
        wallet_rv.adapter = adapterWallet

        other_rv.layoutManager = LinearLayoutManager(this)
        other_rv.setHasFixedSize(true)
        adapterOther = WalletListAdapter(itemOther, 0, false)
        other_rv.adapter = adapterOther

        relative_proceed.setOnClickListener {
            val intent = Intent(this, PaymentSuccessActivity::class.java)
            startActivity(intent)
        }

    }
}