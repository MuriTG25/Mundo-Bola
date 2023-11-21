package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemCadastroTela
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.dicaUrlScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeDeletarDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeEdicaoDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeFABDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltarDescricao
import br.com.alura.mundobola.auxiliardoteste.textoCancelarScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoConfirmarScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoMarcaCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoNomeCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoPrecoCadastroTela
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
        testeDoNavigation.verificaSeExisteOComponentPeloTexto(textoDescricaoCadastroTela)
        testeDoNavigation.verificaSeExisteOComponentPeloTexto(textoSalvarCadastroTela)
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


}