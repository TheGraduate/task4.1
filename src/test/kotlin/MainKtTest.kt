import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun сalculateCommissionVk_typeCardVkPay_pass() {
        //arrange
        val amountTest: Int = 100
        val typeCardTest: String = "VkPay"
        val lastPayTest: Int = 0

        //act
        val result = сalculateCommissionVk(amount = amountTest,
            typeCard = typeCardTest,
            lastPay = lastPayTest)

        //assert
        assertEquals("Коммиссия равна : 0", result)
    }

    @Test
    fun сalculateCommissionVk_typeCardVkPay_fail() {
        //arrange
        val amountTest: Int = 100
        val typeCardTest: String = "VkPay"
        val lastPayTest: Int = 40_000

        //act
        val result = сalculateCommissionVk(amount = amountTest,
            typeCard = typeCardTest,
            lastPay = lastPayTest)

        //assert
        assertEquals("Месячный лимит переводов исчерпан", result)
    }

    @Test
    fun сalculateCommissionVk_typeCardVisaWorld_pass_discountLess35() {
        //arrange
        val amountTest: Int = 100
        val typeCardTest: String = "Visa"
        val lastPayTest: Int = 0

        //act
        val result = сalculateCommissionVk(amount = amountTest,
            typeCard = typeCardTest,
            lastPay = lastPayTest)

        //assert
        assertEquals("Коммиссия равна : 35", result)
    }

    @Test
    fun сalculateCommissionVk_typeCardVisaWorld_pass_discountMore35() {
        //arrange
        val amountTest: Int = 25_000
        val typeCardTest: String = "Visa"
        val lastPayTest: Int = 0

        //act
        val result = сalculateCommissionVk(amount = amountTest,
            typeCard = typeCardTest,
            lastPay = lastPayTest)

        //assert
        assertEquals("Коммиссия равна : 187", result)
    }

    @Test
    fun сalculateCommissionVk_typeCardVisaWorld_fail() {
        //arrange
        val amountTest: Int = 25_000
        val typeCardTest: String = "Visa"
        val lastPayTest: Int = 599_000

        //act
        val result = сalculateCommissionVk(amount = amountTest,
            typeCard = typeCardTest,
            lastPay = lastPayTest)

        //assert
        assertEquals("Месячный лимит переводов исчерпан", result)
    }

    @Test
    fun сalculateCommissionVk_typeMasterMaestro_pass_amountLess75_000() {
        //arrange
        val amountTest: Int = 25_000
        val typeCardTest: String = "Maestro"
        val lastPayTest: Int = 0

        //act
        val result = сalculateCommissionVk(amount = amountTest,
            typeCard = typeCardTest,
            lastPay = lastPayTest)

        //assert
        assertEquals("Коммиссия равна : 0", result)
    }

    @Test
    fun сalculateCommissionVk_typeMasterMaestro_pass_amountMore75_000() {
        //arrange
        val amountTest: Int = 76_000
        val typeCardTest: String = "Maestro"
        val lastPayTest: Int = 0

        //act
        val result = сalculateCommissionVk(amount = amountTest,
            typeCard = typeCardTest,
            lastPay = lastPayTest)

        //assert
        assertEquals("Коммиссия равна : 476", result)
    }

    @Test
    fun сalculateCommissionVk_typeMasterMaestro_fail() {
        //arrange
        val amountTest: Int = 25_000
        val typeCardTest: String = "Maestro"
        val lastPayTest: Int = 599_000

        //act
        val result = сalculateCommissionVk(amount = amountTest,
            typeCard = typeCardTest,
            lastPay = lastPayTest)

        //assert
        assertEquals("Месячный лимит переводов исчерпан", result)
    }
}