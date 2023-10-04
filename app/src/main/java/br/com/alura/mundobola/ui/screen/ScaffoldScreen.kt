package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.components.scaffold.FloatActionButtonComponent
import br.com.alura.mundobola.ui.components.scaffold.TopAppBarComponent

@Composable
fun ScaffoldScreen(
    nabusca: () -> Unit = {},
    noClicaFab: () -> Unit = {},
    conteudo: @Composable () -> Unit,
) {
    Scaffold (
        topBar = {
            TopAppBarComponent(
                nabusca
            )
        },
        floatingActionButton = {
            FloatActionButtonComponent(
                noClicaFab
            )
        }
    ){
        Box (
            modifier = Modifier.padding(it)
        ){
            conteudo()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ScaffoldScreenPreview() {
    ScaffoldScreen(){}
}