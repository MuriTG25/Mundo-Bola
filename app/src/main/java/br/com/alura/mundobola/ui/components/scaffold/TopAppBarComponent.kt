package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.R
import br.com.alura.mundobola.ui.components.comum.IconTopAppBarComponent
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.theme.AppPrimaryColor
import br.com.alura.mundobola.ui.theme.CorDosElementosScaffolds

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    texto: String = "",
    mostraBusca: Boolean = true,
    noClicaBusca: () -> Unit = {},
    mostraVolta: Boolean = true,
    noClicaVolta: () -> Unit = {},
    mostraEditaEDeleta: Boolean = true,
    noClicaEdita: () -> Unit = {},
    noClicaDeleta: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = {
            TextoProdutoComponent(
                texto = texto,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = CorDosElementosScaffolds
            )
        },
        actions = {
            IconTopAppBarComponent(
                mostraElemento = mostraBusca,
                noClicarBotao = noClicaBusca,
                imagemVetor = Icons.Filled.Search,
                descricaoBotao = "Buscar produto pelo nome"
            )
            IconTopAppBarComponent(
                mostraElemento = mostraEditaEDeleta,
                noClicarBotao = noClicaEdita,
                imagemVetor = Icons.Filled.Edit,
                descricaoBotao = "Editar bola"
            )
            IconTopAppBarComponent(
                mostraElemento = mostraEditaEDeleta,
                noClicarBotao = noClicaDeleta,
                imagemVetor = Icons.Filled.Delete,
                descricaoBotao = "Deletar bola"
            )
        },
        navigationIcon = {
            IconTopAppBarComponent(
                mostraElemento = mostraVolta,
                noClicarBotao = noClicaVolta,
                imagemVetor = Icons.Filled.ArrowBack,
                descricaoBotao = "Voltar para a tela anterior"
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = AppPrimaryColor
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarComponentPreviewComElementos() {
    TopAppBarComponent(
        texto = stringResource(id = R.string.app_name),
        mostraBusca = false,
    )
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarComponentPreviewSemElementos() {
    TopAppBarComponent(
        texto = stringResource(id = R.string.app_name),
        mostraBusca = false,
        mostraVolta = false,
        mostraEditaEDeleta = false,
    )
}