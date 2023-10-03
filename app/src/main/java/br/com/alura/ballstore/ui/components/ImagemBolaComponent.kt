package br.com.alura.ballstore.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.ballstore.R
import coil.compose.AsyncImage

@Composable
fun ImagemBolaComponent(
    modifier: Modifier = Modifier,
    imagemDaBola: String? = null
) {
    AsyncImage(
        modifier = modifier
            .size(100.dp)
            .clip(CircleShape),
        model = imagemDaBola,
        contentDescription = "imagem da bola",
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.ic_imagem_nao_encontrado),
        error = painterResource(id = R.drawable.ic_imagem_nao_encontrado),
    )
}

@Preview
@Composable
private fun ImagemBolaComponentPreview() {
    ImagemBolaComponent()
}