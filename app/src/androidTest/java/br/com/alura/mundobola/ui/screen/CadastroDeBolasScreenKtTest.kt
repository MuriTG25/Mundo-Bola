package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.apertaOBotaoDeVoltar
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.dataCriacaoBolaExistente
import br.com.alura.mundobola.auxiliardoteste.descricaoBolaTeste
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemCadastroTela
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.dicaUrlScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.digitaNoCampoDeTexto
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecerComTempo
import br.com.alura.mundobola.auxiliardoteste.fechaOTeclado
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeDeletarDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeEdicaoDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeFABDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltarDescricao
import br.com.alura.mundobola.auxiliardoteste.limpaEDigitaNoCampoDeTexto
import br.com.alura.mundobola.auxiliardoteste.marcaAdidasTexto
import br.com.alura.mundobola.auxiliardoteste.marcaNikeTexto
import br.com.alura.mundobola.auxiliardoteste.marcaPenaltyTexto
import br.com.alura.mundobola.auxiliardoteste.mensagemDeErroPreco
import br.com.alura.mundobola.auxiliardoteste.minimizarOAppEReabrir
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente
import br.com.alura.mundobola.auxiliardoteste.nomeBolaTeste
import br.com.alura.mundobola.auxiliardoteste.nomeOutraBolaExiste
import br.com.alura.mundobola.auxiliardoteste.placeholderDescricaoCadastroTela
import br.com.alura.mundobola.auxiliardoteste.placeholderNomeCadastroTela
import br.com.alura.mundobola.auxiliardoteste.placeholderPrecoCadastroTela
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
import br.com.alura.mundobola.auxiliardoteste.textoDataCriacaoTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoProdutoTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoMarcaCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoMarcaTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoNomeCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoNomeObrigatorioCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoPrecoCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoPrecoObrigatorioCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoUrlScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastro
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.urlBolaTeste
import br.com.alura.mundobola.auxiliardoteste.verificaSeExisteOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTextoMaisDe1Vez
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class CadastroDeBolasScreenKtTest{
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val testeDoNavigation = createAndroidComposeRule(MainActivity::class.java)
    private val uiDevice = UiDevice.getInstance(
        InstrumentationRegistry.getInstrumentation()
    )
    private fun vaiParaATelaDeCadastroPelaTelaDeLista(){
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeFABDescricao)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaCadastro)
    }
    private fun vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeProduto:String) {
        testeDoNavigation.clicaNoElementoPeloNome(nomeProduto)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaCadastro)
    }
    private fun clicaBotaoSalvar(){
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoSalvarCadastroTela)
    }
    private fun scrollaAteOFinalDaTela(){
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
    }

    @Test
    fun deveMostrarOBotaoDeVolta_QuandoVerificarmosOsScaffolds(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(tituloTelaCadastro)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(tituloTelaDetalhes)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(tituloTelaLista)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeFABDescricao)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaDescricao)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeDeletarDescricao)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeEdicaoDescricao)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricao(iconeVoltarDescricao)
    }
    @Test
    fun deveMostarOsElementosDaTela_QuandoEstivermosNaTelaDeCadastro(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.verificaSeMostraOComponentePelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoNomeCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoPrecoCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoMarcaCadastroTela)
        scrollaAteOFinalDaTela()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoDescricaoCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoSalvarCadastroTela)
    }
    @Test
    fun deveIrParaOScaffoldDeInsercaoDoURL_QuandoClicarmosNaImagem(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
            descricaoImagemScaffoldCadastroTela,2
        )
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoUrlScaffoldCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoCancelarScaffoldCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoConfirmarScaffoldCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoUrlScaffoldCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(dicaUrlScaffoldCadastroTela)
    }
    @Test
    fun deveMostarAsOpcoesDeMarcas_QuandoClicarnosNoCampoMarca(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        scrollaAteOFinalDaTela()
        testeDoNavigation.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
    }
    @Test
    fun deveMostarOsTextosDoPlaceholder_QuandoClicarmosNoCampoDeTextoVazio(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.clicaNoElementoPeloNome(textoNomeCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(placeholderNomeCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoPrecoCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(placeholderPrecoCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoDescricaoCadastroTela)
        testeDoNavigation.verificaSeExisteOComponentPeloTexto(placeholderDescricaoCadastroTela)
    }
    @Test
    fun deveVoltarParaATelaPrincipal_QuandoApertarOBotaoDeVolta(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        apertaOBotaoDeVoltar()
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaLista)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
    @Test
    fun deveManterAUrl_QuandoApertarParaConcluirEVoltarParaAMesmaTela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        testeDoNavigation.clicaNoElementoPeloNome(textoConfirmarScaffoldCadastroTela)
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }
    @Test
    fun deveManterAUrl_QuandoApertarParaCancelarEVoltarParaAMesmaTela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        testeDoNavigation.clicaNoElementoPeloNome(textoCancelarScaffoldCadastroTela)
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }
    @Test
    fun deveManterAUrlEOScaffold_QuandoRotacionarATela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        uiDevice.rotacionarATela()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoUrlScaffoldCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }
    @Test
    fun deveManterAUrlEOScaffold_QuandoMinimizarmosEReabrirmosOApp(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        uiDevice.minimizarOAppEReabrir()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoUrlScaffoldCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }

    @Test
    fun deveAparecerMensagemDeCampoObrigatorio_QuandoApertarSalvarSemDigitarNada(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        clicaBotaoSalvar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoPrecoObrigatorioCadastroTela)
    }
    @Test
    fun deveAparecerMensagemDeNomeObrigatorio_QuandoApertarSalvarSoDigitandoPreco(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        clicaBotaoSalvar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroTela)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(textoPrecoObrigatorioCadastroTela)
    }
    @Test
    fun deveAparecerMensagemDePrecoObrigatorio_QuandoApertarSalvarSoDigitandoNome(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        clicaBotaoSalvar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoPrecoObrigatorioCadastroTela)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(textoNomeObrigatorioCadastroTela)
    }
    @Test
    fun deveDesaparecerMensagemDeNomeObrigatorio_QuandoDigitarmosAlgoNoCampoDeNome(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        clicaBotaoSalvar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroTela)
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        fechaOTeclado()
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(textoNomeObrigatorioCadastroTela)
    }
    @Test
    fun deveDesaparecerMensagemDePrecoObrigatorio_QuandoDigitarmosAlgoNoCampoDePreco(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        clicaBotaoSalvar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoPrecoObrigatorioCadastroTela)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(textoPrecoObrigatorioCadastroTela)
    }
    @Test
    fun deveTrocarOQueApareceNoCampoDeMarca_QuandoSelecionarmosUmaMarca(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        scrollaAteOFinalDaTela()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoMarcaCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(marcaPenaltyTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
        testeDoNavigation.clicaNoElementoPeloNome(marcaPenaltyTexto)
        testeDoNavigation.clicaNoElementoPeloNome(marcaNikeTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDoNavigation.clicaNoElementoPeloNome(marcaNikeTexto)
        testeDoNavigation.clicaNoElementoPeloNome(marcaAdidasTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorInvalido(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoComSimboloInvalido)
        scrollaAteOFinalDaTela()
        clicaBotaoSalvar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorComVirgulaEPonto(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoComPontoEVirgula)
        clicaBotaoSalvar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorCom2Virgulas(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoCom2Virgulas)
        clicaBotaoSalvar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorCom2Pontos(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoCom2Pontos)
        clicaBotaoSalvar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveCadastrarUmaBola_QuandoColocarmosPrecoComValorNegativo(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoComSimboloNegativo)
        clicaBotaoSalvar()
        testeDoNavigation.esperaAteATelaAparecerComTempo(nomeOutraBolaExiste)
        testeDoNavigation.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDoNavigation.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
    }
    @Test
    fun deveCadastrarUmaBola_QuandoColocarmosPrecoUtilizandoVirgula(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaComVirgula)
        clicaBotaoSalvar()
        testeDoNavigation.esperaAteATelaAparecerComTempo(nomeOutraBolaExiste)
        testeDoNavigation.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDoNavigation.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
    }

    @Test
    fun deveCadastrarUmaBolaNova_QuandoDigitarmosApenasNomeEPreco(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        clicaBotaoSalvar()
        testeDoNavigation.esperaAteATelaAparecerComTempo(nomeOutraBolaExiste)
        testeDoNavigation.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDoNavigation.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaExistente)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(textoDataAlteracaoTelaDetalhes)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(textoDescricaoProdutoTelaDetalhes)
    }
    @Test
    fun deveCadastrarUmaNovaBola_QuandoInserirmosTodosOsDados(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela, urlBolaTeste)
        testeDoNavigation.clicaNoElementoPeloNome(textoConfirmarScaffoldCadastroTela)
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDoNavigation.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(marcaAdidasTexto)
        testeDoNavigation.digitaNoCampoDeTexto(textoDescricaoCadastroTela, descricaoBolaTeste)
        clicaBotaoSalvar()
        testeDoNavigation.esperaAteATelaAparecer(nomeOutraBolaExiste)
        testeDoNavigation.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDoNavigation.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoDescricaoProdutoTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoMarcaTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoDataCriacaoTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaExistente)
    }
    @Test
    fun deveEditarUmaBola_QuandoFormosNaTelaDeCadastroPelaEdicao(){
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.limpaEDigitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.limpaEDigitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDoNavigation.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(marcaPenaltyTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
        testeDoNavigation.limpaEDigitaNoCampoDeTexto(textoDescricaoCadastroTela, descricaoBolaTeste)
        clicaBotaoSalvar()
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoDescricaoProdutoTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoMarcaTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoDataCriacaoTelaDetalhes)
        testeDoNavigation.verificaSeMostraOComponentePeloTextoMaisDe1Vez(
            dataCriacaoBolaExistente,2
        )
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(textoDataAlteracaoTelaDetalhes)
    }
    @Test
    fun deveVoltarParaTelaDeDetalhesEDepoisParaTelaDeLista_QuandoApertarmosOBotaoDeVoltaDoApp(){
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhes)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaLista)
    }
    @Test
    fun deveVoltarParaTelaDeDetalhesEDepoisParaTelaDeLista_QuandoApertarmosOBotaoDeVoltaDoAndroid(){
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente)
        apertaOBotaoDeVoltar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhes)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        apertaOBotaoDeVoltar()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaLista)
    }
    @Test
    fun deveManterOsDadosDigitados_QuandoRotacionarATela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDoNavigation.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(marcaAdidasTexto)
        testeDoNavigation.digitaNoCampoDeTexto(textoDescricaoCadastroTela, descricaoBolaTeste)
        uiDevice.rotacionarATela()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
    }
    @Test
    fun deveManterOsDadosDigitados_QuandoMinimizarATelaEReabrir(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDoNavigation.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(marcaAdidasTexto)
        testeDoNavigation.digitaNoCampoDeTexto(textoDescricaoCadastroTela, descricaoBolaTeste)
        uiDevice.minimizarOAppEReabrir()
        fechaOTeclado()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
    }
}