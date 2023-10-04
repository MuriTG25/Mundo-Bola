package br.com.alura.mundobola.ui.components.listadebolas

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.R
import coil.compose.AsyncImage

@Composable
fun ImagemBolaComponent(
    modifier: Modifier = Modifier,
    imagemDaBola: String? = null,
    escala: ContentScale = ContentScale.Crop
) {
    AsyncImage(
        modifier = modifier,
        model = imagemDaBola,
        contentDescription = "imagem da bola",
        contentScale = escala,
        placeholder = painterResource(id = R.drawable.ic_imagem_nao_encontrado),
        error = painterResource(id = R.drawable.ic_imagem_nao_encontrado),
    )
}

@Preview(showBackground = true)
@Composable
private fun ImagemBolaComponentPreview() {
    ImagemBolaComponent()
}