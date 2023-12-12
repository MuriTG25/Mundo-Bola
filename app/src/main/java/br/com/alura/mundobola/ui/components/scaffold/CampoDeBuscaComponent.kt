package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.components.comum.CampoDeTextoComIconesComponent

@Composable
fun CampoDeBuscaComponent(
    modifier: Modifier = Modifier,
    textoBusca: String = "",
    naMudancaDeBusca: (String) -> Unit = {},
    noClicaPesquisa: () -> Unit = {},
    noClicaVolta: () -> Unit = {},
) {
    CampoDeTextoComIconesComponent(
        modifier = modifier.semantics {
            contentDescription = "Campo de texto de busca de bola"
        },
        nomeDoCampo = "Buscar bola",
        dicaDoCampo = "Digite o nome da bola desejada",
        texto = textoBusca,
        naMudancaDeTexto = naMudancaDeBusca,
        acaoDoEnter = ImeAction.Search,
        iconeNoInicio = {
            IconTopAppBarComponent(
                imagemVetor = Icons.Filled.ArrowBack,
                mostraElemento = true,
                noClicarBotao = noClicaVolta,
                descricaoBotao = "Fecha a aba de pesquisa"
            )

        },
        iconeNoFinal = {
            IconTopAppBarComponent(
                imagemVetor = Icons.Filled.Search,
                mostraElemento = true,
                noClicarBotao = noClicaPesquisa,
                descricaoBotao = "Buscar o produto pelo nome"
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun CampoDeBuscaComponentVazioPreview() {
    CampoDeBuscaComponent()
}

@Preview(showBackground = true)
@Composable
private fun CampoDeBuscaComponentDigitadoPreview() {
    CampoDeBuscaComponent(
        textoBusca = "Jabula"
    )
}
