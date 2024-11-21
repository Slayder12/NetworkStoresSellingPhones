

fun main() = onlineShop()

private fun onlineShop() {

    var isFirstVisit = true
    var repairServiceFirstVisit = true

    while (true) {

        if (isFirstVisit) {
            println("Добро пожаловать в сеть магазинов по продаже телефонов!")
        }

        println("Выберите город\n1. Москва\n2. Санкт-Петербург\n0. Выход")
        val city = readlnOrNull()?.toIntOrNull()
        var bool = true

        when (city) {
            1 -> {
                val shop = Magnit()
                Process().shopping(shop)
                repairServiceFirstVisit = Process().repairPhone(repairServiceFirstVisit, shop)
                isFirstVisit = false
            }

            2 -> {
                val shop = Tehnopark()
                Process().shopping(shop)
                isFirstVisit = false
            }

            0 -> {
                bool = false
            }

            else -> {
                println("Некорректный ввод. Пожалуйста, выберите город.")
            }
        }
        if (!bool) {
            break
        }
    }
}
