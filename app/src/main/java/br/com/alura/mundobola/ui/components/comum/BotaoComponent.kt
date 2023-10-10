package br.com.alura.mundobola.ui.components.comum

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.ui.theme.AppPrimaryColor
import br.com.alura.mundobola.ui.theme.CorDosElementosScaffolds

@Composable
fun BotaoComponent(
    modifier: Modifier = Modifier,
    texto: String = "",
    fontSize: TextUnit = 18.sp,
    noClicarBotao: () -> Unit = {}
) {
    Button(
        onClick = noClicarBotao,
        modifier = modifier,
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.buttonColors(containerColor = AppPrimaryColor),

    ) {
        TextoProdutoComponent(
            texto = texto,
            fontSize = fontSize,
            color = CorDosElementosScaffolds
        )
    }
}

@Preview
@Composable
private fun BotaoComponentPreview() {
    BotaoComponent(texto = "Salvar")
}