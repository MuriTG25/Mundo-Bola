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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.aplicacao.extra.ID_GENERICO
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.extra.amostraDeListaDeMarcas
import br.com.alura.mundobola.ui.stateholder.CadastroDeMarcasUiState

@Composable
fun CadastroDeMarcasScreen(
    modifier: Modifier = Modifier,
    state: CadastroDeMarcasUiState,
    tituloDaTela: String = "",
    noClicaVolta: () -> Unit = {}
) {
   ScaffoldScreen (
       titulo = tituloDaTela,
       mostraVolta = true,
       noClicaVolta = noClicaVolta,
   ){
       //TODO vou começar a implementar a tela de cadastro
       Column (
           modifier = modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center
           ){
           TextoProdutoComponent(
               modifier = Modifier.fillMaxWidth(),
               texto = "Em breve",
               textAlign = TextAlign.Center,
               fontSize = 30.sp,
               fontWeight = FontWeight.Bold
           )
           if(state.marcaId.isNotEmpty()){
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
private fun EdicaoDeMarcasScreenPreview() {
    CadastroDeMarcasScreen(
        state = CadastroDeMarcasUiState(
            nome = amostraDeListaDeMarcas.first().nome,
            marcaId = amostraDeListaDeMarcas.first().marcaId,
        ),
        tituloDaTela = "Editar Marca",
    )
}