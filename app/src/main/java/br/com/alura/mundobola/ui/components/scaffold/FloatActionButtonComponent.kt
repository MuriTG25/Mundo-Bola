package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.theme.AppPrimaryColor
import br.com.alura.mundobola.ui.theme.CorDosElementosScaffolds

@Composable
fun FloatActionButtonComponent(
    noClicaFab: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = noClicaFab,
        modifier = Modifier.semantics {
            contentDescription = "Adicionar Produto"
        },
        containerColor = AppPrimaryColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            tint = CorDosElementosScaffolds
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FloatActionButtonComponentPreview() {
    FloatActionButtonComponent()
}