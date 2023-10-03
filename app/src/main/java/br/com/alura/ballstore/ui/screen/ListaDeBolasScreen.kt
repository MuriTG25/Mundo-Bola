package br.com.alura.ballstore.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.ballstore.aplicacao.ui.stateholder.ListaDeBolasUiState
import br.com.alura.ballstore.dominio.Bola
import br.com.alura.ballstore.ui.components.ProdutoBolaComponent
import br.com.alura.ballstore.ui.extra.amostraDeListaDeBolas
import br.com.alura.ballstore.ui.extra.margemPadrao

@Composable
fun ListaDeBolasScreen(
    modifier: Modifier = Modifier,
    state: ListaDeBolasUiState,
    navegarParaADescricao: (Bola) -> Unit = {},
) {
    LazyVerticalGrid(
        modifier = modifier.padding(
            top = margemPadrao,
            start = margemPadrao,
            bottom = margemPadrao,
        ),
        verticalArrangement = Arrangement.spacedBy(margemPadrao),
        horizontalArrangement = Arrangement.spacedBy(margemPadrao),
        columns = GridCells.Fixed(2),
    ) {
        items(state.listaDeBolas) { bola ->
            ProdutoBolaComponent(
                modifier = Modifier.clickable {
                    navegarParaADescricao(bola)
                },
                bola = bola,
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ListaDeBolasScreenPreview() {
    ListaDeBolasScreen(
        state = ListaDeBolasUiState(amostraDeListaDeBolas)
    )
}