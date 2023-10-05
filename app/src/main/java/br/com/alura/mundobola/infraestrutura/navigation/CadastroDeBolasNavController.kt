package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.mundobola.aplicacao.ui.viewmodel.CadastrodeBolasViewModel
import br.com.alura.mundobola.ui.screen.CadastroDeBolasScreen

internal const val cadastroDeBolasRota = "cadastroDeBolas"

fun NavGraphBuilder.CadastroDeBolasNavController() {
    composable(cadastroDeBolasRota) {
        val viewModel = hiltViewModel<CadastrodeBolasViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        CadastroDeBolasScreen(
            state = uiState,
            noClicarSalvar = {
                viewModel.clicarSalvar()
            }
        )
    }
}

fun NavController.navegarParaCadastroDeBolas() {
    navigate(cadastroDeBolasRota) {
    }
}