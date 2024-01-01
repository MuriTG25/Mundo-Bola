package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.mundobola.aplicacao.extra.ID_MARCA
import br.com.alura.mundobola.ui.screen.DetalhesDaMarcaScreen
import br.com.alura.mundobola.ui.viewmodel.DetalhesDaMarcaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val detalhesDaMarcaRotaInicio = "detalhesDaMarca"
internal const val detalhesDaMarcaRota = "${detalhesDaMarcaRotaInicio}/{$ID_MARCA}"

fun NavGraphBuilder.DetalhesDaMarcaNavController(
    navegarParaTelaAnterior: () -> Unit = {},
    navegarParaATelaDeCadastro: (String) -> Unit = {},

    ) {
    composable(detalhesDaMarcaRota) { backStackEntry ->
        backStackEntry.arguments?.getString(ID_MARCA)?.let { id ->
            val viewModel = hiltViewModel<DetalhesDaMarcaViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            val coroutineScope = rememberCoroutineScope()
            DetalhesDaMarcaScreen(
                state = uiState,
                navegarDeVolta = navegarParaTelaAnterior,
                noClicaEditaMarca = {
                    navegarParaATelaDeCadastro(id)
                },
                noClicaDeletaMarca = {
                    coroutineScope.launch {
                        viewModel.deletaMarca(id)
                        launch (Dispatchers.Main){
                            navegarParaTelaAnterior()
                        }
                    }
                }
            )
        } ?: LaunchedEffect(key1 = Unit) {
            this.launch(Dispatchers.Main) {
                navegarParaTelaAnterior()
            }

        }
    }
}

fun NavController.navegarParaTelaDeDetalhesDaMarca(id: String){
    navigate("$detalhesDaMarcaRotaInicio/$id"){
        launchSingleTop = true
        popUpTo(listaDeBolasRota){
            inclusive = false
        }
    }
}