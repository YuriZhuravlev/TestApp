package com.zhuravlev.leroy.repository

import com.zhuravlev.leroy.model.Good
import kotlin.random.Random


object Repository {
    private val listTitles =
        "Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum".split(
            " "
        )

    fun getList(count: Int, onSuccess: (List<Good>) -> Unit) {
        val list = List<Good>(count) {
//            val random = Random(count)
            val length = Random.nextInt(1, 5)
            val title = StringBuilder()
            for (i in 0..length) {
                title.append(listTitles[Random.nextInt(listTitles.lastIndex)] + " ")
            }
            val price = "${Random.nextInt(1, 80_000)} ₽/шт"
            Good(title.toString(), price, "")
        }
        onSuccess(list)
    }
}