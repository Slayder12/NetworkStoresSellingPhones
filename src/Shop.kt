abstract class Shop(val storeName: String, val town: String): PriceFactor {

    private val smartPhoneList = DataBase().smartPhoneList.map { smartphone ->
        smartphone.copy(price = smartphone.price * getPriceIndex())
    }

    private val salesList: MutableList<Smartphone> = mutableListOf()

    fun priceList() {
        smartPhoneList.indices.forEach {
            println("$it -> ${smartPhoneList[it]}")
        }
        println("${smartPhoneList.size} -> Посмотреть статистику покупок")
    }

    fun buySmartphone(position: Int?) {

        if (position == smartPhoneList.size) {
            shoppingStatistics()
            return
        }

        if (position == null || position !in smartPhoneList.indices ) {
            println("Некорректный ввод. Пожалуйста, выберите модель телефона.")
            return
        }

        val smartphone = smartPhoneList[position]
        salesList.add(smartphone)
        println("Вы купили ${smartphone.model} за ${smartphone.price} рублей.")
    }

    private fun shoppingStatistics() {
        val buyCount = salesList.size
        val sum = salesList.sumOf { it.price }
        println("Количество купленных телефонов: $buyCount")
        println("Общая сумма покупок: $sum")
        println("Список купленных телефонов:")

        printSmartphoneCountByModel(salesList)
    }

    private fun printSmartphoneCountByModel(smartphones: List<Smartphone>) {
        val groupedByBrand = smartphones.groupBy { it.brand }

        groupedByBrand.forEach { (brand, smartphones) ->
            println("Брэнд: $brand")

            val modelCount = smartphones.groupingBy { it.model }.eachCount()
            modelCount.forEach { (model, count) ->
                println("       Модель: $model, Количество проданных: $count")
            }
        }
    }

}

