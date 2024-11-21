class Process {

    fun shopping(shop: Shop) {
        while (true) {
            println("Выберите модель телефона (введите номер):")
            shop.priceList()
            val model = readlnOrNull()?.toIntOrNull()
            shop.buySmartphone(model)

            println("Хотите ли вы продолжить покупки? (да/нет)")
            val buy = readlnOrNull()?.trim()?.lowercase()
            if (buy != "да") {
                break
            }

        }
    }

    fun repairPhone(isVisit: Boolean, shop: Magnit): Boolean {
        if (isVisit) {
            println("Хотите ли вы починить свой телефон? (да/нет)")
            val repair = readlnOrNull()?.trim()?.lowercase()
            if (repair == "да") {
                shop.repair()
            }
        }
        return false
    }
}