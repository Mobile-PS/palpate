package com.palpate.timeline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.vipulasri.timelineview.TimelineView
import com.palpate.R
import com.palpate.model.OrderStatus
import com.palpate.model.TimeLineModel
import kotlinx.android.synthetic.main.item_timeline.view.*

class ExampleTimeLineAdapter (private val mFeedList: List<TimeLineModel>) : RecyclerView.Adapter<ExampleTimeLineAdapter.TimeLineViewHolder>() {

    private lateinit var mLayoutInflater: LayoutInflater

    override fun getItemViewType(position: Int): Int {
        return TimelineView.getTimeLineViewType(position, itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeLineViewHolder {

        if(!::mLayoutInflater.isInitialized) {
            mLayoutInflater = LayoutInflater.from(parent.context)
        }

        return TimeLineViewHolder(mLayoutInflater.inflate(R.layout.item_timeline, parent, false), viewType)
    }

    override fun onBindViewHolder(holder: TimeLineViewHolder, position: Int) {

        val timeLineModel = mFeedList[position]

        when {
            timeLineModel.status == OrderStatus.INACTIVE -> {
                setMarker(holder, R.drawable.ic_marker, R.color.material_grey_500)
            }
            timeLineModel.status == OrderStatus.ACTIVE -> {
                setMarker(holder, R.drawable.ic_marker, R.color.txtcolor3)
            }
            else -> {
                setMarker(holder, R.drawable.ic_marker, R.color.material_grey_500)
            }
        }

//        if (timeLineModel.date.isNotEmpty()) {
//            holder.txt_datetime.visibility=View.VISIBLE
//        } else
//            holder.txt_datetime.visibility=View.GONE

        holder.txtstatus.text = timeLineModel.message
        holder.txt_datetime.text = timeLineModel.date
    }

    private fun setMarker(holder: TimeLineViewHolder, drawableResId: Int, colorFilter: Int) {
        holder.timeline.marker = VectorDrawableUtils.getDrawable(
            holder.itemView.context,
            drawableResId,
            ContextCompat.getColor(holder.itemView.context, colorFilter)
        )
    }

    override fun getItemCount() = mFeedList.size

    inner class TimeLineViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {

        val txtstatus = itemView.txt_status
        val txt_datetime = itemView.txt_datetime
        val timeline = itemView.timeline

        init {
            timeline.initLine(viewType)
        }
    }

}