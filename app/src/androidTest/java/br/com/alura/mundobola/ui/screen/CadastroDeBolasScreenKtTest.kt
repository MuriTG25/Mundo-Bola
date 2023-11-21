package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeDeletarDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeEdicaoDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeFABDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltarDescricao
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastro
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoMostraOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoMostraOComponentePelaDescricao
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class CadastroDeBolasScreenKtTest{
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val testeDoNavigation = createAndroidComposeRule(MainActivity::class.java)
    @Test
    fun deveMostrarFabENomeApp_QuandoEstiverNaTelaDeBolas(){
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(tituloTelaLista)
        testeDoNavigation.verificaSeNaoMostraOComponentPeloTexto(tituloTelaCadastro)
        testeDoNavigation.verificaSeNaoMostraOComponentPeloTexto(tituloTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricao(iconeFABDescricao)
        testeDoNavigation.verificaSeNaoMostraOComponentePelaDescricao(iconeBuscaDescricao)
        testeDoNavigation.verificaSeNaoMostraOComponentePelaDescricao(iconeDeletarDescricao)
        testeDoNavigation.verificaSeNaoMostraOComponentePelaDescricao(iconeEdicaoDescricao)
        testeDoNavigation.verificaSeNaoMostraOComponentePelaDescricao(iconeVoltarDescricao)
    }

}