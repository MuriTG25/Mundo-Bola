package br.com.alura.mundobola.ui.stateholder

import br.com.alura.mundobola.aplicacao.modelo.dto.BolaDTO

data class DetalhesDaMarcaUiState(
    val marcaId: String = "",
    val nome: String = "",
    val imagem: String = "",
    val dataCriacao: String = "",
    val dataAlteracao: String = "",
    val marcaEncontrada: Boolean = true,
    val listaDeBolasDaMarca: List<BolaDTO> = emptyList(),
    val expandirImagem: Boolean = false,
    val noClickDaExpansaoDaImagem: (Boolean) -> Unit = {},
    val expandirListaDeBolas: Boolean = false,
    val noClickDaExpansaoDaListaDeBolas: (Boolean) -> Unit = {},
    val ativarToast: Boolean = false,
    val expandirConfirmacaoExclusao: Boolean = false,
    val noClickConfirmacaoExclusao: (Boolean) -> Unit = {},
)
