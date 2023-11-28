package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.mundobola.aplicacao.extra.ID_BOLA
import br.com.alura.mundobola.aplicacao.extra.ID_GENERICO
import br.com.alura.mundobola.ui.viewmodel.CadastrodeBolasViewModel
import br.com.alura.mundobola.ui.screen.CadastroDeBolasScreen
import kotlinx.coroutines.launch

internal const val cadastroDeBolasRota = "cadastroDeBolas"
internal const val cadastroDeBolasRotaCompleto = "$cadastroDeBolasRota/{$ID_BOLA}"

fun NavGraphBuilder.CadastroDeBolasNavController(
    irParaTelaPrincipal: () -> Unit = {},
    voltarParaTelaAnterior: () -> Unit = {},
    irParaATelaDeDetalhes: (String) -> Unit = {},
) {
    composable(cadastroDeBolasRotaCompleto) { backStackEntry ->
        backStackEntry.arguments?.getString(ID_BOLA)?.let {id ->
            val viewModel = hiltViewModel<CadastrodeBolasViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            val coroutineScope = rememberCoroutineScope()
            CadastroDeBolasScreen(
                tituloTela = if (id == ID_GENERICO) "Cadastrar Bola"
                 else "Editar Bola",
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
                noCarregarImagem = { linkImagem ->
                    viewModel.carregarImagem(linkImagem)
                },
                noClicaVolta = voltarParaTelaAnterior
            )
        }
    }
}

fun NavController.navegarParaCadastroDeBolas(id: String) {
    navigate("$cadastroDeBolasRota/$id") {
        launchSingleTop = true
        popBackStack("$cadastroDeBolasRota/$id", true)
    }
}