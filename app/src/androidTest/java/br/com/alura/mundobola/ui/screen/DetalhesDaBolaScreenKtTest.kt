package br.com.alura.mundobola.ui.screen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import br.com.alura.mundobola.MainActivity
import br.com.alura.mundobola.auxiliardoteste.apertaOBotaoDeVoltar
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.clicaNoElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.dataCriacaoBolaExistente
import br.com.alura.mundobola.auxiliardoteste.descricaoBolaExistente
import br.com.alura.mundobola.auxiliardoteste.descricaoImagemCadastroTela
import br.com.alura.mundobola.auxiliardoteste.esperaAteATelaAparecer
import br.com.alura.mundobola.auxiliardoteste.iconeBuscaDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeDeletarDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeEdicaoDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeFABDescricao
import br.com.alura.mundobola.auxiliardoteste.iconeVoltarDescricao
import br.com.alura.mundobola.auxiliardoteste.imagemBolaExistente
import br.com.alura.mundobola.auxiliardoteste.marcaAdidasTexto
import br.com.alura.mundobola.auxiliardoteste.nomeBolaExistente
import br.com.alura.mundobola.auxiliardoteste.precoBolaExistenteEditado
import br.com.alura.mundobola.auxiliardoteste.precoBolaExistenteOriginal
import br.com.alura.mundobola.auxiliardoteste.rotacionarATela
import br.com.alura.mundobola.auxiliardoteste.scrollaAteOElementoPelaDescricao
import br.com.alura.mundobola.auxiliardoteste.scrollaAteOElementoPeloNome
import br.com.alura.mundobola.auxiliardoteste.textoCancelarScaffoldCadastroTela
import br.com.alura.mundobola.auxiliardoteste.textoConfirmarScaffoldDetalhesTela
import br.com.alura.mundobola.auxiliardoteste.textoDescricaoProdutoTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.textoPerguntaScaffoldDetalhesTela
import br.com.alura.mundobola.auxiliardoteste.textoSalvarCadastroTela
import br.com.alura.mundobola.auxiliardoteste.tituloTelaCadastro
import br.com.alura.mundobola.auxiliardoteste.tituloTelaDetalhes
import br.com.alura.mundobola.auxiliardoteste.tituloTelaEdicao
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
    val testeDeUi = createAndroidComposeRule(MainActivity::class.java)
    private val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    private fun vaiParaATelaDeDetalhes(nomeProduto:String){
        testeDeUi.clicaNoElementoPeloNome(nomeProduto)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
    }

    @Test
    fun deveMostrarOBotaoDeVoltaExcluirEEditar_QuandoVerificarmosOsScaffolds(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhes)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(tituloTelaCadastro)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(tituloTelaEdicao)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(tituloTelaLista)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeFABDescricao)
        testeDeUi.verificaSeNaoExisteOComponentePelaDescricao(iconeBuscaDescricao)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeDeletarDescricao)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeEdicaoDescricao)
        testeDeUi.verificaSeMostraOComponentePelaDescricao(iconeVoltarDescricao)
    }
    @Test
    fun deveAbrirODialogComImagem_QuandoClicaNaImagem(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
            descricaoImagemCadastroTela, 2
        )
    }
    @Test
    fun deveAbrirDialogDeConfirmacaDeExclusao_QuandoApertarNoBotaoDeDeletar(){
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente)
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoPerguntaScaffoldDetalhesTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoConfirmarScaffoldDetalhesTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(textoCancelarScaffoldCadastroTela)
    }
    @Test
    fun deveVoltarParaTelaDeDetalhesSemExcluir_QuandoApertarNoBotaoDeCancelar(){
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente)
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoCancelarScaffoldCadastroTela)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(textoPerguntaScaffoldDetalhesTela)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(textoCancelarScaffoldCadastroTela)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(textoConfirmarScaffoldDetalhesTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaDetalhes)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente)
    }
    @Test
    fun devemManterDialogComImagem_QuandoRotacionarmosODispositivo(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        uiDevice.rotacionarATela()
        testeDeUi.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(
            descricaoImagemCadastroTela, 2
        )
    }
    @Test
    fun deveMostrarNomePrecoDataCriacao_QuandoFormosNosDetalhes(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaExistenteEditado)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDeUi.verificaSeMostraOComponentePeloTexto(dataCriacaoBolaExistente)
    }
    @Test
    fun deveSerPossivel_QuandoVerificarmosOCampoDeDetalhes(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.verificaSeOElementoEClicavel(textoDescricaoProdutoTelaDetalhes)
    }
    @Test
    fun deveVoltarParaATelaPrincipal_QuandoClicarmosNoBotaoVolta(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePeloTexto("Total90")
    }
    @Test
    fun deveIrParaATelaDeCadastroComDadosPreenchidos_QuandoClicarmosNoBotaoEditar(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaEdicao)
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente)
        testeDeUi.verificaSeMostraOComponentePeloTexto(precoBolaExistenteOriginal)
        testeDeUi.verificaSeMostraOComponentePeloTexto(marcaAdidasTexto)
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(descricaoBolaExistente)
        testeDeUi.scrollaAteOElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.clicaNoElementoPelaDescricao(descricaoImagemCadastroTela)
        testeDeUi.verificaSeMostraOComponentePeloTexto(imagemBolaExistente)
    }
    @Test
    fun deveExcluirOsDados_QuandoApertarNoBotaoDeDeletarEConfirmar(){
        testeDeUi.verificaSeMostraOComponentePeloTexto(nomeBolaExistente)
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.clicaNoElementoPelaDescricao(iconeDeletarDescricao)
        testeDeUi.clicaNoElementoPeloNome(textoConfirmarScaffoldDetalhesTela)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeNaoExisteOComponentPeloTexto(nomeBolaExistente)
    }
    @Test
    fun deveVoltarParaATelaDeListaENaoDeCadastro_QuandoApertaBotaoVoltarPeloAppAposTerEditadoBola(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaEdicao)
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroTela)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        testeDeUi.clicaNoElementoPelaDescricao(iconeVoltarDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
    @Test
    fun deveVoltarParaATelaDeListaENaoDeCadastro_QuandoApertaBotaoVoltarDoAndroidAposTerEditadoBola(){
        vaiParaATelaDeDetalhes(nomeBolaExistente)
        testeDeUi.clicaNoElementoPelaDescricao(iconeEdicaoDescricao)
        testeDeUi.esperaAteATelaAparecer(tituloTelaEdicao)
        testeDeUi.scrollaAteOElementoPeloNome(textoSalvarCadastroTela)
        testeDeUi.clicaNoElementoPeloNome(textoSalvarCadastroTela)
        testeDeUi.esperaAteATelaAparecer(tituloTelaDetalhes)
        apertaOBotaoDeVoltar()
        testeDeUi.esperaAteATelaAparecer(tituloTelaLista)
        testeDeUi.verificaSeMostraOComponentePeloTexto(tituloTelaLista)
    }
}