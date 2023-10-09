package br.com.alura.mundobola.ui.stateholder

import br.com.alura.mundobola.dominio.Bola

data class DetalhesDaBolaUiState(
    val nomeBola: String = "",
    val precoDaBola: String = "",
    val imagemDaBola: String = "",
    val descricaoDaBola: String = "",
    val nomeDaMarca: String = "",
)
