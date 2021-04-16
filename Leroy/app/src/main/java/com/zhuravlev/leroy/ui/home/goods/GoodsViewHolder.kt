package com.zhuravlev.leroy.ui.home.goods

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.leroy.R

class GoodsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val view = itemView
    val title = itemView.findViewById<TextView>(R.id.item_title_goods)
    val price = itemView.findViewById<TextView>(R.id.item_price_goods)
    val image = itemView.findViewById<ImageView>(R.id.item_image_goods)
}