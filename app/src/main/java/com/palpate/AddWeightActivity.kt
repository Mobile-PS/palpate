package com.palpate


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.android.material.snackbar.Snackbar
import com.palpate.adapter.BSCategButtonAdapter
import com.palpate.adapter.WeightItemAdapter
import com.palpate.adapter.WeightItemButtonAdapter
import com.palpate.model.BSCategItemModel
import com.palpate.model.BloodSugerItemModel
import com.palpate.model.WeigthItemModel
import kotlinx.android.synthetic.main.addweight_activity.*


class AddWeightActivity : AppCompatActivity() {
    private var items = arrayListOf(
        WeigthItemModel(
            "15 July 2021",
            "08:13 AM",
            "80.2"
        ),
        WeigthItemModel(
            "15 July 2021",
            "11:16 AM",
            "80.3"
        ),
        WeigthItemModel(
            "16 July 2021",
            "01:19 PM",
            "80.3"
        ),
        WeigthItemModel(
            "15 July 2021",
            "08:13 AM",
            "80.2"
        ),
        WeigthItemModel(
            "17 July 2021",
            "05:13 PM",
            "80.2"
        ),
        WeigthItemModel(
            "18 July 2021",
            "09:40 AM",
            "80.2"
        ),
        WeigthItemModel(
            "18 July 2021",
            "07:52 PM",
            "80.4"
        ),
    )

    private var items2 = arrayListOf("1 Week", "1 Month", "6 Months", "1 Year", "Maximum");

    private var itemsBSCat = arrayListOf(
        BSCategItemModel(
            true, "Fasting",
        ),
//        BSCategItemModel(
//            false, "Pre-meal",
//        ),
        BSCategItemModel(
            false, "Post-meal",
        ),

//        BSCategItemModel(
//            R.drawable.night_icon, "Before Sleep",
//        ),

        BSCategItemModel(
            false, "Random",
        ),

        BSCategItemModel(
            false, "HbA1c",
        ),

        )

    private lateinit var adapter: WeightItemAdapter

    private lateinit var adapter2: WeightItemButtonAdapter
    private lateinit var adapter3: BSCategButtonAdapter
    var title = ""
    var swtichValue = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addweight_activity)
        intent.extras?.let {
            title = intent.extras!!.getString("title")!!
            title1.text = title;
        }

        if (title == "BMI") {
            btn_add_health_stat.visibility = View.GONE
            weightItem_rv.visibility = View.GONE
            linear_switch.visibility = View.VISIBLE
        }

        btn_add_health_stat.text = "\u002b  Add " + title

        weightItem_rv.layoutManager = LinearLayoutManager(this)
        weightItem_rv.setHasFixedSize(true)
        adapter = WeightItemAdapter(items, 0)
        weightItem_rv.adapter = adapter

        weightItembutton_rv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        weightItembutton_rv.setHasFixedSize(true)
        adapter2 = WeightItemButtonAdapter(items2, 0)
        weightItembutton_rv.adapter = adapter2

        if (title == "Blood Sugar") {
            bscategory_rv.visibility=View.VISIBLE
            bscategory_rv.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            bscategory_rv.setHasFixedSize(true)
            adapter3 = BSCategButtonAdapter(itemsBSCat, 0)
            bscategory_rv.adapter = adapter3

        }



        back.setOnClickListener {
            finish()
        }

        btn_add_health_stat.setOnClickListener {
            if (title == "Weight") {
                val intent = Intent(this, AddWeight1Activity::class.java)
                startActivity(intent)
            } else if (title == "BMI") {
                val intent = Intent(this, AddBMIActivity::class.java)
                startActivity(intent)
            } else if (title == "Heart Rate") {
                val intent = Intent(this, AddHeartRateActivity::class.java)
                startActivity(intent)
            } else if (title == "Blood Pressure") {
                val intent = Intent(this, AddBPActivity::class.java)
                startActivity(intent)
            } else if (title == "Temperature") {
                val intent = Intent(this, AddTempActivity::class.java)
                startActivity(intent)
            } else if (title == "Blood Sugar") {
                val intent = Intent(this, AddBloodSugerActivity::class.java)
                startActivity(intent)
            } else if (title == "Height") {
                val intent = Intent(this, AddHeightActivity::class.java)
                startActivity(intent)
            } else if (title == "Oxygen Saturation") {
                val intent = Intent(this, AddOxygenActivity::class.java)
                startActivity(intent)
            }

        }

        drawLineChart()

        /* img_list.setOnClickListener {
             img_list.visibility=View.GONE
             img_graph.visibility=View.VISIBLE
             linear_list.visibility=View.GONE
             weightItem_rv.visibility=View.VISIBLE
             btn_add_health_stat.visibility=View.VISIBLE
         }

         img_graph.setOnClickListener {
             img_list.visibility=View.VISIBLE
             img_graph.visibility=View.GONE
             linear_list.visibility=View.VISIBLE
             weightItem_rv.visibility=View.GONE
             btn_add_health_stat.visibility=View.GONE
         }
 */


        btn_switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            swtichValue = isChecked
            drawLineChart()
        })

    }

    private fun drawLineChart() {

        val lineEntries: List<Entry> = getDataSet()
        val lineDataSet = LineDataSet(lineEntries, "")
        lineDataSet.axisDependency = YAxis.AxisDependency.RIGHT
        lineDataSet.isHighlightEnabled = false
        lineDataSet.lineWidth = 1f
        lineDataSet.color = Color.parseColor("#FF3E6C")
        lineDataSet.setCircleColor(Color.parseColor("#FF3E6C"))
        lineDataSet.setDrawHighlightIndicators(true)
        lineDataSet.valueTextSize = 12f
        lineDataSet.valueTextColor = Color.DKGRAY
      //  linechart.getXAxis().setLabelCount(lineDataSet.entryCount)
       // linechart.setData(LineData(lineDataSet))



        val lineEntries1: List<Entry> = getDataSet2()
        val lineDataSet1 = LineDataSet(lineEntries1, "")
        lineDataSet1.axisDependency = YAxis.AxisDependency.RIGHT
        lineDataSet1.isHighlightEnabled = false
        lineDataSet1.lineWidth = 1f
        lineDataSet1.color = Color.parseColor("#00FF00")
        lineDataSet1.setCircleColor(Color.parseColor("#00FF00"))
        lineDataSet1.setDrawHighlightIndicators(true)
        lineDataSet1.valueTextSize = 12f
        lineDataSet1.valueTextColor = Color.DKGRAY
       // linechart.getXAxis().setLabelCount(lineDataSet1.entryCount)
       // linechart.setData(LineData(lineDataSet1))


        val lineEntries2: List<Entry> = getDataSet3()
        val lineDataSet2 = LineDataSet(lineEntries2, "")
        lineDataSet2.axisDependency = YAxis.AxisDependency.RIGHT
        lineDataSet2.isHighlightEnabled = false
        lineDataSet2.lineWidth = 1f
        lineDataSet2.color = Color.parseColor("#A020F0")
        lineDataSet2.setCircleColor(Color.parseColor("#A020F0"))
        lineDataSet2.setDrawHighlightIndicators(true)
        lineDataSet2.valueTextSize = 12f
        lineDataSet2.valueTextColor = Color.DKGRAY


        val lineEntries3: List<Entry> = getDataSet2()
        val lineDataSet3 = LineDataSet(lineEntries3, "")
        lineDataSet3.axisDependency = YAxis.AxisDependency.RIGHT
        lineDataSet3.isHighlightEnabled = false
        lineDataSet3.lineWidth = 1f
        lineDataSet3.color = Color.parseColor("#FFFF00")
        lineDataSet3.setCircleColor(Color.parseColor("#FFFF00"))
        lineDataSet3.setDrawHighlightIndicators(true)
        lineDataSet3.valueTextSize = 12f
        lineDataSet3.valueTextColor = Color.DKGRAY

        val lineEntries4: List<Entry> = getDataSet4()
        val lineDataSet4 = LineDataSet(lineEntries4, "")
        lineDataSet4.axisDependency = YAxis.AxisDependency.RIGHT
        lineDataSet4.isHighlightEnabled = false
        lineDataSet4.lineWidth = 1f
        lineDataSet4.color = Color.parseColor("#0000FF")
        lineDataSet4.setCircleColor(Color.parseColor("#0000FF"))
        lineDataSet4.setDrawHighlightIndicators(true)
        lineDataSet4.valueTextSize = 12f
        lineDataSet4.valueTextColor = Color.DKGRAY

        linechart.getDescription().setText("")
        linechart.getDescription().setTextSize(12f)
        linechart.setDrawMarkers(false)
        linechart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM)
        linechart.animateY(1000)
        linechart.getXAxis().setGranularityEnabled(true)
        linechart.getXAxis().setGranularity(1.0f)

        setXAxisValue()
        linechart.getAxisRight().setEnabled(false)
        val axisLeft: YAxis = linechart.getAxisLeft()
        axisLeft.setAxisMinValue(0f);
        axisLeft.setGranularityEnabled(true);
        axisLeft.setGranularity(1f);
        val leg: Legend = linechart.getLegend()
        leg.setEnabled(false)
        leg.setForm(Legend.LegendForm.LINE);
//        linechart.setVisibleYRangeMaximum(85f, YAxis.AxisDependency.LEFT);
//        linechart.setScaleMinima(85f,85f);


        val dataSet = ArrayList<ILineDataSet>()
        dataSet.add(lineDataSet)
        if (title == "Blood Sugar") {
            dataSet.add(lineDataSet1)
            dataSet.add(lineDataSet2)
            dataSet.add(lineDataSet3)
            dataSet.add(lineDataSet4)
        }

        val lineData1 = LineData(dataSet)
        linechart.data = lineData1
        axisLeft.setDrawLimitLinesBehindData(true);


    }

    private fun setXAxisValue() {
        var mValues = arrayOf<String>();
        if (swtichValue) {
            mValues = arrayOf(
                "1 Year",
                "5 Years",
                "10 Years",
                "15 Years",
                "20 Years",
                "25 Years",
                "30 Years",
                "35 Years",
            )
        } else {
            mValues = arrayOf(
                "19 Aug",
                "20 Aug",
                "21 Aug",
                "22 Aug",
                "23 Aug",
                "24 Aug",
                "25 Aug",
                "26 Aug",
            )
        }

        linechart.getXAxis().setValueFormatter(object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return mValues[value.toInt()]
            }
        })

    }

    private fun getDataSet(): List<Entry> {
        val entries = ArrayList<Entry>()
        entries.add(Entry(0f, 0f))
        entries.add(Entry(1f, 70f))
        entries.add(Entry(2f, 73f))
        entries.add(Entry(3f, 80f))
        entries.add(Entry(4f, 70f))
        entries.add(Entry(5f, 73f))
        entries.add(Entry(6f, 85f))
        entries.add(Entry(7f, 70f))



        return entries
    }

    private fun getDataSet3(): List<Entry> {
        val entries = ArrayList<Entry>()
        entries.add(Entry(0f, 0f))
        entries.add(Entry(1f, 50f))
        entries.add(Entry(2f, 80f))
        entries.add(Entry(3f, 90f))
        entries.add(Entry(4f, 52f))
        entries.add(Entry(5f, 98f))
        entries.add(Entry(6f, 68f))
        entries.add(Entry(7f, 50f))



        return entries
    }

    private fun getDataSet4(): List<Entry> {
        val entries = ArrayList<Entry>()
        entries.add(Entry(0f, 0f))
        entries.add(Entry(1f, 20f))
        entries.add(Entry(2f, 50f))
        entries.add(Entry(3f, 90f))
        entries.add(Entry(4f, 32f))
        entries.add(Entry(5f, 98f))
        entries.add(Entry(6f, 58f))
        entries.add(Entry(7f, 90f))



        return entries
    }

    private fun getDataSet5(): List<Entry> {
        val entries = ArrayList<Entry>()
        entries.add(Entry(0f, 0f))
        entries.add(Entry(1f, 80f))
        entries.add(Entry(2f, 70f))
        entries.add(Entry(3f, 50f))
        entries.add(Entry(4f, 74f))
        entries.add(Entry(5f, 29f))
        entries.add(Entry(6f, 78f))
        entries.add(Entry(7f, 90f))



        return entries
    }

    private fun getDataSet2(): List<Entry> {
        val entries = ArrayList<Entry>()
        entries.add(Entry(0f, 0f))
        entries.add(Entry(1f, 80f))
        entries.add(Entry(2f, 40f))
        entries.add(Entry(3f, 76f))
        entries.add(Entry(4f, 93f))
        entries.add(Entry(5f, 08f))
        entries.add(Entry(6f, 58f))
        entries.add(Entry(7f, 90f))



        return entries
    }



}