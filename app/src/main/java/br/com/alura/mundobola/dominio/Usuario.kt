package br.com.alura.mundobola.dominio

import java.time.LocalDateTime

data class Usuario(
    val cpf: String,
    val nome: String,
    val email: String,
    val senha: String,
    val dataCriacao: LocalDateTime,
    val dataAlteracao: LocalDateTime,
    val estaAtivo: Boolean = true,
)
