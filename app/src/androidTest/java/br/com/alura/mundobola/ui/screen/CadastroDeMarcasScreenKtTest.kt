package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.apertaOBotaoDeVoltar
import br.com.alura.mundobola.auxiliardoteste.campoImagemCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.campoNomeCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.dataCriacaoBolaExistente
import br.com.alura.mundobola.auxiliardoteste.dataCriacaoBolaNova
import br.com.alura.mundobola.auxiliardoteste.descricaoCampoBusca
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemCadastroBola
import br.com.alura.mundobola.auxiliardoteste.digitaNoCampoDeTexto
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
import br.com.alura.mundobola.auxiliardoteste.imagemMarcaTeste
import br.com.alura.mundobola.auxiliardoteste.imagemNikeTexto
import br.com.alura.mundobola.auxiliardoteste.insereDadosNoDb
import br.com.alura.mundobola.auxiliardoteste.limpaDatabase
import br.com.alura.mundobola.auxiliardoteste.limpaEDigitaNoCampoDeTexto
import br.com.alura.mundobola.auxiliardoteste.marcaNikeTexto
import br.com.alura.mundobola.auxiliardoteste.minimizarOAppEReabrir
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente1
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente3
import br.com.alura.mundobola.auxiliardoteste.nomeMarcaTeste
import br.com.alura.mundobola.auxiliardoteste.placeholderImagemCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.placeholderNomeCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.rotacionarATela
import br.com.alura.mundobola.auxiliardoteste.textoCadastroNavigationDrawer
import br.com.alura.mundobola.auxiliardoteste.textoNomeObrigatorioCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicaoMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.voltarARotacaoDaTela
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
    fun dadoAIdaParaATelaDeCadastroPeloDeDetalhes_deveVoltarParaATelaDeDetalhesEDepoisNaTelaDeLista_QuandoClicarmosNoBotaoDeVolta() {
        vaiParaATelaDeEdicaoPeloDetalhes(marcaNikeTexto)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesMarca)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }

    @Test
    fun dadoAIdaParaATelaDeCadastroPeloDeDetalhes_deveVoltarParaATelaDeDetalhesEDepoisNaTelaDeLista_QuandoClicarmosNoVoltaDoAndroid() {
        vaiParaATelaDeEdicaoPeloDetalhes(marcaNikeTexto)
        apertaOBotaoDeVoltar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesMarca)
        apertaOBotaoDeVoltar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
    @Test
    fun deveMostrarImagemCampoUrlENomeESalvar_QuandoVerificarmosOsComponentesDaTela(){
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.verificaSeMostraOComponentePelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(campoImagemCadastroMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(campoNomeCadastroMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoSalvarCadastroMarca)
    }
    @Test
    fun deveMostarOsPlaceholders_quandoClicarmosNosCamposDosTextos(){
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.clicaNoElementoPeloNome(campoImagemCadastroMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(placeholderImagemCadastroMarca)
        testeDeUi.clicaNoElementoPeloNome(campoNomeCadastroMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(placeholderNomeCadastroMarca)
    }
    @Test
    fun deveMostrarOQueFoiDigitado_quandoPreenchermosOCampoDeTexto(){
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.digitaNoCampoDeTexto(campoImagemCadastroMarca, imagemMarcaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(imagemMarcaTeste)
        testeDeUi.digitaNoCampoDeTexto(campoNomeCadastroMarca, nomeMarcaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeMarcaTeste)
    }
    @Test
    fun deveMostrarDadosJaPreenchidos_quandoFormosPelaTelaDeDetalhes(){
        vaiParaATelaDeEdicaoPeloDetalhes(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(imagemNikeTexto)
    }
    @Test
    fun deveManterOsDadosDigitado_quandoRotacionarmosATelaDoCelular(){
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.digitaNoCampoDeTexto(campoImagemCadastroMarca, imagemMarcaTeste)
        testeDeUi.digitaNoCampoDeTexto(campoNomeCadastroMarca, nomeMarcaTeste)
        uiDevice.rotacionarATela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(imagemMarcaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeMarcaTeste)
        uiDevice.voltarARotacaoDaTela()
    }
    @Test
    fun deveManterOsDadosDigitado_quandoFecharmosEReabrirmosOAplicativo(){
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.digitaNoCampoDeTexto(campoImagemCadastroMarca, imagemMarcaTeste)
        testeDeUi.digitaNoCampoDeTexto(campoNomeCadastroMarca, nomeMarcaTeste)
        uiDevice.minimizarOAppEReabrir()
        testeDeUi.verificaSeMostraOComponentePeloTexto(imagemMarcaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeMarcaTeste)
    }
    @Test
    fun deveAparecerMensagemDeNomeObrigatorio_QuandoClicarmosEmSalvarSemPreencherOsDados(){
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroMarca)
    }
    @Test
    fun deveDesaparecerMensagemDeNomeObrigatorio_QuandoPreenchermosOCampoDoNome(){
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroMarca)
        testeDeUi.digitaNoCampoDeTexto(campoNomeCadastroMarca, nomeMarcaTeste)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoNomeObrigatorioCadastroMarca)
    }
    @Test
    fun deveCadastrarMarca_QuandoInserirmosApenasONome(){
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.digitaNoCampoDeTexto(campoNomeCadastroMarca, nomeMarcaTeste)
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroMarca)
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente3)
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.clicaNoElementoPeloNome(nomeMarcaTeste)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeMarcaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaNova)
    }
    @Test
    fun deveCadastrarMarca_QuandoInserirmosONomeEImagem(){
        vaiParaATelaDeCadastroPelaLista()
        testeDeUi.digitaNoCampoDeTexto(campoNomeCadastroMarca, nomeMarcaTeste)
        testeDeUi.digitaNoCampoDeTexto(campoImagemCadastroMarca, imagemMarcaTeste)
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroMarca)
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente3)
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.clicaNoElementoPeloNome(nomeMarcaTeste)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeMarcaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaNova)
    }
    @Test
    fun deveEditarUmaMarca_QuandoAlterarmosOsDadosCadastrais(){
        vaiParaATelaDeEdicaoPeloDetalhes(marcaNikeTexto)
        testeDeUi.limpaEDigitaNoCampoDeTexto(campoNomeCadastroMarca, nomeMarcaTeste)
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroMarca)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeMarcaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaExistente)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaNova)
    }

}