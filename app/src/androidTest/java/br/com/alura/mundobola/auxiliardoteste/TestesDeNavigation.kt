package br.com.alura.mundobola.auxiliardoteste

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

fun ComposeContentTestRule.verificaSeMostraOComponentPeloTexto(texto: String){
    onNodeWithText(texto).assertIsDisplayed()
}
fun ComposeContentTestRule.verificaSeExisteOComponentPeloTexto(texto: String){
    onNodeWithText(texto).assertExists()
}
fun ComposeContentTestRule.verificaSeNaoExisteOComponentPeloTexto(texto: String){
    onNodeWithText(texto).assertDoesNotExist()
}
fun ComposeContentTestRule.verificaSeMostraOComponentePelaDescricao(descricao: String){
    onNodeWithContentDescription(descricao).assertIsDisplayed()
}
fun ComposeContentTestRule.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
    descricao: String,
    vezes: Int
){
    onAllNodesWithContentDescription(descricao).assertCountEquals(vezes)
}
fun ComposeContentTestRule.verificaSeExisteOComponentePelaDescricao(descricao: String){
    onNodeWithContentDescription(descricao).assertExists()
}
fun ComposeContentTestRule.verificaSeNaoExisteOComponentePelaDescricao(descricao: String){
    onNodeWithContentDescription(descricao).assertDoesNotExist()
}
fun ComposeContentTestRule.clicaNoElementoPeloNome(texto: String){
    onNodeWithText(texto).performClick()
}
fun ComposeContentTestRule.clicaNoPrimeiroElementoPeloNome(texto: String){
    onAllNodesWithText(texto).onFirst().performClick()
}
fun ComposeContentTestRule.clicaNoElementoPelaDescricao(texto: String){
    onNodeWithContentDescription(texto).performClick()
}
fun ComposeContentTestRule.esperaAteATelaAparecer(
    texto: String,
    vezes:Int = 1
){
    waitUntil {
        this.onAllNodesWithText(texto)
            .fetchSemanticsNodes()
            .size == vezes
    }
}

