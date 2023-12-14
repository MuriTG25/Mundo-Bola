package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import br.com.alura.mundobola.aplicacao.extra.ID_GENERICO
//TODO pesquisar depois sobre animações em transição de telas
@Composable
fun MundoBolaNavHost(
    navHostController: NavHostController,
) {     
    NavHost(
        navController = navHostController,
        startDestination = listaDeBolasRota,
    ){
        ListaDeBolasNavController(
            navegarParaADescricao = {id ->
                navHostController.navegarParaTelaDeDetalhes(id)
            },
            navegarParaCadastro = {
                navHostController.navegarParaCadastroDeBolas(ID_GENERICO)
            }
        )
        CadastroDeBolasNavController(
            irParaTelaPrincipal = {
                navHostController.navegarParaListaDeBolas()
            },
            irParaATelaDeDetalhes = {id ->
                navHostController.navegarParaTelaDeDetalhes(id)
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