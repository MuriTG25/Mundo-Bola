package br.com.alura.mundobola.ui.stateholder

import androidx.compose.material3.DrawerValue
import br.com.alura.mundobola.aplicacao.modelo.dto.BolaDTO
import br.com.alura.mundobola.aplicacao.modelo.dto.MarcaDTO

data class ListaDeBolasUiState(
    val listaDeBolas: List<BolaDTO> = emptyList(),
    val listaDeBusca: List<BolaDTO> = emptyList(),
    val listaDeMarcas: List<MarcaDTO> = emptyList(),
    val mostraTituloBuscaEOrdenaPor: Boolean = true,
    val textoDeBusca: String = "",
    val noClicaBusca: () -> Unit = {},
    val noClicaVolta: () -> Unit = {},
    val noClicaHome: () -> Unit = {},
    val naMudancaDaBusca: (String) -> Unit = {},
    val expandirMenu: Boolean = false,
    val expandirHome: DrawerValue = DrawerValue.Closed,
    val alteracaoDaExpansaoMenu: (Boolean) -> Unit = {},
)
