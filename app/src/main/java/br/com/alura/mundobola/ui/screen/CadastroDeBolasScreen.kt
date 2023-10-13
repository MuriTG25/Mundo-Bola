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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.ui.stateholder.CadastroDeBolasUiState
import br.com.alura.mundobola.ui.components.comum.BotaoComponent
import br.com.alura.mundobola.ui.components.comum.CampoDeTextoComponent
import br.com.alura.mundobola.ui.components.cadastrodebolas.DialogCadastroImagem
import br.com.alura.mundobola.ui.components.cadastrodebolas.DialogErroPrecoComponent
import br.com.alura.mundobola.ui.components.cadastrodebolas.DropdownMenuComponent
import br.com.alura.mundobola.ui.components.cadastrodebolas.TextoCampoObrigatorioComponent
import br.com.alura.mundobola.ui.components.comum.ImagemBolaComponentComRequest
import br.com.alura.mundobola.ui.extra.margemPadrao
import coil.request.ImageRequest

@Composable
fun CadastroDeBolasScreen(
    modifier: Modifier = Modifier,
    state: CadastroDeBolasUiState,
    noCarregarImagem: (String) -> Unit = {},
    noClicarSalvar: () -> Unit = {},
) {
    Column(modifier = modifier.fillMaxSize()) {
        //TODO talvez eu altere como a imagem é exibida para ser mais intuitivo e com um visual melhor
        ImagemBolaComponentComRequest(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
                .height(200.dp)
                .clickable {
                    state.noClickDaImagem(true)
                },
            imagemDaBola = ImageRequest.Builder(LocalContext.current).data(state.fotoBola).build(),
            escala = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(margemPadrao)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(margemPadrao)
        ) {
            Column (verticalArrangement = Arrangement.spacedBy(margemPadrao/4)){
                if (state.campoNomeObrigatorio && state.campoDoNome.isBlank()){
                    TextoCampoObrigatorioComponent(texto = "Nome")
                }
                CampoDeTextoComponent(
                    nomeDoCampo = "Nome",
                    dicaDoCampo = "Insira o nome da Bola",
                    texto = state.campoDoNome,
                    naMudancaDeTexto = state.alteracaoDoCampoNome,
                )
            }
            Column (verticalArrangement = Arrangement.spacedBy(margemPadrao/4)){
                if (state.campoPrecoObrigatorio && state.campoDoPreco.isBlank()){
                    TextoCampoObrigatorioComponent(texto = "Preço")
                }
                CampoDeTextoComponent(
                    nomeDoCampo = "Preço",
                    dicaDoCampo = "Insira o preço da bola",
                    texto = state.campoDoPreco,
                    naMudancaDeTexto = state.alteracaoDoCampoPreco,
                    tipoDeTeclado = KeyboardType.Decimal,
                )
            }
            DropdownMenuComponent(
                modifier = Modifier.fillMaxWidth(),
                textoDoCampo = "Marca",
                expandir = state.expandirMenuMarca,
                alteracaoDeExpansao = state.alteracaoExpansaoMenuMarca,
                listaDeMarcas = state.listaDeMarcas,
                pegaIdMarca = state.pegaIdMarca,
                campoMarca = state.campoMarca,
                alteracaoDoCampoMarca = state.alteracaoDoCampoMarca,
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
        if (state.mostraDialogImagem) {
            DialogCadastroImagem(
                imagemBola =state.fotoBola,
                alteracaoDaImagemBola = state.alteracaoDaImagemDaBola,
                noClickSair = {
                    state.noClickDaImagem(false)
                },
                noClickConfirmar = {
                    noCarregarImagem(it)
                }
            )
        }
        if(state.mostraDialogErroPreco){
            DialogErroPrecoComponent(
                fecharDialog = {
                    state.noCLickDialogErroPreco(false)
                }
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