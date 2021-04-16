package com.zhuravlev.leroy.repository

class Categories {
    // элементы 1-го уровня
    private val groups = listOf("Обои для стен и потолка", "Оформление окна", "Карнизы для штор")

    // элементы 2-го уровня
    private val array1 = listOf("Декоративные обои", "Обои под покраску", "Фотообои")
    private val array2 = listOf("Готовые шторы и тюли", "Аксессуары для штор", "Жалюзи")
    private val array3 = listOf("Настенные карнизы", "Потолочные карнизы", "Струнные карнизы")

    // основные данные для передачи
    private val groupDataList = mutableListOf<Map<String, String>>()

    // список из всех элементов 2-го уровня
    private val childDataList: MutableList<MutableList<MutableMap<String, String>>> =
        mutableListOf()

    val group: List<Map<String, String>> = groupDataList
    val child: List<List<Map<String, String>>> = childDataList

    init {
        groups.forEach {
            val map = mutableMapOf<String, String>()
            map[GROUP_FROM[0]] = it   // add group
            groupDataList.add(map)
        }

        // добавление каждого array в childDataList
        childDataList.add(childDataItem(array1))
        childDataList.add(childDataItem(array2))
        childDataList.add(childDataItem(array3))
    }

    private fun childDataItem(array: List<String>): MutableList<MutableMap<String, String>> {
        val childDataItemList: MutableList<MutableMap<String, String>> = mutableListOf()
        array.forEach {
            val map = mutableMapOf<String, String>()
            map[CHILD_FROM[0]] = it
            childDataItemList.add(map)
        }
        return childDataItemList
    }

    companion object {
        val GROUP_FROM = listOf("group")
        val CHILD_FROM = arrayOf("elem")
    }
}