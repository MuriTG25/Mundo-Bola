package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.aplicacao.ui.stateholder.CadastroDeBolasUiState
import br.com.alura.mundobola.ui.components.cadastrodebolas.BotaoComponent
import br.com.alura.mundobola.ui.components.cadastrodebolas.CampoDeTextoComponent
import br.com.alura.mundobola.ui.components.listadebolas.ImagemBolaComponent
import br.com.alura.mundobola.ui.extra.margemPadrao

@Composable
fun CadastroDeBolasScreen(
    modifier: Modifier = Modifier,
    noClickDaImagem: () -> Unit = {},
    state: CadastroDeBolasUiState,
    noClicarSalvar: () -> Unit = {},
) {
    Column (modifier = modifier.fillMaxSize()){
        ImagemBolaComponent(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .height(200.dp)
                .clickable {
                    noClickDaImagem()
                },
            escala = ContentScale.FillHeight
        )
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(margemPadrao)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(margemPadrao)
        ){
            CampoDeTextoComponent(
                nomeDoCampo = "Nome",
                dicaDoCampo = "Insira o nome da Bola",
                texto = state.campoDoNome,
                naMudancaDeTexto = state.alteracaoDoCampoNome,
            )
            CampoDeTextoComponent(
                nomeDoCampo = "Preço",
                dicaDoCampo = "Insira o preço da bola",
                texto = state.campoDoPreco,
                naMudancaDeTexto = state.alteracaoDoCampoPreco,
                tipoDeTeclado = KeyboardType.Decimal,
            )
            CampoDeTextoComponent(
                nomeDoCampo = "Descrição",
                dicaDoCampo = "Insira uma descrição com mais detalhes sobre o produto",
                texto = state.campoDaDescricao,
                naMudancaDeTexto = state.alteracaoDoCampoDescricao,
                maiuscula = KeyboardCapitalization.Sentences,
                acaoDeEnter = ImeAction.None,
                minimoDeLinhas = 5,
                maximoDeLinhas = 20
            )
            BotaoComponent(
                modifier = Modifier.fillMaxWidth(),
                texto = "Salvar",
                noClicarBotao = noClicarSalvar,
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CadastroDeBolasScreenPreview() {
    CadastroDeBolasScreen(
        state = CadastroDeBolasUiState()
    )
}