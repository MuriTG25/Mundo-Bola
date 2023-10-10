package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.ui.components.comum.BotaoComponent
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.extra.margemPadrao

@Composable
fun ErroScreen(
    modifier: Modifier = Modifier,
    descricaoErro: String = "",
    navegarDeVolta: () -> Unit = {},
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically),
        verticalArrangement = Arrangement.spacedBy(margemPadrao),
        horizontalAlignment = Alignment.CenterHorizontally){
        TextoProdutoComponent(
            texto = "Falha ao $descricaoErro",
            fontSize = 24.sp,
        )
        BotaoComponent(
            texto = "Voltar",
            noClicarBotao = navegarDeVolta
            )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ErroScreenPreview() {
    ErroScreen(descricaoErro = "buscar a bola")
}