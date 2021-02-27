package com.zhuravlev.recyclerviewexample.utils

import android.graphics.*
import androidx.core.graphics.toRectF
import com.squareup.picasso.Transformation


class CustomTransform : Transformation {
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
            source.width / 10 + 0.7f,
            source.height / 10 + 0.7f,
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