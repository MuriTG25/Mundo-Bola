package br.com.alura.mundobola.ui.stateholder

data class DetalhesDaBolaUiState(
    val bolaId: String = "",
    val nomeBola: String = "",
    val precoDaBola: String = "",
    val imagemDaBola: String = "",
    val descricaoDaBola: String = "",
    val nomeDaMarca: String = "",
    val dataCriacaoBola: String = "",
    val dataAlteracaoBola: String = "",
    val usuarioEncontrado: Boolean = true,
)
