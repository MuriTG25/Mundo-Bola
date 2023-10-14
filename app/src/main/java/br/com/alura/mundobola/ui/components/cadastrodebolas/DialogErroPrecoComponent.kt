package br.com.alura.mundobola.ui.components.cadastrodebolas

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.ui.components.comum.BotaoComponent
import br.com.alura.mundobola.ui.components.comum.DialogComponent
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.extra.tamanhoCaixaPadrao

@Composable
fun DialogErroPrecoComponent(
    modifier: Modifier = Modifier,
    fecharDialog: () -> Unit = {},
) {
    DialogComponent(
        modifier = modifier,
        alturaMinima = tamanhoCaixaPadrao,
        noClickSair = fecharDialog
    ) {
        TextoProdutoComponent(
            texto = "Utilize \",\" ou \".\" apenas para separar o real do centavos:\n ex: \"200,00 ou 200.00\"\n E não utilize outros símbolos, como \"-\", \"/\" para o preço",
            maxLines = 8,
            textAlign = TextAlign.Center
        )
        BotaoComponent(texto = "Voltar", noClicarBotao = fecharDialog)
    }

}
@Preview(showBackground = true)
@Composable
private fun DialogErroPrecoComponentPreview() {
    DialogErroPrecoComponent()
}