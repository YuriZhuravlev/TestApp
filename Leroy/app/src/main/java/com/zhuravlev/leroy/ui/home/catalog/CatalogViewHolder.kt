package com.zhuravlev.leroy.ui.home.goods

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.leroy.R

class CatalogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val view = itemView
    val title = itemView.findViewById<TextView>(R.id.item_title_type)
    val image = itemView.findViewById<ImageView>(R.id.item_image_type)
}