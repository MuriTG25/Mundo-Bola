package br.com.alura.mundobola

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.alura.mundobola.aplicacao.extra.ID_BOLA
import br.com.alura.mundobola.aplicacao.extra.ID_GENERICO
import br.com.alura.mundobola.infraestrutura.navigation.MundoBolaNavHost
import br.com.alura.mundobola.infraestrutura.navigation.cadastroDeBolasRotaCompleto
import br.com.alura.mundobola.infraestrutura.navigation.detalhesDaBolaRota
import br.com.alura.mundobola.infraestrutura.navigation.listaDeBolasRota
import br.com.alura.mundobola.infraestrutura.navigation.navegarParaCadastroDeBolas
import br.com.alura.mundobola.ui.extra.mensagemDeAviso
import br.com.alura.mundobola.ui.screen.ScaffoldScreen
import br.com.alura.mundobola.ui.theme.MundoBolaTheme
import br.com.alura.mundobola.ui.viewmodel.ScaffoldViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MundoBolaTheme {
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
private fun TelaApp(
) {
    val navController = rememberNavController()
    val backStackEntryState by navController.currentBackStackEntryAsState()
    val idPelaRota = backStackEntryState?.arguments?.getString(ID_BOLA)
    val destinoAtual = backStackEntryState?.destination
    val rotaAtual = destinoAtual?.route
    val coroutineScope = rememberCoroutineScope()
    val viewModel = hiltViewModel<ScaffoldViewModel>()
    val context = LocalContext.current
    ScaffoldScreen (
        texto = when(rotaAtual){
            cadastroDeBolasRotaCompleto -> "Cadastrar Bola"
            detalhesDaBolaRota -> "Detalhes da Bola"
            else -> stringResource(id = R.string.app_name)
        },
        mostraFab = when(rotaAtual) {
            listaDeBolasRota -> true
            else -> false
        },
        noClicaFab = {
            navController.navegarParaCadastroDeBolas(ID_GENERICO)
        },
        mostraBusca =  false,
        mostraVolta =  when(rotaAtual) {
            cadastroDeBolasRotaCompleto, detalhesDaBolaRota -> true
            else -> false
        },
        noClicaVolta = {
            navController.navigateUp()
        },
        mostraEditaEDelete = when(rotaAtual){
            detalhesDaBolaRota -> true
            else -> false
        },
        noClicaEdita = {
            coroutineScope.launch {
                idPelaRota?.let {
                    navController.navegarParaCadastroDeBolas(it)
                }
            }
        },
        noClicaDeleta = {
            coroutineScope.launch{
                idPelaRota?.let {
                    viewModel.deletaUsuario(it)
                    context.mensagemDeAviso("Bola Deletada com sucesso")
                } ?: context.mensagemDeAviso("Falha ao deletar a bola")
                navController.navigateUp()
            }
        }
            ){
        MundoBolaNavHost(
            navHostController = navController,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TelaAppPreview() {
    TelaApp()
}


