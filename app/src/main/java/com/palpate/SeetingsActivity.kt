package com.palpate

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.SettingsAdapter
import com.palpate.model.SettingItemModel
import kotlinx.android.synthetic.main.settings_activity.*


class SeetingsActivity : AppCompatActivity() {


    lateinit var settingAapter: SettingsAdapter
    private var itemsSetting = arrayListOf(
        SettingItemModel(
            R.drawable.qr_icon, "My Health QR"
        ),
        SettingItemModel(
            R.drawable.user_icon, "Manage Profile"
        ),
        SettingItemModel(
            R.drawable.pin_icon, "Manage Address"
        ),
//        SettingItemModel(
//            R.drawable.activity_icon, "Activity Goal"
//        ),
        SettingItemModel(
            R.drawable.mange_dash_icon, "Health Stats"
        ),
        SettingItemModel(
            R.drawable.share_icon, "Share App "
        ),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        back.setOnClickListener {
            finish()
        }

        seeting_rv.layoutManager = LinearLayoutManager(
            this
        )
        seeting_rv.setHasFixedSize(true)
        settingAapter = SettingsAdapter(itemsSetting, 0)
        seeting_rv.adapter = settingAapter


    }


}