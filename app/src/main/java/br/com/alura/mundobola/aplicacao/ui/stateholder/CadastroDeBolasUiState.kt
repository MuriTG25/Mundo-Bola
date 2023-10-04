package br.com.alura.mundobola.aplicacao.ui.stateholder

import br.com.alura.mundobola.dominio.Marca

data class CadastroDeBolasUiState(
    val listaDeMarcas: List<Marca> = emptyList()
)
