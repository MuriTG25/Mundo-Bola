package br.com.alura.mundobola.ui.components.listadebolas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.aplicacao.modelo.view.BolaView
import br.com.alura.mundobola.ui.components.comum.ImagemBolaComponent
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.extra.bolaDeAmostra
import br.com.alura.mundobola.ui.extra.margemPadrao

@Composable
fun ProdutoBolaComponent(
    modifier: Modifier = Modifier,
    bola: BolaView,
) {
    Surface (
        modifier = modifier
            .heightIn(230.dp,300.dp)
            .widthIn(160.dp,200.dp),
        shape = RoundedCornerShape(margemPadrao),
        shadowElevation = 4.dp,
        border = BorderStroke(2.dp, color = Color.Black)
    ){
        Column (
            modifier = modifier
                .background(MaterialTheme.colorScheme.onTertiary)
                .padding(margemPadrao),
            verticalArrangement = Arrangement.spacedBy(margemPadrao/2)
        ){
            ImagemBolaComponent(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .size(100.dp)
                    .clip(CircleShape),
                imagemDaBola = bola.imagem
            )
            TextoProdutoComponent(
                texto = bola.nome,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            TextoProdutoComponent(
                texto = bola.preco,
                maxLines = 1,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BolaComponentPreview() {
    ProdutoBolaComponent(bola = bolaDeAmostra)
}