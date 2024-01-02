package br.com.alura.mundobola.ui.screen

import android.content.Context
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.components.cadastrodebolas.TextoCampoObrigatorioComponent
import br.com.alura.mundobola.ui.components.comum.BotaoComponent
import br.com.alura.mundobola.ui.components.comum.CampoDeTextoComponent
import br.com.alura.mundobola.ui.components.comum.ImagemBolaComponent
import br.com.alura.mundobola.ui.extra.amostraDeListaDeMarcas
import br.com.alura.mundobola.ui.extra.margemPadrao
import br.com.alura.mundobola.ui.extra.mensagemDeAviso
import br.com.alura.mundobola.ui.extra.tamanhoCaixaPadrao
import br.com.alura.mundobola.ui.stateholder.CadastroDeMarcasUiState

@Composable
fun CadastroDeMarcasScreen(
    modifier: Modifier = Modifier,
    state: CadastroDeMarcasUiState,
    tituloDaTela: String = "",
    context: Context = LocalContext.current,
    noClicaVolta: () -> Unit = {},
    noClicarSalvar: () -> Unit = {}
) {
   ScaffoldScreen (
       titulo = tituloDaTela,
       mostraVolta = true,
       noClicaVolta = noClicaVolta,
   ){
       //TODO vou começar a implementar a tela de cadastro
       Column (
           modifier = modifier
               .fillMaxSize()
               .verticalScroll(rememberScrollState()),
           ){
               ImagemBolaComponent(
                   modifier = Modifier
                       .background(MaterialTheme.colorScheme.primaryContainer)
                       .fillMaxWidth()
                       .height(tamanhoCaixaPadrao),
                   imagemDaBola = state.urlImagem,
                   escala = ContentScale.FillHeight
               )
           Column(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(margemPadrao),
               verticalArrangement = Arrangement.spacedBy(margemPadrao)
           ){
               val focusManager = LocalFocusManager.current
               val acaoDoTeclado = KeyboardActions(
                   onNext = { focusManager.moveFocus(FocusDirection.Next) })
               CampoDeTextoComponent(
                   nomeDoCampo = "Url da Imagem",
                   dicaDoCampo = "Insira o link contendo a imagem da marca",
                   texto = state.urlImagem,
                   naMudancaDeTexto = state.alteracaoDoCampouUrlImagem,
                   acaoDoTeclado = acaoDoTeclado
               )
               if (state.campoNomeObrigatorio && state.campoDoNome.isBlank()) {
                   TextoCampoObrigatorioComponent(texto = "Nome")
               }
               CampoDeTextoComponent(
                   nomeDoCampo = "Nome",
                   dicaDoCampo = "Insira o nome da Marca",
                   texto = state.campoDoNome,
                   naMudancaDeTexto = state.alteracaoDoCampoNome,
               )
               BotaoComponent(
                   modifier = Modifier.fillMaxWidth(),
                   texto = "Salvar",
                   noClicarBotao = noClicarSalvar,
               )
               if( state.mensagemErroCarregamento
                   || state.mensagemCadastroConcluido
                   || state.mensagemEdicaoConcluido
               ){
                   val mensagem:String = when {
                       state.mensagemErroCarregamento -> "Marca não encontrada"
                       state.mensagemCadastroConcluido -> "Marca cadastrada com sucesso"
                       state.mensagemEdicaoConcluido -> "Marca editada com sucesso"
                       else -> ""
                   }
                   LaunchedEffect(Unit){
                       context.mensagemDeAviso(mensagem)
                   }
               }
           }
       }
   }
}

@Preview(showSystemUi = true)
@Composable
private fun CadastroDeMarcasScreenPreview() {
    CadastroDeMarcasScreen(
        state = CadastroDeMarcasUiState(),
        tituloDaTela = "Cadastrar Marca"
    )
}
@Preview(showSystemUi = true)
@Composable
private fun EdicaoDeMarcasComCamposPreenchidosScreenPreview() {
    CadastroDeMarcasScreen(
        state = CadastroDeMarcasUiState(
            campoDoNome = amostraDeListaDeMarcas.first().nome,
            marcaId = amostraDeListaDeMarcas.first().marcaId,
            urlImagem = amostraDeListaDeMarcas.first().imagem
        ),
        tituloDaTela = "Editar Marca",
    )
}