package br.com.alura.mundobola.ui.components.detalhesdabola

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.components.comum.BotaoComponent
import br.com.alura.mundobola.ui.components.comum.DialogComponent
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.extra.alturaDialogPequenaMax
import br.com.alura.mundobola.ui.extra.alturaDialogPequenaMin
import br.com.alura.mundobola.ui.extra.tamanhoFontePequena

@Composable
fun DialogConfirmacaoExclusaoComponent(
    modifier: Modifier = Modifier,
    noClickDeletar: () -> Unit = {},
    noClickSair: () -> Unit = {},
) {
    DialogComponent(
        modifier = modifier,
        noClickSair = noClickSair,
        alturaMinima = alturaDialogPequenaMin,
        alturaMaxima = alturaDialogPequenaMax,
    ) {
        TextoProdutoComponent(texto = "Deseja mesmo excluir essa bola?")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            BotaoComponent(
                noClicarBotao = noClickSair,
                fontSize = tamanhoFontePequena,
                texto = "Cancelar"
            )
            BotaoComponent(
                noClicarBotao = noClickDeletar,
                fontSize = tamanhoFontePequena,
                texto = "Confirmar"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DialogConfirmacaoExclusaoComponentPreview() {
    DialogConfirmacaoExclusaoComponent()
}