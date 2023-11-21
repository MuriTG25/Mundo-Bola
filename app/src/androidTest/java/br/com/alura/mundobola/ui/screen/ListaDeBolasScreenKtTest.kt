package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeDeletarDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeEdicaoDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeFABDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltarDescricao
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoProdutoTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoMarcaTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoNomeCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroTela
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastro
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaSeExisteOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ListaDeBolasScreenKtTest{
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val testeDoNavigation = createAndroidComposeRule(MainActivity::class.java)
    @Test
    fun deveMostrarFabENomeApp_QuandoEstiverNaTelaDeBolas(){
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(tituloTelaLista)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(tituloTelaCadastro)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(tituloTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricao(iconeFABDescricao)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaDescricao)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeDeletarDescricao)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeEdicaoDescricao)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeVoltarDescricao)
    }
    @Test
    fun deveIrParaATelaDeCadastros_QuandoApertarNoBotaoDoFab(){
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeFABDescricao)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaCadastro)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoNomeCadastroTela)
        testeDoNavigation.verificaSeExisteOComponentPeloTexto(textoSalvarCadastroTela)
    }
    @Test
    fun deveIrParaATelaDeDetalhes_QuandoApertarEmUmProduto(){
        testeDoNavigation.clicaNoElementoPeloNome("Jabulani")
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoDescricaoProdutoTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoMarcaTelaDetalhes)
    }
}