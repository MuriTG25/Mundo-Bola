package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.components.listadebolas.TextoProdutoComponent
import br.com.alura.mundobola.ui.stateholder.DetalhesDaBolaUiState

@Composable
fun DetalhesDaBolaScreen(
    modifier: Modifier = Modifier,
    state: DetalhesDaBolaUiState,
    id: String = "",
) {
    Column (
        modifier = modifier
        .fillMaxSize()
    ){
        TextoProdutoComponent(texto = id)
    }
}

@Preview
@Composable
fun DetalhesDaBolaScreenPreview() {
    DetalhesDaBolaScreen(
        state = DetalhesDaBolaUiState()
    )
}