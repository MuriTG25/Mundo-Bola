package br.com.alura.mundobola.ui.stateholder

import br.com.alura.mundobola.aplicacao.modelo.dto.BolaDTO

data class ListaDeBolasUiState(
    val listaDeBolas: List<BolaDTO> = emptyList(),
    val listaDeBusca: List<BolaDTO> = emptyList(),
    val mostraTituloBuscaEOrdenaPor: Boolean = true,
    val textoDeBusca: String = "",
    val noClicaBusca: () -> Unit = {},
    val noClicaVolta: () -> Unit = {},
    val naMudancaDaBusca: (String) -> Unit = {},
    val expandirMenu: Boolean = false,
    val alteracaoDaExpansaoMenu: (Boolean) -> Unit = {},
)
