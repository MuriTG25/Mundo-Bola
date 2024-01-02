package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.mundobola.aplicacao.extra.ID_GENERICO
import br.com.alura.mundobola.aplicacao.extra.ID_MARCA
import br.com.alura.mundobola.ui.screen.CadastroDeMarcasScreen
import br.com.alura.mundobola.ui.viewmodel.CadastroDeMarcasViewModel
import kotlinx.coroutines.launch

internal const val cadastroDeMarcasRota = "cadastroDeMarcas"
internal const val cadastroDeMarcasRotaCompleto = "$cadastroDeMarcasRota/{$ID_MARCA}"

fun NavGraphBuilder.CadastroDeMarcasNavController(
    voltarParaATelaAnterior: () -> Unit = {},
    irParaATelaDeLista: () -> Unit = {},
    irParaATelaDeDetalhesDaMarca: (String) -> Unit = {},
){
    composable(cadastroDeMarcasRotaCompleto){ backStackEntry ->
        backStackEntry.arguments?.getString(ID_MARCA)?.let {marcaId->
            val viewModel = hiltViewModel<CadastroDeMarcasViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            val coroutineScope = rememberCoroutineScope()
            CadastroDeMarcasScreen(
                state = uiState,
                tituloDaTela = if(marcaId == ID_GENERICO) "Cadastrar Marca"
                else "Editar Marca",
                noClicaVolta = voltarParaATelaAnterior,
                noClicarSalvar = {
                    coroutineScope.launch {
                        viewModel.salvarMarca(
                            irParaATelaDeLista = irParaATelaDeLista,
                            irParaATelaDeDetalhesDaMarca = irParaATelaDeDetalhesDaMarca,
                        )
                    }
                }
            )
        }
    }
}
fun NavController.navegarParaCadastroDeMarcas(id: String) {
    navigate("$cadastroDeMarcasRota/$id") {
        launchSingleTop = true
        popBackStack("$cadastroDeMarcasRota /$id", true)
    }
}