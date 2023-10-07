package br.com.alura.mundobola.ui.components.cadastrodebolas

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.ui.components.listadebolas.TextoProdutoComponent

@Composable
fun TextoCampoObrigatorioComponent(
    modifier: Modifier = Modifier,
    texto: String = "",

) {
    TextoProdutoComponent(
        modifier = modifier,
        texto = "*Campo de $texto é obrigatório",
        maxLines = 1,
        fontSize = 12.sp,
        color = Color.Red,

    )
}

@Preview
@Composable
private fun TextoCampoObrigatorioComponentPreview() {
    TextoCampoObrigatorioComponent()
}