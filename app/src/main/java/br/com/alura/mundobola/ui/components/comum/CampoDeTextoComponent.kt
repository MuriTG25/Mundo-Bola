package br.com.alura.mundobola.ui.components.comum

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CampoDeTextoComponent(
    modifier: Modifier = Modifier,
    nomeDoCampo: String = "",
    dicaDoCampo: String = "",
    texto: String = "",
    naMudancaDeTexto: (String) -> Unit = {},
    maiuscula: KeyboardCapitalization = KeyboardCapitalization.Words,
    acaoDeEnter: ImeAction = ImeAction.Next,
    tipoDeTeclado: KeyboardType = KeyboardType.Text,
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
            imeAction = acaoDeEnter,
            keyboardType = tipoDeTeclado
        ),
        minLines = minimoDeLinhas,
        maxLines = maximoDeLinhas,
        shape = RoundedCornerShape(15),
    )
}

@Preview(showBackground = true)
@Composable
fun CampoDeTextoComponentPreviewSemTexto() {
    CampoDeTextoComponent(nomeDoCampo = "Nome")
}
@Preview(showBackground = false)
@Composable
fun CampoDeTextoComponentPreviewComTexto() {
    CampoDeTextoComponent(
        nomeDoCampo = "Nome",
        texto = "Jabulani",
    )
}
