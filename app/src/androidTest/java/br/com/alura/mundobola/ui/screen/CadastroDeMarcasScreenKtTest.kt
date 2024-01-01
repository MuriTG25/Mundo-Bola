package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.apertaOBotaoDeVoltar
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.descricaoCampoBusca
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaPesquisaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeDeletarDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeEdicaoDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeFABDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeMenuDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeOrdenacaoDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltaPesquisaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltarDescricao
import br.com.alura.mundobola.auxiliardoteste.insereDadosNoDb
import br.com.alura.mundobola.auxiliardoteste.limpaDatabase
import br.com.alura.mundobola.auxiliardoteste.marcaNikeTexto
import br.com.alura.mundobola.auxiliardoteste.textoCadastroNavigationDrawer
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastroBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicaoMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePeloTexto
import br.com.alura.mundobola.infraestrutura.database.MundoBolaDatabase
import br.com.alura.mundobola.infraestrutura.database.dao.BolaDao
import br.com.alura.mundobola.infraestrutura.database.dao.MarcaDao
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class CadastroDeMarcasScreenKtTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val testeDeUi = createAndroidComposeRule(MainActivity::class.java)

    @Inject
    lateinit var testDb: MundoBolaDatabase

    @Inject
    lateinit var bolaDao: BolaDao

    @Inject
    lateinit var marcaDao: MarcaDao
    private val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Before
    fun setUp() = runBlocking {
        hiltRule.inject()
        insereDadosNoDb(
            marcaDao = marcaDao,
            bolaDao = bolaDao
        )
    }

    @After
    fun finish() {
        testDb.limpaDatabase()
    }

    private fun vaiParaATelaDeCadastroPelaLista() {
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoCadastroNavigationDrawer)
        testeDeUi.esperaAteATelaAparecer(tituloTelaCadastroMarca)
    }

    private fun vaiParaATelaDeEdicaoPeloDetalhes(marcaNome: String) {
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.clicaNoElementoPeloNome(marcaNome)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesMarca)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaEdicaoMarca)
    }

    @Test
    fun deveMostrarOBotaoDeVolta_QuandoVerificarmosOsScaffolds() {
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaCadastroMarca)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(descricaoCampoBusca)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeVoltaPesquisaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaPesquisaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaDetalhesBola)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaLista)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeFABDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeMenuDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeDeletarDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeEdicaoDescricao)
    }

    @Test
    fun deveMostarONomeDaTelaDeEdicao_SeAbrirmosATelaPeloDetalhes() {
        vaiParaATelaDeEdicaoPeloDetalhes(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaEdicaoMarca)
    }

    @Test
    fun deveVoltarParaATelaDeLista_QuandoClicarmosNoBotaoDeVolta() {
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }

    @Test
    fun deveVoltarParaATelaDeLista_QuandoClicarmosNoVoltaDoAndroid() {
        vaiParaATelaDeCadastroPelaLista()
        apertaOBotaoDeVoltar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }

    @Test
    fun deveVoltarParaATelaDeDetalhesEDepoisNaTelaDeLista_QuandoClicarmosNoBotaoDeVolta() {
        vaiParaATelaDeEdicaoPeloDetalhes(marcaNikeTexto)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesMarca)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }

    @Test
    fun deveVoltarParaATelaDeDetalhesEDepoisNaTelaDeLista_QuandoClicarmosNoVoltaDoAndroid() {
        vaiParaATelaDeEdicaoPeloDetalhes(marcaNikeTexto)
        apertaOBotaoDeVoltar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesMarca)
        apertaOBotaoDeVoltar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
}