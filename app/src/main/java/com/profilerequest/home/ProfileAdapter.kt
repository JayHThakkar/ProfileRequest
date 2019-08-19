package com.profilerequest.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.profilerequest.R
import com.profilerequest.data.model.Work

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    private var workDetails: List<Work> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_work, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (company, position, startDate, endDate, role) = workDetails[position]
        if (company != null) {
            holder.mCompany.text = company
        } else {
            holder.mCompany.setText(R.string.no_company)
        }
        if (position != null) {
            holder.mPosition.text = position
        } else {
            holder.mPosition.setText(R.string.no_position)
        }
        if (startDate != null) {
            holder.mStartDate.text = startDate
        } else {
            holder.mStartDate.setText(R.string.no_startdate)
        }
        if (endDate != null) {
            holder.mEndDate.text = endDate
        } else {
            holder.mEndDate.setText(R.string.no_enddate)
        }
        if (role != null) {
            holder.mRole.text = role
        } else {
            holder.mRole.setText(R.string.no_role)
        }

    }

    override fun getItemCount() = workDetails.size

    fun setProfileDetails(workDetails: List<Work>) {
        this@ProfileAdapter.workDetails = workDetails
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mCompany: TextView = itemView.findViewById(R.id.company)
        val mPosition: TextView = itemView.findViewById(R.id.position)
        val mStartDate: TextView = itemView.findViewById(R.id.startDate)
        val mEndDate: TextView = itemView.findViewById(R.id.endDate)
        val mRole: TextView = itemView.findViewById(R.id.role)
    }

    /*interface OnPhotoClickListener {
        fun onPhotoClicked(workDetails: work)
    }*/
}