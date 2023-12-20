package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.mundobola.ui.viewmodel.ListaDeBolasViewModel
import br.com.alura.mundobola.ui.screen.ListaDeBolasScreen

internal const val listaDeBolasRota = "listaDeBolas"
private const val nomeProperty = "nome"
private const val precoProperty = "preco"
private const val dataCriacaoProperty = "dataCriacao"

fun NavGraphBuilder.ListaDeBolasNavController(
    navegarParaADescricao: (String) -> Unit = {},
    navegarParaCadastro: () -> Unit = {},
){
    composable(listaDeBolasRota){
        val viewModel = hiltViewModel<ListaDeBolasViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        ListaDeBolasScreen(
            state = uiState,
            navegarParaADescricao = {
                navegarParaADescricao(it)
            },
            noClicaFab = navegarParaCadastro,
            noClicaNomeAsc = {
                viewModel.ordenaListaPorAsc(nomeProperty)
            },
            noClicaNomeDesc = {
                viewModel.ordenaListaPorDesc(nomeProperty)
            },
            noClicaPrecoAsc = {
                viewModel.ordenaListaPorAsc(precoProperty)
            },
            noClicaPrecoDesc = {
                viewModel.ordenaListaPorDesc(precoProperty)
            },
            noClicaMaisAntigo = {
                viewModel.ordenaListaPorAsc(dataCriacaoProperty)
            },
            noClicaMaisNovo = {
                viewModel.ordenaListaPorDesc(dataCriacaoProperty)
            }
        )
    }
}
fun NavController.navegarParaListaDeBolas(){
    navigate(listaDeBolasRota){
        launchSingleTop = true
        popUpTo(graph.id){
            inclusive = true
        }
    }
}