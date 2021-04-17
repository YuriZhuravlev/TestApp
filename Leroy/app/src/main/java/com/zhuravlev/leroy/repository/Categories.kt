package com.zhuravlev.leroy.repository

class Categories(
    private val data: Map<String, List<String>> = mapOf(
        "Обои для стен и потолка" to listOf("Декоративные обои", "Обои под покраску", "Фотообои"),
        "Оформление окна" to listOf("Готовые шторы и тюли", "Аксессуары для штор", "Жалюзи"),
        "Карнизы для штор" to listOf("Настенные карнизы", "Потолочные карнизы", "Струнные карнизы")
    )
) {
    // элементы 1-го уровня
    private val groups: List<String> = data.keys.toList()

    // элементы 2-го уровня
    private val arrays: MutableList<List<String>> = mutableListOf()

    // основные данные для передачи
    private val groupDataList = mutableListOf<Map<String, String>>()

    // список из всех элементов 2-го уровня
    private val childDataList: MutableList<MutableList<MutableMap<String, String>>> =
        mutableListOf()

    val group: List<Map<String, String>> = groupDataList
    val child: List<List<Map<String, String>>> = childDataList

    init {
        groups.forEach {
            data[it]?.let { it1 -> arrays.add(it1) }
            val map = mutableMapOf<String, String>()
            map[GROUP_FROM[0]] = it   // add group
            groupDataList.add(map)
        }

        // добавление каждого array в childDataList
        arrays.forEach {
            childDataList.add(childDataItem((it)))
        }
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