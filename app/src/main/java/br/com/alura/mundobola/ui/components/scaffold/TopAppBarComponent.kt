package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.R
import br.com.alura.mundobola.ui.components.listadebolas.TextoProdutoComponent
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
            if (mostraBusca) {
                IconButton(
                    onClick = noClicaBusca
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Buscar produto pelo nome",
                        tint = CorDosElementosScaffolds,
                    )
                }
            }
        },
        navigationIcon = {
            if (mostraVolta) {
                IconButton(
                    onClick = noClicaVolta
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Voltar para a tela anterior",
                        tint = CorDosElementosScaffolds,
                    )
                }
            }
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
        texto = stringResource(id = R.string.app_name)
    )
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarComponentPreviewSemElementos() {
    TopAppBarComponent(
        texto = stringResource(id = R.string.app_name),
        mostraBusca = false,
        mostraVolta = false,
    )
}