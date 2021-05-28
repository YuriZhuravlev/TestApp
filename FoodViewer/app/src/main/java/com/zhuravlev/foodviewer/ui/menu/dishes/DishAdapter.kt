package com.zhuravlev.foodviewer.ui.menu.dishes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zhuravlev.foodviewer.R
import com.zhuravlev.foodviewer.model.Dish

class DishAdapter : RecyclerView.Adapter<DishViewHolder>() {
    var list = listOf<Dish>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        return DishViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        with(list[position]) {
            holder.title.text = name
            holder.description.text = description
            holder.price.text = price
            Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.ic_placeholder)
                .into(holder.image)
        }
    }

    override fun getItemCount(): Int = list.size

    fun updateAdapter(newList: List<Dish>) {
        DiffUtilCallback(list, newList)
        val result = DiffUtil.calculateDiff(DiffUtilCallback(list, newList))
        list = newList
        result.dispatchUpdatesTo(this)
    }

    private class DiffUtilCallback(val oldList: List<Dish>, val newList: List<Dish>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        // надо ли сравнивать
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        // сравнение
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}