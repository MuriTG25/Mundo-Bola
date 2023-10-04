package br.com.alura.mundobola.ui.components.cadastrodebolas

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
    texto: String = "",
    naMudancaDeTexto: (String) -> Unit = {},
    nomeDoCampo: String = "",
    maiuscula: KeyboardCapitalization = KeyboardCapitalization.Words,
    acaoDeEnter: ImeAction = ImeAction.Next,
    tipoDeTeclado: KeyboardType = KeyboardType.Text,
    maximoDeLinhas: Int = 1

) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = texto,
        onValueChange = naMudancaDeTexto,
        label = {
            Text(text = nomeDoCampo)
        },
        keyboardOptions = KeyboardOptions(
            capitalization = maiuscula,
            imeAction = acaoDeEnter,
            keyboardType = tipoDeTeclado
        ),
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
