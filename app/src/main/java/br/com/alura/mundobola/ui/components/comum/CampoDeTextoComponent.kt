package br.com.alura.mundobola.ui.components.comum

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.ui.components.scaffold.IconTopAppBarComponent

@Composable
fun CampoDeTextoComponent(
    modifier: Modifier = Modifier,
    nomeDoCampo: String = "",
    dicaDoCampo: String = "",
    texto: String = "",
    naMudancaDeTexto: (String) -> Unit = {},
    maiuscula: KeyboardCapitalization = KeyboardCapitalization.Words,
    acaoDoEnter: ImeAction = ImeAction.Next,
    tipoDeTeclado: KeyboardType = KeyboardType.Text,
    acaoDoTeclado: KeyboardActions = KeyboardActions.Default,
    minimoDeLinhas: Int = 1,
    maximoDeLinhas: Int = 1,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = texto,
        onValueChange = naMudancaDeTexto,
        label = {
            Text(text = nomeDoCampo)
        },
        placeholder = {
            Text(text = dicaDoCampo)
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
    )
}

@Preview(showBackground = true)
@Composable
private fun CampoDeTextoComponentPreviewSemTexto() {
    CampoDeTextoComponent(nomeDoCampo = "Nome")
}

@Preview(showBackground = false)
@Composable
private fun CampoDeTextoComponentPreviewComTexto() {
    CampoDeTextoComponent(
        nomeDoCampo = "Nome",
        texto = "Jabulani",
    )
}



