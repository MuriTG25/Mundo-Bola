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
)
