package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.R
import br.com.alura.mundobola.ui.components.scaffold.FloatActionButtonComponent
import br.com.alura.mundobola.ui.components.scaffold.TopAppBarComponent

@Composable
fun ScaffoldScreen(
    texto: String = "",
    mostraBusca: Boolean = true,
    naBusca: () -> Unit = {},
    mostraFab: Boolean = true,
    noClicaFab: () -> Unit = {},
    mostraVolta: Boolean = true,
    noClicaVolta: () -> Unit = {},
    mostraEditaEDelete: Boolean = true,
    noClicaEdita: () -> Unit = {},
    noClicaDeleta: () -> Unit = {},
    conteudo: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBarComponent(
                noClicaBusca = naBusca,
                mostraBusca = mostraBusca,
                texto = texto,
                mostraVolta = mostraVolta,
                noClicaVolta = noClicaVolta,
                mostraEditaEDeleta = mostraEditaEDelete,
                noClicaEdita = noClicaEdita,
                noClicaDeleta = noClicaDeleta
            )
        },
        floatingActionButton = {
            if (mostraFab) {
                FloatActionButtonComponent(
                    noClicaFab
                )
            }
        }
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            conteudo()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ScaffoldScreenPreviewTelaPrincipal() {
    ScaffoldScreen(
        texto = stringResource(id = R.string.app_name),
        mostraVolta = false,
    ) {}
}

@Preview(showSystemUi = true)
@Composable
private fun ScaffoldScreenPreviewOutrasTelas() {
    ScaffoldScreen(
        texto = stringResource(id = R.string.app_name),
        mostraBusca = false,
        mostraFab = false,
    ) {}
}