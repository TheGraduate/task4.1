fun сalculateCommissionVk(amount: Int, typeCard: String = "VkPay", lastPay: Int = 0): String {
    var commission =  "Коммиссия равна : 0"
    if (lastPay + amount >= 40_000) {
        commission = "Месячный лимит переводов исчерпан"
    }
    return commission
}

fun сalculateCommissionVisaWorld(amount: Int, typeCard: String, lastPay: Int = 0): String {
    var commission = "Месячный лимит переводов исчерпан"
    if (lastPay + amount <= 600_000) {
        when (typeCard) {
            "Visa", "Мир" -> when {
                (amount * 0.75 / 100).toInt() > 35 -> commission = "Коммиссия равна : " + ((amount * 0.75 / 100).toInt()).toString()
                (amount * 0.75 / 100).toInt() < 35 -> commission = "Коммиссия равна : " + 35.toString()
            }
        }
    }
    return commission
}

fun сalculateCommissionMasterMaestro(amount: Int, typeCard: String, lastPay: Int = 0): String {
    var commission = "Месячный лимит переводов исчерпан"
    if (lastPay + amount <= 600_000) {
        when (typeCard) {
            "MasterCard", "Maestro" -> when {
                amount <= 75_000 -> commission = "Коммиссия равна : " + 0.toString()
                amount > 75_000 -> commission = "Коммиссия равна : " + ((amount * 0.6 / 100 + 20).toInt()).toString()
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
        when (typeCard) {
            "MasterCard", "Maestro" -> println(сalculateCommissionMasterMaestro(amount.toInt(), typeCard, lastPay.toInt()))
            "Visa", "Мир" -> println(сalculateCommissionVisaWorld(amount.toInt(), typeCard, lastPay.toInt()))
            "VkPay" ->  println(сalculateCommissionVk(amount.toInt(), typeCard, lastPay.toInt()))
        }
    }
}