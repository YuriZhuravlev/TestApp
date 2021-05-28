package com.zhuravlev.foodviewer.model

// order - можно использовать для группировки - сначала "основные блюда", потом "закуски", "кофе" и т.д.
// local name можно парсить в extension функции ссылаясь на контекст
enum class Category(val order: Int) {
    PIZZA(0),
    COMBO(1),
    DESERT(2),
    DRINK(3)
}