package com.zhuravlev.leroy.ui.tile.recycler

import android.os.Bundle
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.zhuravlev.leroy.R
import com.zhuravlev.leroy.model.Catalog
import com.zhuravlev.leroy.ui.home.goods.CatalogAdapter
import com.zhuravlev.leroy.ui.home.goods.CatalogViewHolder

class TileAdapter(list: List<Catalog>) : CatalogAdapter(list) {
    override fun getItemViewType(position: Int): Int {
        return COMMON_TYPE
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        with(list[position]) {
            val direction = object : NavDirections {
                override fun getActionId(): Int {
                    return R.id.action_tile_to_lists
                }

                override fun getArguments(): Bundle {
                    val bundle = Bundle()
                    bundle.putString("category", list[position].title)
                    return bundle
                }
            }
            holder.view.setOnClickListener(Navigation.createNavigateOnClickListener(direction))
            holder.title.text = this.title
            if (getItemViewType(position) == 0) {
                holder.image.setImageResource(this.imageId)
            }
        }

    }
}