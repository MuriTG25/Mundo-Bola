package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.extra.margemPadrao
import br.com.alura.mundobola.ui.stateholder.DetalhesDaBolaUiState

@Composable
fun DetalhesDaBolaScreen(
    modifier: Modifier = Modifier,
    state: DetalhesDaBolaUiState,
    navegarDeVolta: () -> Unit = {},
) {
    if (state.usuarioEncontrado) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(margemPadrao),
        ) {
            TextoProdutoComponent(texto = state.bolaId)
            TextoProdutoComponent(texto = state.nomeBola)
            TextoProdutoComponent(texto = state.precoDaBola)
            TextoProdutoComponent(texto = state.descricaoDaBola, maxLines = 5)
            TextoProdutoComponent(texto = state.imagemDaBola)
            TextoProdutoComponent(texto = state.nomeDaMarca)
            TextoProdutoComponent(texto = state.dataCriacaoBola)
            TextoProdutoComponent(texto = state.dataAlteracaoBola)
        }
    } else {
        ErroScreen(
            descricaoErro = "buscar a bola",
            navegarDeVolta = navegarDeVolta
        )
    }
}


@Preview
@Composable
fun DetalhesDaBolaScreenPreview() {
    DetalhesDaBolaScreen(
        state = DetalhesDaBolaUiState()
    )
}