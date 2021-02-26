package com.zhuravlev.recyclerviewexample.utils

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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

fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.animator.slide_in, R.animator.slide_out)
            .addToBackStack(null)
            .replace(R.id.container, fragment)
            .commit()
}