package br.com.alura.mundobola.ui.extra

import android.content.Context
import android.widget.Toast
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.paraMoedaBrasileira(): String =
    NumberFormat.getCurrencyInstance(Locale("pt", "br")).format(this)

fun Context.mensagemDeAviso(texto: String) = Toast.makeText(this, texto, Toast.LENGTH_LONG).show()