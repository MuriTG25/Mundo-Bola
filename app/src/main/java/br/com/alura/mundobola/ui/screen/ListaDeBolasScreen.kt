package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.R
import br.com.alura.mundobola.ui.components.listadebolas.NavigationDrawerComponent
import br.com.alura.mundobola.ui.stateholder.ListaDeBolasUiState
import br.com.alura.mundobola.ui.components.listadebolas.ProdutoBolaComponent
import br.com.alura.mundobola.ui.extra.amostraDeListaDeBolas
import br.com.alura.mundobola.ui.extra.margemPadrao

@Composable
fun ListaDeBolasScreen(
    modifier: Modifier = Modifier,
    state: ListaDeBolasUiState,
    noClicaFab: () -> Unit = {},
    noClicaRealizarBusca: () -> Unit = {},
    navegarParaADescricao: (String) -> Unit = {},
    noClicaMarca: (String) -> Unit = {},
    noClicaNomeAsc: () -> Unit = {},
    noClicaNomeDesc: () -> Unit = {},
    noClicaPrecoAsc: () -> Unit = {},
    noClicaPrecoDesc: () -> Unit = {},
    noClicaMaisAntigo: () -> Unit = {},
    noClicaMaisNovo: () -> Unit = {},
) {
    val drawerState = rememberDrawerState(
        initialValue = state.expandirHome,
        )
    NavigationDrawerComponent (
        drawerState = drawerState,
        listaDeMarcas = state.listaDeMarcas,
        noClicaMarca = noClicaMarca
    ){
        ScaffoldScreen(
            titulo = stringResource(id = R.string.app_name),
            mostraTitulo = state.mostraTituloBuscaEOrdenaPor,
            mostraFab = true,
            mostraBuscaEOrdenaPor = state.mostraTituloBuscaEOrdenaPor,
            noClicaBusca = state.noClicaBusca,
            noClicaFab = noClicaFab,
            mostraTextoBusca = !state.mostraTituloBuscaEOrdenaPor,
            textoBusca = state.textoDeBusca,
            naMudancaDaBusca = state.naMudancaDaBusca,
            noClicaRealizarBusca = noClicaRealizarBusca,
            noClicaVoltaBusca = state.noClicaVolta,
            noClicaHome = state.noClicaHome,
            expandirMenu = state.expandirMenu,
            alteracaoDaExpansaoMenu = state.alteracaoDaExpansaoMenu,
            noClicaNomeAsc = noClicaNomeAsc,
            noClicaNomeDesc = noClicaNomeDesc,
            noClicaPrecoAsc = noClicaPrecoAsc,
            noClicaPrecoDesc = noClicaPrecoDesc,
            noClicaMaisNovo = noClicaMaisNovo,
            noClicaMaisAntigo = noClicaMaisAntigo
        ) {
            LazyVerticalGrid(
                modifier = modifier.padding(margemPadrao),
                verticalArrangement = Arrangement.spacedBy(margemPadrao),
                horizontalArrangement = Arrangement.spacedBy(margemPadrao),
                columns = GridCells.Fixed(2),
            ) {
                val listaDeBolas = if (state.textoDeBusca.isEmpty())
                    state.listaDeBolas
                else state.listaDeBusca
                items(listaDeBolas) { bola ->
                    ProdutoBolaComponent(
                        modifier = Modifier.clickable {
                            navegarParaADescricao(bola.bolaId)
                        },
                        bola = bola,
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ListaDeBolasScreenPreview() {
    ListaDeBolasScreen(
        state = ListaDeBolasUiState(amostraDeListaDeBolas,)
    )
}

@Preview(showSystemUi = true)
@Composable
private fun ListaDeBolasScreenComCampoDeBuscaPreview() {
    ListaDeBolasScreen(
        state = ListaDeBolasUiState(
            listaDeBolas = amostraDeListaDeBolas,
            mostraTituloBuscaEOrdenaPor = false,
        )
    )
}

@Preview(showSystemUi = true)
@Composable
private fun ListaDeBolasScreenComCampoDeBuscaDigitadoPreview() {
    ListaDeBolasScreen(
        state = ListaDeBolasUiState(
            listaDeBolas = amostraDeListaDeBolas,
            mostraTituloBuscaEOrdenaPor = false,
            textoDeBusca = "Total 90",
        )
    )
}