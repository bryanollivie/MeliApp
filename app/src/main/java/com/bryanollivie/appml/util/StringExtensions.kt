package com.bryanollivie.appml.util

import java.math.BigDecimal
import java.net.MalformedURLException
import java.net.URL
import java.text.NumberFormat
import java.util.Locale


//Taxas de cambio
val EXCHANGE_RATE = "0.00601".toBigDecimal()

fun String.capitalizeFirstLetter(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

fun String.addExclamation(): String {
    return "$this!"
}

fun String.toCamelCase(): String {
    return this.split(" ").joinToString("") { it.capitalizeFirstLetter() }
}

fun String.limitLength(maxLength: Int): String {
    return if (this.length <= maxLength) this else this.substring(0, maxLength)
}

fun String.limitLengthWithEllipsis(maxLength: Int): String {
    return if (this.length <= maxLength) this
    else this.substring(0, maxLength) + " ..."
}

fun convertStrintToURL(urlString: String): URL? {
    return try {
        URL(urlString)
    } catch (e: MalformedURLException) {
        e.printStackTrace()
        null
    }
}

fun String.toBrazilianCurrency(): String? {
    return try {
        val value = this.toBigDecimal()
        val brazilianLocale = Locale("pt", "BR")
        val format = NumberFormat.getCurrencyInstance(brazilianLocale)
        format.format(value)
    } catch (e: NumberFormatException) {
        null // Retorna null se a string não puder ser convertida para um número
    }
}

fun String.toArgentinianPesoFormat(): String? {
    return try {
        val value = this.toBigDecimal()
        val argentinianLocale = Locale("es", "AR")
        val format = NumberFormat.getCurrencyInstance(argentinianLocale)
        format.format(value)
    } catch (e: NumberFormatException) {
        null // Retorna null se a string não puder ser convertida para um número
    }
}

fun String.convertPesosArgentinosToBrazilianReais(exchangeRate: BigDecimal): String? {
    return try {
        val valueInPesos = this.toBigDecimal()
        val valueInReais = valueInPesos * exchangeRate
        val brazilianLocale = Locale("pt", "BR")
        val format = NumberFormat.getCurrencyInstance(brazilianLocale)
        format.format(valueInReais)
    } catch (e: NumberFormatException) {
        null // Retorna null se a string não puder ser convertida para um número
    }
}