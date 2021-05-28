package com.zhuravlev.foodviewer.ui.menu.category

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.foodviewer.R

class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val view = itemView
    val text = view.findViewById<TextView>(R.id.item_category_text)
}