class Magnit : Shop(storeName = "Магнит", town = "Москва"), RepairService {
    override fun getPriceIndex()=  1.0
    override fun repair(){
        println("Телефон отремонтирован")
    }
}