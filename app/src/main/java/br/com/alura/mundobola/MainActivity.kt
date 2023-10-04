package br.com.alura.mundobola

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.alura.mundobola.infraestrutura.navigation.MundoBolaNavHost
import br.com.alura.mundobola.infraestrutura.navigation.cadastroDeBolasRota
import br.com.alura.mundobola.infraestrutura.navigation.listaDeBolasRota
import br.com.alura.mundobola.infraestrutura.navigation.navegarParaCadastroDeBolas
import br.com.alura.mundobola.ui.screen.ScaffoldScreen
import br.com.alura.mundobola.ui.theme.BallStoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BallStoreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaApp()
                }
            }
        }
    }
}

@Composable
private fun TelaApp() {
    val navController = rememberNavController()
    val backStackEntryState by navController.currentBackStackEntryAsState()
    val destinoAtual = backStackEntryState?.destination
    ScaffoldScreen (
        noClicaFab = {
            navController.navegarParaCadastroDeBolas()
        },
        mostraFab = when(destinoAtual?.route) {
            listaDeBolasRota -> true
            else -> false
        },
        mostraBusca =  when(destinoAtual?.route) {
            listaDeBolasRota -> true
            else -> false
        },
        texto = when(destinoAtual?.route){
            cadastroDeBolasRota -> "Cadastrar Bola"
            else -> stringResource(id = R.string.app_name)
        },
        mostraVolta =  when(destinoAtual?.route) {
            cadastroDeBolasRota -> true
            else -> false
        },
        noClicaVolta = {
            navController.popBackStack()
        }
            ){
        MundoBolaNavHost(navHostController = navController)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TelaAppPreview() {
    TelaApp()
}


