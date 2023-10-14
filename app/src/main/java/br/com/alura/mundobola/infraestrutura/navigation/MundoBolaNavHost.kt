package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

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
            }
        )
        CadastroDeBolasNavController(
            irParaTelaPrincipal = {
                navHostController.navegarParaListaDeBolas()
            },
            irParaATelaDeDetalhes = {
                navHostController.navegarParaTelaDeDetalhes(it)
            }
        )
        DetalhesDaBolaNavController(
            navegarParaTelaAnterior = {
                navHostController.popBackStack()
            }
        )
    }
}