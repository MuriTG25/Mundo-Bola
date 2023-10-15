package br.com.alura.mundobola.aplicacao.dao

import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test

class BolaDaoTest{
    private val bolaDao = BolaDao()
    @Test
    fun `Deve retornar State Flow de Lista de Bola, quando Buscarmos a lista`(): Unit = runBlocking{
        val listaDeBolas = bolaDao.listaDeBolas()
        listaDeBolas.shouldBeInstanceOf(StateFlow::class)
    }
    @Test
    fun `Deve retornar Lista de Bola, quando extrairmos a lista`(): Unit = runBlocking{
        val listaDeBolas = bolaDao.listaDeBolas().firstOrNull()
        listaDeBolas.shouldBeInstanceOf(List::class)
    }
    @Test
    fun `Deve retornar os Itens Lista de Bola, quando extrairmos a lista`(): Unit = runBlocking{
        val listaDeBolas = bolaDao.listaDeBolas().firstOrNull()
        val tamanhoDaLista = listaDeBolas?.size
        val listaDeNomes = listaDeBolas?.joinToString {
            it.nome
        }
        listaDeNomes.shouldBeEqualTo(listaBolaCompletaNome)
        tamanhoDaLista.shouldBeEqualTo(6)
    }

}