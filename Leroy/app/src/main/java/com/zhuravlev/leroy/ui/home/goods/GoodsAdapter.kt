package com.zhuravlev.leroy.ui.home.goods

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.squareup.picasso.Picasso
import com.zhuravlev.leroy.R
import com.zhuravlev.leroy.model.Good


class GoodsAdapter(val list: List<Good>) : Adapter<GoodsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsViewHolder {
        return GoodsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_goods, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GoodsViewHolder, position: Int) {
        with(list[position]) {
            holder.view.setOnClickListener {
                Toast.makeText(it.context, "Click ${this.title}", Toast.LENGTH_SHORT).show()
            }
            holder.title.text = this.title
            holder.price.text = this.price
            if (this.imageUrl.isNotEmpty()) {
                Picasso.get()
                    .load(this.imageUrl)
                    .placeholder(R.drawable.ic_list)
                    .error(R.drawable.ic_list)
                    .into(holder.image)
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}