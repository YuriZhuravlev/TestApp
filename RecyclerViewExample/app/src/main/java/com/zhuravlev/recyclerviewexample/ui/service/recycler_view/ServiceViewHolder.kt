package com.zhuravlev.recyclerviewexample.ui.main.recycler_view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.recyclerviewexample.R

class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val view = itemView
    val title: TextView = itemView.findViewById(R.id.item_service_title)
    val description: TextView = itemView.findViewById(R.id.item_service_description)
    val image: ImageView = itemView.findViewById(R.id.item_service_image)
}