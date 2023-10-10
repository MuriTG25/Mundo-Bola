package br.com.alura.mundobola.ui.stateholder

import br.com.alura.mundobola.aplicacao.modelo.view.BolaView

data class ListaDeBolasUiState(
    val listaDeBolas: List<BolaView> = emptyList()
)
