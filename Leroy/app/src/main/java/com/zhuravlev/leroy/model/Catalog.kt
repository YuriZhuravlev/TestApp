package com.zhuravlev.leroy.model

import com.zhuravlev.leroy.R

open class Catalog(val title: String, val imageId: Int) {

    companion object {
        fun getList(): List<Catalog> {
            return listOf(
                Catalog("Каталог", R.drawable.ic_list),
                Catalog("Сад", R.drawable.img_garden),
                Catalog("Освещение", R.drawable.img_lamp),
                Catalog("Инструменты", R.drawable.img_instruments),
                Catalog("Стройматериалы", R.drawable.img_brick),
                Catalog("Декор", R.drawable.img_rull)
            )
        }
    }
}