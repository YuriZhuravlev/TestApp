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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {
    private var list = listOf<Category>()
    private var selectedIndex = 0
    private val _selectedFlow = MutableStateFlow<Category?>(null)
    val selectedFlow: StateFlow<Category?> = _selectedFlow

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        // TODO LOCAL
        holder.view.isSelected = (position == selectedIndex)

        holder.view.setOnClickListener {
            // TODO send message to MenuViewModel
            if (position != selectedIndex) {
                select(position)
            }
        }
        holder.text.text = list[position].name
    }

    private fun select(position: Int) {
        val oldItemPosition = selectedIndex
        selectedIndex = position
        notifyItemChanged(oldItemPosition)
        notifyItemChanged(selectedIndex)
        // не отслеживается, не отменяется
        GlobalScope.launch {
            _selectedFlow.emit(list[position])
        }
    }

    fun getCurrentCategory(): Category = list[selectedIndex]

    fun setSelectCategory(category: Category) {
        if (category != getCurrentCategory()) {
            select(category.ordinal)
        }
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