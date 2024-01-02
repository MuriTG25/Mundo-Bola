package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.descricaoCampoBusca
import br.com.alura.mundobola.auxiliardoteste.digitaNoCampoDeTexto
import br.com.alura.mundobola.auxiliardoteste.esperaAteASumirOElemento
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecerComTempo
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
import br.com.alura.mundobola.auxiliardoteste.labelCampoPesquisa
import br.com.alura.mundobola.auxiliardoteste.limpaDatabase
import br.com.alura.mundobola.auxiliardoteste.marcaAdidasTexto
import br.com.alura.mundobola.auxiliardoteste.marcaNikeTexto
import br.com.alura.mundobola.auxiliardoteste.marcaPenaltyTexto
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente1
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente2
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente3
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExtra1
import br.com.alura.mundobola.auxiliardoteste.placeholderCampoPesquisa
import br.com.alura.mundobola.auxiliardoteste.textoCadastroNavigationDrawer
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoProdutoTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoMarcaTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoNomeCadastroBola
import br.com.alura.mundobola.auxiliardoteste.textoOrdenacaoMaisAntigo
import br.com.alura.mundobola.auxiliardoteste.textoOrdenacaoMaisNovo
import br.com.alura.mundobola.auxiliardoteste.textoOrdenacaoNomeAsc
import br.com.alura.mundobola.auxiliardoteste.textoOrdenacaoNomeDesc
import br.com.alura.mundobola.auxiliardoteste.textoOrdenacaoPrecoAsc
import br.com.alura.mundobola.auxiliardoteste.textoOrdenacaoPrecoDesc
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroBola
import br.com.alura.mundobola.auxiliardoteste.textoTituloNavigationDrawer
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastroBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaPosicaoDoElemento
import br.com.alura.mundobola.auxiliardoteste.verificaSeExisteOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTextoMaisDe1Vez
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoMostraOComponentePeloTexto
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
class ListaDeBolasScreenKtTest{
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
    private val nomePesquisaInvalido = "Aleatorio"
    private val altura1 = 80.dp
    private val altura2 = 326.dp
    private val largura1 = 16.dp
    private val largura2 = 213.71.dp

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
    fun deveMostrarFabIconeBuscaOrdenacaoMenuENomeApp_QuandoEstiverNaTelaDeBolas(){
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaCadastroBola)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeFABDescricao)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeMenuDescricao)
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
        testeDeUi.esperaAteATelaAparecer(tituloTelaCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeCadastroBola)
        testeDeUi.verificaSeExisteOComponentPeloTexto(textoSalvarCadastroBola)
    }
    @Test
    fun deveMostrarOstTiposDeOrdenamento_QuandoCicarmosNoBotaoDeOrdenar(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoOrdenacaoNomeAsc)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoOrdenacaoNomeDesc)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoOrdenacaoPrecoAsc)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoOrdenacaoPrecoDesc)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoOrdenacaoMaisAntigo)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoOrdenacaoMaisNovo)
    }
    @Test
    fun deveAbrirCampoDePesquisa_QuandoClicarNoIconeDeBusca(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(tituloTelaCadastroBola)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeMenuDescricao)
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
        //TODO ainda não sei o que fazer com ele
        testeDeUi.clicaNoElementoPelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeOElementoEClicavelPelaDescricao(iconeBuscaPesquisaDescricao)
    }
    @Test
    fun deveAbrirONAvigationDrawer_QuandoClicarNoBotaoDeMenu() = runBlocking{
        marcaDao.inserirMaisMarcasNoDb()
        bolaDao.inserirMaisBolasNoDb()
        testeDeUi.esperaAteATelaAparecerComTempo(nomeBolaExistente1)
        testeDeUi.esperaAteATelaAparecerComTempo(nomeBolaExtra1)
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoTituloNavigationDrawer)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoCadastroNavigationDrawer)
    }

    @Test
    fun deveAparecerOTexto_quandoDigitarNoCampoDeBusca(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeBuscaDescricao)
        testeDeUi.digitaNoCampoDeTexto(labelCampoPesquisa,nomePesquisaInvalido)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomePesquisaInvalido)
    }
    @Test
    fun deveAparecerUmaBola_quandoDigitarmosNoCampoDeBusca(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeBuscaDescricao)
        testeDeUi.digitaNoCampoDeTexto(labelCampoPesquisa, nomeBolaExistente1)
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente1,2)
        testeDeUi.verificaSeMostraOComponentePeloTextoMaisDe1Vez(
            nomeBolaExistente1,
            2
        )
    }
    @Test
    fun deveMostarListaVazia_quandoDigitarmosNoCampoDeBusca(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeBuscaDescricao)
        testeDeUi.digitaNoCampoDeTexto(labelCampoPesquisa, nomePesquisaInvalido)
        testeDeUi.esperaAteASumirOElemento(nomeBolaExistente1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomePesquisaInvalido)
        testeDeUi.verificaSeNaoMostraOComponentePeloTexto(nomeBolaExistente1)
        testeDeUi.verificaSeNaoMostraOComponentePeloTexto(nomeBolaExistente2)
        testeDeUi.verificaSeNaoMostraOComponentePeloTexto(nomeBolaExistente3)
    }

    @Test
    fun deveOrdenarALista_QuandoOrganizarmosAListaPeloNomeAsc(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoOrdenacaoNomeAsc)
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente1,altura2,largura1
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente2,altura1,largura1
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente3,altura1,largura2
        )
    }
    @Test
    fun deveOrdenarALista_QuandoOrganizarmosAListaPeloNomeDesc(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoOrdenacaoNomeDesc)
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente1,altura1,largura1
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente2,altura2,largura1
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente3,altura1,largura2
        )
    }
    @Test
    fun deveOrdenarALista_QuandoOrganizarmosAListaPeloPrecoAsc(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoOrdenacaoPrecoAsc)
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente1,altura1,largura1
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente2,altura1,largura2
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente3,altura2,largura1
        )
    }
    @Test
    fun deveOrdenarALista_QuandoOrganizarmosAListaPeloPrecoDesc(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoOrdenacaoPrecoDesc)
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente1,altura2,largura1
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente2,altura1,largura2
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente3,altura1,largura1
        )
    }
    @Test
    fun deveOrdenarALista_QuandoOrganizarmosAListaPeloMaisNovo(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoOrdenacaoMaisNovo)
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente1,altura2,largura1
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente2,altura1,largura1
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente3,altura1,largura2
        )
    }
    @Test
    fun deveOrdenarALista_QuandoOrganizarmosAListaPeloMaisAntigo(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeOrdenacaoDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoOrdenacaoMaisAntigo)
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente1,altura1,largura1
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente2,altura2,largura1
        )
        testeDeUi.verificaPosicaoDoElemento(
            nomeBolaExistente3,altura1,largura2
        )
    }
    @Test
    fun deveIrParaATelaDeDetalhesDeProduto_QuandoApertarEmUmProduto(){
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente3)
        testeDeUi.clicaNoElementoPeloNome(nomeBolaExistente2)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDescricaoProdutoTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoMarcaTelaDetalhes)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(descricaoCampoBusca)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeVoltaPesquisaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaPesquisaDescricao)
    }
    @Test
    fun deveIrParaATelaDeCadastroDeMarca_QuandoApertarNoBotaoDeCadastrarMarca(){
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente3)
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoCadastroNavigationDrawer)
        testeDeUi.esperaAteATelaAparecer(tituloTelaCadastroMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaCadastroMarca)
    }
    @Test
    fun deveIrParaATelaDeDetalhesDaMarca_QuandoApertarNoBotaoDeAlgumaMarca(){
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente3)
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.clicaNoElementoPeloNome(marcaNikeTexto)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesMarca)
    }
}