package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.extra.amostraDeListaDeMarcas
import br.com.alura.mundobola.ui.stateholder.DetalhesDaMarcaUiState

@Composable
fun DetalhesDaMarcaScreen(
    modifier: Modifier = Modifier,
    state: DetalhesDaMarcaUiState,
    navegarDeVolta: () -> Unit = {},
    noClicaEditaMarca: () -> Unit = {},
    noClicaDeletaMarca: () -> Unit = {},
) {
    if (state.marcaEncontrada) {
        ScaffoldScreen(
            titulo = "Detalhes da Marca",
            mostraVolta = true,
            noClicaVolta = navegarDeVolta,
            mostraEditaEDelete = true,
            noClicaEdita = noClicaEditaMarca,
            noClicaDeleta = noClicaDeletaMarca,
        ) {
            //TODO vou começar a implementar a tela de detalhes
            Column (
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ){
                TextoProdutoComponent(
                    modifier = Modifier.fillMaxWidth(),
                    texto = "ID da Marca: ${state.marcaId}",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                TextoProdutoComponent(
                    modifier = Modifier.fillMaxWidth(),
                    texto = "Nome da Marca: ${state.nome}",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    } else {
        ErroScreen(
            descricaoErro = "buscar a Marca",
            navegarDeVolta = navegarDeVolta
            )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DetalhesDaMarcaScreenPreview() {
    DetalhesDaMarcaScreen(
        state = DetalhesDaMarcaUiState(
            nome = amostraDeListaDeMarcas.first().nome,
            marcaId = amostraDeListaDeMarcas.first().marcaId,
        )
    )
}
@Preview(showSystemUi = true)
@Composable
private fun DetalhesDaMarcaScreenComErro() {
    DetalhesDaMarcaScreen(
        state = DetalhesDaMarcaUiState(
            marcaEncontrada = false,
        )
    )
}