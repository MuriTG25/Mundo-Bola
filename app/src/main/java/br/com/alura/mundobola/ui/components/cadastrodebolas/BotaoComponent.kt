package br.com.alura.mundobola.ui.components.cadastrodebolas

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.components.listadebolas.TextoProdutoComponent
import br.com.alura.mundobola.ui.theme.AppPrimaryColor
import br.com.alura.mundobola.ui.theme.CorDosElementosScaffolds

@Composable
fun BotaoComponent(
    modifier: Modifier = Modifier,
    texto: String = "",
    noClicarBotao: () -> Unit = {}
) {
    Button(
        onClick = noClicarBotao,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.buttonColors(containerColor = AppPrimaryColor),

    ) {
        TextoProdutoComponent(
            texto = texto,
            color = CorDosElementosScaffolds
        )
    }
}

@Preview
@Composable
private fun BotaoComponentPreview() {
    BotaoComponent(texto = "Salvar")
}