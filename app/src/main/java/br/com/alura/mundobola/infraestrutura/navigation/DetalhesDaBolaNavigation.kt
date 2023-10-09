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

internal const val detalhesDaBolaRota = "detalhesDaBola"
internal const val bolaIdRota = "bolaId"

fun NavGraphBuilder.DetalhesDaBolaNavController(
    navegarParaTelaAnterior: () -> Unit = {}
){
    composable(
        "$detalhesDaBolaRota/{$bolaIdRota}"
    ){ backStackEntry ->
        backStackEntry.arguments?.getString(bolaIdRota)?.let {id->
            val viewModel = hiltViewModel<DetalhesDaBolaViewModel>()
            val state by viewModel.uiState.collectAsState()
            LaunchedEffect(key1 = Unit){
                viewModel.buscaPorId(id)
            }
            DetalhesDaBolaScreen(
                state = state,
                id = id
            )
        }?: LaunchedEffect(key1 = Unit){
            navegarParaTelaAnterior()
        }
    }
}

fun NavController.navegarParaTelaDeDetalhes(id: String){
    navigate("$detalhesDaBolaRota/$id")
}