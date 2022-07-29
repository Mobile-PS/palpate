package com.palpate

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palpate.adapter.VaccineParentAdapter
import com.palpate.model.VaccinationParentModel
import kotlinx.android.synthetic.main.vaccinationdeatils_activity.*
import kotlinx.android.synthetic.main.vaccinationdeatils_activity.back

class VaccinationDetailsActivity : AppCompatActivity() {
    private var items = arrayListOf(
        VaccinationParentModel(
            "Covid Vaccine"
        ),
        VaccinationParentModel(
            "At Birth"
        ),
        VaccinationParentModel(
            "10 Weeks"
        ),

        )

    private var items1 = arrayListOf(
        VaccinationParentModel(
            "Covid Vaccine"
        ),
        VaccinationParentModel(
            "At Birth"
        ),
        VaccinationParentModel(
            "6 Weeks"
        ),
        VaccinationParentModel(
            "10 Weeks"
        ),
        VaccinationParentModel(
            "Other Vaccine"
        ),
    )

    private lateinit var adapter: VaccineParentAdapter
    var selectedname = "Completed"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vaccinationdeatils_activity)

        setAdapter()

        radio_group.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                selectedname = radio.text.toString();
                setAdapter()

            })
        btn_add_vacctination.setOnClickListener {
            val intent = Intent(this, AddVaccinationActivity::class.java)
            startActivity(intent)
        }
        back.setOnClickListener {
            finish()
        }

    }

    private fun setAdapter() {
        vaccination_rv.layoutManager = LinearLayoutManager(this)
        vaccination_rv.setHasFixedSize(true)
        if (selectedname == "Completed") {
            adapter = VaccineParentAdapter(items, selectedname)
        } else if (selectedname == "Not Completed") {
            adapter = VaccineParentAdapter(items1, selectedname)
        }
        vaccination_rv.adapter = adapter
    }
}