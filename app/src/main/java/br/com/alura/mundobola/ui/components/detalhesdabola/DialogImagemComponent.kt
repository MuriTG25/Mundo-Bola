package br.com.alura.mundobola.ui.components.detalhesdabola

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.ui.components.comum.DialogComponent
import br.com.alura.mundobola.ui.components.comum.ImagemBolaComponent
import br.com.alura.mundobola.ui.extra.margemPadrao

@Composable
fun DialogImagemComponent(
    modifier: Modifier = Modifier,
    imagemDaBola: String = "",
    noClickkSair: () -> Unit = {},

) {
    DialogComponent(
        modifier = Modifier,
        alturaMaxima = 800.dp,
        larguraMaxima = 600.dp,
        noClickSair = noClickkSair
    ) {
        ImagemBolaComponent(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer),
            imagemDaBola = imagemDaBola,
            escala = ContentScale.FillWidth,
        )
    }
}