package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.apertaOBotaoDeVoltar
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.dataCriacaoBolaExistente
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemCadastroTela
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeDeletarDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeEdicaoDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeFABDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltarDescricao
import br.com.alura.mundobola.auxiliardoteste.marcaAdidasTexto
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente
import br.com.alura.mundobola.auxiliardoteste.precoBolaExistenteEditado
import br.com.alura.mundobola.auxiliardoteste.precoBolaExistenteOriginal
import br.com.alura.mundobola.auxiliardoteste.rotacionarATela
import br.com.alura.mundobola.auxiliardoteste.scrollaAteOElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoProdutoTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroTela
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastro
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.tituloTelaLista
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentPeloTexto
import br.com.alura.mundobola.auxiliardoteste.verificaSeNaoExisteOComponentePelaDescricao
import br.com.alura.mundobola.auxiliardoteste.verificaSeOElementoEClicavel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class DetalhesDaBolaScreenKtTest{
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val testeDoNavigation = createAndroidComposeRule(MainActivity::class.java)
    private val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    private fun vaiParaATelaDeDetalhes(nomeProduto:String){
        testeDoNavigation.clicaNoElementoPeloNome(nomeProduto)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
    }

    @Test
    fun deveMostrarOBotaoDeVoltaExcluirEEditar_QuandoVerificarmosOsScaffolds(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhes)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(tituloTelaCadastro)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(tituloTelaLista)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeFABDescricao)
        testeDoNavigation.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaDescricao)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricao(iconeDeletarDescricao)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricao(iconeEdicaoDescricao)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricao(iconeVoltarDescricao)
    }
    @Test
    fun deveAbrirODialogComImagem_QuandoClicaNaImagem(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDoNavigation.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
            descricaoImagemCadastroTela, 2
        )
    }
    @Test
    fun devemManterDialogComImagem_QuandoRotacionarmosODispositivo(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        uiDevice.rotacionarATela()
        testeDoNavigation.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
            descricaoImagemCadastroTela, 2
        )
    }
    @Test
    fun deveMostrarNomePrecoDataCriacao_QuandoFormosNosDetalhes(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(nomeBolaExistente)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(precoBolaExistenteEditado)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaExistente)
    }
    @Test
    fun deveSerPossivel_QuandoVerificarmosOCampoDeDetalhes(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.verificaSeOElementoEClicavel(textoDescricaoProdutoTelaDetalhes)
    }
    @Test
    fun deveVoltarParaATelaPrincipal_QuandoClicarmosNoBotaoVolta(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaLista)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto("Total90")
    }
    @Test
    fun deveIrParaATelaDeCadastroComDadosPreenchidos_QuandoClicarmosNoBotaoEditar(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaCadastro)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(nomeBolaExistente)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(precoBolaExistenteOriginal)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
    }
    @Test
    fun deveExcluirOsDados_QuandoApertarNoBotaoDeDeletar(){
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(nomeBolaExistente)
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaLista)
        testeDoNavigation.verificaSeNaoExisteOComponentPeloTexto(nomeBolaExistente)
    }
    @Test
    fun deveVoltarParaATelaDeListaENaoDeCadastro_QuandoApertaBotaoVoltarPeloAppAposTerEditadoBola(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaCadastro)
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaLista)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
    @Test
    fun deveVoltarParaATelaDeListaENaoDeCadastro_QuandoApertaBotaoVoltarDoAndroidAposTerEditadoBola(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDoNavigation.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaCadastro)
        testeDoNavigation.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.clicaNoElementoPeloNome(textoSalvarCadastroTela)
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaDetalhes)
        apertaOBotaoDeVoltar()
        testeDoNavigation.esperaAteATelaAparecer(tituloTelaLista)
        testeDoNavigation.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
}