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
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastroBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicaoBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicaoMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeOElementoEClicavelPelaDescricao
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
class DetalhesDaMarcaScreenKtTest{
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
    private fun vaiParaATelaDeDetalhesDaMarca(nomeMarca: String){
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.clicaNoElementoPeloNome(nomeMarca)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesMarca)
    }
    @Before
    fun setUp() = runBlocking{
        hiltRule.inject()
        insereDadosNoDb(
            marcaDao = marcaDao,
            bolaDao = bolaDao
        )
    }
    @After
    fun finish(){
        testDb.limpaDatabase()
    }
    @Test
    fun deveMostrarOBotaoDeVoltaExcluirEEditar_QuandoVerificarmosOsScaffolds(){
        vaiParaATelaDeDetalhesDaMarca(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesMarca)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeDeletarDescricao)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeEdicaoDescricao)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(descricaoCampoBusca)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeMenuDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeVoltaPesquisaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaPesquisaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaCadastroBola)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaEdicaoBola)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaLista)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeFABDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaDescricao)
    }
    @Test
    fun deveVoltarParaATelaDeLista_QuandoClicarNoBotaoDeVoltar(){
        vaiParaATelaDeDetalhesDaMarca(marcaNikeTexto)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
    @Test
    fun deveVoltarParaATelaDeLista_QuandoVoltarPeloAndroid(){
        vaiParaATelaDeDetalhesDaMarca(marcaNikeTexto)
        apertaOBotaoDeVoltar()
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
    @Test
    fun deveIrParaATelaDeEdicaoDaMarca_QuandoClicarmosEmEditar(){
        vaiParaATelaDeDetalhesDaMarca(marcaNikeTexto)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaEdicaoMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaEdicaoMarca)
    }
    @Test
    fun deveVerSeOIconeDeDeletarEhClicavel_ImplementacaoNaoFeita(){
        //TODO fazer a implementação do delete
        vaiParaATelaDeDetalhesDaMarca(marcaNikeTexto)
        testeDeUi.verificaSeOElementoEClicavelPelaDescricao(iconeDeletarDescricao)
    }
}