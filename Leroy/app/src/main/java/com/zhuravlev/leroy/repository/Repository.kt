package com.zhuravlev.leroy.repository

import com.zhuravlev.leroy.model.Good
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random


object Repository {
    private val listTitles =
        "Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum".split(
            " "
        )
    private val listImages = listOf(
        "https://mossklad.ru/data/ruchnoi_instrument_s_gubkami_100.jpg",
        "https://img.ukr.bio/cache/images2/714668b1480818b5d0cf3aadbf368c19.jpg",
        "https://storage.webprorab.com/offers/2/0/u/x/j/r/s2314949894a9201e42f7a4919.jpg",
        "https://knipex-master.ru/wa-data/public/shop/products/89/15/1589/images/4083/4083.100x0.jpg",
        "https://opt.alfagifts.ru/image/cache/catalog/foto-tovar/nabor-instrumentov-master-42-predmeta-5346-1-400x400.jpg",
        "https://ae01.alicdn.com/kf/HTB1gYtngDCWBKNjSZFtq6yC3FXaO/94-1-4-1-2.jpg",
        "https://s1.olcso.hu/public/images/product/1/5/1/3/9/1513929260.jpg",
        "https://sun9-15.userapi.com/c11357/u11428782/d_257da7f2.jpg"
    )

    fun getList(count: Int, onSuccess: (List<Good>) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            val list = List(count) {
                val length = Random.nextInt(1, 5)
                val title = StringBuilder()
                for (i in 0..length) {
                    title.append(listTitles[Random.nextInt(listTitles.size)] + " ")
                }
                val price = "${Random.nextInt(1, 80_000)} ₽/шт"
                val url = listImages[Random.nextInt(listImages.size)]
                Good(title.toString(), price, url)
            }
            launch(Dispatchers.Main) {
                onSuccess(list)
            }
        }
    }

    fun getCategoriesByName(name: String): Categories {
        return when (name) {
            "Сад" -> Categories(
                mapOf(
                    "Семена" to listOf("Семена овощей", "Семена цветов"),
                    "Саженцы и рассада" to listOf(
                        "Садовые цветы",
                        "Плодовые деревья и кустарники",
                        "Декоративные деревья и кустарники",
                        "Декоративно-лиственные растения"
                    ),
                    "Садовая техника" to listOf("Культиваторы и мотоблоки")
                )
            )
            "Освещение" -> Categories(
                mapOf(
                    "Освещение жилых помещений" to listOf("Люстры", "Споты", "Бра")
                )
            )
            "Инструменты" -> Categories(
                mapOf(
                    "Электроинстументы" to listOf("Дрели", "Перфораторы", "УШМ"),
                    "Ручной инструмент" to listOf("Наборы инструментов", "Ключи")
                )
            )
            "Стройматериалы" -> Categories(
                mapOf(
                    "Блоки для строительства" to listOf(
                        "Блоки строительные",
                        "Кирпич",
                        "Плиты палогребневые",
                        "Стеклоблоки"
                    )
                )
            )
            "Декор" -> Categories()
            else -> Categories()
        }
    }
}