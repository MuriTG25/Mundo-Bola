package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
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
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class DetalhesDaBolaScreenKtTest{
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val testeDoNavigation = createAndroidComposeRule(MainActivity::class.java)
    private fun vaiParaATelaDeDetalhes(nomeProduto:String){
        testeDoNavigation.clicaNoElementoPeloNome(nomeProduto)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
    }
    private val nomeBolaAleatoria = "Jabulani"
    @Test
    fun deveMostrarOBotaoDeVoltaExcluirEEditar_QuandoVerificarmosOsScaffolds(){
        vaiParaATelaDeDetalhes(nomeBolaAleatoria)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(tituloTelaDetalhes)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(tituloTelaCadastro)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(tituloTelaLista)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeFABDescricao)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaDescricao)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricao(iconeDeletarDescricao)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricao(iconeEdicaoDescricao)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricao(iconeVoltarDescricao)
    }
}