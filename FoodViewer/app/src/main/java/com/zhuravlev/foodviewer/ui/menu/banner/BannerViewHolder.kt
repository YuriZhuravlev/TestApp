package com.zhuravlev.foodviewer.ui.menu.banner

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.foodviewer.R

class BannerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val view = itemView
    val image = view.findViewById<ImageView>(R.id.banner_image)
}