package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.R
import br.com.alura.mundobola.ui.components.comum.SnackBarComponent
import br.com.alura.mundobola.ui.components.scaffold.FloatActionButtonComponent
import br.com.alura.mundobola.ui.components.scaffold.TopAppBarComponent

@Composable
fun ScaffoldScreen(
    titulo: String = "",
//    snackbarHostState: SnackbarHostState = SnackbarHostState(),
    mostraBusca: Boolean = false,
    naBusca: () -> Unit = {},
    mostraFab: Boolean = false,
    noClicaFab: () -> Unit = {},
    mostraVolta: Boolean = false,
    noClicaVolta: () -> Unit = {},
    mostraEditaEDelete: Boolean = false,
    noClicaEdita: () -> Unit = {},
    noClicaDeleta: () -> Unit = {},
    conteudo: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBarComponent(
                noClicaBusca = naBusca,
                mostraBusca = mostraBusca,
                texto = titulo,
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
        },
//        snackbarHost = {
//            SnackBarComponent(
//                snackbarHostState = snackbarHostState
//            )
//        }
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
        titulo = stringResource(id = R.string.app_name),
        mostraFab = true
    ) {}
}

@Preview(showSystemUi = true)
@Composable
private fun ScaffoldScreenPreviewCadastro() {
    ScaffoldScreen(
        titulo = "Cadastrar Bola",
        mostraVolta = true
    ) {}
}
@Preview(showSystemUi = true)
@Composable
private fun ScaffoldScreenPreviewDetalhes() {
    ScaffoldScreen(
        titulo = "Detalhes da bola",
        mostraVolta = true,
        mostraEditaEDelete = true
    ) {}
}