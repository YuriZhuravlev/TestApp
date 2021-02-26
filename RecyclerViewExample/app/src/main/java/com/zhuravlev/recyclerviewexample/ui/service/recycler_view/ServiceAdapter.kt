package com.zhuravlev.recyclerviewexample.ui.main.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.recyclerviewexample.R
import com.zhuravlev.recyclerviewexample.model.Service

class ServiceAdapter(list: List<Service?>) : RecyclerView.Adapter<ServiceViewHolder>() {
    val mList = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        with(mList[position]) {
//            holder.name.text = this!!.name!!
//            holder.count.background.setTint(getColorFromString(this.color!!))
//            holder.count.text = this.count.toString()
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}