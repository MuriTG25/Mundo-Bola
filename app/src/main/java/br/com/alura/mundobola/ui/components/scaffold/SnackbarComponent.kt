package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent

@Composable
fun SnackBarComponent(
    modifier: Modifier = Modifier,
    mensagem: String = "",
    snackbarHostState: SnackbarHostState = SnackbarHostState(),
    corDoContainer: Color = Color.White,
    shape: Shape = RoundedCornerShape(percent = 15),
    borda: Brush = SolidColor(Color.Black),

) {
    SnackbarHost (
        hostState = snackbarHostState
    ){
        Snackbar (
            modifier = modifier.border(
                width = 2.dp,
                brush = borda,
                shape = shape
            ),
            containerColor = corDoContainer,
            shape = shape
        ){
            TextoProdutoComponent(texto = mensagem)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SnackBarComponentPreview() {
    SnackBarComponent(
        mensagem = "Ola,tudo bem?",
        corDoContainer = Color.Blue
    )
}