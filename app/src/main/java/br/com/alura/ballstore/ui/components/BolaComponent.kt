package br.com.alura.ballstore.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.ballstore.dominio.Bola
import br.com.alura.ballstore.ui.extra.bolaDeAmostra
import br.com.alura.ballstore.ui.extra.margemPadrao
import br.com.alura.ballstore.ui.extra.paraMoedaBrasileira

@Composable
fun ProdutoBolaComponent(
    modifier: Modifier = Modifier,
    bola: Bola,
) {
    Surface (
        modifier = modifier
            .heightIn(200.dp,300.dp)
            .width(200.dp),
        shape = RoundedCornerShape(margemPadrao),
        shadowElevation = 4.dp,
        border = BorderStroke(2.dp, color = Color.Black)
    ){
        Column (
            modifier = modifier
                .background(Color.White)
                .padding(margemPadrao),
            verticalArrangement = Arrangement.spacedBy(margemPadrao/2)
        ){
            ImagemBolaComponent(
                modifier = modifier.align(Alignment.CenterHorizontally),
                imagemDaBola = bola.imagem
            )
            TextoProdutoComponent(
                texto = bola.nome,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            TextoProdutoComponent(
                texto = bola.preco.paraMoedaBrasileira(),
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