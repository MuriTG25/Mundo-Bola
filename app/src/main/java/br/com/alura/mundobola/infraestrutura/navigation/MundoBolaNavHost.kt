package br.com.alura.mundobola.infraestrutura.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MundoBolaNavHost(
    navHostController: NavHostController
) {     
    NavHost(
        navController = navHostController,
        startDestination = listaDeBolasRota,
    ){
        ListaDeBolasNavController()
        CadastroDeBolasNavController(
            voltarTelaAnterior = {
                navHostController.navegarParaListaDeBolas()
            }
        )
    }
}