fun сalculateCommission(amount: Int, typeCard: String = "VkPay", lastPay: Int = 0): Int {
    var commission = 0
    if (typeCard === "VkPay" && lastPay <= 40_000 + amount || lastPay + amount <= 600_000) {
        when (typeCard) {
            "VkPay" -> commission = 0
            "Visa", "Мир" -> when {
             (amount * 0.75 / 100).toInt() > 35 -> commission = (amount * 0.75 / 100).toInt()
             (amount * 0.75 / 100).toInt() < 35 -> commission = 35
            }
            "MasterCard", "Maestro" -> when {
                lastPay <= 75_000 -> commission = 0
                lastPay > 75_000 -> commission = (amount * 0.6 / 100 + 20).toInt()
            }
        }
    }
    return commission
}

fun main() {
    println("Введите сумму для перевода")
    val amount = readLine()
    println("Введите тип карты")
    val typeCard: String? = readLine()
    println("Введите суммму предыдущих переводов")
    val lastPay = readLine()
    if (amount != null && lastPay != null && typeCard != null) {
        println( "Коммиссия равна : " + сalculateCommission(amount.toInt(), typeCard, lastPay.toInt()))
    }
}