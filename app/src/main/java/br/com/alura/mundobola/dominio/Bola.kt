package br.com.alura.mundobola.dominio

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class Bola(
    val bolaId: String = UUID.randomUUID().toString(),
    val nome: String,
    val preco: BigDecimal,
    val marcaId: String,
    val descricao: String? = null,
    val imagem: String? = null,
    val dataCriacao: LocalDateTime,
    val dataAlteracao: LocalDateTime? = null,
    val estaAtivo: Boolean = true,
)
