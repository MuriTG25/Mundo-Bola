package br.com.alura.mundobola.ui.components.listadebolas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.ui.components.comum.ImagemBolaComponent
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.extra.tamanhoFonteMedia

@Composable
fun NavigationDrawerItemComImagemComponent(
    modifier: Modifier = Modifier,
    titulo: String = "",
    imagemDaMarca: String = "",
    noClicaItem: () -> Unit = {},
) {
    NavigationDrawerItem(
        modifier = modifier.border(
            BorderStroke(2.dp, color = Color.Black),
            RoundedCornerShape(10)
        ),
        label = {
            TextoProdutoComponent(
                texto = titulo,
                maxLines = 1,
            )
        },
        icon = {
            ImagemBolaComponent(
                modifier.aspectRatio(1.4F),
                imagemDaBola = imagemDaMarca,
                escala = ContentScale.FillHeight
            )
        },
        selected = false,
        onClick = noClicaItem,
    )
}
@Composable
fun NavigationDrawerItemSemImagemComponent(
    modifier: Modifier = Modifier,
    titulo: String = "",
    noClicaItem: () -> Unit = {},
) {
    NavigationDrawerItem(
        modifier = modifier.border(
            BorderStroke(2.dp, color = Color.Black),
            RoundedCornerShape(10)
        ),
        label = {
            TextoProdutoComponent(
                texto = titulo,
                fontSize = tamanhoFonteMedia,
                maxLines = 1
            )
        },
        selected = false,
        onClick = noClicaItem,
    )
}

@Preview(showBackground = true)
@Composable
private fun NavigationDrawerItemComImagemComponentPreview() {
    NavigationDrawerItemComImagemComponent(
        titulo = "Adidas"
    )
}

@Preview
@Composable
fun NavigationDrawerItemSemImagemComponentPreview() {
    NavigationDrawerItemSemImagemComponent(
        titulo = "Cadastrar Marca"
    )
}
