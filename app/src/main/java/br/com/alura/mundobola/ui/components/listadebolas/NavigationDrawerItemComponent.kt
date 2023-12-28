package br.com.alura.mundobola.ui.components.listadebolas

import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.components.comum.ImagemBolaComponent
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent

@Composable
fun NavigationDrawerItemComImagemComponent(
    modifier: Modifier = Modifier,
    titulo: String = "",
    imagemDaMarca: String = "",
    noClicaItem: () -> Unit = {},
) {
    NavigationDrawerItem(
        modifier = modifier,
        label = {
            TextoProdutoComponent(
                texto = titulo
            )
        },
        icon = {
            ImagemBolaComponent(
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
        modifier = modifier,
        label = {
            TextoProdutoComponent(
                texto = titulo
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
