package br.com.alura.mundobola.ui.components.comum

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import br.com.alura.mundobola.ui.extra.margemPadrao

@Composable
fun DialogComponent(
    modifier: Modifier = Modifier,
    noClickSair: () -> Unit = {},
    alturaMinima: Dp = 300.dp,
    alturaMaxima: Dp = 600.dp,
    larguraMinima: Dp = 400.dp,
    larguraMaxima: Dp = 400.dp,
    corDeFundo: Color = Color.White,
    conteudo: @Composable () -> Unit ={},
) {
    Dialog(onDismissRequest = noClickSair) {
        Column(
            modifier
                .clip(RoundedCornerShape(5))
                .heightIn(alturaMinima, alturaMaxima)
                .widthIn(larguraMinima,larguraMaxima)
                .background(corDeFundo)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(margemPadrao)
        ) {
            conteudo()
        }
    }
}