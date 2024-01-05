package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.apertaOBotaoDeVoltar
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.dataCriacaoBolaExistente
import br.com.alura.mundobola.auxiliardoteste.dataCriacaoBolaNova
import br.com.alura.mundobola.auxiliardoteste.descricaoCampoBusca
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecerComTempo
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecerComTempoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecerPelaDescricao
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
import br.com.alura.mundobola.auxiliardoteste.inserirMaisBolasNoDb
import br.com.alura.mundobola.auxiliardoteste.inserirMaisMarcasNoDb
import br.com.alura.mundobola.auxiliardoteste.limpaDatabase
import br.com.alura.mundobola.auxiliardoteste.marcaAdidasTexto
import br.com.alura.mundobola.auxiliardoteste.marcaNikeTexto
import br.com.alura.mundobola.auxiliardoteste.marcaPenaltyTexto
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente1
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente2
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente3
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExtra1
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExtra2
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExtra3
import br.com.alura.mundobola.auxiliardoteste.scrollaAteOElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.textoBotaoExpansaoEsconderDetalhesMarca
import br.com.alura.mundobola.auxiliardoteste.textoBotaoExpansaoMostrarDetalhesMarca
import br.com.alura.mundobola.auxiliardoteste.textoCancelarScaffoldDetalhesTela
import br.com.alura.mundobola.auxiliardoteste.textoConfirmarScaffoldDetalhesTela
import br.com.alura.mundobola.auxiliardoteste.textoDataAlteracaoTelaDetalhesMarca
import br.com.alura.mundobola.auxiliardoteste.textoDataCriacaoTelaDetalhesMarca
import br.com.alura.mundobola.auxiliardoteste.textoPerguntaScaffoldDetalhesTelaMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastroBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicaoBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicaoMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeOElementoEClicavelPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeOElementoEClicavelPeloTexto
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
    fun deveMostrarDialogDeDeletar_QuandoClicarNoBotaoDeDelete(){
        vaiParaATelaDeDetalhesDaMarca(marcaNikeTexto)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPerguntaScaffoldDetalhesTelaMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoCancelarScaffoldDetalhesTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoConfirmarScaffoldDetalhesTela)
    }
    @Test
    fun deveFecharDialogDeDeletarSemExcluir_QuandoClicarNoBotaoDeCancelar(){
        vaiParaATelaDeDetalhesDaMarca(marcaNikeTexto)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoCancelarScaffoldDetalhesTela)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoPerguntaScaffoldDetalhesTelaMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesMarca)
    }
    @Test
    fun deveExcluirMArca_QuandoClicarParaExcluirMarca() = runBlocking{
        marcaDao.inserirMaisMarcasNoDb()
        vaiParaATelaDeDetalhesDaMarca(marcaAdidasTexto)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoConfirmarScaffoldDetalhesTela)
        testeDeUi.esperaAteATelaAparecerComTempoPelaDescricao(iconeMenuDescricao)
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
    }
    //TODO fazer o teste de alteracao dos dados de marca nas bolas, e exclusão de marcas que tenham bolas
    @Test
    fun deveMostarDataDeCriacaoDataAlteracaoENome_QuandoFormosEmUmaMarcaEditada(){
        vaiParaATelaDeDetalhesDaMarca(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaExistente)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaNova)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDataCriacaoTelaDetalhesMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDataAlteracaoTelaDetalhesMarca)
    }
    @Test
    fun deveMostarDataDeCriacaoENome_QuandoFormosEmUmaMarcaNaoEditada() = runBlocking{
        marcaDao.inserirMaisMarcasNoDb()
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente3)
        vaiParaATelaDeDetalhesDaMarca(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaNova)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDataCriacaoTelaDetalhesMarca)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoDataAlteracaoTelaDetalhesMarca)
    }
    @Test
    fun deveNaoMostarOBotaoDaLista_QuandoFormosEmUmaMarcaQueNaoTemBola() = runBlocking{
        marcaDao.inserirMaisMarcasNoDb()
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente3)
        vaiParaATelaDeDetalhesDaMarca(marcaAdidasTexto)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoBotaoExpansaoMostrarDetalhesMarca)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoBotaoExpansaoEsconderDetalhesMarca)
    }
    @Test
    fun deveAparecerBotaoDeExpandirAsBolas_QuandoFormosEmUmaMarcaQueTemBola(){
        vaiParaATelaDeDetalhesDaMarca(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoBotaoExpansaoMostrarDetalhesMarca)
        testeDeUi.verificaSeOElementoEClicavelPeloTexto(textoBotaoExpansaoMostrarDetalhesMarca)
    }
    @Test
    fun deveMostarAListaDeBolasPorMarca_QuandoFormosEmUmaMarcaQueTemBola() = runBlocking{
        marcaDao.inserirMaisMarcasNoDb()
        bolaDao.inserirMaisBolasNoDb()
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente3)
        testeDeUi.esperaAteATelaAparecer(nomeBolaExtra1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente2)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente3)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExtra1)
        testeDeUi.scrollaAteOElementoPeloNome(nomeBolaExtra3)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExtra2)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExtra3)
        vaiParaATelaDeDetalhesDaMarca(marcaAdidasTexto)
        testeDeUi.clicaNoElementoPeloNome(textoBotaoExpansaoMostrarDetalhesMarca)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(nomeBolaExistente1)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(nomeBolaExistente2)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(nomeBolaExistente3)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(nomeBolaExtra1)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(nomeBolaExtra2)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExtra3)
    }
    @Test
    fun deveExpandirEEsconderALista_QuandoClicarmosNoBotaoDaLista()= runBlocking{
        marcaDao.inserirMaisMarcasNoDb()
        bolaDao.inserirMaisBolasNoDb()
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente3)
        testeDeUi.esperaAteATelaAparecer(nomeBolaExtra1)
        vaiParaATelaDeDetalhesDaMarca(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoBotaoExpansaoMostrarDetalhesMarca)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoBotaoExpansaoEsconderDetalhesMarca)
        testeDeUi.clicaNoElementoPeloNome(textoBotaoExpansaoMostrarDetalhesMarca)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoBotaoExpansaoMostrarDetalhesMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoBotaoExpansaoEsconderDetalhesMarca)
        testeDeUi.clicaNoElementoPeloNome(textoBotaoExpansaoEsconderDetalhesMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoBotaoExpansaoMostrarDetalhesMarca)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoBotaoExpansaoEsconderDetalhesMarca)
    }
    @Test
    fun deveIrParaATelaDeDetalhesDaBola_QuandoClicarmosNumaBola(){
        vaiParaATelaDeDetalhesDaMarca(marcaNikeTexto)
        testeDeUi.clicaNoElementoPeloNome(textoBotaoExpansaoMostrarDetalhesMarca)
        testeDeUi.clicaNoElementoPeloNome(nomeBolaExistente1)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente1)
    }

}