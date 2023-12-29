package br.com.alura.mundobola.ui.stateholder

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
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
    val naMudancaDaBusca: (String) -> Unit = {},
    val expandirOrdenacao: Boolean = false,
    val noClicaMenu: () -> Unit = {},
    val alteracaoDaExpansaoOrdenacao: (Boolean) -> Unit = {},
)
