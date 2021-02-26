package com.zhuravlev.recyclerviewexample.ui.main.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.recyclerviewexample.R
import com.zhuravlev.recyclerviewexample.model.Data
import com.zhuravlev.recyclerviewexample.utils.getColorFromString

class MainAdapter(data: Data) : RecyclerView.Adapter<MainViewHolder>() {
    val mData = data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        with(mData.categories!![position]) {
            holder.name.text = this!!.name!!
            holder.count.setBackgroundColor(getColorFromString(this!!.color!!))
            holder.count.text = this.count.toString()
        }
    }

    override fun getItemCount(): Int {
        return try {
            mData.categories!!.size
        } catch (e: Exception) {
            0
        }
    }
}