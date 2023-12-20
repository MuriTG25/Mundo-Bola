package br.com.alura.mundobola.ui.components.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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
            modifier = Modifier,
            expanded = expandir,
            onDismissRequest = {
                alteracaoDaExpansao(false)
            }
        ) {
            DropdownMenuItemComponent(
                texto = "Nome Asc",
                noClicaItem = {
                    noClicaNomeAsc()
                    alteracaoDaExpansao(false)
                }
            )
            DropdownMenuItemComponent(
                texto = "Nome Desc",
                noClicaItem = {
                    noClicaNomeDesc()
                    alteracaoDaExpansao(false)
                }
            )
            DropdownMenuItemComponent(
                texto = "Preço Asc",
                noClicaItem = {
                    noClicaPrecoAsc()
                    alteracaoDaExpansao(false)
                },
            )
            DropdownMenuItemComponent(
                texto = "Preço Desc",
                noClicaItem = {
                    noClicaPrecoDesc()
                    alteracaoDaExpansao(false)
                },
            )
            DropdownMenuItemComponent(
                texto = "Mais Novo",
                noClicaItem = {
                    noClicaMaisNovo()
                    alteracaoDaExpansao(false)
                },
            )
            DropdownMenuItemComponent(
                texto = "Mais Antigo",
                noClicaItem = noClicaMaisAntigo,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DropdowmMenuComponentPreview() {
    DropdowmMenuComponent()
}