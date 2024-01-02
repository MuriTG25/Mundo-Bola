package br.com.alura.mundobola.ui.components.comum

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.ui.extra.margemPadrao
import br.com.alura.mundobola.ui.extra.tamanhoFontePadrao
import br.com.alura.mundobola.ui.theme.md_theme_light_primary

@Composable
fun BotaoComponent(
    modifier: Modifier = Modifier,
    texto: String = "",
    fontSize: TextUnit = tamanhoFontePadrao,
    temImagem: Boolean = false,
    imagem: ImageVector = Icons.Filled.KeyboardArrowDown,
    noClicarBotao: () -> Unit = {}
) {
    Button(
        onClick = noClicarBotao,
        modifier = modifier,
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),


    ) {
        if (temImagem){
            Icon(
                imageVector = imagem,
                contentDescription = "Icone do Botão"
            )
        }
        Spacer(modifier = Modifier.width(margemPadrao))
        TextoProdutoComponent(
            texto = texto,
            fontSize = fontSize,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
private fun BotaoComponentSemImagemPreview() {
    BotaoComponent(texto = "Salvar")
}
@Preview
@Composable
private fun BotaoComponentComImagemPreview() {
    BotaoComponent(
        texto = "Abrir bolas da marca",
        temImagem = true
    )
}