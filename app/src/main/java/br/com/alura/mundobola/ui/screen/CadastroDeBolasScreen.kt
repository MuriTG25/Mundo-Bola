package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.aplicacao.ui.stateholder.CadastroDeBolasUiState
import br.com.alura.mundobola.ui.components.listadebolas.TextoProdutoComponent

@Composable
fun CadastroDeBolasScreen(
    modifier: Modifier = Modifier,
    state: CadastroDeBolasUiState,
) {
    Column (modifier = modifier.fillMaxWidth()){
        TextoProdutoComponent(texto = "Em contrução")
    }
}

@Preview
@Composable
private fun CadastroDeBolasScreenPreview() {
    CadastroDeBolasScreen(
        state = CadastroDeBolasUiState()
    )
}