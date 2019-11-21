package com.deepti.matches.application_card

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import android.view.ViewGroup
import com.deepti.matches.R
import com.deepti.matches.databinding.ApplicationRowBinding
import com.deepti.matches.model.TopList
import com.deepti.matches.utils.Common

class ApplicationAdapter(private var appList: ArrayList<TopList>) :
    RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ApplicationViewHolder {
        val appBinding = DataBindingUtil.inflate<ApplicationRowBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.application_row, viewGroup, false
        )
        return ApplicationViewHolder(appBinding)
    }

    override fun onBindViewHolder(holder: ApplicationViewHolder, position: Int) {
        var application = appList[position]
        holder.appBinding.tvName.text = "${application.name!!.title}. ${application.name!!.first} " +
                "${application.name!!.last}"
        holder.appBinding.age.text = "Age : ${application.dob!!.age}"
        holder.appBinding.gender.text = "Gender : ${application.gender}"
        holder.appBinding.location.text = "Location : ${application.location!!.city}," +
                "${application.location!!.state},${application.location!!.postcode}"
        Common.loadImg(application.picture!!.medium!!, holder.appBinding.customerImg)
        holder.appBinding.executePendingBindings()

    }

    class ApplicationViewHolder(val appBinding: ApplicationRowBinding) :
        RecyclerView.ViewHolder(appBinding.root)

    override fun getItemCount(): Int = appList.size

}

