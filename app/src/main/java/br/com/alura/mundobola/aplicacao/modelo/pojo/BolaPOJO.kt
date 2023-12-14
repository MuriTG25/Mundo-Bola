package br.com.alura.mundobola.aplicacao.modelo.pojo

import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.time.LocalDateTime

data class BolaPOJO(
    @PrimaryKey()
    val bolaId: String,
    val nome: String,
    val preco: BigDecimal,
    val marcaId: String? = null,
    val descricao: String? = null,
    val imagem: String? = null,
    val dataAlteracao: LocalDateTime = LocalDateTime.now(),
)
