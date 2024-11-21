data class Smartphone(val brand: String, val model: String, var price: Double){
    override fun toString(): String {
        return "Брэнд: $brand, Модель: $model, Цена: $price)"
    }
}