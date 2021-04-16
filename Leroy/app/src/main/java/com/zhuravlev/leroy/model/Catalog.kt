package com.zhuravlev.leroy.model

import com.zhuravlev.leroy.R

class Catalog(val title: String, val imageId: Int) {

    fun getList(): List<Catalog> {
        return listOf(
            Catalog("Каталог", R.drawable.ic_list),
            Catalog("", R.drawable.img_garden)
        )
    }
}