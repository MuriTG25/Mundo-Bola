package br.com.alura.ballstore.infraestrutura.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.ballstore.aplicacao.ui.viewmodel.ListaDeBolasViewModel
import br.com.alura.ballstore.ui.screen.ListaDeBolasScreen

internal const val listaDeBolasRota = "listaDeBolas"

fun NavGraphBuilder.ListaDeBolasNavController(){
    composable(listaDeBolasRota){
        val viewModel = hiltViewModel<ListaDeBolasViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        ListaDeBolasScreen(state = uiState)
    }
}
fun NavController.navegarParaListaDeBolas(){
    navigate(listaDeBolasRota){
        launchSingleTop = true
        popUpTo(listaDeBolasRota)
    }
}