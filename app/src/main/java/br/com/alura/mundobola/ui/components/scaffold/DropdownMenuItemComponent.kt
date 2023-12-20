package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent

@Composable
fun DropdownMenuItemComponent(
    modifier: Modifier = Modifier,
    texto: String,
    noClicaItem: () -> Unit = {},
    ) {
    DropdownMenuItem(
        modifier = modifier,
        text = {
        TextoProdutoComponent(texto = texto)
    },
        onClick = noClicaItem,
    )

}