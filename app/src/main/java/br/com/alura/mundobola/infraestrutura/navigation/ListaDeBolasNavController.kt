package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.mundobola.aplicacao.ui.viewmodel.ListaDeBolasViewModel
import br.com.alura.mundobola.ui.screen.ListaDeBolasScreen

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