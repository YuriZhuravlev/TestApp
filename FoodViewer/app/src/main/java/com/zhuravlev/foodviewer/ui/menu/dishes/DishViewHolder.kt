package com.zhuravlev.foodviewer.ui.menu.dishes

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.foodviewer.R

/**
 * @param itemView R.layout.item_dish
 */
class DishViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val view = itemView
    val title = view.findViewById<TextView>(R.id.dish_title)
    val description = view.findViewById<TextView>(R.id.dish_description)
    val price = view.findViewById<TextView>(R.id.dish_price)
    val image = view.findViewById<ImageView>(R.id.dish_img)
}