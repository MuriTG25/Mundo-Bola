package br.com.alura.ballstore.aplicacao.ui.stateholder

import br.com.alura.ballstore.dominio.Bola

data class ListaDeBolasUiState(
    val listaDeBolas: List<Bola> = emptyList()
)
