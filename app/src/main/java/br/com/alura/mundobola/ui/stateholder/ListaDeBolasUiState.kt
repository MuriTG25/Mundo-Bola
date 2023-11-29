package br.com.alura.mundobola.ui.stateholder

import br.com.alura.mundobola.aplicacao.modelo.dto.BolaDTO

data class ListaDeBolasUiState(
    val listaDeBolas: List<BolaDTO> = emptyList()
)
