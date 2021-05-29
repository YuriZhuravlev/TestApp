package com.zhuravlev.foodviewer.ui.menu.spinner

import android.content.Context
import android.widget.ArrayAdapter
import com.zhuravlev.foodviewer.model.Location

fun locationAdapter(context: Context, list: List<Location>): ArrayAdapter<String> {
    val mutableList = mutableListOf<String>()
    list.forEach {
        mutableList.add(it.name)
    }
    val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, mutableList)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    return adapter
}
