package com.example.apikeypractice.util

class CreditCard {

    val ACME = 1121
    val ALFA = 1111
    val AMEX = 3796

    fun validateCreditCard(creditCard: String, expiryDate: String): Boolean {
        return checkProvider(creditCard) && verifyDate(creditCard, expiryDate)
    }

    fun verifyDate(creditCard: String, expiryDate: String): Boolean {
        return creditCard.takeLast(4) == expiryDate.replace("/", "")
    }

    fun checkProvider(creditCard: String): Boolean {
        return when (creditCard.take(4)) {
            ACME.toString() -> true
            ALFA.toString() -> true
            AMEX.toString() -> true
            else -> false
        }
    }

}