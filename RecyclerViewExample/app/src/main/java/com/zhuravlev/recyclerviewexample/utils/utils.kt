package com.zhuravlev.recyclerviewexample.utils

import android.graphics.Color

fun getColorFromString(str: String): Int {
    return when (str) {
        "warning" -> Color.YELLOW
        "secondary" -> Color.GREEN
        "success" -> Color.GRAY
        "danger" -> Color.RED
        else -> Color.MAGENTA
    }
}