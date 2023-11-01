package br.com.alura.mundobola.aplicacao.dao

import br.com.alura.mundobola.auxiliarTeste.bolaDeTesteCompleta
import br.com.alura.mundobola.auxiliarTeste.BolaJaExistenteParaTestes
import br.com.alura.mundobola.auxiliarTeste.listaBolaCompletaNome
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldBeNull
import org.junit.Test

class BolaDaoTest{
    private val bolaDao = BolaDao()
    @Test
    fun `Deve retornar State Flow de Lista de Bola, Quando Buscarmos a lista`(): Unit = runBlocking{
        val listaDeBolas = bolaDao.listaDeBolas()
        listaDeBolas.shouldBeInstanceOf(StateFlow::class)
    }
    @Test
    fun `Deve retornar Lista de Bola, Quando extrairmos a lista`(): Unit = runBlocking{
        val listaDeBolas = bolaDao.listaDeBolas().firstOrNull()
        listaDeBolas.shouldBeInstanceOf(List::class)
    }
    @Test
    fun `Deve retornar os Itens Lista de Bola, Quando extrairmos a lista`(): Unit = runBlocking{
        val listaDeBolas = bolaDao.listaDeBolas().firstOrNull()
        val tamanhoDaLista = listaDeBolas?.size
        val listaDeNomes = listaDeBolas?.joinToString {
            it.nome
        }
        listaDeNomes.shouldBeEqualTo(listaBolaCompletaNome)
        tamanhoDaLista.shouldBeEqualTo(6)
    }
    @Test
    fun `Deve não adicionar bolas, Quando fazemos alteração na lista diretamente nele, a lista é só de leitura e está protegida`(): Unit = runBlocking{
        val listaDeBolas = bolaDao.listaDeBolas().firstOrNull()
        val tamanhoDaLista = listaDeBolas?.size
        val listaDeNomes = listaDeBolas?.joinToString {
            it.nome
        }
        listaDeNomes.shouldBeEqualTo(listaBolaCompletaNome)
        tamanhoDaLista.shouldBeEqualTo(6)
        listaDeBolas?.let {
            it + bolaDeTesteCompleta
        }
        listaDeNomes.shouldBeEqualTo(listaBolaCompletaNome)
        tamanhoDaLista.shouldBeEqualTo(6)
        val novaLista = listaDeBolas?.let {
            it + bolaDeTesteCompleta
        }
        novaLista?.size.shouldBeEqualTo(7)
    }
    @Test
    fun `Deve não retirar bolas, quando fazemos alteração na lista diretamente nele, a lista é só de leitura e está protegida`(): Unit = runBlocking{
        val listaDeBolas = bolaDao.listaDeBolas().firstOrNull()
        val tamanhoDaLista = listaDeBolas?.size
        val listaDeNomes = listaDeBolas?.joinToString {
            it.nome
        }
        listaDeNomes.shouldBeEqualTo(listaBolaCompletaNome)
        tamanhoDaLista.shouldBeEqualTo(6)
        listaDeBolas?.let {
            it - BolaJaExistenteParaTestes
        }
        listaDeNomes.shouldBeEqualTo(listaBolaCompletaNome)
        tamanhoDaLista.shouldBeEqualTo(6)
    }

    @Test
    fun `Deve adicionar uma bola nova, Quando utilizamos a função adicionarBola `(): Unit = runBlocking {
        val listaDeBolas = bolaDao.listaDeBolas().firstOrNull()
        val tamanhoDaLista = listaDeBolas?.size
        tamanhoDaLista.shouldBeEqualTo(6)
        bolaDao.adicionarBola(bolaDeTesteCompleta)
        val listaAtualizada = bolaDao.listaDeBolas().firstOrNull()
        listaAtualizada?.size.shouldBeEqualTo(7)
        listaAtualizada?.last()?.nome?.shouldBeEqualTo("Bola Nike")
    }
    @Test
    fun `Deve retornar uma bola, Quando buscamos o mesmo pelo id`(): Unit = runBlocking {
        val bolaEncontrada = bolaDao.encontrarBolaPeloId(BolaJaExistenteParaTestes.bolaId)
        bolaEncontrada?.nome?.shouldBeEqualTo("Total90")
    }
    @Test
    fun `Deve retornar null, Quando buscamos o mesmo pelo id inexistente`(): Unit = runBlocking {
        val bolaEncontrada = bolaDao.encontrarBolaPeloId("fadsfdsd")
        bolaEncontrada.shouldBeNull()
    }
    @Test
    fun `Deve deletar uma bola, Quando utilizamos a função de deletarBola `(): Unit = runBlocking {
        val listaDeBolas = bolaDao.listaDeBolas().firstOrNull()
        val tamanhoDaLista = listaDeBolas?.size
        tamanhoDaLista.shouldBeEqualTo(6)
        val bolaEncontrada = bolaDao.encontrarBolaPeloId(BolaJaExistenteParaTestes.bolaId)
        bolaEncontrada?.let {
            bolaDao.deletaBola(it)
        }
        val listaAtualizada = bolaDao.listaDeBolas().firstOrNull()
        listaAtualizada?.size.shouldBeEqualTo(5)
    }


}