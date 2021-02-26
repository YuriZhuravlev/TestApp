package com.zhuravlev.recyclerviewexample.utils

import android.graphics.Color
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import com.zhuravlev.recyclerviewexample.R

fun getColorFromString(str: String): Int {
    return when (str) {
        "warning" -> Color.YELLOW
        "secondary" -> Color.GREEN
        "success" -> Color.GRAY
        "danger" -> Color.RED
        else -> Color.MAGENTA
    }
}

fun setImage(imageView: ImageView, url: String?) {
    Picasso.get().load(url).transform(CustomTransform()).into(imageView);
}

fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .setCustomAnimations(R.animator.slide_in, R.animator.slide_out)
        .addToBackStack(null)
        .replace(R.id.container, fragment)
        .commit()
}