package br.com.alura.mundobola.ui.stateholder

import java.time.LocalDateTime

data class CadastroDeMarcasUiState(
    val marcaId: String = "",
    val nome: String = "",
    val imagem: String = "",
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
)
