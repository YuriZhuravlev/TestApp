package com.zhuravlev.recyclerviewexample.ui.main.recycler_view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.recyclerviewexample.R

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val view: View = itemView
    val name: TextView = itemView.findViewById(R.id.item_category_name)
    val count: TextView = itemView.findViewById(R.id.item_category_count)
}