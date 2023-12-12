package br.com.alura.mundobola.ui.stateholder

import br.com.alura.mundobola.aplicacao.modelo.dto.BolaDTO

data class ListaDeBolasUiState(
    val listaDeBolas: List<BolaDTO> = emptyList(),
    val mostraTituloEIconeBusca: Boolean = true,
    val textoDeBusca: String = "",
    val noClicaBusca: () -> Unit = {},
    val noClicaVolta: () -> Unit = {},
    val naMudancaDaBusca: (String) -> Unit = {}
)
