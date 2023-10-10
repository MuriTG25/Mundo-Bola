package br.com.alura.mundobola.ui.components.cadastrodebolas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import br.com.alura.mundobola.ui.components.comum.BotaoComponent
import br.com.alura.mundobola.ui.components.comum.CampoDeTextoComponent
import br.com.alura.mundobola.ui.components.comum.DialogComponent
import br.com.alura.mundobola.ui.components.comum.ImagemBolaComponent
import br.com.alura.mundobola.ui.extra.margemPadrao

@Composable
fun DialogCadastroImagem(
    modifier: Modifier = Modifier,
    imagemBola: String = "",
    alteracaoDaImagemBola: (String) -> Unit = {},
    noClickSair: () -> Unit = {},
    noClickConfirmar: (String) -> Unit = {},
) {
    DialogComponent(
        modifier = modifier,
        noClickSair = noClickSair
    ) {
        ImagemBolaComponent(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 200.dp),
            imagemDaBola = imagemBola,
            escala = ContentScale.FillHeight
        )
        CampoDeTextoComponent(
            modifier = Modifier.fillMaxWidth(),
            texto = imagemBola,
            nomeDoCampo = "Url da Imagem",
            dicaDoCampo = "Insira o link contendo a imagem da bola",
            naMudancaDeTexto = alteracaoDaImagemBola,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            BotaoComponent(
                noClicarBotao = noClickSair,
                fontSize = 16.sp,
                texto = "Cancelar"
            )
            BotaoComponent(
                noClicarBotao = {
                    noClickConfirmar(imagemBola)
                },
                fontSize = 16.sp,
                texto = "Confirmar"
            )
        }
    }
}

@Preview
@Composable
fun DialogCadastroImagemPreview() {
    DialogCadastroImagem()
}