package br.com.alura.mundobola.ui.components.cadastrodebolas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.dominio.Marca

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuComponent(
    modifier: Modifier = Modifier,
    textoDoCampo: String = "",
    expandir: Boolean = false,
    alteracaoDeExpansao: (Boolean) -> Unit = {},
    listaDeMarcas: List<Marca> = emptyList(),
    pegaIdMarca: (String) -> Unit = {},
    campoMarca: String = "",
    alteracaoDoCampoMarca: (String) -> Unit = {},
) {
    ExposedDropdownMenuBox(
        modifier = modifier.fillMaxWidth(),
        expanded = expandir,
        onExpandedChange = {
            alteracaoDeExpansao(!expandir)
        },
    ) {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .menuAnchor(),
            value = campoMarca,
            onValueChange = { },
            label = {
                Text(text = textoDoCampo)
            },
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandir)
            },
            shape = RoundedCornerShape(15),
        )
        ExposedDropdownMenu(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            expanded = expandir,
            onDismissRequest = {
                alteracaoDeExpansao(!expandir)
            }
        ) {
            //TODO talvez eu implemente o leading icon com o simbolo das marcas
            listaDeMarcas.forEach {
                DropdownMenuItem(
                    text = {
                        Text(text = it.nome)
                    },
                    onClick = {
                        pegaIdMarca(it.marcaId)
                        alteracaoDoCampoMarca(it.nome)
                        alteracaoDeExpansao(!expandir)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExposedDropdownMenuComponentPreview() {
    ExposedDropdownMenuComponent()
}