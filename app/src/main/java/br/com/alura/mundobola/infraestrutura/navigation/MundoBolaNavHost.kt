package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import br.com.alura.mundobola.aplicacao.extra.ID_GENERICO

@Composable
fun MundoBolaNavHost(
    navHostController: NavHostController,
) {     
    NavHost(
        navController = navHostController,
        startDestination = listaDeBolasRota,
    ){
        //TODO preciso corrigir fluxo navegação
        ListaDeBolasNavController(
            navegarParaADescricao = {
                navHostController.navegarParaTelaDeDetalhes(it)
            },
            navegarParaCadastro = {
                navHostController.navegarParaCadastroDeBolas(ID_GENERICO)
            }
        )
        CadastroDeBolasNavController(
            irParaTelaPrincipal = {
                navHostController.navegarParaListaDeBolas()
            },
            irParaATelaDeDetalhes = {
                navHostController.navegarParaTelaDeDetalhes(it)
            },
            voltarParaTelaAnterior = {
                navHostController.popBackStack()
            }
        )
        DetalhesDaBolaNavController(
            navegarParaTelaAnterior = {
                navHostController.popBackStack()
            },
            navegarParaTelaCadastro = { id ->
                navHostController.navegarParaCadastroDeBolas(id)
            }
        )
    }
}