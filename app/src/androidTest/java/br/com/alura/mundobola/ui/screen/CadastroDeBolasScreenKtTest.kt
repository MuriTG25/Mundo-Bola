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
import br.com.alura.mundobola.auxiliardoteste.descricaoBolaTeste
import br.com.alura.mundobola.auxiliardoteste.descricaoCampoBusca
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemCadastroBola
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.dicaUrlScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.digitaNoCampoDeTexto
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecerComTempo
import br.com.alura.mundobola.auxiliardoteste.fechaOTeclado
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
import br.com.alura.mundobola.auxiliardoteste.inserirMaisMarcasNoDb
import br.com.alura.mundobola.auxiliardoteste.limpaDatabase
import br.com.alura.mundobola.auxiliardoteste.limpaEDigitaNoCampoDeTexto
import br.com.alura.mundobola.auxiliardoteste.marcaAdidasTexto
import br.com.alura.mundobola.auxiliardoteste.marcaNikeTexto
import br.com.alura.mundobola.auxiliardoteste.marcaPenaltyTexto
import br.com.alura.mundobola.auxiliardoteste.mensagemDeErroPreco
import br.com.alura.mundobola.auxiliardoteste.minimizarOAppEReabrir
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente1
import br.com.alura.mundobola.auxiliardoteste.nomeBolaTeste
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente2
import br.com.alura.mundobola.auxiliardoteste.placeholderDescricaoCadastroBola
import br.com.alura.mundobola.auxiliardoteste.placeholderNomeCadastroBola
import br.com.alura.mundobola.auxiliardoteste.placeholderPrecoCadastroBola
import br.com.alura.mundobola.auxiliardoteste.precoBolaComVirgula
import br.com.alura.mundobola.auxiliardoteste.precoBolaEditadoTeste
import br.com.alura.mundobola.auxiliardoteste.precoBolaLimpoTeste
import br.com.alura.mundobola.auxiliardoteste.precoCom2Pontos
import br.com.alura.mundobola.auxiliardoteste.precoCom2Virgulas
import br.com.alura.mundobola.auxiliardoteste.precoComPontoEVirgula
import br.com.alura.mundobola.auxiliardoteste.precoComSimboloInvalido
import br.com.alura.mundobola.auxiliardoteste.precoComSimboloNegativo
import br.com.alura.mundobola.auxiliardoteste.rotacionarATela
import br.com.alura.mundobola.auxiliardoteste.scrollaAteOElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.textoCancelarScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoConfirmarScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoDataAlteracaoTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoDataCriacaoTelaDetalhesBola
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoCadastroBola
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoProdutoTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoMarcaCadastroBola
import br.com.alura.mundobola.auxiliardoteste.textoMarcaTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoNomeCadastroBola
import br.com.alura.mundobola.auxiliardoteste.textoNomeObrigatorioCadastroBola
import br.com.alura.mundobola.auxiliardoteste.textoPrecoCadastroBola
import br.com.alura.mundobola.auxiliardoteste.textoPrecoObrigatorioCadastroBola
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroBola
import br.com.alura.mundobola.auxiliardoteste.textoUrlScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastroBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicaoBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.urlBolaTeste
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez
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
class CadastroDeBolasScreenKtTest{
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

    private val uiDevice = UiDevice.getInstance(
        InstrumentationRegistry.getInstrumentation()
    )
    private fun vaiParaATelaDeCadastroPelaTelaDeLista(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeFABDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaCadastroBola)
    }
    private fun vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeProduto:String) {
        testeDeUi.clicaNoElementoPeloNome(nomeProduto)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaEdicaoBola)
    }
    private fun clicaBotaoSalvar(){
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroBola)
    }
    private fun scrollaAteOFinalDaTela(){
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroBola)
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
    fun deveMostrarOBotaoDeVolta_QuandoVerificarmosOsScaffolds(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaCadastroBola)
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
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeVoltarDescricao)
    }
    @Test
    fun deveMostarONomeDaTelaDeEdicao_QuandoFormosParaATelaDeCastroPeloTelaDeDetalhes(){
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaEdicaoBola)
    }
    @Test
    fun deveMostarOsElementosDaTela_QuandoEstivermosNaTelaDeCadastro(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.verificaSeMostraOComponentePelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPrecoCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoMarcaCadastroBola)
        scrollaAteOFinalDaTela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDescricaoCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoSalvarCadastroBola)
    }
    @Test
    fun deveIrParaOScaffoldDeInsercaoDoURL_QuandoClicarmosNaImagem(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
            descricaoImagemScaffoldCadastroTela,2
        )
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoUrlScaffoldCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoCancelarScaffoldCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoConfirmarScaffoldCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(textoUrlScaffoldCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dicaUrlScaffoldCadastroTela)
    }
    @Test
    fun deveMostarAsOpcoesDeMarcas_QuandoClicarnosNoCampoMarca() = runBlocking{
        marcaDao.inserirMaisMarcasNoDb()
        vaiParaATelaDeCadastroPelaTelaDeLista()
        scrollaAteOFinalDaTela()
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
    }
    @Test
    fun deveMostarOsTextosDoPlaceholder_QuandoClicarmosNoCampoDeTextoVazio(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPeloNome(textoNomeCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(placeholderNomeCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(textoPrecoCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(placeholderPrecoCadastroBola)
        fechaOTeclado()
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(textoDescricaoCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(placeholderDescricaoCadastroBola)
    }
    @Test
    fun deveVoltarParaATelaPrincipal_QuandoVoltamosPeloAndroid(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        apertaOBotaoDeVoltar()
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
    @Test
    fun deveVoltarParaATelaPrincipal_QuandoApertarOBotaoDeVolta(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
    @Test
    fun deveManterAUrl_QuandoApertarParaConcluirEVoltarParaAMesmaTela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(textoConfirmarScaffoldCadastroTela)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }
    @Test
    fun deveManterAUrl_QuandoApertarParaCancelarEVoltarParaAMesmaTela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(textoCancelarScaffoldCadastroTela)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }
    @Test
    fun deveManterAUrlEOScaffold_QuandoRotacionarATela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        uiDevice.rotacionarATela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoUrlScaffoldCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
        uiDevice.voltarARotacaoDaTela()

    }
    @Test
    fun deveManterAUrlEOScaffold_QuandoMinimizarmosEReabrirmosOApp(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        uiDevice.minimizarOAppEReabrir()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoUrlScaffoldCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }

    @Test
    fun deveAparecerMensagemDeCampoObrigatorio_QuandoApertarSalvarSemDigitarNada(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPrecoObrigatorioCadastroBola)
    }
    @Test
    fun deveAparecerMensagemDeNomeObrigatorio_QuandoApertarSalvarSoDigitandoPreco(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoBolaLimpoTeste)
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroBola)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoPrecoObrigatorioCadastroBola)
    }
    @Test
    fun deveAparecerMensagemDePrecoObrigatorio_QuandoApertarSalvarSoDigitandoNome(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        clicaBotaoSalvar()
        testeDeUi.scrollaAteOElementoPeloNome(textoPrecoObrigatorioCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPrecoObrigatorioCadastroBola)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoNomeObrigatorioCadastroBola)
    }
    @Test
    fun deveDesaparecerMensagemDeNomeObrigatorio_QuandoDigitarmosAlgoNoCampoDeNome(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        clicaBotaoSalvar()
        testeDeUi.scrollaAteOElementoPeloNome(textoNomeObrigatorioCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroBola)
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        fechaOTeclado()
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoNomeObrigatorioCadastroBola)
    }
    @Test
    fun deveDesaparecerMensagemDePrecoObrigatorio_QuandoDigitarmosAlgoNoCampoDePreco(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        clicaBotaoSalvar()
        testeDeUi.scrollaAteOElementoPeloNome(textoPrecoCadastroBola)
        testeDeUi.esperaAteATelaAparecer(textoPrecoObrigatorioCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPrecoObrigatorioCadastroBola)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoBolaLimpoTeste)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoPrecoObrigatorioCadastroBola)
    }
    @Test
    fun deveTrocarOQueApareceNoCampoDeMarca_QuandoSelecionarmosUmaMarca() = runBlocking{
        marcaDao.inserirMaisMarcasNoDb()
        vaiParaATelaDeCadastroPelaTelaDeLista()
        scrollaAteOFinalDaTela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoMarcaCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(marcaPenaltyTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
        testeDeUi.clicaNoElementoPeloNome(marcaPenaltyTexto)
        testeDeUi.clicaNoElementoPeloNome(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.clicaNoElementoPeloNome(marcaNikeTexto)
        testeDeUi.clicaNoElementoPeloNome(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorInvalido(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoComSimboloInvalido)
        scrollaAteOFinalDaTela()
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorComVirgulaEPonto(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoComPontoEVirgula)
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorCom2Virgulas(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoCom2Virgulas)
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorCom2Pontos(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoCom2Pontos)
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveCadastrarUmaBola_QuandoColocarmosPrecoComValorNegativo(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoComSimboloNegativo)
        clicaBotaoSalvar()
        testeDeUi.esperaAteATelaAparecerComTempo(nomeBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
    }
    @Test
    fun deveCadastrarUmaBola_QuandoColocarmosPrecoUtilizandoVirgula(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoBolaComVirgula)
        clicaBotaoSalvar()

        testeDeUi.esperaAteATelaAparecerComTempo(nomeBolaExistente2)
        testeDeUi.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
    }

    @Test
    fun deveCadastrarUmaBolaNova_QuandoDigitarmosApenasNomeEPreco(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoBolaLimpoTeste)
        clicaBotaoSalvar()

        testeDeUi.esperaAteATelaAparecerComTempo(nomeBolaExistente2)
        testeDeUi.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaNova)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoDataAlteracaoTelaDetalhes)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoDescricaoProdutoTelaDetalhes)
    }
    @Test
    fun deveCadastrarUmaNovaBola_QuandoInserirmosTodosOsDados(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela, urlBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(textoConfirmarScaffoldCadastroTela)
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(marcaNikeTexto)
        testeDeUi.digitaNoCampoDeTexto(textoDescricaoCadastroBola, descricaoBolaTeste)
        clicaBotaoSalvar()
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente2)
        testeDeUi.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDescricaoProdutoTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoMarcaTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDataCriacaoTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaNova)
    }
    @Test
    fun deveEditarUmaBola_QuandoFormosNaTelaDeCadastroPelaEdicao() = runBlocking{
        marcaDao.inserirMaisMarcasNoDb()
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.limpaEDigitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.limpaEDigitaNoCampoDeTexto(textoPrecoCadastroBola, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(marcaPenaltyTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
        testeDeUi.limpaEDigitaNoCampoDeTexto(textoDescricaoCadastroBola, descricaoBolaTeste)
        clicaBotaoSalvar()
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDescricaoProdutoTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoMarcaTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDataCriacaoTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaExistente)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaNova)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDataAlteracaoTelaDetalhes)
    }
    @Test
    fun deveVoltarParaTelaDeDetalhesEDepoisParaTelaDeLista_QuandoApertarmosOBotaoDeVoltaDoApp(){
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesBola)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
    }
    @Test
    fun deveVoltarParaTelaDeDetalhesEDepoisParaTelaDeLista_QuandoApertarmosOBotaoDeVoltaDoAndroid(){
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente1)
        apertaOBotaoDeVoltar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesBola)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        apertaOBotaoDeVoltar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
    }
    @Test
    fun deveManterOsDadosDigitados_QuandoRotacionarATela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(marcaNikeTexto)
        testeDeUi.digitaNoCampoDeTexto(textoDescricaoCadastroBola, descricaoBolaTeste)
        uiDevice.rotacionarATela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
        uiDevice.voltarARotacaoDaTela()

    }
    @Test
    fun deveManterOsDadosDigitados_QuandoMinimizarATelaEReabrir(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroBola, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroBola, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(marcaNikeTexto)
        testeDeUi.digitaNoCampoDeTexto(textoDescricaoCadastroBola, descricaoBolaTeste)
        uiDevice.minimizarOAppEReabrir()
        fechaOTeclado()
        testeDeUi.esperaAteATelaAparecer(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
    }
}