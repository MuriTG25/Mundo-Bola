package br.com.alura.mundobola.auxiliardoteste

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText

fun ComposeContentTestRule.verificaSeMostraOComponentPeloTexto(texto: String){
    onNodeWithText(texto).assertIsDisplayed()
}
fun ComposeContentTestRule.verificaSeNaoMostraOComponentPeloTexto(texto: String){
    onNodeWithText(texto).assertIsNotDisplayed()
}
fun ComposeContentTestRule.verificaSeMostraOComponentePelaDescricao(descricao: String){
    onNodeWithContentDescription(descricao).assertIsDisplayed()
}
fun ComposeContentTestRule.verificaSeNaoMostraOComponentePelaDescricao(descricao: String){
    onNodeWithContentDescription(descricao).assertIsNotDisplayed()
}

