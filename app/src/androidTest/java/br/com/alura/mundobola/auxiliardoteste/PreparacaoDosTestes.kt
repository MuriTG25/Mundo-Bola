package br.com.alura.mundobola.auxiliardoteste

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.platform.app.InstrumentationRegistry
import br.com.alura.mundobola.TelaApp

@Composable
fun preparacaoDosTestes(): TestNavHostController {
    val navController = TestNavHostController(context = LocalContext.current)
    navController.navigatorProvider.addNavigator(ComposeNavigator())
    TelaApp(navController)
    return navController
}

@Composable
fun insereContexto():Context {
    return InstrumentationRegistry.getInstrumentation().targetContext
}