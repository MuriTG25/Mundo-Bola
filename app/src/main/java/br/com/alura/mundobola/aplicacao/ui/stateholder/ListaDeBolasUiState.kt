package br.com.alura.mundobola.aplicacao.ui.stateholder

import br.com.alura.mundobola.dominio.Bola

data class ListaDeBolasUiState(
    val listaDeBolas: List<Bola> = emptyList()
)
