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

@Composable
fun DropdowmMenuComponent(
    modifier: Modifier = Modifier,
    expandir: Boolean = false,
    alteracaoDaExpansao: (Boolean) -> Unit = {},
    noClicaNomeAsc: () -> Unit = {},
    noClicaNomeDesc: () -> Unit = {},
    noClicaPrecoAsc: () -> Unit = {},
    noClicaPrecoDesc: () -> Unit = {},
    noClicaMaisNovo: () -> Unit = {},
    noClicaMaisAntigo: () -> Unit = {},
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
                    noClicaNomeAsc()
                }
            )
            DropdownMenuItemComponent(
                texto = "Nome Desc",
                noClicaItem = {
                    noClicaNomeDesc()
                }
            )
            DropdownMenuItemComponent(
                texto = "Preço Asc",
                noClicaItem = {
                    noClicaPrecoAsc()
                },
            )
            DropdownMenuItemComponent(
                texto = "Preço Desc",
                noClicaItem = {
                    noClicaPrecoDesc()
                },
            )
            DropdownMenuItemComponent(
                texto = "Mais Novo",
                noClicaItem = {
                    noClicaMaisNovo()
                },
            )
            DropdownMenuItemComponent(
                texto = "Mais Antigo",
                noClicaItem = {
                    noClicaMaisAntigo()
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