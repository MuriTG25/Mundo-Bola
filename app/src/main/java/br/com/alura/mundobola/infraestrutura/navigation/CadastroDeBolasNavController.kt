package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.mundobola.aplicacao.ui.viewmodel.CadastrodeBolasViewModel
import br.com.alura.mundobola.ui.screen.CadastroDeBolasScreen
import kotlinx.coroutines.launch

internal const val cadastroDeBolasRota = "cadastroDeBolas"

fun NavGraphBuilder.CadastroDeBolasNavController() {
    composable(cadastroDeBolasRota) {
        val viewModel = hiltViewModel<CadastrodeBolasViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        val coroutineScope = rememberCoroutineScope()
        CadastroDeBolasScreen(
            state = uiState,
            noClicarSalvar = {
                coroutineScope.launch {
                    viewModel.clicarSalvar()
                }
            }
        )
    }
}

fun NavController.navegarParaCadastroDeBolas() {
    navigate(cadastroDeBolasRota) {
    }
}