package br.com.alura.ballstore.ui.extra

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.paraMoedaBrasileira():String =
    NumberFormat.getCurrencyInstance(Locale("pt","br")).format(this)