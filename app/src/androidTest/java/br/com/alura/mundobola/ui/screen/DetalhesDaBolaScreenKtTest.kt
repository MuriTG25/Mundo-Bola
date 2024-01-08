package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.apertaOBotaoDeVoltar
import br.com.alura.mundobola.auxiliardoteste.campoNomeCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.clicaNoCanto
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.dataCriacaoBolaExistente
import br.com.alura.mundobola.auxiliardoteste.descricaoBolaExistente
import br.com.alura.mundobola.auxiliardoteste.descricaoCampoBusca
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemCadastroBola
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
import br.com.alura.mundobola.auxiliardoteste.imagemBolaExistente
import br.com.alura.mundobola.auxiliardoteste.insereDadosNoDb
import br.com.alura.mundobola.auxiliardoteste.limpaDatabase
import br.com.alura.mundobola.auxiliardoteste.limpaEDigitaNoCampoDeTexto
import br.com.alura.mundobola.auxiliardoteste.marcaNikeTexto
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente1
import br.com.alura.mundobola.auxiliardoteste.nomeMarcaTeste
import br.com.alura.mundobola.auxiliardoteste.precoBolaExistenteEditado
import br.com.alura.mundobola.auxiliardoteste.precoBolaExistenteOriginal
import br.com.alura.mundobola.auxiliardoteste.rotacionarATela
import br.com.alura.mundobola.auxiliardoteste.scrollaAteOElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.scrollaAteOElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.textoCancelarScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoCancelarScaffoldDetalhesTela
import br.com.alura.mundobola.auxiliardoteste.textoConfirmarScaffoldDetalhesTela
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoProdutoTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoMarcaTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoPerguntaScaffoldDetalhesTelaBola
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroBola
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastroBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhesMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicaoBola
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicaoMarca
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeOElementoEClicavelPeloTexto
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
class DetalhesDaBolaScreenKtTest{
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
    private fun vaiParaATelaDeDetalhes(nomeProduto:String){
        testeDeUi.clicaNoElementoPeloNome(nomeProduto)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
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
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesBola)
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
    fun deveAbrirODialogComImagem_QuandoClicaNaImagem(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
            descricaoImagemCadastroBola, 2
        )
    }
    @Test
    fun deveFecharODialog_QuandoClicaForaDele(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
            descricaoImagemCadastroBola, 2
        )
        uiDevice.clicaNoCanto()
        testeDeUi.verificaSeMostraOComponentePelaDescricao(
            descricaoImagemCadastroBola
        )
    }
    @Test
    fun deveAbrirDialogDeConfirmacaDeExclusao_QuandoApertarNoBotaoDeDeletar(){
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente1)
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPerguntaScaffoldDetalhesTelaBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoConfirmarScaffoldDetalhesTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoCancelarScaffoldDetalhesTela)
    }
    @Test
    fun deveVoltarParaTelaDeDetalhesSemExcluir_QuandoApertarNoBotaoDeCancelar(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoCancelarScaffoldCadastroTela)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoPerguntaScaffoldDetalhesTelaBola)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoCancelarScaffoldCadastroTela)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoConfirmarScaffoldDetalhesTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente1)
    }
    @Test
    fun deveVoltarParaTelaDeDetalhesSemExcluir_QuandoClicarForaDoDialog(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.esperaAteATelaAparecer(textoPerguntaScaffoldDetalhesTelaBola)
        uiDevice.clicaNoCanto()
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoPerguntaScaffoldDetalhesTelaBola)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoCancelarScaffoldCadastroTela)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoConfirmarScaffoldDetalhesTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhesBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente1)
    }
    @Test
    fun devemManterDialogComImagem_QuandoRotacionarmosODispositivo(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        uiDevice.rotacionarATela()
        testeDeUi.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
            descricaoImagemCadastroBola, 2
        )
        uiDevice.voltarARotacaoDaTela()
    }
    @Test
    fun deveMostrarNomePrecoDataCriacao_QuandoFormosNosDetalhes(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaExistenteEditado)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaExistente)
    }
    @Test
    fun deveSerClicavelOCampoDeDetalhes_QuandoVerificarmosOMesmo(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.verificaSeOElementoEClicavelPeloTexto(textoDescricaoProdutoTelaDetalhes)
    }
    @Test
    fun deveAlterarONomeDaMarca_QuandoAlterarmosAlgumaMarca(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.clicaNoElementoPeloNome(marcaNikeTexto)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesMarca)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaEdicaoMarca)
        testeDeUi.limpaEDigitaNoCampoDeTexto(campoNomeCadastroMarca, nomeMarcaTeste)
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroMarca)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesMarca)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeMarcaTeste)
    }
    @Test
    fun deveTerOValorDeNull_QuandoExcluirmosAlgumaMarca(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.clicaNoElementoPelaDescricao(iconeMenuDescricao)
        testeDeUi.clicaNoElementoPeloNome(marcaNikeTexto)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesMarca)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoConfirmarScaffoldDetalhesTela)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(textoMarcaTelaDetalhes)
    }
    @Test
    fun deveVoltarParaATelaPrincipal_QuandoClicarmosNoBotaoVolta(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePeloTexto("Total90")
    }

    @Test
    fun deveIrParaATelaDeCadastroComDadosPreenchidos_QuandoClicarmosNoBotaoEditar(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(nomeBolaExistente1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente1)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaExistenteOriginal)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(descricaoBolaExistente)
        testeDeUi.scrollaAteOElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroBola)
        testeDeUi.verificaSeMostraOComponentePeloTexto(imagemBolaExistente)
    }
    @Test
    fun deveExcluirOsDados_QuandoApertarNoBotaoDeDeletarEConfirmar(){
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente1)
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoConfirmarScaffoldDetalhesTela)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeNaoExisteOComponentePeloTexto(nomeBolaExistente1)
    }
    @Test
    fun deveVoltarParaATelaDeListaENaoDeCadastro_QuandoApertaBotaoVoltarPeloAppAposTerEditadoBola(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaEdicaoBola)
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroBola)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
    @Test
    fun deveVoltarParaATelaDeListaENaoDeCadastro_QuandoApertaBotaoVoltarDoAndroidAposTerEditadoBola(){
        vaiParaATelaDeDetalhes(nomeBolaExistente1)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaEdicaoBola)
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroBola)
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroBola)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhesBola)
        apertaOBotaoDeVoltar()
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
}