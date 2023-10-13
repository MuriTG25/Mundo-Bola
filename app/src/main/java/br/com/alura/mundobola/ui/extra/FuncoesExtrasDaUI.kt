package br.com.alura.mundobola.ui.extra

import android.content.Context
import android.widget.Toast
import java.math.BigDecimal
import java.text.NumberFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun Context.mensagemDeAviso(
    texto: String,
    tempoMensagem: Int = Toast.LENGTH_SHORT,
) =
    Toast.makeText(
        this,
        texto,
        tempoMensagem,
    ).show()


