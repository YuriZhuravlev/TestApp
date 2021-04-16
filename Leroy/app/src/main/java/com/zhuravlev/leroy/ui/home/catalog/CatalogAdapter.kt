package com.zhuravlev.leroy.ui.home.goods

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.zhuravlev.leroy.R
import com.zhuravlev.leroy.model.Catalog


open class CatalogAdapter(val list: List<Catalog>) : Adapter<CatalogViewHolder>() {
    companion object {
        const val COMMON_TYPE = 0
        const val SHOW_ALL_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            LayoutInflater.from(parent.context).inflate(
                if (viewType == COMMON_TYPE) {
                    R.layout.item_type
                } else {
                    R.layout.item_show_all
                }, parent, false
            )

        )
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        with(list[position]) {
            val clickListener: View.OnClickListener = when (position) {
                0 -> Navigation.createNavigateOnClickListener(R.id.action_to_tile)
                list.lastIndex -> Navigation.createNavigateOnClickListener(R.id.action_to_tile)
                else -> {
                    val direction = object : NavDirections {
                        override fun getActionId(): Int {
                            return R.id.action_to_lists
                        }

                        override fun getArguments(): Bundle {
                            val bundle = Bundle()
                            bundle.putString("category", list[position].title)
                            return bundle
                        }

                    }
                    Navigation.createNavigateOnClickListener(direction)
//                    Navigation.createNavigateOnClickListener(R.id.action_to_lists)
                }
            }
            holder.view.setOnClickListener(clickListener)
            holder.title.text = this.title
            if (getItemViewType(position) == 0) {
                holder.image.setImageResource(this.imageId)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (list.lastIndex == position) {
            SHOW_ALL_TYPE
        } else {
            COMMON_TYPE
        }
    }
}