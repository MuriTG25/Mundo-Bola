package br.com.alura.mundobola.ui.components.comum

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun IconTopAppBarComponent(
    modifierDoButton: Modifier = Modifier,
    modifierDoIcon: Modifier = Modifier,
    mostraElemento: Boolean = false,
    noClicarBotao: () -> Unit = {},
    imagemVetor: ImageVector,
    descricaoBotao: String = "",
    cor: Color = MaterialTheme.colorScheme.onPrimary
) {
    if(mostraElemento){
        IconButton(
            modifier = modifierDoButton,
            onClick = noClicarBotao
        ) {
            Icon(
                modifier = modifierDoIcon,
                imageVector = imagemVetor,
                contentDescription = descricaoBotao,
                tint = cor,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IconTopAppBarComponentPreview() {
   IconTopAppBarComponent(imagemVetor = Icons.Filled.ArrowBack)
}