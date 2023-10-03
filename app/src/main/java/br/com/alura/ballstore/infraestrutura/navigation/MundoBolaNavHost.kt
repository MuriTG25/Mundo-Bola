package br.com.alura.ballstore.infraestrutura.navigation

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
    }
}