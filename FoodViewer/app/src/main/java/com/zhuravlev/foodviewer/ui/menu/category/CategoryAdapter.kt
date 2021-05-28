package com.zhuravlev.foodviewer.ui.menu.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zhuravlev.foodviewer.R
import com.zhuravlev.foodviewer.model.Category
import com.zhuravlev.foodviewer.ui.menu.dishes.DishViewHolder

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {
    var list = listOf<Category>()
    var selected: View? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        // TODO LOCAL
        if (selected == null && position == 0) {
            selected = holder.view
            holder.view.isSelected = true
        }
        holder.view.setOnClickListener {
            // TODO send message to MenuViewModel
            if (!holder.view.isSelected) {
                holder.view.isSelected = true
                selected?.isSelected = false
                selected = holder.view
            }
        }
        holder.text.text = list[position].name
    }

    override fun getItemCount(): Int = list.size

    fun updateAdapter(newList: List<Category>) {
        DiffUtilCallback(list, newList)
        val result = DiffUtil.calculateDiff(DiffUtilCallback(list, newList))
        list = newList
        result.dispatchUpdatesTo(this)
    }

    private class DiffUtilCallback(val oldList: List<Category>, val newList: List<Category>) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        // надо ли сравнивать
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].ordinal == newList[newItemPosition].ordinal
        }

        // сравнение
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].ordinal == newList[newItemPosition].ordinal
        }
    }
}