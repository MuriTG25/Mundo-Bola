package br.com.alura.mundobola.aplicacao.modelo.pojo

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID

data class MarcaPOJO(
    val marcaId: String,
    val nome: String,
    val imagem: String? = null,
    val dataAlteracao: LocalDateTime = LocalDateTime.now(),
)
