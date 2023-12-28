package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.mundobola.aplicacao.extra.ID_BOLA
import br.com.alura.mundobola.ui.screen.DetalhesDaBolaScreen
import br.com.alura.mundobola.ui.viewmodel.DetalhesDaBolaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val detalhesDaBolaRotaInicio = "detalhesDaBola"
internal const val detalhesDaBolaRota = "$detalhesDaBolaRotaInicio/{$ID_BOLA}"


fun NavGraphBuilder.DetalhesDaBolaNavController(
    navegarParaTelaAnterior: () -> Unit = {},
    navegarParaTelaCadastro: (String) -> Unit = {}
){
    composable(
        detalhesDaBolaRota
    ){ backStackEntry ->
        backStackEntry.arguments?.getString(ID_BOLA)?.let { id->
            val viewModel = hiltViewModel<DetalhesDaBolaViewModel>()
            val state by viewModel.uiState.collectAsState()
            val coroutineScope = rememberCoroutineScope()
            DetalhesDaBolaScreen(
                state = state,
                navegarDeVolta = navegarParaTelaAnterior,
                noClicaEdita = {
                    navegarParaTelaCadastro(id)
                },
                noClicaDeleta = {
                    coroutineScope.launch {
                        viewModel.deletaBola(id)
                        launch(Dispatchers.Main){
                            navegarParaTelaAnterior()
                        }
                    }
                }
            )
        }?: LaunchedEffect(key1 = Unit){
            this.launch(Dispatchers.Main){
                navegarParaTelaAnterior()
            }
        }
    }
}

fun NavController.navegarParaTelaDeDetalhes(id: String){
    navigate("$detalhesDaBolaRotaInicio/$id"){
        launchSingleTop = true
        popUpTo(listaDeBolasRota){
            inclusive = false
        }
    }
}