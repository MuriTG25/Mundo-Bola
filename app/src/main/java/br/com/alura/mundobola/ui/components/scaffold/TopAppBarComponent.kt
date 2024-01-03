package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.mundobola.R
import br.com.alura.mundobola.aplicacao.extra.OrdenacaoDaLista
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    texto: String = "",
    mostraTitulo: Boolean = true,
    mostraBuscaHomeEOrdenaPor: Boolean = true,
    noClicaBusca: () -> Unit = {},
    mostraVolta: Boolean = true,
    noClicaVolta: () -> Unit = {},
    mostraEditaEDeleta: Boolean = true,
    noClicaEdita: () -> Unit = {},
    noClicaDeleta: () -> Unit = {},
    mostraTextoBusca: Boolean = false,
    textoBusca: String = "",
    naMudancaDaBusca: (String) -> Unit = {},
    noClicaRealizarBusca: () -> Unit = {},
    noClicaVoltaBusca: () -> Unit = {},
    noClicaHome: () -> Unit = {},
    expandirMenu: Boolean = false,
    alteracaoDaExpansaoMenu: (Boolean) -> Unit = {},
    noClicaOrdenaPor: (OrdenacaoDaLista) -> Unit = {},
    ) {
    CenterAlignedTopAppBar(
        title = {
            if (mostraTitulo) {
                TextoProdutoComponent(
                    texto = texto,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            if (mostraTextoBusca) {
                CampoDeBuscaComponent(
                    modifier = Modifier.offset(y = (-2).dp),
                    textoBusca = textoBusca,
                    naMudancaDeBusca = naMudancaDaBusca,
                    noClicaPesquisa = noClicaRealizarBusca,
                    noClicaVolta = noClicaVoltaBusca,
                )
            }
        },
        actions = {
            if(mostraBuscaHomeEOrdenaPor){
                DropdowmMenuComponent(
                    expandir = expandirMenu,
                    alteracaoDaExpansao = alteracaoDaExpansaoMenu,
                    noClicaOrdenaPor = noClicaOrdenaPor
                )
            }
            IconTopAppBarComponent(
                mostraElemento = mostraBuscaHomeEOrdenaPor,
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
            IconTopAppBarComponent(
                mostraElemento = mostraBuscaHomeEOrdenaPor,
                noClicarBotao = noClicaHome,
                imagemVetor = Icons.Filled.Menu,
                descricaoBotao = "Abrir a aba lateral de Menu"
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarComponentPreviewComElementos() {
    TopAppBarComponent(
        texto = stringResource(id = R.string.app_name),
        mostraBuscaHomeEOrdenaPor = false,
    )
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarComponentPreviewTelaLista() {
    TopAppBarComponent(
        texto = stringResource(id = R.string.app_name),
        mostraBuscaHomeEOrdenaPor = true,
        mostraVolta = false,
        mostraEditaEDeleta = false,
    )
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarComponentPreviewTelaBusca() {
    TopAppBarComponent(
        texto = stringResource(id = R.string.app_name),
        mostraTitulo = false,
        mostraBuscaHomeEOrdenaPor = false,
        mostraVolta = false,
        mostraEditaEDeleta = false,
        mostraTextoBusca = true,
    )
}