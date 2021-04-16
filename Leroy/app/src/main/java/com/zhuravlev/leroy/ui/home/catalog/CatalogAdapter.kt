package com.zhuravlev.leroy.ui.home.goods

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.zhuravlev.leroy.R
import com.zhuravlev.leroy.model.Catalog


class CatalogAdapter(val list: List<Catalog>) : Adapter<CatalogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            LayoutInflater.from(parent.context).inflate(
                if (viewType == 0) {
                    R.layout.item_type
                } else {
                    R.layout.item_show_all
                }, parent, false
            )

        )
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        with(list[position]) {
            holder.view.setOnClickListener {
                Toast.makeText(it.context, "Click ${this.title}", Toast.LENGTH_SHORT).show()
            }
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
            1
        } else {
            0
        }
    }
}