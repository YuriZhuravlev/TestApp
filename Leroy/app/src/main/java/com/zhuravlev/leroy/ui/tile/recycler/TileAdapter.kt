package com.zhuravlev.leroy.ui.tile.recycler

import android.widget.Toast
import com.zhuravlev.leroy.model.Catalog
import com.zhuravlev.leroy.ui.home.goods.CatalogAdapter
import com.zhuravlev.leroy.ui.home.goods.CatalogViewHolder

class TileAdapter(list: List<Catalog>) : CatalogAdapter(list) {
    override fun getItemViewType(position: Int): Int {
        return COMMON_TYPE
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        with(list[position]) {
            holder.view.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "Click ${this.title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            holder.title.text = this.title
            if (getItemViewType(position) == 0) {
                holder.image.setImageResource(this.imageId)
            }
        }

    }
}