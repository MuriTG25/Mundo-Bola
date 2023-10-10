package br.com.alura.mundobola.aplicacao.extra

import java.math.BigDecimal
import java.text.NumberFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun String.paraBigDecimal() = try {
    val formatado = this.replace(",",".").replace("-","")
    formatado.toBigDecimal()
} catch (e: NumberFormatException) {
    null
}

fun LocalDateTime.dataFormatada() = this.format(DateTimeFormatter.ofPattern("dd/MM/uuuu"))

fun BigDecimal.paraMoedaBrasileira(): String =
    NumberFormat.getCurrencyInstance(Locale("pt", "br")).format(this)

fun String.estaVazio(): String?{
    return if (this.isBlank()){
        null
    } else{
        this
    }
}