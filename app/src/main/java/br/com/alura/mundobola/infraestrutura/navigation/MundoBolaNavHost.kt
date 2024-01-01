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
    ) {
        ListaDeBolasNavController(
            navegarParaADescricaoDeBola = { bolaId ->
                navHostController.navegarParaTelaDeDetalhesDaBola(bolaId)
            },
            navegarParaADescricaoDeMarca = { marcaId ->
                navHostController.navegarParaTelaDeDetalhesDaMarca(marcaId)
            },
            navegarParaCadastroDeBola = {
                navHostController.navegarParaCadastroDeBolas(ID_GENERICO)
            },
            navegarParaOCadastroDeMarca = {
                navHostController.navegarParaCadastroDeMarcas(ID_GENERICO)
            }
        )
        CadastroDeBolasNavController(
            irParaTelaPrincipal = {
                navHostController.navegarParaListaDeBolas()
            },
            irParaATelaDeDetalhes = { bolaId ->
                navHostController.navegarParaTelaDeDetalhesDaBola(bolaId)
            },
            voltarParaTelaAnterior = {
                navHostController.popBackStack()
            }
        )
        DetalhesDaBolaNavController(
            navegarParaTelaAnterior = {
                navHostController.popBackStack()
            },
            navegarParaTelaCadastro = { bolaId ->
                navHostController.navegarParaCadastroDeBolas(bolaId)
            }
        )
        CadastroDeMarcasNavController(
            voltarParaATelaAnterior = {
                navHostController.popBackStack()
            }
        )
        DetalhesDaMarcaNavController(
            navegarParaTelaAnterior = {
                navHostController.popBackStack()
            },
            navegarParaATelaDeCadastro = { marcaId ->
                navHostController.navegarParaCadastroDeMarcas(marcaId)
            }
        )
    }
}