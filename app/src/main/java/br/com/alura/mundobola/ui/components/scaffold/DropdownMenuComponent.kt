package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.aplicacao.extra.OrdenacaoDaLista

@Composable
fun DropdowmMenuComponent(
    modifier: Modifier = Modifier,
    expandir: Boolean = false,
    alteracaoDaExpansao: (Boolean) -> Unit = {},
    noClicaOrdenaPor: (OrdenacaoDaLista) -> Unit = {},
) {
    Box(
        modifier = modifier
            .wrapContentSize(Alignment.TopEnd),
    ) {
        IconTopAppBarComponent(
            mostraElemento = true,
            imagemVetor = Icons.Filled.List,
            descricaoBotao = "Ordenar a lista por:",
            noClicarBotao = {
                alteracaoDaExpansao(!expandir)
            }
        )
        DropdownMenu(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .widthIn(200.dp,500.dp),
            expanded = expandir,
            onDismissRequest = {
                alteracaoDaExpansao(false)
            },
            offset = DpOffset((-40).dp,0.dp)
        ) {
            DropdownMenuItemComponent(
                texto = "Nome Asc",
                noClicaItem = {
                    noClicaOrdenaPor(OrdenacaoDaLista.NOME_ASC)
                }
            )
            DropdownMenuItemComponent(
                texto = "Nome Desc",
                noClicaItem = {
                    noClicaOrdenaPor(OrdenacaoDaLista.NOME_DESC)
                }
            )
            DropdownMenuItemComponent(
                texto = "Preço Asc",
                noClicaItem = {
                    noClicaOrdenaPor(OrdenacaoDaLista.PRECO_ASC)
                },
            )
            DropdownMenuItemComponent(
                texto = "Preço Desc",
                noClicaItem = {
                    noClicaOrdenaPor(OrdenacaoDaLista.PRECO_DESC)
                },
            )
            DropdownMenuItemComponent(
                texto = "Mais Novo",
                noClicaItem = {
                    noClicaOrdenaPor(OrdenacaoDaLista.MAIS_NOVO)
                },
            )
            DropdownMenuItemComponent(
                texto = "Mais Antigo",
                noClicaItem = {
                    noClicaOrdenaPor(OrdenacaoDaLista.MAIS_ANTIGO)
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DropdowmMenuComponentPreview() {
    DropdowmMenuComponent()
}