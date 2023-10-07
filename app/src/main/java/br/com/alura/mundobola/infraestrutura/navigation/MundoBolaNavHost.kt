package br.com.alura.mundobola.infraestrutura.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
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
        ListaDeBolasNavController()
        CadastroDeBolasNavController(
            voltarTelaAnterior = {
                navHostController.navegarParaListaDeBolas()
            },
        )
    }
}