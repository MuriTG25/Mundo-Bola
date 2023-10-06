package br.com.alura.mundobola.ui.components.listadebolas

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.R
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ImagemBolaComponent(
    modifier: Modifier = Modifier,
    imagemDaBola: String? = "",
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
@Composable
fun ImagemBolaComponentComRequest(
    modifier: Modifier = Modifier,
    imagemDaBola: ImageRequest,
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