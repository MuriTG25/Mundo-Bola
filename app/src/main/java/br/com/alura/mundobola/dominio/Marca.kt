package br.com.alura.mundobola.dominio

import java.time.LocalDateTime
import java.util.UUID

data class Marca(
    val marcaId: String = UUID.randomUUID().toString(),
    val nome: String,
    val imagem: String? = null,
    val dataCriacao: LocalDateTime,
    val dataAlteracao: LocalDateTime? = null,
    val estaAtivo: Boolean = true,
)