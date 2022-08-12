package com.palpate


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.palpate.adapter.WeightItemAdapter
import com.palpate.adapter.WeightItemButtonAdapter
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

    private var items2 = arrayListOf("1 Week", "1 Month", "6 Months");

    private lateinit var adapter: WeightItemAdapter

    private lateinit var adapter2: WeightItemButtonAdapter
    var title = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addweight_activity)
        intent.extras?.let {
            title = intent.extras!!.getString("title")!!
            title1.text = title;
        }

        btn_add_health_stat.text="\u002b  Add "+title

        weightItem_rv.layoutManager = LinearLayoutManager(this)
        weightItem_rv.setHasFixedSize(true)
        adapter = WeightItemAdapter(items, 0)
        weightItem_rv.adapter = adapter

        weightItembutton_rv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        weightItembutton_rv.setHasFixedSize(true)
        adapter2 = WeightItemButtonAdapter(items2, 0)
        weightItembutton_rv.adapter = adapter2



        back.setOnClickListener {
            finish()
        }

        btn_add_health_stat.setOnClickListener {
            if (title=="Weight") {
                val intent = Intent(this, AddWeight1Activity::class.java)
                startActivity(intent)
            }else  if (title=="BMI") {
                val intent = Intent(this, AddBMIActivity::class.java)
                startActivity(intent)
            }else  if (title=="Heart Rate") {
                val intent = Intent(this, AddHeartRateActivity::class.java)
                startActivity(intent)
            }else  if (title=="Blood Pressure") {
                val intent = Intent(this, AddBPActivity::class.java)
                startActivity(intent)
            }else  if (title=="Temperature") {
                val intent = Intent(this, AddTempActivity::class.java)
                startActivity(intent)
            }else  if (title=="Blood Sugar") {
                val intent = Intent(this, AddBloodSugerActivity::class.java)
                startActivity(intent)
            }else  if (title=="Height") {
                val intent = Intent(this, AddHeightActivity::class.java)
                startActivity(intent)
            }else  if (title=="Oxygen Saturation") {
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

        val lineData = LineData(lineDataSet)
        linechart.getDescription().setText("")
        linechart.getDescription().setTextSize(12f)
        linechart.setDrawMarkers(false)
        linechart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM)
        linechart.animateY(1000)
        linechart.getXAxis().setGranularityEnabled(true)
        linechart.getXAxis().setGranularity(1.0f)
        linechart.getXAxis().setLabelCount(lineDataSet.entryCount)
        val mValues = arrayOf(
            "19 Aug",
            "20 Aug",
            "21 Aug",
            "22 Aug",
            "23 Aug",
            "24 Aug",
            "25 Aug",
            "26 Aug",

            )
        linechart.getXAxis().setValueFormatter(object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return mValues[value.toInt()]
            }
        })

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

        axisLeft.setDrawLimitLinesBehindData(true);

        linechart.setData(lineData)
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

}