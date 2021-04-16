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
            LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        with(list[position]) {
            holder.view.setOnClickListener {
                Toast.makeText(it.context, "Click ${this.title}", Toast.LENGTH_SHORT).show()
            }
            holder.title.text = this.title
            holder.image.setImageResource(this.imageId)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}