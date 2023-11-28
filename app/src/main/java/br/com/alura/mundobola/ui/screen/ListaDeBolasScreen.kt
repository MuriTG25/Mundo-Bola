package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.R
import br.com.alura.mundobola.ui.stateholder.ListaDeBolasUiState
import br.com.alura.mundobola.ui.components.listadebolas.ProdutoBolaComponent
import br.com.alura.mundobola.ui.extra.amostraDeListaDeBolas
import br.com.alura.mundobola.ui.extra.margemPadrao

@Composable
fun ListaDeBolasScreen(
    modifier: Modifier = Modifier,
    state: ListaDeBolasUiState,
    noClicaFab: () -> Unit = {},
    navegarParaADescricao: (String) -> Unit = {},
) {
    ScaffoldScreen (
        titulo = stringResource(id = R.string.app_name),
        mostraBusca = false,
        noClicaFab = noClicaFab,
        mostraVolta = false,
        mostraEditaEDelete = false,
    ){
        LazyVerticalGrid(
            modifier = modifier.padding(margemPadrao),
            verticalArrangement = Arrangement.spacedBy(margemPadrao),
            horizontalArrangement = Arrangement.spacedBy(margemPadrao),
            columns = GridCells.Fixed(2),
        ) {
            items(state.listaDeBolas) { bola ->
                ProdutoBolaComponent(
                    modifier = Modifier.clickable {
                        navegarParaADescricao(bola.bolaId)
                    },
                    bola = bola,
                )
            }
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