package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.mundobola.ui.screen.DetalhesDaBolaScreen
import br.com.alura.mundobola.ui.viewmodel.DetalhesDaBolaViewModel

private const val detalhesDaBolaRotaInicio = "detalhesDaBola"
internal const val bolaIdRota = "bolaId"
internal const val detalhesDaBolaRota = "$detalhesDaBolaRotaInicio/{$bolaIdRota}"


fun NavGraphBuilder.DetalhesDaBolaNavController(
    navegarParaTelaAnterior: () -> Unit = {}
){
    composable(
        detalhesDaBolaRota
    ){ backStackEntry ->
        backStackEntry.arguments?.getString(bolaIdRota)?.let {id->
            val viewModel = hiltViewModel<DetalhesDaBolaViewModel>()
            val state by viewModel.uiState.collectAsState()
            LaunchedEffect(key1 = Unit){
                viewModel.buscaPorId(id)
            }
            DetalhesDaBolaScreen(
                state = state,
                navegarDeVolta = navegarParaTelaAnterior
            )
        }?: LaunchedEffect(key1 = Unit){
            navegarParaTelaAnterior()
        }
    }
}

fun NavController.navegarParaTelaDeDetalhes(id: String){
    navigate("$detalhesDaBolaRotaInicio/$id")
}