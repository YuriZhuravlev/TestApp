package com.zhuravlev.foodviewer.ui.menu.banner

import android.graphics.*
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toRectF
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import com.zhuravlev.foodviewer.R
import com.zhuravlev.foodviewer.model.Banner

class BannerAdapter : RecyclerView.Adapter<BannerViewHolder>() {
    private var list = listOf<Banner>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        Picasso.get().load(list[position].imageUrl)
            .placeholder(R.drawable.ic_placeholder)
            .resize(256, 72)
            .transform(CustomTransform())
            .into(holder.image)
    }

    override fun getItemCount(): Int = list.size

    fun updateAdapter(newList: List<Banner>) {
        DiffUtilCallback(list, newList)
        val result = DiffUtil.calculateDiff(DiffUtilCallback(list, newList))
        list = newList
        result.dispatchUpdatesTo(this)
    }

    private class DiffUtilCallback(val oldList: List<Banner>, val newList: List<Banner>) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

    }

    private class CustomTransform : Transformation {
        override fun transform(source: Bitmap): Bitmap {
            val output = Bitmap.createBitmap(
                source.width, source.height,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(output)
            val paint = Paint()
            val rect = Rect(0, 0, source.width, source.height)
            paint.isAntiAlias = true
            paint.isFilterBitmap = true
            paint.isDither = true
            canvas.drawARGB(0, 0, 0, 0)
            paint.color = Color.parseColor("#BAB399")
            canvas.drawRoundRect(
                rect.toRectF(),
                6f,
                6f,
                paint
            )
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            canvas.drawBitmap(source, rect, rect, paint)
            if (source != output) {
                source.recycle()
            }
            return output
        }

        override fun key(): String {
            return "roundRect"
        }
    }
}