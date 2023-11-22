package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.apertaOBotaoDeVoltar
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemCadastroTela
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.dicaUrlScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.digitaNoCampoDeTexto
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.fechaOTeclado
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeDeletarDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeEdicaoDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeFABDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltarDescricao
import br.com.alura.mundobola.auxiliardoteste.nomeBolaTeste
import br.com.alura.mundobola.auxiliardoteste.placeholderDescricaoCadastroTela
import br.com.alura.mundobola.auxiliardoteste.placeholderNomeCadastroTela
import br.com.alura.mundobola.auxiliardoteste.placeholderPrecoCadastroTela
import br.com.alura.mundobola.auxiliardoteste.precoBolaTeste
import br.com.alura.mundobola.auxiliardoteste.scrollaAteOElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.textoCancelarScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoConfirmarScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoMarcaCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoNomeCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoNomeObrigatorioCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoPrecoCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoPrecoObrigatorioCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoUrlScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastro
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaSeExisteOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez
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

    @Test
    fun deveMostrarOBotaoDeVolta_QuandoVerificarmosOsScaffolds(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(tituloTelaCadastro)
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
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoNomeCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoPrecoCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoMarcaCadastroTela)
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoDescricaoCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoSalvarCadastroTela)
    }
    @Test
    fun deveIrParaOScaffoldDeInsercaoDoURL_QuandoClicarmosNaImagem(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
            descricaoImagemScaffoldCadastroTela,2
        )
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoUrlScaffoldCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoCancelarScaffoldCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoConfirmarScaffoldCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoUrlScaffoldCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(dicaUrlScaffoldCadastroTela)
    }
    @Test
    fun deveMostarOsTextosDoPlaceholder_QuandoClicarmosNoCampoDeTextoVazio(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.clicaNoElementoPeloNome(textoNomeCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(placeholderNomeCadastroTela)
        fechaOTeclado()
        testeDoNavigation.clicaNoElementoPeloNome(textoPrecoCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(placeholderPrecoCadastroTela)
        fechaOTeclado()
        testeDoNavigation.clicaNoElementoPeloNome(textoDescricaoCadastroTela)
        testeDoNavigation.verificaSeExisteOComponentPeloTexto(placeholderDescricaoCadastroTela)
    }
    @Test
    fun deveVoltarParaATelaPrincipal_QuandoApertarOBotaoDeVolta(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        apertaOBotaoDeVoltar()
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaLista)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(tituloTelaLista)
    }
    @Test
    fun deveAparecerMensagemDeCampoObrigatorio_QuandoApertarSalvarSemDigitarNada(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoNomeObrigatorioCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoPrecoObrigatorioCadastroTela)
    }
    @Test
    fun deveAparecerMensagemDeNomeObrigatorio_QuandoApertarSalvarSoDigitandoPreco(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoPrecoCadastroTela, precoBolaTeste)
        fechaOTeclado()
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoNomeObrigatorioCadastroTela)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(textoPrecoObrigatorioCadastroTela)
    }
    @Test
    fun deveAparecerMensagemDePrecoObrigatorio_QuandoApertarSalvarSoDigitandoNome(){
        vaiParaATelaDeCadastroPelaTelaDeLista()
        testeDoNavigation.digitaNoCampoDeTexto(textoNomeCadastroTela, nomeBolaTeste)
        fechaOTeclado()
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentPeloTexto(textoPrecoObrigatorioCadastroTela)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(textoNomeObrigatorioCadastroTela)
    }

}