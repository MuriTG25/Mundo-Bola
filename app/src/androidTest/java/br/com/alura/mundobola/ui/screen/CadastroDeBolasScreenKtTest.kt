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
import br.com.alura.mundobola.auxiliardoteste.mensagemToastCadastroSucesso
import br.com.alura.mundobola.auxiliardoteste.textoUrlScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastro
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicao
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
    val testeDeUi = createAndroidComposeRule(MainActivity::class.java)
    private val uiDevice = UiDevice.getInstance(
        InstrumentationRegistry.getInstrumentation()
    )
    private fun vaiParaATelaDeCadastroPelaTelaDeLista(){
        testeDeUi.clicaNoElementoPelaDescricao(iconeFABDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaCadastro)
    }
    private fun vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeProduto:String) {
        testeDeUi.clicaNoElementoPeloNome(nomeProduto)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaEdicao)
    }
    private fun clicaBotaoSalvar(){
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroTela)
    }
    private fun scrollaAteOFinalDaTela(){
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
    }

    @Test
    fun deveMostrarOBotaoDeVolta_QuandoVerificarmosOsScaffolds(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaCadastro)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(tituloTelaDetalhes)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(tituloTelaLista)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeFABDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeDeletarDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeEdicaoDescricao)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeVoltarDescricao)
    }
    @Test
    fun deveMostarONomeDaTelaDeEdicao_QuandoFormosParaATelaDeCastroPeloTelaDeDetalhes(){
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaEdicao)
    }
    @Test
    fun deveMostarOsElementosDaTela_QuandoEstivermosNaTelaDeCadastro(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.verificaSeMostraOComponentePelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPrecoCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoMarcaCadastroTela)
        scrollaAteOFinalDaTela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDescricaoCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoSalvarCadastroTela)
    }
    @Test
    fun deveIrParaOScaffoldDeInsercaoDoURL_QuandoClicarmosNaImagem(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
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
    fun deveMostarAsOpcoesDeMarcas_QuandoClicarnosNoCampoMarca(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        scrollaAteOFinalDaTela()
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaNikeTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
    }
    @Test
    fun deveMostarOsTextosDoPlaceholder_QuandoClicarmosNoCampoDeTextoVazio(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPeloNome(textoNomeCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(placeholderNomeCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(textoPrecoCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(placeholderPrecoCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(textoDescricaoCadastroTela)
        testeDeUi.verificaSeExisteOComponentPeloTexto(placeholderDescricaoCadastroTela)
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
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(textoConfirmarScaffoldCadastroTela)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }
    @Test
    fun deveManterAUrl_QuandoApertarParaCancelarEVoltarParaAMesmaTela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(textoCancelarScaffoldCadastroTela)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }
    @Test
    fun deveManterAUrlEOScaffold_QuandoRotacionarATela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        uiDevice.rotacionarATela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoUrlScaffoldCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }
    @Test
    fun deveManterAUrlEOScaffold_QuandoMinimizarmosEReabrirmosOApp(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela,urlBolaTeste)
        uiDevice.minimizarOAppEReabrir()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoUrlScaffoldCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(urlBolaTeste)
    }

    @Test
    fun deveAparecerMensagemDeCampoObrigatorio_QuandoApertarSalvarSemDigitarNada(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPrecoObrigatorioCadastroTela)
    }
    @Test
    fun deveAparecerMensagemDeNomeObrigatorio_QuandoApertarSalvarSoDigitandoPreco(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroTela)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(textoPrecoObrigatorioCadastroTela)
    }
    @Test
    fun deveAparecerMensagemDePrecoObrigatorio_QuandoApertarSalvarSoDigitandoNome(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPrecoObrigatorioCadastroTela)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(textoNomeObrigatorioCadastroTela)
    }
    @Test
    fun deveDesaparecerMensagemDeNomeObrigatorio_QuandoDigitarmosAlgoNoCampoDeNome(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoNomeObrigatorioCadastroTela)
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        fechaOTeclado()
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(textoNomeObrigatorioCadastroTela)
    }
    @Test
    fun deveDesaparecerMensagemDePrecoObrigatorio_QuandoDigitarmosAlgoNoCampoDePreco(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPrecoObrigatorioCadastroTela)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(textoPrecoObrigatorioCadastroTela)
    }
    @Test
    fun deveTrocarOQueApareceNoCampoDeMarca_QuandoSelecionarmosUmaMarca(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        scrollaAteOFinalDaTela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoMarcaCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroTela)
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
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoComSimboloInvalido)
        scrollaAteOFinalDaTela()
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorComVirgulaEPonto(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoComPontoEVirgula)
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorCom2Virgulas(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoCom2Virgulas)
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveMostarMensagemDeErro_QuandoColocarmosUmValorCom2Pontos(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoCom2Pontos)
        clicaBotaoSalvar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(mensagemDeErroPreco)
    }
    @Test
    fun deveCadastrarUmaBola_QuandoColocarmosPrecoComValorNegativo(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoComSimboloNegativo)
        clicaBotaoSalvar()
        testeDeUi.esperaAteATelaAparecerComTempo(nomeOutraBolaExiste)

        testeDeUi.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
    }
    @Test
    fun deveCadastrarUmaBola_QuandoColocarmosPrecoUtilizandoVirgula(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaComVirgula)
        clicaBotaoSalvar()

        testeDeUi.esperaAteATelaAparecerComTempo(nomeOutraBolaExiste)
        testeDeUi.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
    }

    @Test
    fun deveCadastrarUmaBolaNova_QuandoDigitarmosApenasNomeEPreco(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        clicaBotaoSalvar()

        testeDeUi.esperaAteATelaAparecerComTempo(nomeOutraBolaExiste)
        testeDeUi.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaExistente)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(textoDataAlteracaoTelaDetalhes)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(textoDescricaoProdutoTelaDetalhes)
    }
    @Test
    fun deveCadastrarUmaNovaBola_QuandoInserirmosTodosOsDados(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.digitaNoCampoDeTexto(textoUrlScaffoldCadastroTela, urlBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(textoConfirmarScaffoldCadastroTela)
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(marcaAdidasTexto)
        testeDeUi.digitaNoCampoDeTexto(textoDescricaoCadastroTela, descricaoBolaTeste)
        clicaBotaoSalvar()
        testeDeUi.esperaAteATelaAparecer(nomeOutraBolaExiste)
        testeDeUi.scrollaAteOElementoPeloNome(nomeBolaTeste)
        testeDeUi.clicaNoElementoPeloNome(nomeBolaTeste)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDescricaoProdutoTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoMarcaTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDataCriacaoTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaExistente)
    }
    @Test
    fun deveEditarUmaBola_QuandoFormosNaTelaDeCadastroPelaEdicao(){
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente)
        testeDeUi.limpaEDigitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.limpaEDigitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(marcaPenaltyTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
        testeDeUi.limpaEDigitaNoCampoDeTexto(textoDescricaoCadastroTela, descricaoBolaTeste)
        clicaBotaoSalvar()
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaEditadoTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDescricaoProdutoTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoMarcaTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaPenaltyTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDataCriacaoTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTextoMaisDe1Vez(
            dataCriacaoBolaExistente,2
        )
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoDataAlteracaoTelaDetalhes)
    }
    @Test
    fun deveVoltarParaTelaDeDetalhesEDepoisParaTelaDeLista_QuandoApertarmosOBotaoDeVoltaDoApp(){
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhes)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
    }
    @Test
    fun deveVoltarParaTelaDeDetalhesEDepoisParaTelaDeLista_QuandoApertarmosOBotaoDeVoltaDoAndroid(){
        vaiParaATelaDeCadastroPelaTelaDeDetalhes(nomeBolaExistente)
        apertaOBotaoDeVoltar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhes)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        apertaOBotaoDeVoltar()
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
    }
    @Test
    fun deveManterOsDadosDigitados_QuandoRotacionarATela(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(marcaAdidasTexto)
        testeDeUi.digitaNoCampoDeTexto(textoDescricaoCadastroTela, descricaoBolaTeste)
        uiDevice.rotacionarATela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
    }
    @Test
    fun deveManterOsDadosDigitados_QuandoMinimizarATelaEReabrir(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDeUi.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        testeDeUi.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.clicaNoElementoPeloNome(textoMarcaCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(marcaAdidasTexto)
        testeDeUi.digitaNoCampoDeTexto(textoDescricaoCadastroTela, descricaoBolaTeste)
        uiDevice.minimizarOAppEReabrir()
        fechaOTeclado()
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaTeste)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaLimpoTeste)
        scrollaAteOFinalDaTela()
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(descricaoBolaTeste)
    }
}