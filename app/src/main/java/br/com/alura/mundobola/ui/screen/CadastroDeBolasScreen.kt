package br.com.alura.mundobola.ui.screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.stateholder.CadastroDeBolasUiState
import br.com.alura.mundobola.ui.components.comum.BotaoComponent
import br.com.alura.mundobola.ui.components.comum.CampoDeTextoComponent
import br.com.alura.mundobola.ui.components.cadastrodebolas.DialogCadastroImagem
import br.com.alura.mundobola.ui.components.cadastrodebolas.DialogErroPrecoComponent
import br.com.alura.mundobola.ui.components.cadastrodebolas.DropdownMenuComponent
import br.com.alura.mundobola.ui.components.cadastrodebolas.TextoCampoObrigatorioComponent
import br.com.alura.mundobola.ui.components.comum.ImagemBolaComponentComRequest
import br.com.alura.mundobola.ui.extra.margemPadrao
import br.com.alura.mundobola.ui.extra.mensagemDeAviso
import br.com.alura.mundobola.ui.extra.tamanhoCaixaPadrao
import coil.request.ImageRequest

@Composable
fun CadastroDeBolasScreen(
    modifier: Modifier = Modifier,
    state: CadastroDeBolasUiState,
    tituloTela: String = "",
    context:Context = LocalContext.current,
    noCarregarImagem: (String) -> Unit = {},
    noClicaVolta: () -> Unit = {},
    noClicarSalvar: () -> Unit = {},
) {
    ScaffoldScreen (
        titulo = tituloTela,
//        "Cadastrar/Editar Bola",
        mostraVolta = true,
        noClicaVolta = noClicaVolta,
    ){
        Column(modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
            //TODO talvez eu altere como a imagem é exibida para ser mais intuitivo e com um visual melhor
            ImagemBolaComponentComRequest(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .fillMaxWidth()
                    .height(tamanhoCaixaPadrao)
                    .clickable {
                        state.noClickDaImagem(true)
                    },
                imagemDaBola = ImageRequest.Builder(LocalContext.current).data(state.fotoBola).build(),
                escala = ContentScale.FillHeight
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(margemPadrao),
                verticalArrangement = Arrangement.spacedBy(margemPadrao)
            ) {
                val focusManager = LocalFocusManager.current
                val acaoDoTeclado = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) })
                Column(verticalArrangement = Arrangement.spacedBy(margemPadrao / 4)) {
                    if (state.campoNomeObrigatorio && state.campoDoNome.isBlank()) {
                        TextoCampoObrigatorioComponent(texto = "Nome")
                    }
                    CampoDeTextoComponent(
                        nomeDoCampo = "Nome",
                        dicaDoCampo = "Insira o nome da Bola",
                        texto = state.campoDoNome,
                        naMudancaDeTexto = state.alteracaoDoCampoNome,
                        acaoDoTeclado = acaoDoTeclado
                    )
                }
                Column(verticalArrangement = Arrangement.spacedBy(margemPadrao / 4)) {
                    if (state.campoPrecoObrigatorio && state.campoDoPreco.isBlank()) {
                        TextoCampoObrigatorioComponent(texto = "Preço")
                    }
                    CampoDeTextoComponent(
                        nomeDoCampo = "Preço",
                        dicaDoCampo = "Insira o preço da bola",
                        texto = state.campoDoPreco,
                        naMudancaDeTexto = state.alteracaoDoCampoPreco,
                        tipoDeTeclado = KeyboardType.Decimal,
                        acaoDoTeclado = acaoDoTeclado
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
                    maximoDeLinhas = 20,
                )
                BotaoComponent(
                    modifier = Modifier.fillMaxWidth(),
                    texto = "Salvar",
                    noClicarBotao = noClicarSalvar,
                )
            }
            if (state.mostraDialogImagem) {
                DialogCadastroImagem(
                    imagemBola = state.fotoBola,
                    alteracaoDaImagemBola = state.alteracaoDaImagemDaBola,
                    noClickSair = {
                        state.noClickDaImagem(false)
                    },
                    noClickConfirmar = {
                        noCarregarImagem(it)
                    }
                )
            }
            if (state.mostraDialogErroPreco) {
                DialogErroPrecoComponent(
                    fecharDialog = {
                        state.noCLickDialogErroPreco(false)
                    }
                )
            }
            //TODO talvez eu altere o toast para snackbar
            if(state.mensagemErroCarregamento
                || state.mensagemCadastroConcluido
                || state.mensagemEdicaoConcluido
            ){
                val mensagem:String = when {
                    state.mensagemErroCarregamento -> "Bola não encontrada"
                    state.mensagemCadastroConcluido -> "Bola cadastrada com sucesso"
                    state.mensagemEdicaoConcluido -> "Bola editada com sucesso"
                    else -> ""
                }
                LaunchedEffect( Unit){
                    context.mensagemDeAviso(mensagem)
                }
            }
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