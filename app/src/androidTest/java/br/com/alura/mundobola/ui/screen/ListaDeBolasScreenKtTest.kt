package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.descricaoCampoBusca
import br.com.alura.mundobola.auxiliardoteste.digitaNoCampoDeTexto
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaPesquisaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeDeletarDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeEdicaoDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeFABDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltaPesquisaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltarDescricao
import br.com.alura.mundobola.auxiliardoteste.labelCampoPesquisa
import br.com.alura.mundobola.auxiliardoteste.placeholderCampoPesquisa
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoProdutoTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoMarcaTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoNomeCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroTela
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastro
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaSeExisteOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeOElementoEClicavelPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeOElementoEClicavelPeloTexto
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ListaDeBolasScreenKtTest{
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val testeDeUi = createAndroidComposeRule(MainActivity::class.java)
    @Test
    fun deveMostrarFabIconeBuscaENomeApp_QuandoEstiverNaTelaDeBolas(){
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaCadastro)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeFABDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(descricaoCampoBusca)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeVoltaPesquisaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaPesquisaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeDeletarDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeEdicaoDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeVoltarDescricao)
    }
    @Test
    fun deveIrParaATelaDeCadastros_QuandoApertarNoBotaoDoFab(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeFABDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaCadastro)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeCadastroTela)
        testeDeUi.verificaSeExisteOComponentPeloTexto(textoSalvarCadastroTela)
    }
    @Test
    fun deveAbrirCampoDePesquisa_QuandoClicarNoIconeDeBusca(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaCadastro)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(descricaoCampoBusca)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeBuscaPesquisaDescricao)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeVoltaPesquisaDescricao)
    }
    @Test
    fun deveAparecerLabelEPlaceholder_QuandoEstivermosComOCampoDePesquisaAberto(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(labelCampoPesquisa)
        testeDeUi.clicaNoElementoPeloNome(labelCampoPesquisa)
        testeDeUi.verificaSeMostraOComponentePeloTexto(labelCampoPesquisa)
        testeDeUi.verificaSeMostraOComponentePeloTexto(placeholderCampoPesquisa)
    }
    @Test
    fun deveFecharCampoDePesquisa_QuandoApertarmosOBotaoDeVoltar(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeBuscaDescricao)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltaPesquisaDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeBuscaDescricao)
    }
    @Test
    fun deveSerClicavelIconeBusca_ImplementacaoAindaNaoFeita(){
        //TODO implementação desse botão apenas ao concluir a construção do db
        testeDeUi.clicaNoElementoPelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeOElementoEClicavelPelaDescricao(iconeBuscaPesquisaDescricao)
    }
    @Test
    fun deveAparecerOTexto_quandoDigitarNoCampoDeBusca(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeBuscaDescricao)
        testeDeUi.digitaNoCampoDeTexto(labelCampoPesquisa,"Aleatorio")
        testeDeUi.verificaSeMostraOComponentePeloTexto("Aleatorio")
    }
    @Test
    fun deveIrParaATelaDeDetalhes_QuandoApertarEmUmProduto(){
        testeDeUi.clicaNoElementoPeloNome("Jabulani")
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDescricaoProdutoTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoMarcaTelaDetalhes)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(descricaoCampoBusca)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeVoltaPesquisaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaPesquisaDescricao)
    }
}