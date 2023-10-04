package br.com.alura.mundobola.ui.components.listadebolas

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextoProdutoComponent(
    modifier: Modifier = Modifier,
    texto: String,
    maxLines: Int = 2,
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit = 18.sp,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.Black
) {
    Text(
        modifier = modifier,
        text = texto,
        maxLines = maxLines,
        textAlign = textAlign,
        fontSize = fontSize,
        overflow = overflow,
        fontWeight = fontWeight,
        color = color,
    )
}

@Preview(showBackground = true)
@Composable
private fun TextoProdutoComponentPreview() {
    TextoProdutoComponent(texto = LoremIpsum(10).values.toString())
}