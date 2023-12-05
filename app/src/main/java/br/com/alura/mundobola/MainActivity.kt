package br.com.alura.mundobola

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.alura.mundobola.infraestrutura.navigation.MundoBolaNavHost
import br.com.alura.mundobola.ui.theme.MundoBolaTheme
import dagger.hilt.android.AndroidEntryPoint

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
                    val navController = rememberNavController()
                    TelaApp(navController)
                }
            }
        }
    }
}

@Composable
private fun TelaApp(
    navController: NavHostController,
) {
    MundoBolaNavHost(
        navHostController = navController,
    )
}

@Preview(showSystemUi = true)
@Composable
private fun TelaAppPreview() {
    TelaApp(rememberNavController())
}


