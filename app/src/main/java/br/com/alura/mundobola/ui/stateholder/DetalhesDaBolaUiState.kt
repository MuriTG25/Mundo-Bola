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
    val expandirImagem: Boolean = false,
    val noClickDaImagem: (Boolean) -> Unit = {},
    val expandirDescricao: Boolean = false,
    val expandirConfirmacaoExclusao: Boolean = false,
    val noClickConfirmacaoExclusao: (Boolean) -> Unit = {},
    val noClickDaDescricao: (Boolean) -> Unit = {},
)

