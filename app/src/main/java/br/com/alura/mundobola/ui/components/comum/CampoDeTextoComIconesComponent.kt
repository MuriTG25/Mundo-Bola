package br.com.alura.mundobola.ui.components.comum


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import br.com.alura.mundobola.ui.components.scaffold.IconTopAppBarComponent
import br.com.alura.mundobola.ui.extra.tamanhoFontePadrao

@Composable
fun CampoDeTextoComIconesComponent(
    modifier: Modifier = Modifier,
    nomeDoCampo: String = "",
    dicaDoCampo: String = "",
    texto: String = "",
    tamanhoDoTexto: TextUnit = tamanhoFontePadrao,
    naMudancaDeTexto: (String) -> Unit = {},
    maiuscula: KeyboardCapitalization = KeyboardCapitalization.Words,
    acaoDoEnter: ImeAction = ImeAction.Done,
    tipoDeTeclado: KeyboardType = KeyboardType.Text,
    acaoDoTeclado: KeyboardActions = KeyboardActions.Default,
    minimoDeLinhas: Int = 1,
    maximoDeLinhas: Int = 1,
    iconeNoInicio: @Composable () -> Unit = {},
    iconeNoFinal: @Composable () -> Unit = {},
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = texto,
        textStyle = TextStyle(
            color =  MaterialTheme.colorScheme.onPrimary,
            fontSize = tamanhoDoTexto,
        ),
        onValueChange = naMudancaDeTexto,
        label = {
            Text(
                text = nomeDoCampo,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        },
        placeholder = {
            Text(
                text = dicaDoCampo,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        },
        keyboardOptions = KeyboardOptions(
            capitalization = maiuscula,
            imeAction = acaoDoEnter,
            keyboardType = tipoDeTeclado
        ),
        keyboardActions = acaoDoTeclado,
        minLines = minimoDeLinhas,
        maxLines = maximoDeLinhas,
        shape = RoundedCornerShape(15),
        leadingIcon = iconeNoInicio,
        trailingIcon = iconeNoFinal
    )
}

@Preview(showBackground = true)
@Composable
private fun CampoDeTextoComIconesComponentPreview() {
    CampoDeTextoComIconesComponent(
        nomeDoCampo = "Nome",
        iconeNoInicio = {
            IconTopAppBarComponent(
                imagemVetor = Icons.Filled.ArrowBack,
                mostraElemento = true
            )
        },
        iconeNoFinal = {
            IconTopAppBarComponent(
                imagemVetor = Icons.Filled.Search,
                mostraElemento = true
            )
        }
    )
}