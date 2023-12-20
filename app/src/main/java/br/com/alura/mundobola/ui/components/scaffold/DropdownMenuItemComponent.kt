package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent

@Composable
fun DropdownMenuItemComponent(
    modifier: Modifier = Modifier,
    texto: String,
    noClicaItem: () -> Unit = {},
    ) {
    DropdownMenuItem(
        modifier = modifier.fillMaxWidth(),
        text = {
        TextoProdutoComponent(
            modifier =Modifier.fillMaxWidth(),
            texto = texto,
            maxLines = 1
        )
    },
        onClick = noClicaItem,
    )

}