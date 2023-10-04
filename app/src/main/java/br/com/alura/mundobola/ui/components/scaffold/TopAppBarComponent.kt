package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.R
import br.com.alura.mundobola.ui.components.listadebolas.TextoProdutoComponent
import br.com.alura.mundobola.ui.theme.AppPrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    naBusca: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            TextoProdutoComponent(
                texto = stringResource(id = R.string.app_name),
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )
        },
        actions = {
            IconButton(
                onClick = {
                    naBusca
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar produto pelo nome",
                    tint = Color.White,
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = AppPrimaryColor
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarComponentPreview() {
    TopAppBarComponent()
}