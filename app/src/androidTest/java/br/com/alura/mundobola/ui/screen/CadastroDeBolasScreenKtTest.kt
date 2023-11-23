package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
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
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente
import br.com.alura.mundobola.auxiliardoteste.nomeBolaTeste
import br.com.alura.mundobola.auxiliardoteste.nomeOutraBolaExiste
import br.com.alura.mundobola.auxiliardoteste.placeholderDescricaoCadastroTela
import br.com.alura.mundobola.auxiliardoteste.placeholderNomeCadastroTela
import br.com.alura.mundobola.auxiliardoteste.placeholderPrecoCadastroTela
import br.com.alura.mundobola.auxiliardoteste.precoBolaEditadoTeste
import br.com.alura.mundobola.auxiliardoteste.precoBolaLimpoTeste
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
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
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
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
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
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
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
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
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
    //TODO teste que faltam: preco invalido, fluxo de navegação de edicao, alteracao no campo de marca
}