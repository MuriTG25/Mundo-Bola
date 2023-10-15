package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.mundobola.aplicacao.extra.ID_BOLA
import br.com.alura.mundobola.ui.viewmodel.CadastrodeBolasViewModel
import br.com.alura.mundobola.ui.screen.CadastroDeBolasScreen
import kotlinx.coroutines.launch

internal const val cadastroDeBolasRota = "cadastroDeBolas"
internal const val cadastroDeBolasRotaCompleto = "$cadastroDeBolasRota/{$ID_BOLA}"

fun NavGraphBuilder.CadastroDeBolasNavController(
    irParaTelaPrincipal: () -> Unit = {},
    irParaATelaDeDetalhes: (String) -> Unit = {},
) {
    composable(cadastroDeBolasRotaCompleto) { backStackEntry->
        backStackEntry.arguments?.getString(ID_BOLA)?.let {
            val viewModel = hiltViewModel<CadastrodeBolasViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            val coroutineScope = rememberCoroutineScope()
            CadastroDeBolasScreen(
                state = uiState,
                noClicarSalvar = {
                    coroutineScope.launch {
                        viewModel.clicarSalvar(
                            irParaTelaPrincipal = irParaTelaPrincipal,
                            irParaATelaDeDetalhes = {
                                irParaATelaDeDetalhes(it)
                            },
                        )
                    }
                },
                noCarregarImagem = {linkImagem ->
                    viewModel.carregarImagem(linkImagem)
                }
            )
        }
    }
}

fun NavController.navegarParaCadastroDeBolas(id: String) {
    navigate("$cadastroDeBolasRota/$id"){
        popBackStack("$cadastroDeBolasRota/$id", true)
    }
}